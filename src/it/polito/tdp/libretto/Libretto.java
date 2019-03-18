package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti=new ArrayList<Voto>();
	}
	
	//Aggiungere un nuovo voto al libretto
	//@param v  il {@link Voto} da aggiungere
	
	public void add(Voto v) {
		voti.add(v);
	}
	
	//Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	//@param punti punteggio da ricerca
	//@return lista di {@link Voto} aventi quel voto
	
	public List<Voto> cercaVoti(int voto) {
		List<Voto> result=new ArrayList<Voto>();
		for(Voto v:this.voti) {
			if(v.getPunti()==voto) {
				result.add(v);
			}
		}
		return result;
	}
	
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v:this.voti) {
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}
		return null;
	}
}
