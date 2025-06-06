package fr.hb.rpg.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.SaveScore;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.interfaces.impl.InputOutputImpl;
import fr.hb.rpg.interfaces.impl.SaveScoreImpl;
import fr.hb.rpg.personnages.Dragon;
import fr.hb.rpg.personnages.Ennemi;
import fr.hb.rpg.personnages.Gobelin;
import fr.hb.rpg.personnages.Hero;
import fr.hb.rpg.personnages.Personnage;
import fr.hb.rpg.personnages.Troll;

public class CombatManager {

  private static SortFactory sortFactory = new SortFactory();
  private static InputOutput inputOutput = new InputOutputImpl();
  private static List<Sort> sorts = new ArrayList<>();
  private static List<Ennemi> ennemis = new ArrayList<>();
  private static int compteurPotion = 1;
  private static int compteurEnnemi = 0;
  private static SaveScore saveScore = new SaveScoreImpl();

  public void commencerJeu() {
    voirLogo();
    createSort();
    createEnnemis();
    inputOutput.afficherSansRetour("Entrez votre nom héros : ");
    String nom = inputOutput.lireString();
    Hero hero = creerHero(nom);
    inputOutput.afficher(hero.toString());
    inputOutput.afficher("");
    Ennemi ennemi = randomEnnemi();
    combat(hero, ennemi);
  }

  public static Hero creerHero(String nom) {
    if (nom.isEmpty() || !nom.matches("^[\\p{L}0-9 '\\-]+$")) {
      inputOutput.afficher("\u001B[31mNom invalide, le nom par défaut 'Héros' sera utilisé.\u001B[0m");
      nom = "Héros";
    }
    Hero hero = new Hero(nom, 100, 90, 30, 50, 20);
    return hero;
  }

  public static void combat(Hero hero, Ennemi ennemi) {
    // ICI une boucle while
    while (hero.estVivant()) {
      inputOutput.afficher("Ennemi n " + compteurEnnemi + " : " + ennemi.getNom());
      inputOutput.afficher("=======================================");
      inputOutput.afficher(" ");
      inputOutput.afficher(
          hero.getNom() + "-" + " PV " + hero.getPv() + " | Mana " + hero.getMana() + " | Potions " + compteurPotion);
      inputOutput.afficher("");
      inputOutput.afficher(
          ennemi.getNom() + "-" + " PV " + ennemi.getPv());

      Integer choix = voirMenu();
      switch (choix) {
        case 1:
          int degats = attaque(hero, ennemi);
          inputOutput.afficher(
              hero.getNom() + "  attaque " + ennemi.getNom() + " ! Il inflige " + degats + " de dégâts.");
          if (ennemi.estVivant()) {
            degats = attaque(ennemi, hero);
            inputOutput.afficher(
                ennemi.getNom() + " attaque " + hero.getNom() + " ! Il inflige " +
                    degats + " de dégâts.");
          } else {
            inputOutput.afficher("\u001B[32m" + ennemi.getNom() + " est vaincu.\u001B[0m");
            ennemi = randomEnnemi();
          }
          break;
        case 2:
          utilisationSort(hero, ennemi);
          inputOutput.afficher(ennemi.toString());
          break;
        case 3:
          if (compteurPotion <= 0) {
            inputOutput.afficher("Vous n'avez plus de potion !");
            break;
          }
          utilisationPotion(hero);
          break;
        case 4:
          break;
        default:
          inputOutput.afficher("\u001B[31mChoix non reconnu.\u001B[0m");
          break;
      }
    }
    saveScore(hero.getNom(), compteurEnnemi);
  }

  public static void voirLogo() {
    inputOutput.afficher("=======================================");
    inputOutput.afficher("||                                   ||");
    inputOutput.afficher("||       ⚔️  MINI RPG QUEST ⚔️       ||");
    inputOutput.afficher("||                                   ||");
    inputOutput.afficher("||     Un héros. Des ennemis.        ||");
    inputOutput.afficher("||     Une légende à écrire...       ||");
    inputOutput.afficher("||                                   ||");
    inputOutput.afficher("=======================================\n");
    inputOutput.afficher("");
    inputOutput.afficher("");
  }

