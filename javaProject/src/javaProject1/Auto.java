package javaProject1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Auto {
	
	private String marka;
	private String model;
	private int rokProdukcji;
	private int przebieg;
	private String typSilnika; //mo¿e enum jakiœ?
	private int pojemnosc;
	private double cena;
	//List<String> wyposazenie=new ArrayList();
	private String vin;
	private Date dodano;
	private String opis;
	
	public Auto(String marka, String model, double cena, Date dodano){
		this.marka=marka;
		this.model=model;
		this.cena=cena;
		this.setDodano(dodano);//czy przy przekazywaniu obiektów coœ siê nie podzieje
		
	}
	public Auto(String marka, String model,double cena, Date dodano, int rokProdukcji){
		this(marka, model, cena, dodano);
		this.rokProdukcji=rokProdukcji;
		
	}
	public Auto(String marka, String model, double cena, Date dodano, int rokProdukcji, int przebieg){
		this(marka, model, cena, dodano, rokProdukcji);
		this.przebieg=przebieg;
		
	}
	public Auto(String marka, String model, double cena, Date dodano, int rokProdukcji, int przebieg, String typSilnika, int pojemnosc, String vin){
		this(marka, model, cena, dodano, rokProdukcji, przebieg);
		this.typSilnika=typSilnika;
		this.pojemnosc=pojemnosc;
		this.vin=vin;
	
		
	}
	public Auto(String marka, String model, double cena, Date dodano, int rokProdukcji, int przebieg, String typSilnika, int pojemnosc, String vin, String opis){
		this(marka, model, cena, dodano, rokProdukcji, przebieg, typSilnika, pojemnosc, vin);
		this.setOpis(opis);
	}
	
	
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRokProdukcji() {
		return rokProdukcji;
	}
	public void setRokProdukcji(int rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}
	public int getPrzebieg() {
		return przebieg;
	}
	public void setPrzebieg(int przebieg) {
		this.przebieg = przebieg;
	}
	public String getTypSilnika() {
		return typSilnika;
	}
	public void setTypSilnika(String typSilnika) {
		this.typSilnika = typSilnika;
	}
	public int getPojemnosc() {
		return pojemnosc;
	}
	public void setPojemnosc(int pojemnosc) {
		this.pojemnosc = pojemnosc;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Date getDodano() {
		return dodano;
	}
	public void setDodano(Date dodano) {
		this.dodano = dodano;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
		public String daneAuta(){
			return "\nMarka: "+marka+" Model: "+model+"\nRok produkcji: "+rokProdukcji+" Przebieg: "+przebieg+"\nTyp silnika: "+typSilnika+" Pojemnoœæ: "+pojemnosc+"\nCena: "+cena;
		}
		
		


}
