package fr.hb.rpg.personnages;

import fr.hb.rpg.interfaces.PouvoirSpecial;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.interfaces.impl.PouvoirSpecialImpl;

public abstract class Hero extends Personnage {

  private int mana;
  private PouvoirSpecial pouvoirSpecial = new PouvoirSpecialImpl();
  private Sort sort;
  private int potion;
  private int xp;
  private int niveau;

  public Hero(String nom, int pv, int attaque, int defense, int mana, int potion, int xp, int niveau) {
    super(nom, pv, attaque, defense);
    this.mana = mana;
    this.potion = potion;
    this.xp = xp;
    this.niveau = niveau;
  }

  public abstract String getClasse();

  public int getXp() {
    return xp;
  }

  public void setXp(int xp) {
    this.xp = xp;
  }

  public int getNiveau() {
    return niveau;
  }

  public void setNiveau(int niveau) {
    this.niveau = niveau;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

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

  public PouvoirSpecial getPouvoirSpecial() {
    return pouvoirSpecial;
  }

  public void setPouvoirSpecial(PouvoirSpecial pouvoirSpecial) {
    this.pouvoirSpecial = pouvoirSpecial;
  }

  public Sort getSort() {
    return sort;
  }

  public void setSort(Sort sort) {
    this.sort = sort;
  }

  public int getPotion() {
    return potion;
  }

  public void setPotion(int potion) {
    this.potion = potion;
  }

  public int usePotion() {
    this.pv += this.potion;
    return this.potion;
  }

  public void augmenterXp(int xp) {
    this.xp += xp;
  }

  public void augmenterStats(int pv, int attaque, int defense) {
    this.pv += pv;
    this.attaque += attaque;
    this.defense += defense;
  }

  public boolean augmenterNiveau() {
    if (niveau < 9) {
      this.niveau++;
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + mana;
    return result;
  }

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

  @Override
  public String toString() {
    return "nom " + getNom() + ",mana " + mana + ", Pv " + getPv() + ", Attaque " + getAttaque()
        + ", Defense " + getDefense() + "";
  }

}
