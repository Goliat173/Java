import java.util.Date;
import java.util.LinkedHashMap;


public class Egzamplarz {
String marka;
String model;
String nrRejestracji;
int cena;
int lMiejsc;
String segment;
LinkedHashMap<Date,Boolean> dostepnosc=new LinkedHashMap<Date,Boolean>();

public Egzamplarz(String marka, String model, String nrRejestracji, int cena, int lMiejsc, String segment) {
	this.marka=marka;
	this.model = model;
	this.nrRejestracji = nrRejestracji;
	this.cena = cena;
	this.lMiejsc = lMiejsc;
	this.segment = segment;
}

public String toString(){
	return "Marka: "+marka+" Model: "+model+" NrRej: "+nrRejestracji+" Cena: "+cena+" L.miej.: "+lMiejsc+" Segment: "+segment+dostepnosc.toString();
}

public LinkedHashMap<Date, Boolean> getDostepnosc() {
	return dostepnosc;
}

public void setDostepnosc(LinkedHashMap<Date, Boolean> dostepnosc) {
	this.dostepnosc = dostepnosc;
}




}
