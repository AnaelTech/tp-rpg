package fr.hb.rpg.personnages;

public class Troll extends Ennemi {

  public Troll(String nom, int pv, int attaque, int defense) {
    super(nom, pv, attaque, defense);
  }

  @Override
  public String toString() {
    return "Troll []";
  }

}
