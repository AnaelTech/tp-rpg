package fr.hb.rpg.sorts;

import fr.hb.rpg.interfaces.Sort;

/**
 * Classe SortDePoison
 * 
 * @author Anael
 *
 */
public class SortDeFroid implements Sort {
  /**
   * retourne le nom du sort
   * 
   * @return nom du sort
   */
  @Override
  public String getNom() {
    return "Sort de froid";
  }

  /**
   * retourne le nombre de dégats
   * 
   * @return nombre de dégats
   */
  @Override
  public int getDegats() {
    return 20;
  }

  /**
   * retourne le nombre de mana
   * 
   * @return nombre de mana
   */
  @Override
  public int getMana() {
    return 10;
  }

}
