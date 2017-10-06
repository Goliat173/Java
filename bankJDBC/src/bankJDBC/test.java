package bankJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
//		Date dataUrodzenia=new Date();
//		Logowanie logowanie = new Logowanie();

//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			dataUrodzenia=sdf.parse("1995-03-17");
//		} catch (ParseException e) {
//			System.out.println("B³¹d przy dacie urodzenia");
//			e.printStackTrace();
//		}
		//#################
		
		SqlConnect sqlconnect=new SqlConnect("org.postgresql.Driver","jdbc:postgresql://localhost:5432/postgres","postgres","8519");
		Connection connection = sqlconnect.connect();
		Menu menu=new Menu();
		menu.start(connection);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dodac konto bankiera ktory robi wplaty gotowkowe
		//dodaæ mo¿liwosæ rejestracji
	}

}
