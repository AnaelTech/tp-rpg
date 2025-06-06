package fr.hb.rpg.interfaces;

public interface InputOutput {

  void afficher(String message);

  void afficherSansRetour(String message);

  String lireString();

  Integer lireInt();

}
