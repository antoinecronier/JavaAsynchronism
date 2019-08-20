package com.tactfactory.genericity;

import com.tactfactory.genericity.entities.Moto;
import com.tactfactory.genericity.entities.Voiture;

public class Genericity {

	public static void main(String[] args) {
		GenericTestClass<Moto> maClass = new GenericTestClass<Moto>();
		maClass.setTitem(new Moto("moto1",260,"rouge",2));
		System.out.println(maClass.getTitem());
		GenericTestClass<Voiture> maClassBis = new GenericTestClass<Voiture>();
		maClassBis.setTitem(new Voiture("voiture1quidechiretropvite",90,"blanc",5));
		System.out.println(maClassBis.getTitem());
	}

//	System.out.println(fonctionGenerique(10));
//	System.out.println(fonctionGenerique(10f));
//	System.out.println(fonctionGenerique(10L));
//	System.out.println(fonctionGenerique(10.00));

	public static <T extends Number> String fonctionGenerique(T item){
		return String.valueOf((item.doubleValue() * item.floatValue() + item.intValue()));
	}

	public static String fonctionInteger(Integer item){
		return String.valueOf((item.doubleValue() * item.floatValue() + item.intValue()));
	}
}
