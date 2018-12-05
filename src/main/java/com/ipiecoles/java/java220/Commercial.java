package com.ipiecoles.java.java220;

import java.util.Objects;
import org.joda.time.LocalDate;

public class Commercial extends Employe {
	
	private Double caAnnuel;
	private Integer performance;
	private Note note;
		
	public Commercial() {
	}
	
	public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
		super(nom, prenom, matricule, dateEmbauche, salaire);
		this.caAnnuel = caAnnuel;
	}

	public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
		this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
		this.performance = performance;
		this.setNote(equivalenceNote());
	}

	/**
	 * @return the caAnnuel
	 */
	public Double getCaAnnuel() {
		return caAnnuel;
	}

	/**
	 * @param caAnnuel the caAnnuel to set
	 */
	public void setCaAnnuel(Double caAnnuel) {
		this.caAnnuel = caAnnuel;
	}
	
	/**
	 * La méthode getPrimeAnnuelle retourne le montant de la prime.
	 * La prime doit être égale à 5% du caAnnuel, avec un minimum de 500 € même en cas de chiffre d'affaire nul.
	 */
	public Double getPrimeAnnuelle() {
		Double calc = 0.0;
		if(this.getCaAnnuel() > 0.0) {
			calc = (Double) Math.ceil(0.05 * this.getCaAnnuel());
			if(calc >= 500.0) {
				return calc;
			}
		}
		return 500.0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Commercial)) return false;
		if(!super.equals(obj)) return false;
		
		Commercial other = (Commercial) obj;
		//Cette possibilité permet de ne pas redéfinir equals afin d'utiliser celui d'Employé
		return hashCode() == obj.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), caAnnuel, performance);
	}
	
	/**
	 * La méthode performanceEgale prend un Integer en paramètre qui renvoie true 
	 * si la performance du commercial est égale à celle passée en paramètre, false sinon
	 */
	public boolean performanceEgale(Integer performance) {		
		return this.performance.equals(performance);
	}
	
	/**
	 * Créer un enum note avec les valeurs INSUFFISANT, PASSABLE, BIEN, TRES_BIEN 
	 * La méthode equivalenceNote traduit une performance en Note :
	 * Si performance = 0 ou 50 : INSUFFISANT
	 * Si performance = 100 : PASSABLE
	 * Si performance = 150 : BIEN
	 * Si performance = 200 : TRES_BIEN
	 */
	public Note equivalenceNote() {
		switch(this.performance) {
			case 0 :
			case 50 :
				return Note.INSUFFISANT;
			case 100 : 
				return Note.PASSABLE;
			case 150 :
				return Note.BIEN;
			case 200 :
				return Note.TRES_BIEN;
			default : 
				//"Ce cas n'est pas géré."
				return null;
		}
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}
}