/*
 * Created of DV0101 on 09.02.2010 17:37:33
 *
 * Filename	  CreateTableEigentuemer.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 09.02.2010 um 17:37:33
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableEigentuemer {

	public synchronized void createTableEigentuemer(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".eigentuemer( " +
					"objektId int NOT NULL COMMENT '0 ObjektId'," +
					"name char(50) NOT NULL COMMENT '1 Eigentuemer Name'," + 
					"vorname char(50) NOT NULL COMMENT '2 Eigentuemer Vorname'," +
					"geburtstag DATETIME NOT NULL COMMENT '3 Eigentuemer Gebrurtstag Datum'," +
					"seit DATETIME NOT NULL COMMENT '4 Eigentum seit'," +
							
					"createUser char(10) NOT NULL COMMENT '5 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '6 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '7 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '8 Aenderungs Datum'," + 
					"PRIMARY KEY (objektId,seit)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Objekt-Eigentuemer'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableEigentuemer:", e);
			System.out.println(this.getClass().getName() + "createTableEigentuemer:" + e);
		}//catch
	}//createTableEigentuemer
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
    	
    	CreateTableEigentuemer selinas = new CreateTableEigentuemer();
    	dbConn.getConnection();
    	selinas.createTableEigentuemer(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableEigenttuemer
