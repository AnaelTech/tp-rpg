package fr.hb.rpg.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.hb.rpg.equipement.Armure;
import fr.hb.rpg.equipement.Bouclier;
import fr.hb.rpg.equipement.Couteau;
import fr.hb.rpg.equipement.Epee;
import fr.hb.rpg.equipement.LarmeDeMana;
import fr.hb.rpg.equipement.Loot;
import fr.hb.rpg.equipement.Rareté;
import fr.hb.rpg.equipement.StatType;

public class LootFactory {

  private final List<Loot> loots = new ArrayList<>();

  public void createLoot() {
    loots.clear();
    Random rand = new Random();
    for (int i = 0; i < 20; i++) {
      loots.add(new Bouclier(
          "Bouclier",
          Rareté.values()[rand.nextInt(Rareté.values().length)],
          StatType.values()[rand.nextInt(StatType.values().length)], rand.nextDouble()));
      loots.add(new Couteau(
          "Couteau",
          Rareté.values()[rand.nextInt(Rareté.values().length)],
          StatType.values()[rand.nextInt(StatType.values().length)], rand.nextDouble()));
      loots.add(new Epee(
          "Épée",
          Rareté.values()[rand.nextInt(Rareté.values().length)],
          StatType.values()[rand.nextInt(StatType.values().length)], rand.nextDouble()));
      loots.add(new LarmeDeMana(
          "Larme de mana",
          Rareté.values()[rand.nextInt(Rareté.values().length)],
          StatType.values()[rand.nextInt(StatType.values().length)], rand.nextDouble()));
      loots.add(new Armure(
          "Armure",
          Rareté.values()[rand.nextInt(Rareté.values().length)],
          StatType.values()[rand.nextInt(StatType.values().length)], rand.nextDouble()));
    }
  }

}
