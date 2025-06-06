package fr.hb.rpg.personnages;

public class Gobelin extends Ennemi {

  public Gobelin(String nom, int pv, int attaque, int defense) {
    super(nom, pv, attaque, defense);
  }

  @Override
  public String toString() {
    return "Gobelin []";
  }
}
