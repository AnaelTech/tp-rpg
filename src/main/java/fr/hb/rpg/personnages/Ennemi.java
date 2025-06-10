package fr.hb.rpg.personnages;

/**
 * Classe Ennemi
 * 
 * @author Anael
 *
 */
public class Ennemi extends Personnage {

  /**
   * Constructeur de la classe Ennemi
   * 
   * @param nom     nom du personnage
   * @param pv      points de vie
   * @param attaque dégâts
   * @param defense défense
   */
  public Ennemi(String nom, int pv, int attaque, int defense) {
    super(nom, pv, attaque, defense);
  }

  /**
   * retourne une chaîne de caractères représentant l'ennemi
   * 
   * @return une chaîne de caractères représentant l'ennemi
   */
  @Override
  public String toString() {
    return "Ennemi []";
  }
}
