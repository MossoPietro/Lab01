package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	private List<String> elenco;
	
	public Parole() {
		this.elenco = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		this.elenco.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(elenco);
		return this.elenco;
	}
	
	public void reset() {
		this.elenco.clear();
	}

	@Override
	public String toString() {
		String risultato = "";
		for (String s:this.elenco)
			risultato +=s + "\n";
		return risultato;
	}
	
}
