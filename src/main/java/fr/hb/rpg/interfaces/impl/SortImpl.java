package fr.hb.rpg.interfaces.impl;

import fr.hb.rpg.interfaces.Sort;

/**
 * Classe SortImpl
 * Implémentation de la classe Sort
 * 
 * @author Anael
 *
 */
public class SortImpl implements Sort {

  private String nom;
  private int degats;
  private int mana;

  /**
   * Constructeur de la classe SortImpl
   * 
   * @param nom    nom du sort
   * @param degats nombre de dégats
   * @param mana   nombre de mana
   */
  public SortImpl(String nom, int degats, int mana) {
    this.nom = nom;
    this.degats = degats;
    this.mana = mana;
  }

  /**
   * Surcharge de la méthode getNom de la classe Sort
   * retourne le nom du sort
   * 
   * @return nom du sort
   */
  @Override
  public String getNom() {
    return nom;
  }

  /**
   * Surcharge de la méthode getDegats de la classe Sort
   * retourne le nombre de dégats
   * 
   * @return nombre de dégats
   */
  @Override
  public int getDegats() {
    return degats;
  }

  /**
   * Surcharge de la méthode getMana de la classe Sort
   * retourne le nombre de mana
   * 
   * @return nombre de mana
   */
  @Override
  public int getMana() {
    return mana;
  }

}
