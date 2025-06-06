package fr.hb.rpg.personnages;

public class Dragon extends Ennemi {

  public Dragon(String nom, int pv, int attaque, int defense) {
    super(nom, pv, attaque, defense);
  }

  @Override
  public String toString() {
    return "Dragon []";
  }

}
