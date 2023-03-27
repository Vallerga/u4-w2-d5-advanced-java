package Libreria;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper=true)

public class Libro extends Articolo {
	
	private String autore;
	private String genere;
	
	public Libro (StringBuilder cINSB, String tit, int year, int nPag, String aut, String gen) {
		super(cINSB, tit, year, nPag);
		this.autore = aut;
		this.genere = gen;		
	}
}
