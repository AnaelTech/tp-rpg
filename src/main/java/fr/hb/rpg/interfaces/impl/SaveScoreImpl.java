package fr.hb.rpg.interfaces.impl;

import java.io.FileWriter;
import java.io.IOException;

import fr.hb.rpg.interfaces.SaveScore;

public class SaveScoreImpl implements SaveScore {
  private final String filePath = "score.txt";

  @Override
  public void saveScore(String playerName, int score) {
    try (FileWriter writer = new FileWriter(filePath, true)) {
      writer.write(playerName + " a vaincu " + score + " ennemis" + System.lineSeparator());
    } catch (IOException e) {
      System.err.println("Erreur lors de l'enregistrement du score : " + e.getMessage());
    }
  }

}
