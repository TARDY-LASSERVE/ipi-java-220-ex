package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;
import java.util.HashSet;

public class Manager extends Employe {
	
	private HashSet<Technicien> equipe = new HashSet<>();
	
	public Manager() {		
	}
	
	public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
		super(nom, prenom, matricule, dateEmbauche, salaire);
	}
	
	public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe) {
		super(nom, prenom, matricule, dateEmbauche, salaire);
		this.equipe = equipe;
	}
	
	/**
	 * La méthode getPrimeAnnuelle retourne le montant d'une prime (Double)
	 */
	public Double getPrimeAnnuelle() {
		return null; //Entreprise.primeAnnuelleBase();
	}
	
	/**
	 * @return the equipe
	 */
	public HashSet<Technicien> getEquipe() {
		return equipe;
	}

	/**
	 * @param equipe the equipe to set
	 */
	public void setEquipe(HashSet<Technicien> equipe) {
		this.equipe = equipe;
	}

	/**
	 * @param Technicien
	 */
	public void ajoutTechnicienEquipe(Technicien t) {
		this.equipe.add(t);
	}
}