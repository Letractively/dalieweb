/*
 * Created of DV0101 on 08.01.2010 08:48:31
 *
 * Filename	  CreateTableStatus.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 08.01.2010 um 08:48:31
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableStatus {

	public synchronized void createTableStatus(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".status( " +
					"statusId char(2) NOT NULL COMMENT '0 StatusId'," +
					"sprachId char(2) NOT NULL COMMENT '1 Key'," +
					"description char(100) NOT NULL COMMENT '2 Beschreibung'," +
					"notizen char(100) NOT NULL COMMENT '3 User Notizen'," +
					
					"createUser char(10) NOT NULL COMMENT '4 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '5 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '6 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '7 Aenderungs Datum'," + 
					"PRIMARY KEY (statusId,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'SelinasStatis'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableStatus:", e);
			System.out.println(this.getClass().getName() + "createTableStatus:" + e);
		}//catch
	}//createTableUser
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
		
    	CreateTableStatus selinas = new CreateTableStatus();
    	dbConn.getConnection();
    	selinas.createTableStatus(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableStatus
