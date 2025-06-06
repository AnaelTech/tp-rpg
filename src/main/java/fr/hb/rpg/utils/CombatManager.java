package fr.hb.rpg.utils;

import java.util.ArrayList;
import java.util.List;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.interfaces.impl.InputOutputImpl;
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
    // Gobelin ennemi = new Gobelin("Gobelin", 100, 70, 30);
    combat(hero, ennemi);
  }

  public static Hero creerHero(String nom) {
    Hero hero = new Hero(nom, 100, 90, 30, 50, 20);
    return hero;
  }

  public static void combat(Hero hero, Ennemi ennemi) {
    // ICI une boucle while
    while (hero.estVivant()) {
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
            inputOutput.afficher(ennemi.getNom() + " est vaincu.");
            ennemi = randomEnnemi();
          }
          break;
        case 2:
          utilisationSort(hero, ennemi);
          inputOutput.afficher(ennemi.toString());
          break;
        case 3:
          if (compteurPotion <= 0) {
            break;
          }
          utilisationPotion(hero);
          break;
        case 4:
          break;
        default:
          break;
      }
    }
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
    // - choix 1: Attaquer
    // - choix 2: Utiliser un sort
    // - choix 3: Utiliser une potion
    // - choix 4: Revenir au menu
  }

  // Attaque
  public static int attaque(Personnage attaquant, Personnage ennemi) {
    return attaquant.attaquer(ennemi);
  }

  // Utilise un sort
  public static void utilisationSort(Hero hero, Ennemi ennemi) {
    inputOutput.afficher("Quel sort voulez-vous utiliser ?");
    for (int i = 0; i < sorts.size(); i++) {
      Sort s = sorts.get(i);
      inputOutput.afficher((i + 1) + ". " + s.getNom() + " (Dégâts: " + s.getDegats() + ", Mana: " + s.getMana() + ")");
    }
    int choix = inputOutput.lireInt() - 1;
    if (choix >= 0 && choix < sorts.size()) {
      Sort sortChoisi = sorts.get(choix);
      hero.utiliserPouvoir(ennemi, sortChoisi);
      inputOutput.afficher(hero.getNom() + " utilise " + sortChoisi.getNom() + " !");
    } else {
      inputOutput.afficher("Choix invalide.");
    }
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
    ennemis.add(new Gobelin("Gobelin", 100, 70, 30));
    ennemis.add(new Troll("Troll", 100, 70, 30));
    ennemis.add(new Dragon("Dragon", 100, 70, 30));
  }

  // Genere un ennemi au hasard
  public static Ennemi randomEnnemi() {
    int index = (int) (Math.random() * ennemis.size());
    return ennemis.get(index);
  }

}
