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
						"kundenId int NOT NULL COMMENT '0 Kunden Id'," +
						"standortId int NOT NULL COMMENT '1 Standort Id'," +
						"sprachId char(2) NOT NULL COMMENT '2 Sprach Id'," +

						"button14 char(150) NOT NULL COMMENT '3 User löschen'," +
						"button15 char(150) NOT NULL COMMENT '4 User anlegen'," +
						"button16 char(150) NOT NULL COMMENT '5 Button 16'," +
						"button17 char(150) NOT NULL COMMENT '6 Button 17'," + 
						"button18 char(150) NOT NULL COMMENT '7 Button 18'," +
						"button19 char(150) NOT NULL COMMENT '8 Button 19'," +
						"button20 char(150) NOT NULL COMMENT '9 Button 20'," +
						"button21 char(150) NOT NULL COMMENT '10 Button 21'," +
						"button22 char(150) NOT NULL COMMENT '11 Button 22'," +
						"button23 char(150) NOT NULL COMMENT '12 Button 23'," +
						"button24 char(150) NOT NULL COMMENT '13 Button 24'," +
						"button25 char(150) NOT NULL COMMENT '14 Button 25'," +
						"permitId char(50) NOT NULL COMMENT '15 BerechtiungsId'," +
						"geburtstag char(50) NOT NULL COMMENT '16 Geburtstag'," +
						"land char(50) NOT NULL COMMENT '17 Adress Land'," +
						"userAppId char(50) NOT NULL COMMENT '18 SicherheitsId User'," +
						"dokumentPermitId char(50) NOT NULL COMMENT '19 Dokumentensicherheit'," +
						"adressUserId char(50) NOT NULL COMMENT '20 UserId of Adress'," +
						"optionDescripten char(50) NOT NULL COMMENT '21 [Bitte auswählen] '," +
					"PRIMARY KEY (kundenId,standortId,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'selinas1 '");
			
		} catch (Exception e) {
			LoggerHelper.log("CreateTableSelinas1","Exception of createTable-SQL:", e);
			System.out.println(this.getClass().getName()+".createTableSelinas1.:" + e);
		}//catch
	}//createTableSelinas1
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
		
    	CreateTableSelinas1 selinas = new CreateTableSelinas1();
    	dbConn.getConnection();
    	selinas.createTableSelinas1(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableSelinas1
