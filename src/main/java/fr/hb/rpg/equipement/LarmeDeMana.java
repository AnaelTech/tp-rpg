package fr.hb.rpg.equipement;

/**
 * Classe LarmeDeMana
 * 
 * @author Anael
 *
 */
public class LarmeDeMana extends Loot {

  /**
   * Constructeur de la classe LarmeDeMana
   * 
   * @param nom      nom de la larme de mana
   * @param rarete   rareté de la larme de mana
   * @param statType type de stat de la larme de mana
   * @param chance   chance de la larme de mana
   */
  public LarmeDeMana(String nom, Rareté rarete, StatType statType, double chance) {
    super(nom, rarete, statType, chance);
  }

}
