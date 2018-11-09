package fr.afpa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AnimalMain {

	public static void displaySelect() throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM animal JOIN specie on specie.id_Specie = animal.id_Specie");
		while(resultSet.next()) {
			long id = resultSet.getLong("animal.id_Animal");
			String name = resultSet.getString("animal.name");
			String sex = resultSet.getString("animal.sex");
			String coatColor = resultSet.getString("animal.coatColor");
			String commonName = resultSet.getString("specie.commonName");
			String latinName = resultSet.getString("specie.latinName");
			System.out.println("id: " + id + " Name: " + name + " Sex: " + sex + " CoatColor: " + coatColor + " CommonName: " + commonName + " LatinName: " + latinName);
		}
	}

	public static final String _SELECTSTATEMENT = "SELECT * FROM animal JOIN specie on specie.id_Specie = animal.id_Specie WHERE id_Animal=?"; 
	public static final String _INSERTSTATEMENT = "INSERT INTO animal (name,sex,coatColor,id_Specie) VALUES (?,?,?,?)"; 
	public static final String _UPDATESTATEMENT = "UPDATE animal SET animal.name=? WHERE id_Animal=?"; 
	public static final String _DELETESTATEMENT = "DELETE animal FROM animal WHERE id_Animal=?"; 

	public static Connection connection;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {



		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bestioles", "bestiole", "root");
			PreparedStatement preparedstatement;
			boolean isFalse = true;
			String choice = "";
			
			while(isFalse) {
				System.out.println(connection.getMetaData().getTableTypes());
				choice = scanner.next();
				switch (choice) {
				
				case "0":
					preparedstatement = connection.prepareStatement(_SELECTSTATEMENT);
					System.out.print("Rentrez un id: ");
					long selectId = scanner.nextInt();
					preparedstatement.setLong(1,selectId);
					ResultSet resultSet =  preparedstatement.executeQuery();
					while(resultSet.next()) {
						long id = resultSet.getLong("animal.id_Animal");
						String name = resultSet.getString("animal.name");
						String sex = resultSet.getString("animal.sex");
						String coatColor = resultSet.getString("animal.coatColor");
						String commonName = resultSet.getString("specie.commonName");
						String latinName = resultSet.getString("specie.latinName");
						System.out.println("id: " + id + " Name: " + name + " Sex: " + sex + " CoatColor: " + coatColor + " CommonName: " + commonName + " LatinName: " + latinName);
					}
					break;
					
				case "1":
					preparedstatement = connection.prepareStatement(_INSERTSTATEMENT);
					System.out.print("Rentrez un nom: ");
					String updateName = scanner.next();
					preparedstatement.setString(1,updateName);
					System.out.print("Rentrez un id: ");
					long updateId = scanner.nextInt();
					preparedstatement.setLong(2,updateId);
					preparedstatement.execute();
					break;
					
				case "2":
					preparedstatement = connection.prepareStatement(_UPDATESTATEMENT);
					System.out.print("Rentrez un nom: ");
					String insertName = scanner.next();
					preparedstatement.setString(1,insertName);
					System.out.print("Rentrez un nom: ");
					String updateSex = scanner.next();
					preparedstatement.setString(2,updateSex);
					System.out.print("Rentrez un nom: ");
					String insertCoatColor = scanner.next();
					preparedstatement.setString(3,insertCoatColor);
					System.out.print("Rentrez un nom: ");
					long insertIdSpecie = scanner.nextInt();
					preparedstatement.setLong(4,insertIdSpecie);
					preparedstatement.execute();
					break;
					
				case "3":
					preparedstatement = connection.prepareStatement(_DELETESTATEMENT);
					System.out.print("Rentrez un id: ");
					long deleteId = scanner.nextInt();
					preparedstatement.setLong(1,deleteId);
					preparedstatement.execute();
					break;
					
				case "4":
					displaySelect();
					break;
					
				case "9":
					isFalse = false;
					break;
					
				default:
					break;
				}
				System.out.println();
				System.out.println();				
			}

		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
			} 
			catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
