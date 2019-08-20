package com.tactfactory.genericity;

import com.tactfactory.genericity.entities.Vehicule;

public class GenericTestClass <T extends Vehicule> {

	private T item;

	public T getTitem() {
		return item;
	}

	public void setTitem(T item) {
		if (item.getVitesse() > 200) {
			item.setVitesse(200);
		}
		if (item.getNom().length() > 10) {
			item.setNom(item.getNom().substring(0, 10));
		}
		this.item = item;
	}
}
