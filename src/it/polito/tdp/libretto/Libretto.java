package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti=new ArrayList<Voto>();
	}
	
	/**
	 * Aggiungere un nuovo voto al libretto
	 * @param v il {@link Voto} da aggiungere
	 * @return {@code true} se aggiungo correttamnete, {@code false} altrimenti
	 */
	
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v)&&!this.votoConflitto(v)) {
			voti.add(v);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * @param punti punteggio da ricerca
	 * @return lista di {@link Voto} aventi quel voto
	 */
	
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
		Voto voto=new Voto(0, nomeEsame, null);
		int pos=this.voti.indexOf(voto);
		if(pos==-1)
			return null;
		else
			return this.voti.get(pos);
	}
	
	/**
	 * Dato un {@link Voto} determina se esiste già un voto con uguale corso e punteggio
	 * @param v
	 * @return {@code true} se lo ha trovato
	 *         {@code false} se non ha torvato il corso o il voto è diveros
	 */
	public boolean esisteGiaVoto(Voto v) {
		int pos=this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else
			return (v.getPunti()==this.voti.get(pos).getPunti());
	}
	
	/**
	 * Mi dice se il voto v è in conflitto con uno dei voti esistenti.
	 * Se il voto non esiste non c'è conflitto, se invece esiste e ha punteggio diverso c'è conflitto.
	 * @param v
	 * @return {@code true} se c'è conflitto, {@code false} se non esiste, oppure esiste e non ha punteggio
	 */
	public boolean votoConflitto(Voto v) {
		int pos=this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else
			return (v.getPunti()!=this.voti.get(pos).getPunti());
	}
	
	public String toString(){
		return this.voti.toString();
	}
}
