package fr.hb.rpg.jeu;

import java.util.List;

import fr.hb.rpg.exceptions.EntreeInvalideException;
import fr.hb.rpg.exceptions.PasAssezDeManaException;
import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.personnages.Ennemi;
import fr.hb.rpg.personnages.Hero;
import fr.hb.rpg.personnages.classes.Guerrier;
import fr.hb.rpg.personnages.classes.Mage;
import fr.hb.rpg.personnages.classes.Voleur;

/**
 * Classe MenuService
 * Gestionnaire de menu
 * 
 * @author Anael
 *
 */
public class MenuService {

  private final InputOutput io;
  private final PasAssezDeManaException pasAssezDeManaException = new PasAssezDeManaException(
      "\u001B[31Pas assez de mana pour ce sort !\u001B[0m");
  private final EntreeInvalideException entreeInvalideException = new EntreeInvalideException(
      "\u001B[31mEntrée invalide. Veuillez saisir un nombre.\u001B[0m");

  /**
   * Constructeur de la classe MenuService
   * 
   * @param io objet de type InputOutput
   */
  public MenuService(InputOutput io) {
    this.io = io;
  }

  /**
   * Crée un héros
   * 
   * @param nom         nom du héros
   * @param choixClasse choix de classe
   * @return héros
   */
  public Hero creerHero(String nom, int choixClasse) {
    if (nom.isEmpty() || !nom.matches("^[\\p{L}0-9 '\\-]+$")) {
      io.afficher("\u001B[31mNom invalide, le nom par défaut 'Héros' sera utilisé.\u001B[0m");
      nom = "Héros";
    }

    return switch (choixClasse) {
      case 1 -> new Guerrier(nom);
      case 2 -> new Mage(nom);
      case 3 -> new Voleur(nom);
      default -> {
        io.afficher("\u001B[31mChoix de classe invalide. Le Guerrier sera utilisé par défaut.\u001B[0m");
        yield new Guerrier(nom);
      }
    };
  }

  /**
   * Menu du choix de classe
   * retourne le choix de classe
   * 
   * @return choix de classe
   */
  public int choixClasse() {
    io.afficher("");
    io.afficher("||  1. Guerrier                   ||");
    io.afficher("||  2. Mage                       ||");
    io.afficher("||  3. Voleur                     ||");
    io.afficher("");
    io.afficherSansRetour("Votre choix : ");
    return io.lireInt();
  }

  /**
   * Menu du choix du personnage
   * retourne le choix du menu
   * 
   * @param compteurPotion compteur de potion
   * @return choix du menu
   */
  public int voirMenu(int compteurPotion) {
    // ICI je vais afficher le menu pour les différents choix
    io.afficher("");
    io.afficher("||                                   ||");
    io.afficher("||   1. Attaquer                     ||");
    io.afficher("||   2. Utiliser un sort             ||");
    if (compteurPotion > 0) {
      io.afficher("||   3. Utiliser une potion          ||");
    } else {
      io.afficher("||    Plus de potion disponible      ||");
    }
    io.afficher("||   4. Revenir au menu              ||");
    io.afficher("||                                   ||");
    io.afficher("=======================================\n");
    io.afficher("");
    Integer choix = io.lireInt();
    return choix;
  }

  /**
   * Demande un nombre entre un interval
   * 
   * @param message message à afficher
   * @param min     minimum
   * @param max     maximum
   * @return nombre entre min et max
   */
  public int demanderInt(String message, int min, int max) {
    Integer val = null;
    do {
      try {
        io.afficher(message);
        val = io.lireInt();
        if (val < min || val > max) {
          io.afficher("Veuillez saisir un nombre entre " + min + " et " + max + ".");
          val = null;
        }
      } catch (Exception e) {
        io.afficher(entreeInvalideException.getMessage());
      }
    } while (val == null);
    return val;
  }

  /**
   * Utilise un sort
   * et affiche le résultat
   *
   * @param hero   héros
   * @param ennemi ennemi
   * @param sorts  liste des sorts
   */
  public void utiliserSort(Hero hero, Ennemi ennemi, List<Sort> sorts) {
    io.afficher("Quel sort voulez-vous utiliser ?");
    for (int i = 0; i < sorts.size(); i++) {
      Sort s = sorts.get(i);
      io.afficher((i + 1) + ". " + s.getNom() + " (Dégâts: " + s.getDegats() + ", Mana: " + s.getMana() + ")");
    }
    int choix = demanderInt("Entrez le numéro du sort :", 1, sorts.size()) - 1;
    Sort sortChoisi = sorts.get(choix);
    if (hero.getMana() < sortChoisi.getMana()) {
      io.afficher(pasAssezDeManaException.getMessage());
      return;
    }
    hero.utiliserPouvoir(ennemi, sortChoisi);
    io.afficher(hero.getNom() + " utilise " + sortChoisi.getNom() + " sur " + ennemi.getNom() + " et inflige "
        + sortChoisi.getDegats() + " de dégâts.");
  }
}
