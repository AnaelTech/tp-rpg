package fr.hb.rpg.interfaces;

/**
 * Interface Sort
 * 
 * @author Anael
 *
 */
public interface Sort {

  /**
   * retourne le nom du sort
   * 
   * @return nom du sort
   */
  String getNom();

  /**
   * retourne le nombre de dégats
   * 
   * @return nombre de dégats
   */
  int getDegats();

  /**
   * retourne le nombre de mana
   * 
   * @return nombre de mana
   */
  int getMana();
}
