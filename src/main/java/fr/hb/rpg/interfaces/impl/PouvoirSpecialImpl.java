package fr.hb.rpg.interfaces.impl;

import fr.hb.rpg.interfaces.PouvoirSpecial;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.personnages.Personnage;

public class PouvoirSpecialImpl implements PouvoirSpecial {
  @Override
  public void utiliserPouvoir(Personnage cible, Sort sort) {
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
      case "Sort d'éclair":
        cible.prendreDegats(sort.getDegats());
        break;
      default:
        throw new IllegalArgumentException("Sort inconnu");
    }
  }
}
