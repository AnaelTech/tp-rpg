package fr.hb.rpg.sorts;

import fr.hb.rpg.interfaces.Sort;

public class SortDeFeu implements Sort {

  @Override
  public String getNom() {
    return "Sort de feu";
  }

  @Override
  public int getDegats() {
    return 20;
  }

  @Override
  public int getMana() {
    return 10;
  }

}
