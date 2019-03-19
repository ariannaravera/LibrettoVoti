package it.polito.tdp.libretto;

import java.util.List;
import java.time.LocalDate;

public class TestLibretto {
	
	public static void main(String[] args) {
		
		Libretto libr=new Libretto();
		libr.add(new Voto(19,"Analisi I", LocalDate.of(2017, 1, 15)));
		libr.add(new Voto(20,"Analisi II", LocalDate.of(2018, 2, 3)));
		libr.add(new Voto(24,"Fisica I", LocalDate.of(2017, 6, 27)));
		libr.add(new Voto(18,"Fisica II", LocalDate.of(2018, 1, 18)));
		libr.add(new Voto(23,"Algebra Lineare e Geometria", LocalDate.of(2017, 7, 1)));
		libr.add(new Voto(25,"Economia Aziendale", LocalDate.of(2018, 1, 28)));
		libr.add(new Voto(25,"Ricerca Operativa", LocalDate.of(2018, 1, 26)));
		libr.add(new Voto(24,"Diritto Privato", LocalDate.of(2019, 1, 23)));
		libr.add(new Voto(30,"Programmazione a Oggetti", LocalDate.of(2018, 6, 25)));
		libr.add(new Voto(27,"Sistemi di produzione", LocalDate.of(2018, 7, 3)));
		
		List<Voto> venticinque=libr.cercaVoti(25);
		System.out.println(venticinque);
		
		Voto a1=libr.cercaEsame("Analisi I");
		Voto a2=libr.cercaEsame("Analisi III");
		System.out.println("\n"+a1);
		System.out.println(a2);
		
		Voto giusto=new Voto(23, "Algebra Lineare e Geometria", LocalDate.now());
		Voto sbagliato=new Voto(18, "Algebra Lineare e Geometria", LocalDate.now());
		Voto mancante=new Voto(30, "Pizza", LocalDate.now());
		System.out.format("\nIl voto %s è %s\n", giusto.toString(), libr.esisteGiaVoto(giusto));
		System.out.format("Il voto %s è %s\n", sbagliato.toString(), libr.esisteGiaVoto(sbagliato));
		System.out.format("Il voto %s è %s\n", mancante.toString(), libr.esisteGiaVoto(mancante));
		
		System.out.format("\nIl voto %s è in conflitto %s\n", giusto.toString(), libr.votoConflitto(giusto));
		System.out.format("Il voto %s è in conflitto %s\n", sbagliato.toString(), libr.votoConflitto(sbagliato));
		System.out.format("Il voto %s è in conflitto %s\n", mancante.toString(), libr.votoConflitto(mancante));
		
		System.out.println("\n"+libr.add(giusto));
		System.out.println(libr.add(sbagliato));
		System.out.println(libr.add(mancante));
		
		System.out.println(libr.toString());
		
	}

}
