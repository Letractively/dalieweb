/*
 * Created of DV0101 on 05.01.2010 11:31:19
 *
 * Filename	  CreateTableUser.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 05.01.2010 um 11:31:19
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableUser {

	public synchronized void createTableUser(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".user( " +
					"userId char(10) NOT NULL COMMENT 'User Id'," +
					"status char(1) NOT NULL COMMENT 'User Status'," +
					"password char(10) NOT NULL COMMENT 'User Password'," +
					"name char(30) NOT NULL COMMENT 'User Name'," + 
					"vorname char(30) NOT NULL COMMENT 'User Vorname'," +
					"geburtstag DATETIME NOT NULL COMMENT 'Gebrurtstag Datum'," +
					"berechtigungsId int NOT NULL COMMENT 'Berechtigung Id'," +
					"userAutorisierungsId int NOT NULL COMMENT 'AutorisierungsId'," +
					
					"kundenId int NOT NULL COMMENT 'Kunden Id'," +
					"standortId int NOT NULL COMMENT 'Standort Id'," +
					"sprachId char(2) NOT NULL COMMENT 'Sprach Id'," +

					"selinasId int NOT NULL COMMENT 'Kunden Id'," +
					"selinasStandortId int NOT NULL COMMENT 'Standort Id'," +

					"createUser char(10) NOT NULL COMMENT 'Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT 'Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT 'Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT 'Aenderungs Datum'," + 
					"PRIMARY KEY (userId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'User'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableUser:", e);
			System.out.println(this.getClass().getName() + "createTableUser:" + e);
		}//catch
	}//createTableUser
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","schemas","kunde","pw");
    	
    	CreateTableUser selinas = new CreateTableUser();
    	dbConn.getConnection();
    	selinas.createTableUser(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableUser
