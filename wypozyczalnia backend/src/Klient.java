import java.util.Date;


public class Klient {
	
	private String imie;
	private String nazwisko;
	private String nrDowodu;
	private Egzamplarz wybraneAuto;
	private Date odkad;
	private Date dokad;
	//wiele wiêcej ;)
	
	public Klient(String imie, String nazwisko, String nrDowodu){
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.nrDowodu=nrDowodu;
	}

	public Egzamplarz getWybraneAuto() {
		return wybraneAuto;
	}

	public void setWybraneAuto(Egzamplarz wybraneAuto) {
		this.wybraneAuto = wybraneAuto;
	}

	@Override
	public String toString() {
		return "Klient [imie= " + imie + ", nazwisko= " + nazwisko
				+ ", nrDowodu= " + nrDowodu + ", wybraneAuto=" + wybraneAuto.marka+" "+wybraneAuto.model+", "+wybraneAuto.nrRejestracji
				+ " \nOd: "+odkad+" Do:"+dokad+"]";
	}

	public Date getOdkad() {
		return odkad;
	}

	public void setOdkad(Date odkad) {
		this.odkad = odkad;
	}

	public Date getDokad() {
		return dokad;
	}

	public void setDokad(Date dokad) {
		this.dokad = dokad;
	}
	
	


}
