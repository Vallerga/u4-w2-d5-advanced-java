package Libreria;

import java.time.LocalDate;
import java.util.ArrayList;

public class Libreria {
	public static void main (String[]args) {
		Libri a1 = new Libri("abcdef", "Libro brutto", 1985, 243, "Non Barbero", "Vorre esser Barbero");
		Libri a2 = new Libri("gfgdar", "Scrivo per soldi", 1995, 50, "Checco Zalone", "Supercazzola Antani");
		Libri a3 = new Libri("awrgad", "Barbero sposami", 2003, 600, "Antonio Vallerga", "Carlo Magno o le Tapparelle");
		System.out.println("primo articolo aggiunto: " + a1);
		
		ArrayList<Libri> database = new ArrayList<Libri>();
		
		database.add(a1);
		database.add(a2);
		database.add(a3);
		System.out.println(database); 
	}	
	
}

