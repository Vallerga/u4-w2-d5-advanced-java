package Libreria;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper=true)
public class Rivista extends Articolo{
	
	private String periodicità;
	
	public Rivista (StringBuilder cINSB, String tit, int year, int nPag, String Per) {
		super(cINSB, tit, year, nPag);
		this.periodicità = Per;
	}
}
