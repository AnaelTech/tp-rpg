package fr.hb.rpg.jeu;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.impl.InputOutputImpl;
//import fr.hb.rpg.personnages.Inventaire;
import fr.hb.rpg.personnages.Hero;

/**
 * Classe MenuInventaire
 * Permet de gérer le menu d'inventaire
 * 
 * @author Anael
 *
 */
public class MenuInventaire {
  private final InputOutput io;
  // private final Inventaire inventaire;

  /**
   * Constructeur de la classe MenuInventaire
   * 
   * @param io objet de type InputOutput
   */
  public MenuInventaire(InputOutput io) {
    this.io = io;
    // this.inventaire = new Inventaire();
  }

  /**
   * Affiche le menu d'inventaire
   * 
   * @param hero objet de type Hero
   */
  public void afficherMenuInventaire(Hero hero) {
    io.afficher("");
    io.afficher("Inventaire du héros : ");
    io.afficher(hero.toString());
    io.afficher("");
    io.afficher("Inventaire : ");
    // for (int i = 0; i < inventaire.getNbItems(); i++) {
    // io.afficher(inventaire.getItem(i).toString());
    // }
    io.afficher("");
    io.afficher("Actions : ");
    io.afficher("1 - Utiliser un objet");
    io.afficher("2 - Ajouter un objet");
    io.afficher("3 - Supprimer un objet");
  }

}
