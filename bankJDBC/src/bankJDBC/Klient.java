package bankJDBC;

import java.util.Date;

public class Klient {
	private String imie;
	private String nazwisko;
	private String nrDowodu;
	private Date dataUrodzenia;
	private String nrRachunku;
	
	public Klient(String imie, String nazwisko, String nrDowodu,
			Date dataUrodzenia, String nrRachunku) {
		
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nrDowodu = nrDowodu;
		this.dataUrodzenia = dataUrodzenia;
		this.nrRachunku = nrRachunku;
	}
	
	

}
