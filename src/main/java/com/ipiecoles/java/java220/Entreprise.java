package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Entreprise {

    public static final Double SALAIRE_BASE = 1480.27;
    public static final Integer NB_CONGES_BASE = 25;
    public static final Double INDICE_MANAGER = 1.3;
    public static final Double PRIME_MANAGER_PAR_TECHNICIEN = 250.0;
    public static final Double PRIME_ANCIENNETE = 100d; //f pour Float, L pour Long, U pour Short
    
    /**
     * La méthode primeAnnuelleBase() calcule la prime de base pour tous les employés de l'entreprise.
     * Une prime vaut 50% de l'année en cours.
     * Par ex, pour l'année 2017 : 2017 / 2 = 1008.5
     * 
     * @param aucun
     */
	public static Double primeAnnuelleBase() {
    	Integer anneeEnCours = new LocalDate().getYear();
    	return (Double) (anneeEnCours / 2d);
    }
}