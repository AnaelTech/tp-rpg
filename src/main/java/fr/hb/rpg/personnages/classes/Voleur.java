package fr.hb.rpg.personnages.classes;

import fr.hb.rpg.personnages.Hero;

public class Voleur extends Hero {

  public Voleur(String nom) {
    super(nom, 100, 15, 10, 40, 25, 0, 0);
  }

  @Override
  public String getClasse() {
    return "Voleur";
  }

}
