package fr.hb.rpg.utils;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.impl.InputOutputImpl;

public class CombatManager {

  private InputOutput inputOutput = new InputOutputImpl();

  public void startGame() {
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
    inputOutput.afficher(nom);
  }

}
