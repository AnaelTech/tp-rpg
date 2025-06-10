package fr.hb.rpg.personnages;

import java.util.List;

import fr.hb.rpg.equipement.Loot;
import fr.hb.rpg.interfaces.PouvoirSpecial;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.interfaces.impl.PouvoirSpecialImpl;

/**
 * Classe Hero
 * Il s'agit d'une classe abstraite qui hérite de la classe Personnage
 * Elle contient les attributs et méthodes communs à tous les héros
 * 
 * @author Anael
 *
 */
public abstract class Hero extends Personnage {

  private int mana;
  private PouvoirSpecial pouvoirSpecial = new PouvoirSpecialImpl();
  private Sort sort;
  private int potion;
  private int xp;
  private int niveau;
  private List<Loot> loot;

  /**
   * Constructeur de la classe Hero
   * 
   * @param nom     nom du personnage
   * @param pv      points de vie
   * @param attaque dégâts
   * @param defense défense
   * @param mana    mana
   * @param potion  potion
   * @param xp      xp
   * @param niveau  niveau
   */
  public Hero(String nom, int pv, int attaque, int defense, int mana, int potion, int xp, int niveau) {
    super(nom, pv, attaque, defense);
    this.mana = mana;
    this.potion = potion;
    this.xp = xp;
    this.niveau = niveau;
  }

  /**
   * methode abstraite qui retourne le nom de la classe
   * 
   */
  public abstract String getClasse();

  /**
   * retourne le nombre d'xp
   * 
   * @return nombre d'xp
   */
  public int getXp() {
    return xp;
  }

  /**
   * Affecte le nombre d'xp
   * 
   * @param xp nombre d'xp
   */
  public void setXp(int xp) {
    this.xp = xp;
  }

  /**
   * retourne le niveau
   * 
   * @return niveau
   */
  public int getNiveau() {
    return niveau;
  }

  /**
   * Affecte le niveau
   * 
   * @param niveau niveau
   */
  public void setNiveau(int niveau) {
    this.niveau = niveau;
  }

  /**
   * retourne le nombre de mana
   * 
   * @return nombre de mana
   */
  public int getMana() {
    return mana;
  }

  /**
   * Affecte le nombre de mana
   * 
   * @param mana nombre de mana
   */
  public void setMana(int mana) {
    this.mana = mana;
  }

  /**
   * qui utilise le pouvoir spécial du héros
   * 
   * @param cible cible
   * @param sort  sort
   */
  public void utiliserPouvoir(Personnage cible, Sort sort) {
    if (this.pouvoirSpecial == null) {
      this.pouvoirSpecial = new PouvoirSpecialImpl();
    }

    if (this.mana >= sort.getMana()) {
      this.pouvoirSpecial.utiliserPouvoir(cible, sort);
      cible.setPv(cible.getPv() - sort.getDegats());
      this.mana -= sort.getMana();
    } else {
      System.out.println("Pas assez de mana pour utiliser ce sort !");
    }
  }

  /**
   * retourne le pouvoir spécial du héros
   * 
   * @return pouvoir spécial
   */
  public PouvoirSpecial getPouvoirSpecial() {
    return pouvoirSpecial;
  }

  /**
   * Affecte le pouvoir spécial du héros
   * 
   * @param pouvoirSpecial pouvoir spécial
   */
  public void setPouvoirSpecial(PouvoirSpecial pouvoirSpecial) {
    this.pouvoirSpecial = pouvoirSpecial;
  }

  /**
   * retourne le sort du héros
   * 
   * @return sort
   */
  public Sort getSort() {
    return sort;
  }

  /**
   * Affecte le sort du héros
   * 
   * @param sort sort
   */
  public void setSort(Sort sort) {
    this.sort = sort;
  }

  /**
   * retourne le potion du héros
   * 
   * @return potion
   */
  public int getPotion() {
    return potion;
  }

  /**
   * Affecte le potion du héros
   * 
   * @param potion potion
   */
  public void setPotion(int potion) {
    this.potion = potion;
  }

  /**
   * retourne le nombre de potions restantes
   * 
   * @return nombre de potions restantes
   */
  public int usePotion() {
    this.pv += this.potion;
    return this.potion;
  }

  /**
   * Augmente le nombre d'xp du héros
   * 
   * @param xp nombre d'xp
   */
  public void augmenterXp(int xp) {
    this.xp += xp;
  }

  /**
   * Augmente les stats du héros
   * 
   * @param pv      points de vie
   * @param attaque dégâts
   * @param defense défense
   */
  public void augmenterStats(int pv, int attaque, int defense) {
    this.pv += pv;
    this.attaque += attaque;
    this.defense += defense;
  }

  /**
   * Augmente le niveau du héros
   * Si le niveau est inférieur à 9, le niveau est augmenté
   * sinon, rien ne se passe
   * 
   * @return true si le niveau est inférieur à 9
   */
  public boolean augmenterNiveau() {
    if (niveau < 9) {
      this.niveau++;
      return true;
    }
    return false;
  }

  /**
   * Récupère la liste des loots du héros
   *
   * @return
   */
  public List<Loot> getLoot() {
    return loot;
  }

  /**
   * Affecte la liste des loots du héros
   *
   * @param loot
   */
  public void setLoot(List<Loot> loot) {
    this.loot = loot;
  }

  /**
   * Supprime un loot du héros
   *
   * @param loot
   *
   */
  public void removeLoot(Loot loot) {
    if (this.loot != null) {
      this.loot.remove(loot);
    }
  }

  /**
   * Ajoute un loot au héros
   *
   * @param loot
   *
   */
  public void addLoot(Loot loot) {
    if (this.loot != null) {
      this.loot.add(loot);
    }
  }

  public void augmentePv(int pv) {
    this.pv += pv;
  }

  public void augmenteAttack(int attack) {
    this.attaque += attack;
  }

  public void augmenteDefense(int defense) {
    this.defense += defense;
  }

  // public void augmenteVitesse(int vitesse) {
  // this.vitesse += vitesse;
  // }

  public void augmenteMana(int mana) {
    this.mana += mana;
  }

  /**
   * Surcharge de la méthode hashCode de la classe Personnage
   * 
   * @return hashCode
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + mana;
    return result;
  }

  /**
   * Surcharge de la méthode equals de la classe Personnage
   * 
   * @return equals
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Hero other = (Hero) obj;
    if (mana != other.mana)
      return false;
    return true;
  }

  /**
   * Surcharge de la méthode toString de la classe Personnage
   * retourne une chaîne de caractères représentant le héros
   * 
   * @return une chaîne de caractères représentant le héros
   */
  @Override
  public String toString() {
    return "nom " + getNom() + ",mana " + mana + ", Pv " + getPv() + ", Attaque " + getAttaque()
        + ", Defense " + getDefense() + "";
  }

}
