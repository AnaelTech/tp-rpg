package fr.hb.rpg.jeu;

import fr.hb.rpg.interfaces.InputOutput;
import fr.hb.rpg.interfaces.SaveScore;
import fr.hb.rpg.interfaces.VoirLogo;
import fr.hb.rpg.interfaces.impl.SaveScoreImpl;
import fr.hb.rpg.interfaces.impl.VoirLogoImpl;
import fr.hb.rpg.personnages.Hero;
import fr.hb.rpg.utils.EnnemiFactory;
import fr.hb.rpg.utils.LootFactory;
import fr.hb.rpg.utils.SortFactory;

/**
 * Classe GameEngine
 * Il gère le lancement du jeu, l'affichage du logo, la création des sorts et
 * des ennemis,
 * la création du héros et la gestion du combat
 * Ce sera celui qui sera appelé par le main
 *
 * @author Anael
 *
 */
public class GameEngine {
  private final InputOutput io;
  private final CombatManager combatManager;
  private final VoirLogo voirLogo;
  private final MenuService menuService;
  private final EnnemiFactory ennemiFactory;
  private final SortFactory sortFactory;
  private final SaveScore saveScore;
  private final LootFactory lootFactory;

  /**
   * Constructeur de la classe GameEngine
   * 
   * @param io objet de type InputOutput
   */
  public GameEngine(InputOutput io) {
    this.io = io;
    this.voirLogo = new VoirLogoImpl();
    this.menuService = new MenuService(io);
    this.ennemiFactory = new EnnemiFactory();
    this.sortFactory = new SortFactory();
    this.lootFactory = new LootFactory();
    this.saveScore = new SaveScoreImpl();
    this.combatManager = new CombatManager(io, menuService, sortFactory, ennemiFactory, saveScore);
  }

  /**
   * Lance le jeu
   * Affiche le logo, crée les sorts et les ennemis,
   * Définit le héros et le fait combattre
   *
   *
   */
  public void lancer() {
    voirLogo.voirLogo();
    sortFactory.createSort();
    // lootFactory.createLoot();
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
