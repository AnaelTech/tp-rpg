package fr.hb.rpg.utils;

import java.util.ArrayList;
import java.util.List;

import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.sorts.SortDEclair;
import fr.hb.rpg.sorts.SortDeFeu;
import fr.hb.rpg.sorts.SortDeFroid;
import fr.hb.rpg.sorts.SortDePoison;

public class SortFactory {
  private final List<Sort> sorts = new ArrayList<>();

  public void createSort() {
    sorts.clear();
    sorts.add(createSort("Sort de feu"));
    sorts.add(createSort("Sort de froid"));
    sorts.add(createSort("Sort de poison"));
    sorts.add(createSort("Sort d'éclair"));
  }

  public Sort createSort(String nom) {
    switch (nom) {
      case "Sort de feu":
        return new SortDeFeu();
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

  public List<Sort> getSorts() {
    return sorts;
  }

}
