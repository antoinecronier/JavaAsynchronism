package com.tactfactory.genericity.entities;

public abstract class Vehicule {

	private String nom;
	private int vitesse;
	private String couleur;

	//Getter(s) Setter(s)

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Vehicule() {
		super();
	}

	public Vehicule(String nom, int vitesse, String couleur) {
		super();
		this.nom = nom;
		this.vitesse = vitesse;
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Vehicule [nom=" + nom + ", vitesse=" + vitesse + ", couleur=" + couleur + "]";
	}
}
