package com.tactfactory.genericity.entities;

public class Moto extends Vehicule {

	private int nbCylindre;

	//Getter(s) Setter(s)

	public int getNbCylindre() {
		return nbCylindre;
	}

	public void setNbCylindre(int nbCylindre) {
		this.nbCylindre = nbCylindre;
	}

	public Moto() {
		super();
	}

	public Moto(String nom, int vitesse, String couleur, int nbCylindre) {
		super(nom, vitesse, couleur);
		this.nbCylindre = nbCylindre;
	}

	@Override
	public String toString() {
		return "Moto [nbCylindre=" + nbCylindre + ", getNom()=" + getNom() + ", getVitesse()=" + getVitesse()
				+ ", getCouleur()=" + getCouleur() + "]";
	}
}
