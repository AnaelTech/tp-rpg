package fr.hb.rpg.utils;

import java.util.ArrayList;
import java.util.List;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.interfaces.impl.InputOutputImpl;
import fr.hb.rpg.personnages.Ennemi;
import fr.hb.rpg.personnages.Gobelin;
import fr.hb.rpg.personnages.Hero;
import fr.hb.rpg.personnages.Personnage;

public class CombatManager {

  private static SortFactory sortFactory = new SortFactory();
  private static InputOutput inputOutput = new InputOutputImpl();
  private static List<Sort> sorts = new ArrayList<>();

  public void commencerJeu() {
    inputOutput.afficher("=======================================");
    inputOutput.afficher("||                                   ||");
    inputOutput.afficher("||       ⚔️  MINI RPG QUEST ⚔️        ||");
    inputOutput.afficher("||                                   ||");
    inputOutput.afficher("||     Un héros. Des ennemis.        ||");
    inputOutput.afficher("||     Une légende à écrire...       ||");
    inputOutput.afficher("||                                   ||");
    inputOutput.afficher("=======================================\n");
    inputOutput.afficher("");
    inputOutput.afficher("");
    createSort();
    inputOutput.afficherSansRetour("Entrez votre nom héros : ");
    String nom = inputOutput.lireString();
    Hero hero = creerHero(nom);
    inputOutput.afficher(hero.toString());
    inputOutput.afficher("");
    Gobelin Gobelin = new Gobelin("Gobelin", 100, 70, 30);
    combat(hero, Gobelin);
  }

  public static Hero creerHero(String nom) {
    Hero hero = new Hero(nom, 100, 90, 30, 50);
    return hero;
  }

  public static void combat(Hero hero, Ennemi ennemi) {
    // ICI une boucle while
    while (hero.estVivant() && ennemi.estVivant()) {
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
          }
          break;
        case 2:
          utilisationSort(hero, ennemi);
          inputOutput.afficher(ennemi.toString());

          break;
        case 3:
          utilisationPotion();
          break;
        case 4:
          break;
        default:
          break;
      }
    }
  }

  public static int voirMenu() {
    // ICI je vais afficher le menu pour les différents choix
    inputOutput.afficher("||                                   ||");
    inputOutput.afficher("||   1. Attaquer                     ||");
    inputOutput.afficher("||   2. Utiliser un sort             ||");
    inputOutput.afficher("||   3. Utiliser une potion          ||");
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

  public static int attaque(Personnage attaquant, Personnage ennemi) {
    return attaquant.attaquer(ennemi);
  }

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

  public static void utilisationPotion() {
    // ICI ils utilisent une potion et j'affiche le sort et le degat
  }

  public static void createSort() {
    sorts.clear();
    sorts.add(sortFactory.createSort("Sort de feu"));
    sorts.add(sortFactory.createSort("Sort de froid"));
    sorts.add(sortFactory.createSort("Sort de poison"));
    sorts.add(sortFactory.createSort("Sort d'éclair"));
  }

}
