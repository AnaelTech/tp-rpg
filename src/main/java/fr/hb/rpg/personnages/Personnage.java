package fr.hb.rpg.personnages;

/**
 * Classe Personnage
 * Classe abstraite qui contient les attributs et méthodes communs à tous les
 * personnages
 * 
 * @author Anael
 *
 */
public abstract class Personnage {

  protected Long id;
  protected String nom;
  protected int pv;
  protected int attaque;
  protected int defense;
  protected Long compteurId = 0L;

  /**
   * Constructeur de la classe Personnage
   * 
   * @param nom     nom du personnage
   * @param pv      points de vie
   * @param attaque dégâts
   * @param defense défense
   */
  public Personnage(String nom, int pv, int attaque, int defense) {
    super();
    this.id = ++compteurId;
    this.nom = nom;
    this.pv = pv;
    this.attaque = attaque;
    this.defense = defense;
  }

  /**
   * retourne l'id du personnage
   * 
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * Affecte l'id du personnage
   * 
   * @param id id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * retourne le compteur id
   * 
   * @return compteur id
   */
  public Long getCompteurId() {
    return compteurId;
  }

  /**
   * Affecte le compteur id
   * 
   * @param compteurId compteur id
   */
  public void setCompteurId(Long compteurId) {
    this.compteurId = compteurId;
  }

  /**
   * retourne le nom du personnage
   * 
   * @return nom
   */
  public String getNom() {
    return nom;
  }

  /**
   * Affecte le nom du personnage
   * 
   * @param nom nom
   */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * retourne le nombre de points de vie
   * 
   * @return nombre de points de vie
   */
  public int getPv() {
    return pv;
  }

  /**
   * Affecte le nombre de points de vie
   * 
   * @param pv nombre de points de vie
   */
  public void setPv(int pv) {
    this.pv = pv;
  }

  /**
   * retourne l'attaque
   * 
   * @return attaque
   */
  public int getAttaque() {
    return attaque;
  }

  /**
   * Affecte l'attaque
   * 
   * @param attaque attaque
   */
  public void setAttaque(int attaque) {
    this.attaque = attaque;
  }

  /**
   * retourne la défense
   * 
   * @return défense
   */
  public int getDefense() {
    return defense;
  }

  /**
   * Affecte la défense
   * 
   * @param defense défense
   */
  public void setDefense(int defense) {
    this.defense = defense;
  }

  public int attaquer(Personnage cible) {
    return cible.prendreDegats(this.attaque);
  }

  /**
   * retourne le nombre de dégâts qu'un ennemi inflige à un héros
   * 
   * @return nombre de dégâts qu'un ennemi inflige à un héros
   */
  public int prendreDegats(int degats) {
    int degatsReels = Math.max(1, degats - this.defense / 2);
    this.pv -= degatsReels;
    return degatsReels;
  }

  /**
   * retourne si le personnage est vivant
   * 
   * @return true si le personnage est vivant, false sinon
   */
  public boolean estVivant() {
    if (this.pv > 0) {
      return true;
    }
    return false;
  }

  /**
   * Surcharge de la méthode hashCode de la classe Object
   * 
   * @return hashCode
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nom == null) ? 0 : nom.hashCode());
    result = prime * result + pv;
    result = prime * result + attaque;
    result = prime * result + defense;
    return result;
  }

  /**
   * Surcharge de la méthode equals de la classe Object
   * 
   * @return equals
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Personnage other = (Personnage) obj;
    if (nom == null) {
      if (other.nom != null)
        return false;
    } else if (!nom.equals(other.nom))
      return false;
    if (pv != other.pv)
      return false;
    if (attaque != other.attaque)
      return false;
    if (defense != other.defense)
      return false;
    return true;
  }

  /**
   * Surcharge de la méthode toString de la classe Object
   * retourne une chaîne de caractères représentant le personnage
   * 
   * @return une chaîne de caractères représentant le personnage
   */
  @Override
  public String toString() {
    return "Personnage [nom=" + nom + ", pv=" + pv + ", attaque=" + attaque + ", defense=" + defense + "]";
  }

}
