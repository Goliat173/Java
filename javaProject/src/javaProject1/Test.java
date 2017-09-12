package javaProject1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {

	
	private static ArrayList<String> linie;

	public static void main(String[] args){
		// TODO Auto-generated method stub
		String marka;
		String model;
		int rokProdukcji;
		int przebieg;
		String typSilnika; //mo�e enum jaki�?
		int pojemnosc;
		double cena;
		String vin;
		Date dodano;
		String opis;
		Date data=new Date();
		
	
		/*
		 * wybierz komis
		 * opcje - przegladaj auta, dodaj auto, sprzedaj auto, edytuj auto, przenies auto, usun te�?
		 * stworz komis
		 * przegladanie aut z filtrem
		 * sortowanie aut
		
		*/
		
		/*wpisywanie danych
		 * model i marka z listy
		 * rok produkcji: 1980-data.getYear()
		 * przebieg:0 - 1000000 [0-9]{,7}
		 * typ silnika benzyna/benzyna LPG/diesel/hybryda/elektryczny
		 * pojemnosc je�li =!elektryczny 1-8000 [1-9]{1}[0-9]{,3}
		 * cena - 0 - 1000000 [1-9]{1}[0-9]{,6}
		 * vin 17 znak�w wielkich [0-9.]{17}
		 * dodano=(data.getYear, data.getMonth(), data.getDay());
		 * opis - do 2000 znak�w [0-9.]{2000}
		 */
		
		linie = new ArrayList<>(Odczyt.czytajPlik());
		Odczyt.doObiektow(linie);
		
		ArrayList<Auto> listaAut = Odczyt.listaAut;
		for (int i = 0; i < listaAut.size(); i++) {
			Auto test = listaAut.get(i);
			System.out.println(test.daneAuta());
		}
	
		/*
		if(Pattern.matches("[0-9]{,7}", "ci�g do sprawdzenia przebiegu"));
		if(Pattern.matches("[1-9]{1}[0-9]{,3}", "ci�g do sprawdzenia pojemnosci"));
		if(Pattern.matches("[1-9]{1}[0-9]{,6}", "ci�g do sprawdzenia ceny"));
		if(Pattern.matches("[0-9.]{17}", "ci�g do sprawdzenia vin"));
		if(Pattern.matches("[0-9.]{2000}", "ci�g do sprawdzenia opisu"));
		*/
		//stw�rz obiekt auto 
		
		
	}

}
