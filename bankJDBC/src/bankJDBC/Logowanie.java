package bankJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Logowanie {
	private String login;
	private String haslo;
	private int id;
	
	

	public Logowanie(){
		this.id=0;
	}
	public Logowanie(String login, String haslo) {
		super();
		this.login = login;
		this.haslo = haslo;
		this.id=0;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void zaloguj(Connection connection){
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, imie, nazwisko FROM Klienci WHERE LOGIN= '"+login+"' AND HASLO= '"+haslo+ "';");
			if(rs.next()) {
	            System.out.println("Zalogowano jako: "+ rs.getString("imie") + " " + rs.getString("nazwisko"));
	            int id=rs.getInt("id");
	            this.id=id;
			}
			else{
				System.out.println("B³êdny login lub has³o!");
			}
	        rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
