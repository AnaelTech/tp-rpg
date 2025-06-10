package fr.hb.rpg.personnages.classes;

import fr.hb.rpg.personnages.Hero;

/**
 * Classe Mage
 * Extends la classe Hero
 * 
 * @author Anael
 *
 */
public class Voleur extends Hero {

  /**
   * Constructeur de la classe Voleur
   * 
   * @param nom nom du personnage
   */
  public Voleur(String nom) {
    super(nom, 100, 15, 10, 40, 25, 0, 0);
  }

  /**
   * retourne une chaîne de caractères représentant le voleur
   * 
   * @return la chaîne de caractères représentant le voleur
   */
  @Override
  public String getClasse() {
    return "Voleur";
  }

}
