package fr.hb.rpg.personnages;

/**
 * Classe Gobelin
 * 
 * @author Anael
 *
 */
public class Gobelin extends Ennemi {

  /**
   * Constructeur de la classe Gobelin
   * 
   * @param nom     nom du personnage
   * @param pv      points de vie
   * @param attaque dégâts
   * @param defense défense
   */
  public Gobelin(String nom, int pv, int attaque, int defense) {
    super(nom, pv, attaque, defense);
  }

  /**
   * retourne une chaîne de caractères représentant le gobelin
   * 
   * @return une chaîne de caractères représentant le gobelin
   */
  @Override
  public String toString() {
    return "Gobelin [nom=" + getNom() + ", pv=" + getPv() + ", attaque=" + getAttaque() + ", defense=" + getDefense();

  }
}
