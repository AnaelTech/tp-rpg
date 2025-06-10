package fr.hb.rpg.personnages;

/**
 * Classe Dragon
 * 
 * @author Anael
 *
 */
public class Dragon extends Ennemi {

  /**
   * Constructeur de la classe Dragon
   * 
   * @param nom     nom du personnage
   * @param pv      points de vie
   * @param attaque dégâts
   * @param defense défense
   */
  public Dragon(String nom, int pv, int attaque, int defense) {
    super(nom, pv, attaque, defense);
  }

  /**
   * retourne une chaîne de caractères représentant le dragon
   * 
   * @return une chaîne de caractères représentant le dragon
   */
  @Override
  public String toString() {
    return "Dragon [nom=" + getNom() + ", pv=" + getPv() + ", attaque=" + getAttaque() + ", defense=" + getDefense();
  }

}
