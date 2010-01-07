/*
 * Created of DV0101 on 05.01.2010 17:34:19
 *
 * Filename	  CreateTableAdressen.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 05.01.2010 um 10:34:19
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableAdressen {
	/* Erstelle eine Table: Adressen */

	public synchronized void createTableAdressen(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".adressen( " +
					"adressId int NOT  NULL COMMENT 'Adress ID'," +
					"adressArt char(1) NOT NULL COMMENT 'Adress Art'," +
					"userId char(10) NOT NULL COMMENT 'User Id'," +
					"strasse char(50) NOT NULL COMMENT 'Adress Strasse'," +
					"nummer char(20) NOT NULL COMMENT 'Adress Hausnummer'," +
					"plz char(20) NOT NULL COMMENT 'Adress PLZ'," +
					"ort char(50) NOT NULL COMMENT 'Adress Ort'," +
					"land char(100) NOT NULL COMMENT 'Adress Land',"+
					
					"telefon char(50) NOT NULL COMMENT 'Adress Telefon'," +
					"fax char(50) NOT NULL COMMENT 'Adress Fax'," +
					"mail char(50) NOT NULL COMMENT 'Adress Mail'," +

					"createUser char(10) NOT NULL COMMENT 'Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT 'Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT 'Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT 'Aenderungs Datum'," + 
					"PRIMARY KEY (adressId, adressArt, userId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Adressen'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableAdressen:", e);
			System.out.println(this.getClass().getName() + "createTableAdressen:" + e);
		}//catch
	}//createTableAdressen
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","schemas","kunde","pw");
    	
    	CreateTableAdressen selinas = new CreateTableAdressen();
    	dbConn.getConnection();
    	selinas.createTableAdressen(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//createTableAdressen
