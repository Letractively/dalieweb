/*
 * Created of DV0101 on 05.01.2010 11:57:36
 *
 * Filename	  CreateTableMessage.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 05.01.2010 um 11:57:36
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableMessage {
	/* Erstelle eine Table: Message */

	public synchronized void createTableMessage(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".message( " +
					"messageId char(30) NOT NULL COMMENT 'Message ID'," +
					"sprachId char(2) NOT NULL COMMENT 'Sprach Id'," +
					"messageTyp char(3) NOT NULL COMMENT 'Message Typ'," +
					"message char(200) NOT NULL COMMENT 'Message Text'," +

					"createUser char(10) NOT NULL COMMENT 'Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT 'Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT 'Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT 'Aenderungs Datum'," + 
					"PRIMARY KEY (messageId,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Message'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableMessage:", e);
			System.out.println(this.getClass().getName() + "createTableMessage:" + e);
		}//catch
	}//createTableMessage
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","schemas","kunde","pw");
    	
    	CreateTableMessage selinas = new CreateTableMessage();
    	dbConn.getConnection();
    	selinas.createTableMessage(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableMessage
