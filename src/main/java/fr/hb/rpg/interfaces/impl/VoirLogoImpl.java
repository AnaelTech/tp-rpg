package fr.hb.rpg.interfaces.impl;

import fr.hb.rpg.interfaces.VoirLogo;

/**
 * Classe VoirLogoImpl
 * Implémentation de la classe VoirLogo
 * 
 * @author Anael
 *
 */
public class VoirLogoImpl implements VoirLogo {

  /**
   * Surcharge de la méthode voirLogo de la classe VoirLogo
   * Affiche le logo
   */
  @Override
  public void voirLogo() {
    System.out.println("=======================================");
    System.out.println("||                                   ||");
    System.out.println("||       ⚔️  MINI RPG QUEST ⚔️       ||");
    System.out.println("||                                   ||");
    System.out.println("||     Un héros. Des ennemis.        ||");
    System.out.println("||     Une légende à écrire...       ||");
    System.out.println("||                                   ||");
    System.out.println("=======================================\n");
    System.out.println("");
    System.out.println("");
  }

}