  public static int voirMenu() {
    // ICI je vais afficher le menu pour les différents choix
    inputOutput.afficher("||                                   ||");
    inputOutput.afficher("||   1. Attaquer                     ||");
    inputOutput.afficher("||   2. Utiliser un sort             ||");
    if (compteurPotion > 0) {
      inputOutput.afficher("||   3. Utiliser une potion          ||");
    } else {
      inputOutput.afficher("||    Plus de potion disponible      ||");
    }
    inputOutput.afficher("||   4. Revenir au menu              ||");
    inputOutput.afficher("||                                   ||");
    inputOutput.afficher("=======================================\n");
    inputOutput.afficher("");
    Integer choix = inputOutput.lireInt();
    return choix;
  }

  // Attaque
  public static int attaque(Personnage attaquant, Personnage ennemi) {
    return attaquant.attaquer(ennemi);
  }

  //
  public static int demanderInt(String message, int min, int max) {
    Integer val = null;
    do {
      try {
        inputOutput.afficher(message);
        val = inputOutput.lireInt();
        if (val < min || val > max) {
          inputOutput.afficher("Veuillez saisir un nombre entre " + min + " et " + max + ".");
          val = null;
        }
      } catch (Exception e) {
        inputOutput.afficher("\u001B[31mEntrée invalide. Veuillez saisir un nombre.\u001B[0m");
      }
    } while (val == null);
    return val;
  }

  // Utilise un sort
  public static void utilisationSort(Hero hero, Ennemi ennemi) {
    inputOutput.afficher("Quel sort voulez-vous utiliser ?");
    for (int i = 0; i < sorts.size(); i++) {
      Sort s = sorts.get(i);
      inputOutput.afficher((i + 1) + ". " + s.getNom() + " (Dégâts: " + s.getDegats() + ", Mana: " + s.getMana() + ")");
    }
    int choix = demanderInt("Entrez le numéro du sort :", 1, sorts.size()) - 1;
    Sort sortChoisi = sorts.get(choix);
    if (hero.getMana() < sortChoisi.getMana()) {
      inputOutput.afficher("\u001B[31mPas assez de mana pour ce sort !\u001B[0m");
      return;
    }
    hero.utiliserPouvoir(ennemi, sortChoisi);
    inputOutput.afficher(hero.getNom() + " utilise " + sortChoisi.getNom() + " sur " + ennemi.getNom() + " et inflige "
        + sortChoisi.getDegats() + " de dégâts.");
  }

  // Utilise une potion
  public static void utilisationPotion(Hero hero) {
    hero.usePotion();
    compteurPotion--;
    inputOutput.afficher(hero.getNom() + " utilise une potion ! Il a " + hero.getPotion() + " de potions restantes.");
  }

  // Crée les sorts
  public static void createSort() {
    sorts.clear();
    sorts.add(sortFactory.createSort("Sort de feu"));
    sorts.add(sortFactory.createSort("Sort de froid"));
    sorts.add(sortFactory.createSort("Sort de poison"));
    sorts.add(sortFactory.createSort("Sort d'éclair"));
  }

  // Crée les ennemis
  public static void createEnnemis() {
    ennemis.clear();
    Random rand = new Random();
    for (int i = 0; i < 20; i++) {
      ennemis.add(new Gobelin(
          "Gobelin",
          rand.nextInt(41) + 60,
          rand.nextInt(31) + 40,
          rand.nextInt(21) + 20));
      ennemis.add(new Troll(
          "Troll",
          rand.nextInt(61) + 90,
          rand.nextInt(21) + 60,
          rand.nextInt(21) + 30));
      ennemis.add(new Dragon(
          "Dragon",
          rand.nextInt(51) + 120,
          rand.nextInt(31) + 80,
          rand.nextInt(21) + 40));
    }
  }

  // Genere un ennemi au hasard
  public static Ennemi randomEnnemi() {
    List<Ennemi> ennemisDisponibles = new ArrayList<>();
    for (Ennemi ennemi : ennemis) {
      if (ennemi.getPv() > 0) {
        ennemisDisponibles.add(ennemi);
      }
    }
    if (ennemisDisponibles.isEmpty()) {
      createEnnemis();
      ennemisDisponibles.addAll(ennemis);
    }
    int index = (int) (Math.random() * ennemis.size());
    compteurEnnemi++;
    return ennemis.get(index);
  }

  public static void saveScore(String playerName, int score) {
    saveScore.saveScore(playerName, score);
  }

}
