package fr.hb.rpg.personnages.classes;

import fr.hb.rpg.personnages.Hero;

public class Guerrier extends Hero {

  public Guerrier(String nom) {
    super(nom, 150, 20, 15, 20, 30, 0, 0);
  }

  @Override
  public String getClasse() {
    return "Guerrier";
  }

}
