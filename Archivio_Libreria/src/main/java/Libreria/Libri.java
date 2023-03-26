package Libreria;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString(callSuper=true)

public class Libri extends Articolo {
	
	private String autore;
	private String genere;
	
	public Libri (String cINSB, String tit, int year, int nPag, String a, String b) {
		super(cINSB, tit, year, nPag);
		this.autore = a;
		this.genere = b;		
	}
}
