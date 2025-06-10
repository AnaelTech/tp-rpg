package fr.hb.rpg.personnages.classes;

import fr.hb.rpg.personnages.Hero;

/**
 * Classe Guerrier
 * Extends la classe Hero
 * 
 * @author Anael
 *
 */
public class Guerrier extends Hero {

  /**
   * Constructeur de la classe Guerrier
   * 
   * @param nom nom du personnage
   */
  public Guerrier(String nom) {
    super(nom, 150, 20, 15, 20, 30, 0, 0);
  }

  /**
   * retourne une chaîne de caractères représentant le guerrier
   * 
   * @return la chaîne de caractères représentant le guerrier
   */
  @Override
  public String getClasse() {
    return "Guerrier";
  }

}
