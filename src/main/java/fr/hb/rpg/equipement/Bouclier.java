package fr.hb.rpg.equipement;

/**
 * Classe Bouclier
 * 
 * @author Anael
 *
 */
public class Bouclier extends Loot {

  /**
   * Constructeur de la classe Bouclier
   * 
   * @param nom      nom du bouclier
   * @param rarete   rareté du bouclier
   * @param statType type de stat du bouclier
   * @param chance   chance du bouclier
   */
  public Bouclier(String nom, Rareté rarete, StatType statType, double chance) {
    super(nom, rarete, statType, chance);
  }

}
