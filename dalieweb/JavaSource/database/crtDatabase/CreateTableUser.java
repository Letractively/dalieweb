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
					"userId char(10) NOT NULL COMMENT '0 User Id'," +
					"status char(1) NOT NULL COMMENT '1 User Status'," +
					"password char(10) NOT NULL COMMENT '2 User Password'," +
					"name char(50) NOT NULL COMMENT '3 User Name'," + 
					"vorname char(50) NOT NULL COMMENT '4 User Vorname'," +
					"geburtstag DATETIME NOT NULL COMMENT '5 Gebrurtstag Datum'," +
					"berechtigungsId int NOT NULL COMMENT '6 Berechtigung Id'," +
					"userAutorisierungsId int NOT NULL COMMENT '7 AutorisierungsId'," +
					
					"kundenId int NOT NULL COMMENT '8 Kunden Id'," +
					"standortId int NOT NULL COMMENT '9 Standort Id'," +
					"spachId char(2) NOT NULL COMMENT '10 User Sprache'," +
					"selinasId int NOT NULL COMMENT '11 Kunden Id'," +
					"selinasStandortId int NOT NULL COMMENT '12 Standort Id'," +

					"createUser char(10) NOT NULL COMMENT '13 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '14 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '15 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '16 Aenderungs Datum'," + 
					"PRIMARY KEY (userId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'User'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableUser:", e);
			System.out.println(this.getClass().getName() + "createTableUser:" + e);
		}//catch
	}//createTableUser
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
		
    	CreateTableUser selinas = new CreateTableUser();
    	dbConn.getConnection();
    	selinas.createTableUser(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableUser
