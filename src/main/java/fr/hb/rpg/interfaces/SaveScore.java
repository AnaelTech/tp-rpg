package fr.hb.rpg.interfaces;

/**
 * Interface SaveScore
 * 
 * @author Anael
 *
 */
public interface SaveScore {

  /**
   * Sauvegarde le score du joueur
   * 
   * @param playerName nom du joueur
   * @param score      score du joueur
   */
  void saveScore(String playerName, int score);

}
