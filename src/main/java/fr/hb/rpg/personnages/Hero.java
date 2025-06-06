package fr.hb.rpg.personnages;

public class Hero extends Personnage {

  private int mana;

  public Hero(String nom, int pv, int attaque, int defense, int mana) {
    super(nom, pv, attaque, defense);
    this.mana = mana;
  }

  @Override
  public void attaquer(Personnage cible) {

  }

  @Override
  public void prendreDegats(int degats) {

  }

  @Override
  public boolean estVivant() {

    return true;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public void utiliserPouvoir(Personnage cible) {

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
    return "Hero [mana=" + mana + ", getNom()=" + getNom() + ", getPv()=" + getPv() + ", getAttaque()=" + getAttaque()
        + ", getDefense()=" + getDefense() + "]";
  }

}
