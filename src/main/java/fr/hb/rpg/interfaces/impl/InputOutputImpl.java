package fr.hb.rpg.interfaces.impl;

import java.util.Scanner;

import fr.hb.rpg.interfaces.InputOutput;

/**
 * Classe InputOutputImpl
 * Implémentation de la classe InputOutput
 * 
 * @author Anael
 *
 */
public class InputOutputImpl implements InputOutput {
  private final Scanner scanner = new Scanner(System.in);

  /**
   * Surcharge de la méthode afficher de la classe InputOutput
   * Affiche un message
   * 
   * @param message message à afficher
   */
  @Override
  public void afficher(String message) {
    System.out.println(message);
  }

  /**
   * Surcharge de la méthode afficherSansRetour de la classe InputOutput
   * Affiche un message sans retour à la ligne
   * 
   * @param message message à afficher
   */
  @Override
  public void afficherSansRetour(String message) {
    System.out.print(message);
  }

  /**
   * Surcharge de la méthode lireString de la classe InputOutput
   * retourne un message en String
   * 
   * @return message
   */
  @Override
  public String lireString() {
    return scanner.nextLine();
  }

  /**
   * Surcharge de la méthode lireInt de la classe InputOutput
   * retourne un message en Int
   * 
   * @return message
   */
  @Override
  public Integer lireInt() {
    return scanner.nextInt();
  }

}
