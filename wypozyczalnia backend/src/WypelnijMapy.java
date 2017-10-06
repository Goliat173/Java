import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class WypelnijMapy {
static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd-HH");
static String dataTeraz = simpleDateFormat.format(new Date());
public static String nazwaPliku = "dostepnosc.txt";
private static Scanner in; 
public static ArrayList<Egzamplarz> listaAut = new ArrayList<>();
private static int i=0;
private static Date ostatnia; 
private static Date dataDodaj; 
private static Calendar calendar = Calendar.getInstance();
private static LinkedHashMap<Date,Boolean> dostepnoscTemp=new LinkedHashMap<Date,Boolean>();
private static ArrayList<Egzamplarz> listaDostepnych=new ArrayList<>(); 

public static ArrayList<String> czytajPlik() {	   	       
    ArrayList<String> odczyt = new ArrayList<String>();
    try {
    	File plikDostepnosc = new File(nazwaPliku);
		in = new Scanner(plikDostepnosc);
			while(in.hasNextLine()){
				odczyt.add(in.nextLine());
			}
    } catch (IOException ex) {
        System.out.println("Brak pliku!");
    }
    return odczyt;
}

public static void doObiektow(ArrayList<String> odczyt) {	  
	Date sdf=new Date();

    for (int i=0; i<odczyt.size();i++) {
    	if(i%2==0){
    	String linia=odczyt.get(i);
    	String[] l = linia.split(",");
        Egzamplarz egzemplarz=new Egzamplarz(l[0],l[1],l[2],Integer.parseInt(l[3]),Integer.parseInt(l[4]),l[5]);
        egzemplarz.toString();
        linia=odczyt.get(i+1);
        l = linia.split(",");
        System.out.println();
        for(int j=0;j<20;j++){
        	try{
        sdf=new SimpleDateFormat("yyyy-MM-dd-HH").parse(l[j]);
        	}catch (ParseException e){
        		System.out.println("B³¹d formatu daty w pliku");
        	}
        Boolean bool=Boolean.valueOf(l[j+1]);
        egzemplarz.dostepnosc.put(sdf, bool);
        j=j+1;
        }
        listaAut.add(egzemplarz);
    	}
    	
    }
  }
    


public static Date teraz(){
	Date date = new Date();
		try{
			date=simpleDateFormat.parse(dataTeraz);
			//String dataString = date.toString();
			System.out.println(dataTeraz);
			
			
			final Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.HOUR, 10);
			ostatnia=calendar.getTime();
			System.out.println(ostatnia);
			
			} catch (ParseException e){
			e.printStackTrace();
		}
	return date;
}

public static void ostatnia(){
	Date date = new Date();
		try{
			date=simpleDateFormat.parse(dataTeraz);
			String dataString = date.toString();
		//	System.out.println(dataString);
			
			calendar.setTime(date);
			calendar.add(Calendar.HOUR, 10);
			ostatnia=calendar.getTime();
		//	System.out.println(ostatnia);
			} catch (ParseException e){
			e.printStackTrace();
		}
	
}


public static ArrayList<Egzamplarz> sprawdzDostepnosc(Date from, Date to){
	
	 for(Egzamplarz e:listaAut){
outer:	 for(Date d:e.dostepnosc.keySet()){
			if(from.compareTo(d)<=0 && to.compareTo(d)>=0){
				if(e.dostepnosc.get(d)==true){
					break outer;
				}
				if(to.compareTo(d)==0){
					listaDostepnych.add(e);
					
				}
			}
		}
	}
	return listaDostepnych;
}

public static void sprawdzDane(Date teraz){   //narazie zmienia tylko w danych obiektów, do zapisu w pliku osobna metoda
	 for(Egzamplarz e:listaAut){
		 dostepnoscTemp=e.dostepnosc;
		for(Date d:e.dostepnosc.keySet()){
			if(teraz.compareTo(d)>=0){
				calendar.setTime(ostatnia);
				calendar.add(Calendar.HOUR, -i);
				dataDodaj=calendar.getTime();
				dostepnoscTemp.put(dataDodaj, false);
				i++;
			}
				
			if(teraz.compareTo(d)<0){
			dostepnoscTemp.put(d, e.dostepnosc.get(d));
			} 
				 
			}
		e.dostepnosc=dostepnoscTemp;
		i=0;
	}
	 
}

public static LinkedHashSet<String> dostepneModele(){
	LinkedHashSet<String> dostepneModeleKlient=new LinkedHashSet<>();
	for(Egzamplarz e:listaDostepnych){
		String dostepnyModel=e.marka.concat(" "+e.model);
		dostepneModeleKlient.add(dostepnyModel);
	}
	
	return dostepneModeleKlient;
	
}


public static void zapis(){
	try{
	PrintWriter zapis = new PrintWriter(nazwaPliku);
	
	  for(Egzamplarz e:listaAut){
		  zapis.println(e.marka+","+e.model+","+e.nrRejestracji+","+e.cena+","+e.lMiejsc+","+e.segment);
		  for(Date d:e.dostepnosc.keySet()){
			  String dataDoZapisu = simpleDateFormat.format(d);// zamiana daty tradycyjnej na string poprzez SDF
			  zapis.print(dataDoZapisu+",");
			  zapis.print(e.dostepnosc.get(d)+",");
		  }
		  zapis.println("");
	  }
	  
      
      
      zapis.close();
	}catch(FileNotFoundException e){
		System.out.println("Nie znaleziono pliku do zapisu");
	}
}

public static Egzamplarz wyborEgzemplarzaDlaKlienta(String wybrany){
	String[] l = wybrany.split(" ");
	System.out.println("Szukam:"+l[0]+" "+l[1]);
			for(Egzamplarz e:WypelnijMapy.listaDostepnych){
				if(e.marka.equals(l[0]) && e.model.equals(l[1])){
					System.out.println("Wybor egzemplarza dla klienta: ");
					System.out.println(e.toString());
					return e;					  //idzie pierwszy lepszy
				}
				
			}
	return null;
}

public static void zarezerwujEgzemplarz(Egzamplarz auto, Date from, Date to){
	Egzamplarz e=auto;
	for(Date d:e.dostepnosc.keySet()){
		Date dokad=to;
		calendar.setTime(to);
		calendar.add(Calendar.HOUR, 1);  //rezerwuje na godzine dluzej niz zyczy klient - kwestie serwisowe
		dokad=calendar.getTime();
		if(from.compareTo(d)<=0 && dokad.compareTo(d)>=0){
			e.dostepnosc.replace(d, true);
		}
	}
	System.out.println(e.dostepnosc.toString());
	auto=e;
	
}


}

