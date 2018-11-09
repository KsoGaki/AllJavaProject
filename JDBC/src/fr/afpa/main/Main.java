package fr.afpa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	
	public static void displayDataBase(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM specie");
		System.out.println();
		while(resultSet.next()) {
			long id = resultSet.getLong("id_Specie");
			String common = resultSet.getString("commonName");
			String latin = resultSet.getString("latinName");
			System.out.println(id + " " + common + " " + latin);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bestioles", "root", "root");
			Statement statement = connection.createStatement();
			
			System.out.println("Avant Insert");
			displayDataBase(statement);
			
			System.out.println("Apres Insert");
			statement.execute("INSERT INTO specie(commonName, latinName) VALUES ('Saïd','SaidusTeteDeCus')", Statement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = statement.getGeneratedKeys();
			long id = 0;
			while(resultSet.next()) {
				id = resultSet.getLong("GENERATED_KEY");
			}
			displayDataBase(statement);
					
			System.out.println("Apres Update");
			statement.execute("UPDATE specie SET latinName = 'SaidusDebilus' WHERE id_Specie='"+ id + "'");
			displayDataBase(statement);
			
			System.out.println("Apres DELETE");
			statement.execute("DELETE specie FROM specie WHERE id_Specie='"+ id + "'");
			displayDataBase(statement);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
