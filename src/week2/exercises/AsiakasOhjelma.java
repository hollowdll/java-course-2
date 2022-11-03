package week2.exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* CRUD = Create, Read, Update, Delete */

public class AsiakasOhjelma {
	
	private String sqlQuery;
	private Lukija lukija = new Lukija();
	
	private Connection yhdista() {
		Connection connection = null;
		final String DB = "databases/Myynti.sqlite";
		final String ROOT_PATH = System.getProperty("user.dir") + "/";    	// project root path
		final String URL = "jdbc:sqlite:" + ROOT_PATH + DB;    
		
		try {	       
			Class.forName("org.sqlite.JDBC");	// try to find database driver
			connection = DriverManager.getConnection(URL);
	        
	     } catch (Exception e) {	
	    	System.out.println("Yhteyden avaus epäonnistui");
	        e.printStackTrace();
	     }
		
		return connection;
	}
	
	public void naytaValikko() {
		int valinta = -1;
		
		while (valinta != 0) {
			System.out.println("\n1. Lisää asiakas"
								+ "\n2. Näytä asiakkaat"
								+ "\n3. Muuta asiakas"
								+ "\n4. Poista asiakas"
								+ "\n0. Lopetus");

			valinta = lukija.lueKokonaisluku("Valintasi: ");
			
			switch (valinta) {
			case 0:
				return;
				
			case 1:
				lisaaAsiakas();
				break;
				
			case 2:
				listaaAsiakkaat();
				break;
				
			case 3:
				muutaAsiakas();
				break;
				
			case 4:
				poistaAsiakas();
				break;
				
			default:
				System.out.println("Virheellinen syöte!");
			}
		}
	}
	
	private void lisaaAsiakas() {
		String etunimi = lukija.lueTeksti("Anna etunimi: ");
		String sukunimi = lukija.lueTeksti("Anna sukunimi: ");
		String puhelin = lukija.lueTeksti("Anna puhelinnumero: ");
		String sposti = lukija.lueTeksti("Anna sähköposti: ");
		
		if (etunimi.length() > 1 && sukunimi.length() > 1 && puhelin.length() > 1 && sposti.length() > 1) {
			sqlQuery = "INSERT INTO asiakkaat (etunimi, sukunimi, puhelin, sposti) VALUES (?,?,?,?)";
			Connection connection = null;
			PreparedStatement stmtPrep = null;
			
			try {
				connection = yhdista();
				
				if (connection != null) {	// jos yhteys onnistui
					stmtPrep = connection.prepareStatement(sqlQuery); 
					stmtPrep.setString(1, etunimi);
					stmtPrep.setString(2, sukunimi);
					stmtPrep.setString(3, puhelin);
					stmtPrep.setString(4, sposti);
					stmtPrep.executeUpdate();
			        connection.close();
			        System.out.println("Asiakkaan lisääminen onnistui.");
			        listaaAsiakkaat();
				}
		        
			} catch (SQLException e) {	
				System.out.println("Asiakkaan lisääminen epäonnistui.");
				e.printStackTrace();
			}
		}	
	}
	
