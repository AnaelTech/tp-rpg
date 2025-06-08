package fr.hb.rpg.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import fr.hb.rpg.personnages.Gobelin;
import fr.hb.rpg.personnages.Troll;
import fr.hb.rpg.personnages.Dragon;
import fr.hb.rpg.personnages.Ennemi;

public class EnnemiFactory {
  private final List<Ennemi> ennemis = new ArrayList<>();

  public void creerEnnemis() {
    ennemis.clear();
    Random rand = new Random();
    for (int i = 0; i < 20; i++) {
      ennemis.add(new Gobelin(
          "Gobelin",
          rand.nextInt(21) + 40,
          rand.nextInt(6) + 5,
          rand.nextInt(5) + 3));
      ennemis.add(new Troll(
          "Troll",
          rand.nextInt(31) + 60,
          rand.nextInt(21) + 20,
          rand.nextInt(11) + 10));
      ennemis.add(new Dragon(
          "Dragon",
          rand.nextInt(21) + 100,
          rand.nextInt(21) + 50,
          rand.nextInt(11) + 30));
    }
  }

  public Ennemi randomEnnemi() {
    List<Ennemi> disponibles = new ArrayList<>();
    for (Ennemi e : ennemis) {
      if (e.getPv() > 0)
        disponibles.add(e);
    }
    if (disponibles.isEmpty()) {
      creerEnnemis();
      disponibles.addAll(ennemis);
    }
    int index = (int) (Math.random() * disponibles.size());
    return disponibles.get(index);
  }
}
