package fr.afpa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main2 {
	
	public static final String _SELECTSTATEMENT = "SELECT * FROM specie WHERE id_Specie=?";
	public static final String _INSERTSTATEMENT = "INSERT INTO specie(commonName, latinName) VALUES(?,?)";
	public static final String _UPDATESTATEMENT = "UPDATE specie set commonName=? WHERE id_Specie=?";
	public static final String _DELETESTATEMENT = "DELETE specie FROM specie WHERE id_Specie=?";

	public static void main(String[] args) {
		
		Connection connection = null;
		long idLong = 0;
		
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bestioles", "root", "root");
			PreparedStatement preparedstatement = connection.prepareStatement(_SELECTSTATEMENT);
			preparedstatement.setLong(1, 20);
			ResultSet resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				long id = resultSet.getLong("id_Specie");
				String common = resultSet.getString("commonName");
				String latin = resultSet.getString("latinName");
				System.out.println(id + " " + common + " " + latin);
			}
			
			preparedstatement = connection.prepareStatement(_INSERTSTATEMENT, Statement.RETURN_GENERATED_KEYS);
			preparedstatement.setString(1, "Saïd");
			preparedstatement.setString(2, "Saïdus");
			preparedstatement.execute();
			resultSet = preparedstatement.getGeneratedKeys();  
			while(resultSet.next()) {
				idLong = resultSet.getLong("GENERATED_KEY");
			}
			
			preparedstatement = connection.prepareStatement(_UPDATESTATEMENT);
			preparedstatement.setString(1, "SaïDiable");
			preparedstatement.setLong(2, idLong);
			preparedstatement.execute();
			
			preparedstatement = connection.prepareStatement(_DELETESTATEMENT);
			preparedstatement.setLong(1, idLong);
			preparedstatement.execute();
			
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
