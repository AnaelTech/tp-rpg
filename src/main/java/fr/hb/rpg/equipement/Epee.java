package fr.hb.rpg.equipement;

/**
 * Classe Epee
 * 
 * @author Anael
 *
 */
public class Epee extends Loot {

  /**
   * Constructeur de la classe Epee
   * 
   * @param nom      nom de l'epee
   * @param rarete   rareté de l'epee
   * @param statType type de stat de l'epee
   * @param chance   chance de l'epee
   */
  public Epee(String nom, Rareté rarete, StatType statType, double chance) {
    super(nom, rarete, statType, chance);
  }

}
