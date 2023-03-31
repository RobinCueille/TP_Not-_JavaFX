package model;

import javafx.scene.paint.Color;


/**
 * Classe représentant les couleurs qui vont être enregistrées
 * dans l'application. Chaque couleur dispose d'un nom la distinguant 
 * @author rcueille
 *
 */
public class Couleur {
	
	private String nom; 
	private int r;
	private int g; 
	private int b;
	
	/**
	 * Constructeur par défaut de la couleur, qui initialise le nom et les valeurs de la couleur 
	 * @param nom
	 * @param r
	 * @param g
	 * @param b
	 */
	public Couleur(String nom, int r, int g, int b) {
		this.nom = nom;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	/**
	 * 
	 * @return le nom de la couleur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie le nom de la couleur 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return la quantité de rouge de la couleur
	 */
	public int getR() {
		return r;
	}

	/**
	 * Modifie la quantité de rouge de la couleur  
	 * @param r
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * 
	 * @return la quantité de vert de la couleur
	 */
	public int getG() {
		return g;
	}

	/**
	 * Modifie la quantité de vert de la couleur  
	 * @param g
	 */
	public void setG(int g) {
		this.g = g;
	}

	/**
	 * 
	 * @return la quantité de bleu de la couleur
	 */
	public int getB() {
		return b;
	}

	/**
	 * Modifie la quantité de bleu de la couleur  
	 * @param b
	 */
	public void setB(int b) {
		this.b = b;
	} 
	
	/**
	 * cette méthode est utilisée dans la classe ModelGestionnaire pour 
	 * transformer un objet Couleur en un objet Color de JavaFX.
	 * @return
	 */
    public Color toColor() {
        double rouge = r / 255.0;
        double vert = g / 255.0;
        double bleu = b / 255.0;
        return new Color(rouge, vert, bleu, 1.0);
    }
	
	
}
