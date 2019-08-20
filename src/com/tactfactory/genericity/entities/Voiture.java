package com.tactfactory.genericity.entities;

public class Voiture extends Vehicule {

	private int nbPorte;

	//Getter(s) Setter(s)

	public int getNbPorte() {
		return nbPorte;
	}

	public void setNbPorte(int nbPorte) {
		this.nbPorte = nbPorte;
	}

	public Voiture() {
		super();
	}

	public Voiture(String nom, int vitesse, String couleur, int nbPorte) {
		super(nom, vitesse, couleur);
		this.nbPorte = nbPorte;
	}

	@Override
	public String toString() {
		return "Voiture [nbPorte=" + nbPorte + ", getNom()=" + getNom() + ", getVitesse()=" + getVitesse()
				+ ", getCouleur()=" + getCouleur() + "]";
	}
}
