package fr.hb.rpg.personnages;

/**
 * Classe Troll
 * 
 * @author Anael
 *
 */
public class Troll extends Ennemi {

  /**
   * Constructeur de la classe Troll
   * 
   * @param nom     nom du personnage
   * @param pv      points de vie
   * @param attaque dégâts
   * @param defense défense
   */
  public Troll(String nom, int pv, int attaque, int defense) {
    super(nom, pv, attaque, defense);
  }

  /**
   * retourne une chaîne de caractères représentant le troll
   * 
   * @return une chaîne de caractères représentant le troll
   */
  @Override
  public String toString() {
    return "Troll [nom=" + getNom() + ", pv=" + getPv() + ", attaque=" + getAttaque() + ", defense=" + getDefense();
  }

}
