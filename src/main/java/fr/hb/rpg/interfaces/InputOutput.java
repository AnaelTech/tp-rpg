package fr.hb.rpg.interfaces;

/**
 * Interface InputOutput
 * Gère les entrées et sorties du jeu (l'affichage)
 *
 * @author Anael
 *
 */
public interface InputOutput {

  /**
   * Affiche un message
   * 
   * @param message message à afficher
   */
  void afficher(String message);

  /**
   * Affiche un message sans retour à la ligne
   * 
   * @param message message à afficher
   */
  void afficherSansRetour(String message);

  /**
   * retourne un message en String
   * 
   * @return message
   */
  String lireString();

  /**
   * retourne un message en Int
   *
   */
  Integer lireInt();

}
