package fr.hb.rpg.interfaces;

import fr.hb.rpg.personnages.Personnage;

/**
 * Interface PouvoirSpecial
 * 
 * @author Anael
 *
 */
public interface PouvoirSpecial {

  /**
   * Utilise le pouvoir spécial du héros
   * 
   * @param cible cible
   * @param sort  sort
   */
  void utiliserPouvoir(Personnage cible, Sort sort);

}
