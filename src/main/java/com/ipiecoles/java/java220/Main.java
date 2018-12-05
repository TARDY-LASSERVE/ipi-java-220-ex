package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Main {
	
	public static void main (String[] args) {
		Technicien technicien = new Technicien("Durand", "Pierre", "01234", LocalDate.now(), 1234.5, 3);		

		Manager m = new Manager("Durand", "Simon", "56789", LocalDate.now(), 1234.5);
		m.ajoutTechnicienEquipe(technicien);
		for (Technicien t : m.getEquipe()) {
			System.out.println(t.toString());
		}
		
	}
}