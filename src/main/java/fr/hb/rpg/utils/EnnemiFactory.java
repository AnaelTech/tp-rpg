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
          rand.nextInt(41) + 60,
          rand.nextInt(10) + 15,
          rand.nextInt(5) + 10));
      ennemis.add(new Troll(
          "Troll",
          rand.nextInt(61) + 90,
          rand.nextInt(21) + 60,
          rand.nextInt(21) + 30));
      ennemis.add(new Dragon(
          "Dragon",
          rand.nextInt(51) + 120,
          rand.nextInt(31) + 80,
          rand.nextInt(21) + 40));
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
