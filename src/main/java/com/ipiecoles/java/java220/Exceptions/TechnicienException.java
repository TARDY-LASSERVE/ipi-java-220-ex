package com.ipiecoles.java.java220.Exceptions;

import com.ipiecoles.java.java220.Technicien;

public class TechnicienException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String GRADE = "Le grade doit être compris entre 1 et 5 : ";
	public static final String REMARQUES = "Les remarques ne doivent pas comporter plus de 100 caractères : ";
	
	/**
	 * 
	 * @param message => La classe appelante transmet son choix de constante à intégrer dans le msg
	 * @param technicien => Instance Technicien
	 * @param valeurIncorrecte => mauvaise saisie
	 */
	public TechnicienException(String message, Technicien technicien, Object valeurIncorrecte) {
		super(message + valeurIncorrecte + ", technicien : " + technicien.toString());
		System.out.println(this.getMessage());
	}
}