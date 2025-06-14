package fr.hb.rpg.equipement;

import fr.hb.rpg.personnages.Hero;

/**
 * Classe Loot
 * 
 * @author Anael
 *
 */
public abstract class Loot {

  protected Long id;
  protected String nom;
  protected Rareté rareté;
  protected StatType statType;
  protected double chance;
  protected Long compteurId = 0L;

  /**
   * Constructeur de la classe Loot
   * 
   * @param nom   nom du loot
   * @param value valeur du loot
   */
  public Loot(String nom, Rareté rareté, StatType statType, double chance) {
    super();
    this.id = ++compteurId;
    this.nom = nom;
    this.rareté = rareté;
    this.statType = statType;
    this.chance = chance;
  }

  /**
   * retourne l'id du loot
   * 
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * Affecte l'id du loot
   * 
   * @param id id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * retourne la chance du loot
   * 
   * @return chance
   */
  public double getChance() {
    return chance;
  }

  /**
   * Affecte la chance du loot
   * 
   * @param chance chance
   */
  public void setChance(double chance) {
    this.chance = chance;
  }

  /**
   * retourne le nom du loot
   * 
   * @return nom
   */
  public String getNom() {
    return nom;
  }

  /**
   * Affecte le nom du loot
   * 
   * @param nom nom
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * retourne la rareté du loot
   * 
   * @return rareté
   */
  public Rareté getRareté() {
    return rareté;
  }

  /**
   * Affecte la rareté du loot
   * 
   * @param rareté rareté
   */
  public void setRareté(Rareté rareté) {
    this.rareté = rareté;
  }

  /**
   * retourne le type de stat du loot
   * 
   * @return type de stat
   */
  public StatType getStatType() {
    return statType;
  }

  /**
   * Affecte le type de stat du loot
   * 
   * @param statType type de stat
   */
  public void setStatType(StatType statType) {
    this.statType = statType;
  }

  /**
   * Utilise le loot
   *
   */
  public void useLoot(Hero player) {

    switch (statType) {
      case PV:
        player.augmentePv(20);
        System.out.println("Vous utilisez un " + nom + " et gagnez 20 PV !");
        break;
      case ATTAQUE:
        player.augmenteAttack(5);
        System.out.println("Vous équipez un " + nom + " (+5 attaque) !");
        break;
      case DEFENSE:
        player.augmenteDefense(3);
        System.out.println("Vous équipez un " + nom + " (+3 défense) !");
        break;
      // case VITESSE:
      // player.augmenteVitesse(5);
      // System.out.println("Vous équipez un " + nom + " (+5 vitesse) !");
      // break;
      case MANA:
        player.augmenteMana(5);
        System.out.println("Vous équipez un " + nom + " (+5 mana) !");
        break;
      default:
        System.out.println("Stat inconnu.");
    }
  }

  @Override
  public String toString() {
    return "Loot [nom=" + nom + ", rareté=" + rareté + ", statType=" + statType + ", chance=" + chance + "]";
  }

}
