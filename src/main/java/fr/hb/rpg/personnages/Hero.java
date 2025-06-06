package fr.hb.rpg.personnages;

import fr.hb.rpg.interfaces.PouvoirSpecial;

public class Hero extends Personnage {

  private int mana;
  private PouvoirSpecial pouvoirSpecial;

  public Hero(String nom, int pv, int attaque, int defense, int mana) {
    super(nom, pv, attaque, defense);
    this.mana = mana;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public void utiliserPouvoir(Personnage cible) {
    pouvoirSpecial.utiliserPouvoir(cible);
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
        + ", tDefense " + getDefense() + "";
  }

}
