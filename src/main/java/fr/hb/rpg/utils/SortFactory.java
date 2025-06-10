package fr.hb.rpg.utils;

import java.util.ArrayList;
import java.util.List;

import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.sorts.SortDEclair;
import fr.hb.rpg.sorts.SortDeFeu;
import fr.hb.rpg.sorts.SortDeFroid;
import fr.hb.rpg.sorts.SortDePoison;

/**
 * La classe SortFactory permet de générer et de gérer une liste de sorts pour
 * le jeu RPG. Elle fournit des méthodes pour créer des sorts de différents
 * types (Sort de feu, Sort de froid, Sort de poison, Sort d'éclair) et pour
 * sélectionner un sort aléatoire disponible.
 */
public class SortFactory {
  private final List<Sort> sorts = new ArrayList<>();

  /**
   * Crée une nouvelle liste de sorts composée de Sort de feu, Sort de froid,
   * Sort de poison et Sort d'éclair, chacun avec des points de vie, d'attaque
   * et de défense générés aléatoirement. La liste précédente est effacée
   * avant la création.
   */
  public void createSort() {
    sorts.clear();
    sorts.add(createSort("Sort de feu"));
    sorts.add(createSort("Sort de froid"));
    sorts.add(createSort("Sort de poison"));
    sorts.add(createSort("Sort d'éclair"));
  }

  /**
   * Crée un sort avec le nom spécifié.
   * 
   * @param nom le nom du sort à créer
   * @return un sort avec le nom spécifié
   */
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

  /**
   * Retourne un sort aléatoire parmi ceux qui ont encore des points de vie.
   * Si aucun sort n'est disponible, la liste est régénérée.
   * 
   * @return un sort disponible aléatoire
   */
  public List<Sort> getSorts() {
    return sorts;
  }

}
