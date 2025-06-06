package fr.hb.rpg.interfaces.impl;

import java.util.Scanner;

import fr.hb.rpg.interfaces.InputOutput;

public class InputOutputImpl implements InputOutput {
  private final Scanner scanner = new Scanner(System.in);

  @Override
  public void afficher(String message) {
    System.out.println(message);
  }

  @Override
  public String lireString() {
    return scanner.nextLine();
  }

  @Override
  public Integer lireInt() {
    return scanner.nextInt();
  }

}
