package Libreria;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Articolo {
	
	private String cod_ISBN;
	private String titolo;
	private LocalDate pub_year;
	private	int num_pag;
}
