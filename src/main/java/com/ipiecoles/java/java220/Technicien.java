package com.ipiecoles.java.java220;

import java.util.Objects;
import org.joda.time.LocalDate;
import com.ipiecoles.java.java220.Exceptions.*;

public class Technicien extends Employe implements Comparable<Technicien> {
	
	private Integer grade;
	
	public Technicien () {
	}
	
	public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
		super(nom, prenom, matricule, dateEmbauche, salaire);
		this.grade=grade;
		this.setSalaire(salaire); //Afin de le màj en fonction du grade
	}

	/**
	 * L'interface Comparable permet de comparer deux Techniciens en fonction de leur grade
	 * plus le grade est haut, plus le technicien est compétent
	 */
	public int compareTo(Technicien o) {
		return Integer.compare(o.getGrade(), this.grade);
	}
	
	/**
	 * La méthode getPrimeAnnuelle retourne le montant d'une prime (Double)
	 * Dans cette classe on ajoute à la prime annuelle un pourcentage en fonction du grade (idem exo 305)
	 * ainsi que la prime d'ancienneté multipliée par le nombre d'année d'ancienneté
	 */
	public Double getPrimeAnnuelle() {
		Double primeAnnuelleBase = Entreprise.primeAnnuelleBase();
		return primeAnnuelleBase + primeAnnuelleBase * ((double) grade / 10) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
	}
	
	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * Teste l'exception sur l'initialisation du Grade
	 * Le message est : "Le grade doit être compris entre 1 et 5 : X, technicien : 
	 * Technicien{grade=X} Employe{nom='NOM', prenom='PRENOM', matricule='MATRICULE', dateEmbauche=DATE, salaire=SALAIRE}"
	 * 
	 * @param grade the grade to set
	 */
	public void setGrade(Integer grade) throws TechnicienException {		
		if(grade != null && grade >= 1 && grade <= 5) {
			this.grade = grade;
		}
		else {
			throw new TechnicienException (TechnicienException.GRADE, this, grade);
		}
	}
	
	/**
	 * Ajout de la bonification du grade au salaire
	 * Cette bonification est égale à une augmentation de X0% par rapport au salaire de base :
	 * Ex : Grade 3 : 30% d'augmentation : 1000.0 de salaire avec grade 1 : 1100.0
	 * 
	 * @param salaire the salaire to set
	 */
	@Override
	public void setSalaire(Double salaire) {
		Double bonification = this.grade * 0.1;
		super.setSalaire(salaire + (salaire * bonification));
	}
	
	/**
	 * Retourne le nombre de congés de base + autant de congés que d'année d'ancienneté.
	 */
	public Integer getNbConges() {
		return super.getNbConges() + this.getNombreAnneeAnciennete();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Technicien{grade=" + this.grade + "} " + super.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.grade);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Technicien)) {
			return false;
		}
		Technicien other = (Technicien) obj;
		return Objects.equals(grade, other.grade);
	}

	
}