	private void listaaAsiakkaat() {
		sqlQuery = "SELECT * FROM asiakkaat";
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement stmtPrep = null;
		
		try {
			connection = yhdista();
			
			if (connection != null) {	// jos yhteys onnistui
				stmtPrep = connection.prepareStatement(sqlQuery);        		
        		resultSet = stmtPrep.executeQuery(); 
        		
				if (resultSet != null) {	// jos kysely onnistui					
					System.out.println();
					while (resultSet.next()) {
						// 5 datakenttää
						System.out.print(resultSet.getInt(1) + "\t\t");
						System.out.print(resultSet.getString(2) + "\t\t");
						System.out.print(resultSet.getString(3) + "\t\t");
						System.out.print(resultSet.getString(4) + "\t\t");
						System.out.print(resultSet.getString(5) + "\t\t");	
						System.out.println();
					}
					System.out.println();
				}
				connection.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void muutaAsiakas() {
		listaaAsiakkaat();
		int asiakasId = lukija.lueKokonaisluku("Anna muutettavan asiakkaan id: ");
		sqlQuery = "SELECT * FROM asiakkaat WHERE asiakas_id = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement stmtPrep = null;
		
		try {
			connection = yhdista();
			
			if (connection != null) { 	//jos yhteys onnistui
				stmtPrep = connection.prepareStatement(sqlQuery); 
				stmtPrep.setInt(1, asiakasId);
				resultSet = stmtPrep.executeQuery();
        		
        		if (resultSet.isBeforeFirst()) { 	//jos kysely tuotti dataa, eli id on käytössä
        			String etunimi = lukija.lueTeksti("Anna uusi etunimi (enter ohittaa): ");
        			String sukunimi = lukija.lueTeksti("Anna uusi sukunimi (enter ohittaa): ");
        			String puhelin = lukija.lueTeksti("Anna uusi puhelinnumero (enter ohittaa): ");
        			String sposti = lukija.lueTeksti("Anna uusi sähköposti (enter ohittaa): ");
        			
					if (etunimi.equals("")) {
						etunimi = resultSet.getString("etunimi");
					}
					if (sukunimi.equals("")) {
						sukunimi = resultSet.getString("sukunimi");
					}
					if (puhelin.equals("")) {
						puhelin = resultSet.getString("puhelin");
					}
					if (sposti.equals("")) {
						sposti = resultSet.getString("sposti");
					}
					
					sqlQuery = "UPDATE asiakkaat SET etunimi=?, sukunimi=?, puhelin=?, sposti=? WHERE asiakas_id=?";	        				
					stmtPrep = connection.prepareStatement(sqlQuery);
					stmtPrep.setString(1, etunimi);
					stmtPrep.setString(2, sukunimi);
					stmtPrep.setString(3, puhelin);
					stmtPrep.setString(4, sposti);
					stmtPrep.setInt(5, asiakasId);
					stmtPrep.executeUpdate();
					
				} else {
					System.out.println("Antamasi asiakas_id ei löytynyt\n");
				}
        		
        		connection.close();
    			listaaAsiakkaat();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void poistaAsiakas() {
		listaaAsiakkaat();
		int asiakas_id = lukija.lueKokonaisluku("Anna poistettavan asiakkaan asiakas_id: ");
		sqlQuery = "SELECT * FROM asiakkaat WHERE asiakas_id = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement stmtPrep = null;
		
		try {
			connection = yhdista();
			
			if (connection != null) { 	//jos yhteys onnistui
				stmtPrep = connection.prepareStatement(sqlQuery); 
				stmtPrep.setInt(1, asiakas_id);
				resultSet = stmtPrep.executeQuery();
        		
        		if (resultSet.isBeforeFirst()) { 	//jos kysely tuotti dataa
        			resultSet.next();	 //siirryttään 1. tietueriville
        			if (lukija.lueTeksti("Haluatko varmasti poistaa asiakkaan "
        					+ asiakas_id + " " + resultSet.getString("etunimi") + " " + resultSet.getString("sukunimi")
        					+ " (k/e): ").equalsIgnoreCase("k")) {        				
        				sqlQuery = "DELETE FROM asiakkaat WHERE asiakas_id = ?";	        				
    					stmtPrep = connection.prepareStatement(sqlQuery);
    					stmtPrep.setInt(1, asiakas_id);
    					System.out.println("Poistetaan asiakas_id: " + asiakas_id);
    					stmtPrep.executeUpdate();
        			}	       			
				} else {
					System.out.println("Antamasi asiakas_id ei löytynyt\n");
				}				
			}
			
			connection.close();
			listaaAsiakkaat();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static void main(String[] args) {
		AsiakasOhjelma ohjelma = new AsiakasOhjelma();
		ohjelma.naytaValikko();
	}

}
