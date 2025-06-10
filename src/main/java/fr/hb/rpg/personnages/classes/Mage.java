package fr.hb.rpg.personnages.classes;

import fr.hb.rpg.personnages.Hero;

/**
 * Classe Mage
 * Extends la classe Hero
 * 
 * @author Anael
 *
 */
public class Mage extends Hero {

  /**
   * Constructeur de la classe Mage
   * 
   * @param nom nom du personnage
   */
  public Mage(String nom) {
    super(nom, 80, 10, 5, 100, 30, 0, 0);
  }

  /**
   * retourne une chaîne de caractères représentant le mage
   * 
   * @return la chaîne de caractères représentant le mage
   */
  @Override
  public String getClasse() {
    return "Mage";
  }

}
