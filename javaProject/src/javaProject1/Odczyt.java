package javaProject1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Odczyt {
	static ArrayList<Auto> listaAut = new ArrayList<>();
	public static String nazwaPliku = "auta.txt";
	private static Scanner in; 
	
	
	 public static ArrayList<String> czytajPlik() {	   	       
	        ArrayList<String> odczyt = new ArrayList<String>();
	        try {
	        	File plikAuta = new File(nazwaPliku);
	    		in = new Scanner(plikAuta);
	    			while(in.hasNextLine()){
	    				odczyt.add(in.nextLine());
	    			}
	        } catch (IOException ex) {
	            System.out.println("Brak pliku!");
	        }
	        
	        return odczyt;
	 }
	      

	    public static void doObiektow(ArrayList<String> odczyt) {	     
	        for (String linia : odczyt) {
	            String[] l = linia.split(",");         	       
				@SuppressWarnings("deprecation")
				Date data=new Date(Integer.parseInt(l[8]),Integer.parseInt(l[9]),Integer.parseInt(l[10]));
	            Auto auto = new Auto(l[0],l[1],Double.parseDouble(l[6]),data,Integer.parseInt(l[2]),Integer.parseInt(l[3]),l[4],Integer.parseInt(l[5]),l[7],l[11]);
	            listaAut.add(auto);
	        }	       
	    }
	
}
