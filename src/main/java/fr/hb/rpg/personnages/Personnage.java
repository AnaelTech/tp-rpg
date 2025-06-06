package fr.hb.rpg.personnages;

public abstract class Personnage {

  private String nom;
  private int pv;
  private int attaque;
  private int defense;

  public Personnage(String nom, int pv, int attaque, int defense) {
    super();
    this.nom = nom;
    this.pv = pv;
    this.attaque = attaque;
    this.defense = defense;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getPv() {
    return pv;
  }

  public void setPv(int pv) {
    this.pv = pv;
  }

  public int getAttaque() {
    return attaque;
  }

  public void setAttaque(int attaque) {
    this.attaque = attaque;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public void attaquer(Personnage cible) {
    cible.prendreDegats(this.attaque);

  }

  public void prendreDegats(int degats) {
    this.defense -= degats;
  }

  public boolean estVivant() {
    return this.defense > 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nom == null) ? 0 : nom.hashCode());
    result = prime * result + pv;
    result = prime * result + attaque;
    result = prime * result + defense;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Personnage other = (Personnage) obj;
    if (nom == null) {
      if (other.nom != null)
        return false;
    } else if (!nom.equals(other.nom))
      return false;
    if (pv != other.pv)
      return false;
    if (attaque != other.attaque)
      return false;
    if (defense != other.defense)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Personnage [nom=" + nom + ", pv=" + pv + ", attaque=" + attaque + ", defense=" + defense + "]";
  }

}
