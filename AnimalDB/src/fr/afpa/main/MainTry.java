package fr.afpa.main;

import java.sql.SQLException;

import fr.afpa.classes.DisplayDataBase;

public class MainTry {	

	public static void main(String[] args) {		
		try {
			String connectionPath = "jdbc:mysql://localhost:3306/bestioles";
			String user = "root";
			String password = "root";
			DisplayDataBase displayDataBase = new DisplayDataBase(connectionPath, user, password);
			displayDataBase.setStringStatement("SELECT * FROM Animal");
			displayDataBase.display();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
