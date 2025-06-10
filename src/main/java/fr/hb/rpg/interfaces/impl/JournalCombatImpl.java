package fr.hb.rpg.interfaces.impl;

import java.io.FileWriter;
import java.io.IOException;

import fr.hb.rpg.interfaces.JournalCombat;

/**
 * Classe JournalCombatImpl
 * Implémentation de la classe JournalCombat
 * 
 * @author Anael
 *
 */
public class JournalCombatImpl implements JournalCombat {
  private final String filePath = "journal.txt";

  /**
   * Affiche le journal du combat
   * 
   * @param joueurNom nom du joueur
   * @param ennemiNom nom de l'ennemi
   * @param degats    nombre de dégats
   */
  @Override
  public void afficherJournalCombat(String joueurNom, String ennemiNom, int degats) {
    try (FileWriter writer = new FileWriter(filePath, true)) {
      writer.write("Joueur : " + joueurNom + " ennemi : " + ennemiNom + " degats : " + degats
          + System.lineSeparator());
    } catch (IOException e) {
      System.err.println("Erreur lors de l'enregistrement de l'historique : " + e.getMessage());
    }
  }

}
