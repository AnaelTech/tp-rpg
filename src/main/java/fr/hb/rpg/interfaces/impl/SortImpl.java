package fr.hb.rpg.interfaces.impl;

import fr.hb.rpg.interfaces.Sort;

public class SortImpl implements Sort {

  private String nom;
  private int degats;
  private int mana;

  public SortImpl(String nom, int degats, int mana) {
    this.nom = nom;
    this.degats = degats;
    this.mana = mana;
  }

  @Override
  public String getNom() {
    return nom;
  }

  @Override
  public int getDegats() {
    return degats;
  }

  @Override
  public int getMana() {
    return mana;
  }

}
