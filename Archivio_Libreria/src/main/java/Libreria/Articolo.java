package Libreria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public abstract class Articolo {
	
	private StringBuilder cod_ISBN;
	private String titolo;
	private int pub_year;
	private	int num_pag;
}
