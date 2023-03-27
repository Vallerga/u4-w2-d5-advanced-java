package Libreria;

import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Libreria {
	static Scanner Scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Articolo> database = new ArrayList<Articolo>();
		StringBuilder BufferPass = new StringBuilder();
		String res;

		System.out.println("");
		System.out.println("Benvenuti nell'archivio della Biblioteca!");
		System.out.println("");
		System.out.println("Vuoi CARICARE il file dall'archivio o GENERARNE uno nuovo? digita CARICA o GENERA");
		int l = 1;
		while (l > 0) {
			res = Scanner.nextLine().toUpperCase();
			if (res.equals("CARICA")) {
				System.out.println("Digita il nome del file");
				String Archivio = Scanner.nextLine();
				File file = new File(Archivio);
				try {
					String input = FileUtils.readFileToString(file, "UTF-8");
					System.out.println(input);
				} catch (IOException e) {
					e.printStackTrace();
				}

				l = 0;
			} else if (res.equals("GENERA")) {
				generaArchivio(database);
				l = 0;
			} else {
				System.out.println("Risposta non corretta.");
			}
		}
		// STAMPA, AGGIUNGI O RIMUOVI ARTICOLI

		int z = 1;
		while (z > 0) {
			System.out.println("Vuoi Stampare l'archivio? Digita Y o N");
			res = Scanner.nextLine().toUpperCase();
			if (res.equals("Y")) {
				System.out.println(database);
				System.out.println("");
				z = 0;
			} else if (res.equals("N")) {
				System.out.println("Vuoi aggiungere o rimuovere un articolo al catalogo? Digita Y o N");
				res = Scanner.nextLine().toUpperCase();
				if (res.equals("Y")) {
					int n = 1;
					while (n > 0) {
						System.out.println("Digita AGGIUNGI o RIMUOVI");
						res = Scanner.nextLine().toUpperCase();
						if (res.equals("AGGIUNGI")) {
							aggiungiArticolo(database);
							n = 0;
						} else if (res.equals("RIMUOVI")) {
							RimuoviArticolo(BufferPass, database);
							n = 0;
						} else {
							System.out.println("Risposta non corretta.");
						}
					}
				} else if (res.equals("N")) {
					z = 0;
				} else {
					System.out.println("Risposta non corretta.");
				}
			} else {
				System.out.println("Risposta non corretta.");
			}
		}

		// RICERCA NEL DATABASE X ANNO O AUTORE

		int h = 1;
		while (h > 0) {
			System.out.println("Vuoi ricercare un Articolo dell'archivio? Digita Y o N");
			res = Scanner.nextLine().toUpperCase();
			if (res.equals("Y")) {
				System.out.println("Ricerca per ANNO di pubblicazione o AUTORE? Digita ANNO oppure AUTORE");
				res = Scanner.nextLine().toUpperCase();
				if (res.equals("ANNO")) {
					ricercaPerAnno(database);
					h = 0;
				} else if (res.equals("AUTORE")) {
					ricercaPerAutore(database);
					h = 0;
				} else {
					System.out.println("Risposta non corretta.");
				}
			} else if (res.equals("N")) {
				h = 0;
			} else {
				System.out.println("Risposta non corretta.");
			}
		}

		// SALVATAGGIO FILE

		System.out.println("Salvataggio database, digita nome del file");
		String bufferName = Scanner.nextLine();
		System.out.println("Il file si chiama: " + bufferName);
		File file = new File(bufferName);
		try {
			FileUtils.writeStringToFile(file, database.toString(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("");
		System.out.println("Il programma è finito, arrivederci");

	}

	public static void generaArchivio(ArrayList<Articolo> list) {
		StringBuilder BufferPass = new StringBuilder();
		creaCodINSB(BufferPass);
		Libro a1 = new Libro(BufferPass, "Guerra e Pace", 1865, 1415, "Lev Tolstoj", "romanzo storico");
		creaCodINSB(BufferPass);
		Libro a2 = new Libro(BufferPass, "Il barone rampante", 1957, 312, "Italo Calvino", "romanzo di formazione");
		creaCodINSB(BufferPass);
		Libro a3 = new Libro(BufferPass, "Moby Dick", 1851, 750, "Herman Melville", "romanzo d'avventura");
		creaCodINSB(BufferPass);
		Libro a4 = new Libro(BufferPass, "Lepanto", 2010, 784, "Alessandro Barbero", "romanzo storico");
		creaCodINSB(BufferPass);
		Libro a5 = new Libro(BufferPass, "Delitto e castigo", 1866, 784, "Fedor Michajlovic Dostoevskij",
				"romanzo psicologico");
		creaCodINSB(BufferPass);
		Rivista a6 = new Rivista(BufferPass, "Focus", 2022, 150, "MENSILE");

		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		list.add(a6);
	}

	public static void creaCodINSB(StringBuilder buffer) {
		char[] chars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
				'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', '0' };
		buffer.setLength(0);
		buffer.setLength(8);
		Random rnd = new Random();
		int charsLength = chars.length;
		int passLength = 8;
		for (int i = 0; i < passLength; i++) {
			int index = rnd.nextInt(charsLength - i - 1);
			char a = chars[i + index];
			chars[i + index] = chars[i];
			chars[i] = a;
			buffer.append(a);
		}
	}

	public static void ricercaPerAnno(ArrayList<Articolo> list) {
		System.out.println("ricerca Articolo per ANNO di pubblicazione: ");
		int annoPub = Scanner.nextInt();
		Scanner.nextLine();
		list.stream().filter(elem -> elem.getPub_year() == annoPub)
				.forEach(articolo -> System.out.println(articolo.toString()));
	}

	public static void ricercaPerAutore(ArrayList<Articolo> list) {
		System.out.print("ricerca Articolo per AUTORE: ");
		Scanner.nextLine();
		String aut = Scanner.nextLine().toUpperCase();
		List<Articolo> libri = list.stream().filter(elem -> elem instanceof Libro).collect(Collectors.toList());
		libri.stream()
				.filter(singoloLibro -> ((Libro) singoloLibro).getAutore().toUpperCase().contains(aut.toUpperCase()))
				.forEach(Libro -> System.out.println(Libro.toString()));
	}

	public static void aggiungiArticolo(ArrayList<Articolo> list) {
		StringBuilder BufferPass = new StringBuilder();
		System.out.println("indica se é una Libro o una Rivista digitando LIBRO o RIVISTA:");
		String res = Scanner.nextLine().toUpperCase();
		if (res.equals("LIBRO")) {
			System.out.println("Digita il Titolo, l'anno di pubblicazione, numero pagine, autore, genere");
			System.out.println("Titolo: ");
			String tit = Scanner.nextLine();
			System.out.println("anno di pubblicazione: ");
			int aPub = Scanner.nextInt();
			Scanner.nextLine();
			System.out.println("numero pagine: ");
			int nPag = Scanner.nextInt();
			Scanner.nextLine();
			System.out.println("Autore: ");
			String Aut = Scanner.nextLine();
			System.out.println("Genere: ");
			String gen = Scanner.nextLine();
			creaCodINSB(BufferPass);
			Libro a7 = new Libro(BufferPass, tit, aPub, nPag, Aut, gen);
			list.add(a7);
		} else if (res.equals("RIVISTA")) {
			System.out.println("Digita il Titolo, anno di pubblicazione, numero pagine, periodicità");
			System.out.println("Titolo: ");
			String tit = Scanner.nextLine();
			System.out.println("anno di pubblicazione: ");
			int aPub = Scanner.nextInt();
			Scanner.nextLine();
			System.out.println("numero pagine: ");
			int nPag = Scanner.nextInt();
			Scanner.nextLine();
			System.out.println("Periodicità: SETTIMANALE, MENSILE, SEMESTRALE");
			String per = Scanner.nextLine().toUpperCase();
			int Check = 1;
			while (Check > 0) {
				switch (per) {
				case "SETTIMANALE":
					Check = 0;
					break;
				case "MENSILE":
					Check = 0;
					break;
				case "SEMESTRALE":
					Check = 0;
					break;
				default:
					System.out.println("Devi digitare SETTIMANALE, MENSILE, SEMESTRALE, ridigita: ");
					break;
				}
			}

			creaCodINSB(BufferPass);
			Rivista a8 = new Rivista(BufferPass, tit, aPub, nPag, per);
			list.add(a8);
		} else {
			System.out.println("Risposta non corretta.");
		}
	}

	public static void RimuoviArticolo(StringBuilder isbn, ArrayList<Articolo> list) {
		list = (ArrayList<Articolo>) list.stream().filter(e -> e.getCod_ISBN() != isbn).collect(Collectors.toList());
	}
}
