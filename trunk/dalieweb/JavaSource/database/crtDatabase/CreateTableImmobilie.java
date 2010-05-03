/*
 * Created of DV0101 on 09.02.2010 17:55:17
 *
 * Filename	  CreateTableImmobilie.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 09.02.2010 um 17:55:17
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableImmobilie {
	
	public synchronized void createTableImmobilie(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".immobilie( " +
					"kundenId int NOT NULL COMMENT '0 KundenId'," +
					"standortId int NOT NULL COMMENT '1 StandortId'," +
					"objektId int NOT NULL COMMENT '2 ObjektId'," +
					
					"createUser char(10) NOT NULL COMMENT '3 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '4 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '5 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '6 Aenderungs Datum'," + 
					"PRIMARY KEY (kundenId,standortId,objektId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'immobilie'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableImmobilie:", e);
			System.out.println(this.getClass().getName() + "createTableImmobilie:" + e);
		}//catch
	}//createTableImmobilie
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
    	
    	CreateTableImmobilie selinas = new CreateTableImmobilie();
    	dbConn.getConnection();
    	selinas.createTableImmobilie(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableImmobilie
