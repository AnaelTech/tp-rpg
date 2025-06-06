package fr.hb.rpg.utils;

import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.sorts.SortDEclair;
import fr.hb.rpg.sorts.SortDeFroid;
import fr.hb.rpg.sorts.SortDePoison;

public class SortFactory {

  public static Sort createSort(String nom) {

    switch (nom) {
      case "Sort de feu":
        return new SortDEclair();
      case "Sort de froid":
        return new SortDeFroid();
      case "Sort de poison":
        return new SortDePoison();
      case "Sort d'éclair":
        return new SortDEclair();
      default:
        throw new IllegalArgumentException("Sort inconnu");
    }
  }

}
