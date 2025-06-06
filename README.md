# tp-rpg

Ceci est un projet d'examen en Java pour créer un jeu de rôle (RPG) en console.

## 📚 Description

Le but du projet est de développer un jeu de rôle (RPG) jouable en console, où le joueur incarne un héros affrontant une infinité d'ennemis générés aléatoirement dans des combats au tour par tour. L’objectif est de vaincre le plus d’ennemis possible avant de mourir. À la fin de la partie, le score (nombre d’ennemis vaincus) est affiché et sauvegardé dans un fichier associé au nom du joueur.

## ❌ Difficultés

- Rendre mon code modulaire et réutilisable
- Identifier les différentes classes et interfaces
- Réflexion sur l'utilisation des Design Patterns

## 📚 Fonctionnalités attendues

### 1. **Création des entités**

- [x] Classe abstraite `Personnage` avec :
  - [x] `nom`, `pv`, `attaque`, `défense`
  - [x] méthode `attaquer(Personnage cible)`
  - [x] méthode `prendreDegats(int degats)`
  - [x] méthode `estVivant()`
- [x] Classe `Hero` héritant de `Personnage` avec :
  - [x] `mana`
  - [x] méthode `utiliserPouvoir(Personnage cible)` (ex : sort de feu)
  - [x] gestion de potions de soin (1 par combat)
- [x] Classe `Ennemi` héritant de `Personnage`, avec plusieurs variantes :
  - [x] `Gobelin`, `Dragon`, `Troll`, etc.

---

### 2. **Interface de Pouvoir**

- [x] Interface `PouvoirSpecial` :
  ```java
  void utiliserPouvoir(Personnage cible);
  ```
- [x] Implémentée par `Hero` pour les sorts magiques (infligeant plus de dégâts, consommant du mana)
- [x] Peut être réutilisée plus tard pour des ennemis spéciaux

---

### 3. **Combat tour par tour**

- [x] Le joueur choisit entre : attaquer, utiliser un pouvoir, ou une potion
- [x] L’ennemi attaque automatiquement s’il est vivant
- [x] Affichage console dynamique :
  ```
  > Arthus attaque Troll ! Il inflige 12 dégâts.
  > Troll attaque Arthus ! Il inflige 6 dégâts.
  ```
- [x] Le joueur voit :
  - [x] Le numéro de l’ennemi rencontré
  - [x] Ses propres PV, mana, et potions restantes
  - [x] Les PV de l’adversaire

---

### 4. **Ennemis générés aléatoirement**

- [x] À chaque victoire, un nouvel ennemi est généré aléatoirement
- [x] Le jeu continue jusqu’à ce que le joueur meure

---

### 5. **Compteur et score**

- [x] Un compteur d’ennemis vaincus est affiché à la fin
- [x] Le score est sauvegardé dans un fichier `scores.txt` au format :
  ```
  Arthus a vaincu 6 ennemis
  ```

---

### 6. **Gestion des exceptions**

- [x] Entrée invalide → message d'erreur et nouvelle demande
- [x] Pas assez de mana → message d’erreur sans action
- [x] Plus de potion → message d’erreur

---

## ✨ Fonctionnalités bonus à implémenter (futur)

### 🧙‍♂️ 1. Système d’expérience (XP) et montée de niveau

- [x] Le héros gagne de l’XP après chaque combat
- [x] À chaque niveau : augmentation de stats (PV, attaque, mana...)

### ⚔️ 2. Choix de la classe du héros

- [ ] Avant de commencer, le joueur choisit une classe (Guerrier, Mage, Voleur)

### 🎒 3. Inventaire complet

- [ ] Ramassage de loot (potions, armes, objets spéciaux)
- [ ] Gestion dynamique de l’inventaire (affichage, utilisation)

### 🛡️ 4. Système d’équipement

- [ ] Le héros peut s’équiper d’armes et armures (épée, armure…)

### 🧠 5. Ennemis plus intelligents

- [ ] Compétences spéciales, IA conditionnelle

### 🪙 6. Système de monnaie et boutique

- [ ] Pièces d’or, boutique entre les combats

### 📜 7. Fichier de sauvegarde de partie

- [ ] Sauvegarde/reprise de partie

### 🏆 8. Classement des meilleurs scores

- [ ] Affichage du top 5 des scores

### 💀 9. Boss aléatoires avec nom généré

- [ ] Boss toutes les 5 victoires

### 🌋 10. Niveaux ou zones progressives

- [ ] Difficulté croissante, zones

### 📖 11. Journal de combat

- [ ] `journal.txt` avec tout l’historique

### 🎲 12. Attaques critiques ou esquives aléatoires

- [ ] Chances de critique/esquive

### ⌛ 13. Pouvoirs à rechargement

- [ ] Certains sorts limités dans le temps

### 🎭 14. Alliés temporaires

- [ ] Recrutement d’alliés pour un combat

### 🧩 15. Événements aléatoires entre combats

- [ ] Pièges, trésors, embuscades

### 🧪 16. Système de statut : poison, gel, brûlure

- [ ] Effets persistants

### 🧬 17. Ennemis générés dynamiquement

- [ ] Procédural, stats et noms aléatoires

### 🧾 18. Interface `Affichable` pour tous les personnages

- [ ] Méthode `afficherFiche()`

### 🎨 19. Affichage en ASCII Art

- [ ] Illustrations monstres/héros

### 🎚️ 20. Système de difficulté

- [ ] Facile / Normal / Difficile

---

## 🛠️ Installation

1. Clone le projet :
   ```bash
   git clone https://github.com/AnaelTech/tp-rpg.git
   cd tp-rpg
   ```
2. Compile le projet :
   ```bash
   javac -d bin src/main/java/fr/hb/rpg/*.java
   ```
3. Lance le jeu :

   ```bash
   java -cp bin fr.hb.rpg.App
   ```

   Ou utilisation avec Maven :

4. Compile le projet :

   ```bash
   mvn clean install
   ```

5. Lance le jeu :
   ```bash
   mvn exec:java
   ```

## ▶️ Utilisation

Au lancement, le jeu demande le nom du héros. Ensuite, le joueur affronte des ennemis aléatoires dans des combats au tour par tour en choisissant chaque action via la console.

À la fin, le nombre d’ennemis vaincus est affiché et sauvegardé dans le fichier `scores.txt`.

## Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :

1. Fork le projet
2. Créer une branche pour votre fonctionnalité
3. Commit vos changements
4. Push vers la branche
5. Ouvrir une Pull Request

## Licence

Ce projet est sous licence [MIT](LICENSE).

---

_Généré avec le script GitHub Repository Creator_
