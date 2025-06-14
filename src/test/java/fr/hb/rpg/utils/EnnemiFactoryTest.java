package fr.hb.rpg.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.hb.rpg.personnages.Ennemi;

class EnnemiFactoryTest {

  private EnnemiFactory factory;

  @BeforeEach
  void setUp() {
    factory = new EnnemiFactory();
    factory.creerEnnemis();
  }

  @Test
  void testRandomEnnemiNotNull() {
    Ennemi ennemi = factory.randomEnnemi();
    assertNotNull(ennemi, "L'ennemi retourné ne doit pas être null");
  }

  @Test
  void testRandomEnnemiHasValidStats() {
    Ennemi ennemi = factory.randomEnnemi();
    assertTrue(ennemi.getPv() > 0, "Les PV doivent être positifs");
    assertTrue(ennemi.getAttaque() >= 0, "L'attaque ne doit pas être négative");
    assertTrue(ennemi.getDefense() >= 0, "La défense ne doit pas être négative");
  }
}
