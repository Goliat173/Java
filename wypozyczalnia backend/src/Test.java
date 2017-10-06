import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Iterator;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> odczyt = new ArrayList<String>();
		ArrayList<Egzamplarz>dostepne=new ArrayList<>();
		LinkedHashSet<String>dostepneModele=new LinkedHashSet<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");
		Date from = new Date();
		Date to = new Date();
		Egzamplarz wybraneAuto;
		
		
		WypelnijMapy.teraz();
		odczyt=WypelnijMapy.czytajPlik();
		WypelnijMapy.doObiektow(odczyt);
		WypelnijMapy.ostatnia();
		WypelnijMapy.sprawdzDane(WypelnijMapy.teraz());
		WypelnijMapy.zapis();
		
		for(Egzamplarz a:WypelnijMapy.listaAut){
				System.out.println("Model w gamie: ");
				System.out.println(a.toString());
				System.out.println("Jego dostêpnoœæ: ");
				System.out.println(a.dostepnosc.toString());
			}
		
		try{
			from=sdf.parse("2017-09-28-0");
			to=sdf.parse("2017-09-28-1");
		}catch(ParseException e){
			System.out.println("Problem z przedzia³em daty dostêpnoœci");
		}
		
		dostepne=WypelnijMapy.sprawdzDostepnosc(from, to);
		
		if(dostepne.size()==0){
			System.out.println("Brak dostepnych modeli w tym terminie :(");
		}
		for(Egzamplarz a:dostepne){
			System.out.println("Model dostêpny na warunkach u¿ytkownika:");
			System.out.println(a.toString());
		}
		
		if(dostepne.size()!=0){
		dostepneModele=WypelnijMapy.dostepneModele();
		System.out.println(dostepneModele);
		
		System.out.println("Podaj który model wybierasz: ");
		Scanner skaner=new Scanner(System.in);
		int wybor=skaner.nextInt();
		wybor=wybor-1;
		Iterator<String> iter=dostepneModele.iterator();
		ArrayList<String> array=new ArrayList<>();
		while(iter.hasNext()){
			array.add(iter.next());
		}
		
		String wybranyModelOgolny=array.get(wybor);
		System.out.println("Wybrano: "+wybranyModelOgolny);
		System.out.println("Podaj swoje dane osobowe:");
		Klient klient=new Klient("Dawid","Szyndler","awj123456");
		klient.setOdkad(from);
		klient.setDokad(to);
		System.out.println("Potwierdz rezerwacje");
		Egzamplarz wybranyModelSzczegolny=WypelnijMapy.wyborEgzemplarzaDlaKlienta(wybranyModelOgolny);
		WypelnijMapy.zarezerwujEgzemplarz(wybranyModelSzczegolny,from,to); //wraz z zapisem do pliku
		System.out.println(WypelnijMapy.listaAut.toString());
		WypelnijMapy.zapis();
		klient.setWybraneAuto(wybranyModelSzczegolny);
		wybranyModelSzczegolny=null;
		wybraneAuto=null;
		System.out.println("Podsumowanie: "+klient.toString());
		
		
		
		//przypisz do klienta(mo¿e nowy plik) auto
		
		} //tylko jak jest cokolwiek dostêpne
		
	}
	
	

}
