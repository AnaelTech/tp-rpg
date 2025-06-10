package fr.hb.rpg.equipement;

/**
 * Classe Armure
 * 
 * @author Anael
 *
 */
public class Armure extends Loot {

  /**
   * Constructeur de la classe Armure
   * 
   * @param nom      nom de l'armure
   * @param rarete   rareté de l'armure
   * @param statType type de stat de l'armure
   * @param chance   chance de l'armure
   */
  public Armure(String nom, Rareté rarete, StatType statType, double chance) {
    super(nom, rarete, statType, chance);
  }

}
