package fr.hb.rpg.personnages.classes;

import fr.hb.rpg.personnages.Hero;

public class Mage extends Hero {

  public Mage(String nom) {
    super(nom, 80, 10, 5, 100, 30, 0, 0);
  }

  @Override
  public String getClasse() {
    return "Mage";
  }

}
