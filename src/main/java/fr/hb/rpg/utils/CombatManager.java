package fr.hb.rpg.utils;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.impl.InputOutputImpl;
import fr.hb.rpg.personnages.Ennemi;
import fr.hb.rpg.personnages.Hero;

public class CombatManager {

  private InputOutput inputOutput = new InputOutputImpl();

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
    inputOutput.afficherSansRetour("Entrez votre nom aventurier : ");
    String nom = inputOutput.lireString();
    Hero hero = creerHero(nom);
    inputOutput.afficher(hero.toString());
  }

  public static Hero creerHero(String nom) {
    Hero hero = new Hero(nom, 100, 10, 30, 50);
    return hero;
  }

  public static void combat(Hero hero, Ennemi ennemi) {
    // ICI une boucle while
  }

  public static void voirMenu() {
    // ICI je vais afficher le menu pour les différents choix
    // - choix 1: Attaquer
    // - choix 2: Utiliser un sort
    // - choix 3: Utiliser une potion
    // - choix 4: Revenir au menu
  }

}
