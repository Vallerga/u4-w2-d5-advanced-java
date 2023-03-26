package Libreria;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Riviste extends Articolo{
	
	private String periodicità;
	
	public Riviste (String cINSB, String tit, int year, int nPag, String Per) {
		super(cINSB, tit, year, nPag);
		this.periodicità = Per;
	}
}
