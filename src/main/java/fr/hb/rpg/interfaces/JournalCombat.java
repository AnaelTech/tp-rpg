package fr.hb.rpg.interfaces;

/**
 * Interface JournalCombat
 * 
 * @author Anael
 *
 */
public interface JournalCombat {

  /**
   * Affiche le journal du combat
   * 
   * @param joueurNom nom du joueur
   * @param ennemiNom nom de l'ennemi
   * @param degats    nombre de dégats
   */
  void afficherJournalCombat(String joueurNom, String ennemiNom, int degats);

}
