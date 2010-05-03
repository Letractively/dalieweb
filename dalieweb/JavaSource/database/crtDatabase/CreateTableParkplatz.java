/*
 * Created of DV0101 on 11.02.2010 16:20:22
 *
 * Filename	  CreateTableParkplatz.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 11.02.2010 um 16:20:22
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableParkplatz {
	
	public synchronized void createTableParkplatz(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".parkplatz( " +
					"objektId int NOT NULL COMMENT '0 ObjektId'," +
					"miete int NOT NULL COMMENT '1 Mietbetrag'," +
					
					"createUser char(10) NOT NULL COMMENT '2 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '3 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '4 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '5 Aenderungs Datum'," + 
					"PRIMARY KEY (objektId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Parkplatz'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableParkplatz:", e);
			System.out.println(this.getClass().getName() + "createTableParkplatz:" + e);
		}//catch
	}//createTableEigentuemer
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
    	
    	CreateTableParkplatz selinas = new CreateTableParkplatz();
    	dbConn.getConnection();
    	selinas.createTableParkplatz(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableParkplatz
