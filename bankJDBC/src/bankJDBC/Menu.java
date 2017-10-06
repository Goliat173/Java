package bankJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
	private int menu=0;
	private int wybor;
	private boolean warunek=true;
	private Scanner skaner=new Scanner(System.in);
	Logowanie logowanie=new Logowanie();
	
	public void start(Connection connection){
		while(warunek){
		switch (menu){
		case 0:
			System.out.println(" \n===========================================\n Menu: \n===========================================\n"
					+"1 - Logowanie");
		
			menu=skaner.nextInt();
			break;
		case 1:
			System.out.println("Podaj login: ");
			String login=skaner.next();
			System.out.println("Podaj haslo: ");
			String haslo=skaner.next();
			logowanie.setLogin(login);
			logowanie.setHaslo(haslo);
			logowanie.zaloguj(connection);
			if (logowanie.getId()!=0){
				menu=2;
			}
			break;
		case 2:
			System.out.println(" \n===========================================\n Menu: \n===========================================\n"
					+"1 - Stan konta \n2 - Wykonaj przelew \n3 - Zmien dane \n4 - Wyloguj");
			wybor=skaner.nextInt();
			if(wybor==4){
				menu=0;  //logowanie = null;
				
				break;
			}
			if(wybor==1){
				System.out.println("Stan konta to: ");
				System.out.println(Zapytania.stanKonta(connection, logowanie.getId()));
				System.out.println("Powrót - dowolny znak");
				if(skaner.hasNext()){
					String temp=skaner.next();
					break;
				}
			}
			if(wybor==2){
				System.out.println("Podaj na jaki rachunek:");
				String nrRachunku=skaner.next();
				System.out.println("Podaj ile:");
				int wartosc=skaner.nextInt();
				Zapytania.wykonajPrzelew(connection,logowanie.getId(), nrRachunku, wartosc);
				break;
			}
			if(wybor==3){
				Zapytania.zmienDane(logowanie.getId());
				break;
				}
	
	}
	}
	
	}

}
