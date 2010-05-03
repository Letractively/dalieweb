/*
 * Created of DV0101 on 11.02.2010 12:54:33
 *
 * Filename	  CreateTableWohnung.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 11.02.2010 um 12:54:33
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableWohnung {
	
	public synchronized void createTableWohnung(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".Wohnung( " +
					"objektId int NOT NULL COMMENT '0 ObjektId'," +
					"baujahr DATETIME NOT NULL COMMENT '1 Baujahr'," +
					"zustand char(1) NOT NULL COMMENT '2 Wohnungszustand'," +
					"wohnungstyp char(1) NOT NULL COMMENT '3 Typ der Wohnung'," +
					"zimmer int NOT NULL COMMENT '4 Anzahl der Zimmer'," +
					"flaeche int NOT NULL COMMENT '5 Flaechenangabe'," +
					"heitzungstyp char(1) NOT NULL COMMENT '6 Heitzungstyp'," +
					
					"createUser char(10) NOT NULL COMMENT '7 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '8 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '9 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '10 Aenderungs Datum'," + 
					"PRIMARY KEY (objektId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Wohnungen'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableWohnung:", e);
			System.out.println(this.getClass().getName() + "createTableWohnung:" + e);
		}//catch
	}//createTableEigentuemer
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
    	
    	CreateTableWohnung selinas = new CreateTableWohnung();
    	dbConn.getConnection();
    	selinas.createTableWohnung(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
}//createTableWohnung
