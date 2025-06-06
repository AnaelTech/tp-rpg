package fr.hb.rpg.utils;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.interfaces.impl.InputOutputImpl;
import fr.hb.rpg.personnages.Ennemi;
import fr.hb.rpg.personnages.Gobelin;
import fr.hb.rpg.personnages.Hero;
import fr.hb.rpg.personnages.Personnage;
import fr.hb.rpg.sorts.SortDEclair;

public class CombatManager {

  private static InputOutput inputOutput = new InputOutputImpl();

  private int compteurAttaque = 0;
  private int compteurSort = 0;
  private int compteurPotion = 0;

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
    inputOutput.afficherSansRetour("Entrez votre nom héros : ");
    String nom = inputOutput.lireString();
    Hero hero = creerHero(nom);
    inputOutput.afficher(hero.toString());
    inputOutput.afficher("");
    Gobelin Gobelin = new Gobelin("Gobelin", 100, 10, 30);
    combat(hero, Gobelin);
  }

  public static Hero creerHero(String nom) {
    Hero hero = new Hero(nom, 100, 10, 30, 50);
    return hero;
  }

  public static void combat(Hero hero, Ennemi ennemi) {
    // ICI une boucle while
    Sort sort = new SortDEclair();
    while (hero.estVivant() && ennemi.estVivant()) {
      Integer choix = voirMenu();
      switch (choix) {
        case 1:
          int degats = hero.attaquer(ennemi);
          inputOutput.afficher(
              hero.getNom() + "  attaque " + ennemi.getNom() + " ! Il inflige " + degats + " de dégâts.");
          inputOutput.afficher(" ");
          inputOutput.afficher(ennemi.toString());

          if (ennemi.estVivant()) {
            degats = ennemi.attaquer(hero);
            inputOutput.afficher(
                ennemi.getNom() + " attaque " + hero.getNom() + " ! Il inflige " +
                    degats + " de dégâts.");
            inputOutput.afficher(hero.toString());
          } else {
            inputOutput.afficher(ennemi.getNom() + " est vaincu.");
          }
          break;
        case 2:
          /* utilisationSort(hero, ennemi); */
          inputOutput.afficher(hero.toString());
          inputOutput.afficher(hero.getNom() + " utilise un sort" + sort.getNom());
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

  // public static void attaque(Personnage ennemi) {
  // // ICI ils attaquent et j'affiche les degats de chaque personnages
  // ennemi.attaquer();
  // // et je fais le calcul de la consommation de mana
  // }
  //
  public static void utilisationSort(Hero hero, Ennemi ennemi) {
    // ICI ils utilisent un sort et j'affiche le sort et le degat
    hero.utiliserPouvoir(ennemi);

  }

  public static void utilisationPotion() {
    // ICI ils utilisent une potion et j'affiche le sort et le degat
  }

}
