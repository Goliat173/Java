package bankJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Zapytania {
	public static int stanKonta(Connection connection, int id){
		String sql;
		int stanKonta=0;
		sql="SELECT saldo FROM rachunki WHERE nrrachunku = (SELECT nrrachunku FROM klienci_rachunki WHERE id_klienta = "+id+") ;";	
		try {
			ResultSet rs=executeQuery(connection, sql);
			rs.next();
			stanKonta=rs.getInt("saldo");
			 return stanKonta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Coœ posz³o Ÿle");
			e.printStackTrace();
		}
		
        return stanKonta;
	}
	public static void wykonajPrzelew(Connection connection, int id, String nrRachunku, Integer wartosc){
		
		String sql2="UPDATE rachunki SET saldo = saldo + "+wartosc.toString()+" WHERE nrrachunku = '"+nrRachunku+"' ;";
		String sql1="UPDATE rachunki SET saldo = saldo - "+wartosc.toString()+" WHERE nrrachunku = (SELECT nrrachunku FROM klienci_rachunki WHERE id_klienta = "+id+") ;";
		int stanKonta=stanKonta(connection, id);
		
		if(wartosc<stanKonta){
			try {
				connection.setAutoCommit(false);
				Statement stmt = connection.createStatement();
				stmt.executeUpdate(sql1);
				stmt.executeUpdate(sql2);
				connection.commit();
				stanKonta=stanKonta(connection, id);
				connection.setAutoCommit(true);
				System.out.println("Wykonano przelewu na kwote "+wartosc+"\nna rachunek: "+nrRachunku);
				System.out.println("Pozosta³o na koncie: "+ stanKonta);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					connection.rollback();
					connection.setAutoCommit(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("Coœ posz³o Ÿle");
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Masz za ma³o œrodków na koncie");
		}
	
		//return sql1;
	}
	
	
	public static String zmienDane(int id){
		String sql="";
		System.out.println("Zmiana danych");
		return sql;
	}
	
	public static ResultSet executeQuery(Connection connection, String query){
		
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}
	
	public static int executeQueryUpdate(Connection connection, String query){
		
		Statement stmt;
		int wykonano;
		try {
			stmt = connection.createStatement();
			wykonano = stmt.executeUpdate(query);
			return wykonano;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
}
}
