package Libreria;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Libri extends Articolo {
	
	private String autore;
	private String genere;
	
}
