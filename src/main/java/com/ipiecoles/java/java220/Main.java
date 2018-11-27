package com.ipiecoles.java.java220;

import java.sql.Date;
import org.joda.time.LocalDate;

public class Main {
	
	public static void Main() {
		LocalDate date = new LocalDate();
		date = LocalDate.fromDateFields(Date.valueOf("01/01/2017"));
		Employe employe = new Employe("Durand", "Pierre", "01234", date, 1234.5);
		employe.toString();
	}
}