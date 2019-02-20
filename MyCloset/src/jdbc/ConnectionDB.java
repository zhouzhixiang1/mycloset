package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodatabase","root", "");
			Statement comandoSql = conn.createStatement();
			ResultSet dati = comandoSql.executeQuery("select * from utente");
			
			while(dati.next()) {
				// durante ogni iterazione, accedo ad un record alla volta 
				System.out.print(dati.getInt("id") + " | ");
				System.out.print(dati.getString("nome") + " | ");
				System.out.print(dati.getString("cognome") + " | ");
				System.out.print(dati.getString("eta") + " | ");
				System.out.print(dati.getString("sesso") + " | ");
				System.out.print(dati.getString("email") + " | ");
				System.out.println(dati.getString("password") + " | ");
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
