package com.ipiecoles.java.java220;

import java.util.Objects;

import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 * 
 * NB : Une méthode static (à éviter) ne peut utiliser que des attributs "static"
 * NB : final déclare des constantes
 */
public class Employe {

    private String nom; 
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;
    
    public Employe() {
    	
    }
    
    public Employe(String nom, String prenom,String matricule, LocalDate dateEmbauche, Double salaire) {
    	setNom(nom);
    	setPrenom(prenom);
    	setMatricule(matricule);
    	//setDateEmbauche(dateEmbauche); On ne garde pas cette commande dans le constructeur à cause de l'exception à gérer
    	this.dateEmbauche = dateEmbauche;
    	setSalaire(salaire);
    }
    
    /**
     * La méthode getNombreAnneeAnciennete calcule le nombre d'années d'ancienneté d'un employé
     * 
     * NB : Une méthode indiquée comme final ne peut être redéfinie dans une classe dérivée. 
     */
    public final Integer getNombreAnneeAnciennete() {
    	return LocalDate.now().getYear() - this.dateEmbauche.getYear();
    }
    
    /**
     * La méthode getNbConges retourne la constante de classe NB_CONGES_BASE de la classe Entreprise
     */
    public final Integer getNbConges() {
    	return Entreprise.NB_CONGES_BASE;
    }
    
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

    /**
     * Affichage textuel des attributs d'une instance
     * Format à respecter :
     * "Employe{nom='nom', prenom='prenom', matricule='12345', dateEmbauche=1970-01-01, salaire=500.0}"
     */
    @Override //Précise que cette méthode est héritée d'une autre classe
    public String toString() {
    	return "Employe{nom='" + this.nom 
    			+ "', prenom='" + this.prenom 
    			+ "', matricule='" + this.matricule 
    			+ "', dateEmbauche=" + this.dateEmbauche
    			+ ", salaire=" + this.salaire + "}";
    }
    
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Employe)) return false;
		
		Employe other = (Employe) obj;
		return hashCode() == obj.hashCode();
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the dateEmbauche
	 */
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	/**
	 * 
	 * @param dateEmbauche the dateEmbauche to set
	 */
	public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
		if(dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {
			throw new Exception ("La date d'embauche ne peut être postérieure à la date courante");
		}
		this.dateEmbauche = dateEmbauche;
	}

	/**
	 * @return the salaire
	 */
	public Double getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
}
