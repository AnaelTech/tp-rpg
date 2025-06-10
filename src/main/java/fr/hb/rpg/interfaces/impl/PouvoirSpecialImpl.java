package fr.hb.rpg.interfaces.impl;

import fr.hb.rpg.interfaces.PouvoirSpecial;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.personnages.Personnage;

/**
 * Classe PouvoirSpecialImpl
 * Implémentation de la classe PouvoirSpecial
 * 
 * @author Anael
 *
 */
public class PouvoirSpecialImpl implements PouvoirSpecial {
  /**
   * Surcharge de la méthode utilisePouvoir de la classe PouvoirSpecial
   * Si le sort est de feu, de froid, de poison ou d'éclair, le cible prend des
   * dégats
   * Si le sort est inconnu, une exception est lancée
   *
   * @param cible cible
   * @param sort  sort
   */
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
