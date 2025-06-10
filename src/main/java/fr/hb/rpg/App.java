package fr.hb.rpg;

import fr.hb.rpg.interfaces.impl.InputOutputImpl;
import fr.hb.rpg.jeu.GameEngine;

/**
 * Lance le jeu
 * 
 * @author Anael
 *
 */
public class App {
  public static void main(String[] args) {
    GameEngine gameEngine = new GameEngine(new InputOutputImpl());
    gameEngine.lancer();
  }
}
