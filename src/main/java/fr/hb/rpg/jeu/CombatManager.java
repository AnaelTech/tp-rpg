package fr.hb.rpg.jeu;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.SaveScore;
import fr.hb.rpg.interfaces.Sort;
import fr.hb.rpg.personnages.Ennemi;
import fr.hb.rpg.personnages.Hero;
import fr.hb.rpg.personnages.Personnage;
import fr.hb.rpg.utils.SortFactory;
import fr.hb.rpg.utils.EnnemiFactory;

import java.util.List;

public class CombatManager {

  private final InputOutput io;
  private final MenuService menuService;
  private final SortFactory sortFactory;
  private final EnnemiFactory ennemiFactory;
  private final SaveScore saveScore;

  private int compteurPotion = 1;
  private int compteurEnnemi = 0;

  public CombatManager(InputOutput io, MenuService menuService, SortFactory sortFactory, EnnemiFactory ennemiFactory,
      SaveScore saveScore) {
    this.io = io;
    this.menuService = menuService;
    this.sortFactory = sortFactory;
    this.ennemiFactory = ennemiFactory;
    this.saveScore = saveScore;
  }

  public void combattre(Hero hero) {
    Ennemi ennemi = ennemiFactory.randomEnnemi();
    while (hero.estVivant()) {
      io.afficher("Ennemi n " + (compteurEnnemi + 1) + " : " + ennemi.getNom());
      io.afficher("=======================================");
      io.afficher("");
      io.afficher(
          hero.getNom() + " - PV " + hero.getPv() + " | Mana " + hero.getMana() + " | Potions " + compteurPotion);
      io.afficher("");
      io.afficher(ennemi.getNom() + " - PV " + ennemi.getPv());

      int choix = menuService.voirMenu(compteurPotion);
      switch (choix) {
        case 1:
          int degats = attaque(hero, ennemi);
          io.afficher(hero.getNom() + " attaque " + ennemi.getNom() + " ! Il inflige " + degats + " de dégâts.");
          if (ennemi.estVivant()) {
            degats = attaque(ennemi, hero);
            io.afficher(ennemi.getNom() + " attaque " + hero.getNom() + " ! Il inflige " + degats + " de dégâts.");
          } else {
            io.afficher("\u001B[32m" + ennemi.getNom() + " est vaincu.\u001B[0m");
            compteurEnnemi++;
            augmenterXp(hero, ennemi);
            if (hero.augmenterNiveau()) {
              augmenterNiveau(hero);
              augmenterStats(hero);
            }
            ennemi = ennemiFactory.randomEnnemi();
          }
          break;
        case 2:
          utilisationSort(hero, ennemi);
          io.afficher(ennemi.toString());
          if (ennemi.estVivant()) {
            degats = attaque(ennemi, hero);
            io.afficher(ennemi.getNom() + " attaque " + hero.getNom() + " ! Il inflige " + degats + " de dégâts.");
          }
          break;
        case 3:
          if (compteurPotion <= 0) {
            io.afficher("Vous n'avez plus de potion !");
            // TODO: Gérer cette affichage avec une exception
            break;
          }
          utilisationPotion(hero);
          break;
        case 4:
          io.afficher("Retour au menu principal.");
          saveScore.saveScore(hero.getNom(), compteurEnnemi);
          return;
        default:
          io.afficher("\u001B[31mChoix non reconnu.\u001B[0m");
          break;
      }
    }
    saveScore.saveScore(hero.getNom(), compteurEnnemi);
  }

  // Attaque
  private int attaque(Personnage attaquant, Personnage ennemi) {
    return attaquant.attaquer(ennemi);
  }

  // Utilise un sort
  private void utilisationSort(Hero hero, Ennemi ennemi) {
    List<Sort> sorts = sortFactory.getSorts();
    menuService.utiliserSort(hero, ennemi, sorts);
  }

  // Utilise une potion
  private void utilisationPotion(Hero hero) {
    hero.usePotion();
    compteurPotion--;
    io.afficher(hero.getNom() + " utilise une potion ! Il a " + hero.getPotion() + " potions restantes.");
  }

  // Gestion des XP
  private void augmenterXp(Hero hero, Ennemi ennemi) {
    switch (ennemi.getNom()) {
      case "Gobelin":
        hero.augmenterXp(10);
        break;
      case "Dragon":
        hero.augmenterXp(40);
        break;
      case "Troll":
        hero.augmenterXp(20);
        break;
      default:
        hero.augmenterXp(10);
        break;
    }
  }

  // Gestion des stats et du niveau
  private void augmenterNiveau(Hero hero) {
    hero.augmenterNiveau();
    int bonus = hero.getNiveau() * 10;
    hero.augmenterStats(bonus, bonus, bonus);
    io.afficher(
        "\u001B[33m" + hero.getNom() + " monte au niveau " + hero.getNiveau() + " ! Stats améliorées.\u001B[0m");
    io.afficher("");
    io.afficher("");
    io.afficher("\u001B[33m" + hero.toString() + " ! Stats améliorées.\u001B[0m");
  }

  // Gestion des Stats en fonction de l'XP
  private void augmenterStats(Hero hero) {
    int xp = hero.getXp();
    switch (xp) {
      case 50:
        augmenterNiveau(hero);
        break;
      case 100:
        augmenterNiveau(hero);
        break;
      case 150:
        augmenterNiveau(hero);
        break;
      case 250:
        augmenterNiveau(hero);
        break;
      case 350:
        augmenterNiveau(hero);
        break;
      default:

        break;
    }
  }

}
