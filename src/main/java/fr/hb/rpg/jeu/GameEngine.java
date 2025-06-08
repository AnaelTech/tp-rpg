package fr.hb.rpg.jeu;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.SaveScore;
import fr.hb.rpg.interfaces.VoirLogo;
import fr.hb.rpg.interfaces.impl.SaveScoreImpl;
import fr.hb.rpg.interfaces.impl.VoirLogoImpl;
import fr.hb.rpg.personnages.Hero;
import fr.hb.rpg.utils.EnnemiFactory;
import fr.hb.rpg.utils.SortFactory;

public class GameEngine {
  private final InputOutput io;
  private final CombatManager combatManager;
  private final VoirLogo voirLogo;
  private final MenuService menuService;
  private final EnnemiFactory ennemiFactory;
  private final SortFactory sortFactory;
  private final SaveScore saveScore;

  public GameEngine(InputOutput io) {
    this.io = io;
    this.voirLogo = new VoirLogoImpl();
    this.menuService = new MenuService(io);
    this.ennemiFactory = new EnnemiFactory();
    this.sortFactory = new SortFactory();
    this.saveScore = new SaveScoreImpl();
    this.combatManager = new CombatManager(io, menuService, sortFactory, ennemiFactory, saveScore);
  }

  public void lancer() {
    voirLogo.voirLogo();
    sortFactory.createSort();
    ennemiFactory.creerEnnemis();

    io.afficherSansRetour("Entrez votre nom héros : ");
    String nom = io.lireString();
    io.afficher("");
    io.afficher("Choississez une classe : ");
    int classe = menuService.choixClasse();
    Hero hero = menuService.creerHero(nom, classe);
    io.afficher(hero.toString());
    io.afficher("");

    while (hero.estVivant()) {
      ennemiFactory.creerEnnemis();
      combatManager.combattre(hero);
    }
    io.afficher(hero.toString());

  }

}
