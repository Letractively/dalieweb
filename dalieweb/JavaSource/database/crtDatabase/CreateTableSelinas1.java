/*
 * Created of DV0101 on 04.01.2010 19:18:44
 *
 * Filename	  CreateDataSelinas1.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table:SELINAS1 om Database.
 *
 * @version 	1.00 04.01.2010 um 19:18:44
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableSelinas1 {
	
	public synchronized void createTableSelinas1(Database dbConn){
		try {
			dbConn.executeUpdate(
					"CREATE TABLE "+dbConn.getDbSchema()+".selinas1(" +
						"kundenId int NOT NULL COMMENT 'Kunden Id'," +
						"standortId int NOT NULL COMMENT 'Standort Id'," +
						"sprachId char(2) NOT NULL COMMENT 'Sprach Id'," +

						"button14 char(150) NOT NULL COMMENT 'User löschen'," +
						"button15 char(150) NOT NULL COMMENT 'User anlegen'," +
						"button16 char(150) NOT NULL COMMENT 'Button 16'," +
						"button17 char(150) NOT NULL COMMENT 'Button 17'," + 
						"button18 char(150) NOT NULL COMMENT 'Button 18'," +
						"button19 char(150) NOT NULL COMMENT 'Button 19'," +
						"button20 char(150) NOT NULL COMMENT 'Button 20'," +
						"button21 char(150) NOT NULL COMMENT 'Button 21'," +
						"button22 char(150) NOT NULL COMMENT 'Button 22'," +
						"button23 char(150) NOT NULL COMMENT 'Button 23'," +
						"button24 char(150) NOT NULL COMMENT 'Button 24'," +
						"button25 char(150) NOT NULL COMMENT 'Button 25'," +
						"permitId char(50) NOT NULL COMMENT 'BerechtiungsId'," +
						"geburtstag char(50) NOT NULL COMMENT 'Geburtstag'," +
						"land char(50) NOT NULL COMMENT 'Adress Land'," +
						"userAppId char(50) NOT NULL COMMENT 'SicherheitsId User'," +
						"dokumentPermitId char(50) NOT NULL COMMENT 'Dokumentensicherheit'," +
						"adressUserId char(50) NOT NULL COMMENT 'UserId of Adress'," +
					"PRIMARY KEY (kundenId,standortId,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'selinas1 '");
			
		} catch (Exception e) {
			LoggerHelper.log("CreateTableSelinas1","Exception of createTable-SQL:", e);
			System.out.println(this.getClass().getName()+".createTableSelinas1.:" + e);
		}//catch
	}//createTableSelinas1
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","schemas","kunde","pw");
    	
    	CreateTableSelinas1 selinas = new CreateTableSelinas1();
    	dbConn.getConnection();
    	selinas.createTableSelinas1(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableSelinas1
