package fr.hb.rpg.interfaces.impl;

import fr.hb.rpg.interfaces.PouvoirSpecial;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.personnages.Personnage;

public class PouvoirSpecialImpl implements PouvoirSpecial {

  // La cible est donc l'ennemi qui va recevoir le sort
  // Donc je suis le Hero
  private Sort sort;

  @Override
  public void utiliserPouvoir(Personnage cible) {
    // J'ai besoin d'utililser la factory de sort avec leurs degats et la
    switch (sort.getNom()) {
      case "Sort de feu":
        cible.prendreDegats(sort.getDegats());
        break;
      case "Sort de froid":
        cible.prendreDegats(sort.getDegats());
        break;
      case "Sort de poison":
        cible.prendreDegats(sort.getDegats());
        break;
      default:
        throw new IllegalArgumentException("Sort inconnu");
    }
  }
  // consommation de mana;

  // J'ai besoin d'un switch qui va chercher le pouvoir spécial et executer le
  // sort

  // Il doit executer le sort et reduire la consommation de mana

  // J'ai besoin d'un switch qui va chercher le pouvoir spécial et executer le

  // sort

  // Il doit executer le sort et reduire la consommation de mana

}
