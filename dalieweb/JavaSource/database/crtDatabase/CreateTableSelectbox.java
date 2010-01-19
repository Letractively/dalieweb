/*
 * Created of DV0101 on 05.01.2010 11:48:48
 *
 * Filename	  CreateTableSelectbox.java
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
public class CreateTableSelectbox {
	/* Erstelle eine Table: Selectbox */
	
	public synchronized void createTableSelectbox(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".selectbox( " +
					"kundenId int NOT NULL COMMENT '0 Kunden Id'," +
					"standortId int NOT NULL COMMENT '1 Standort Id'," +
					"selectbox char(15) NOT NULL COMMENT '2 Selectbox Name'," +
					"sprachId char(2) NOT NULL COMMENT '3 Sprach Id'," +
					
					"createUser char(10) NOT NULL COMMENT '4 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '5 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '6 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '7 Aenderungs Datum'," + 
					"PRIMARY KEY (kundenId,standortId,selectbox,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Selectbox'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableSelectbox:", e);
			System.out.println(this.getClass().getName() + "createTableSelectbox:" + e);
		}//catch
	}//createTableSelectbox
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
		
    	CreateTableSelectbox selectbox = new CreateTableSelectbox();
    	CreateTableSelectOptionen selectoptionen = new CreateTableSelectOptionen();
    	dbConn.getConnection();
    	selectbox.createTableSelectbox(dbConn);
    	selectoptionen.createTableSelectoptionen(dbConn);
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableSelectbox
