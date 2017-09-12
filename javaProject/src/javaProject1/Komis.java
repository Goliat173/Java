package javaProject1;

import java.util.ArrayList;
import java.util.List;

public class Komis {

	private String wlasciciel;
	private String miejscowosc;
	private String ulica;
	private int iloscAut;
	private int id;
	private static int nextId=0;
	public List<Auto> lista = new ArrayList<Auto>();
	
	public Komis(String wlasciciel, String miejscowosc, String ulica){
		this.wlasciciel=wlasciciel;
		this.miejscowosc=miejscowosc;
		this.ulica=ulica;
		this.id=nextId;
		nextId();
	}
	
	private void nextId(){
		nextId++;
	}

	public String getWlasciciel() {
		return wlasciciel;
	}

	public void setWlasciciel(String wlasciciel) {
		this.wlasciciel = wlasciciel;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public int getIloscAut() {
		return iloscAut;
	}


	public int getId() {
		return id;
	}

	
}
