/*
 * Created of DV0101 on 22.02.2010 08:43:20
 *
 * Filename	  CreateTableHaus.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 22.02.2010 um 08:43:20
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableHaus {
	
	public synchronized void createTableHaus(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".haus( " +
					"objektId int NOT NULL COMMENT '0 ObjektId'," +
					"baujahr DATETIME NOT NULL COMMENT '1 Baujahr'," +
					"zustand char(1) NOT NULL COMMENT '2 Hauszustand'," +
					"haustyp char(1) NOT NULL COMMENT '3 Typ des Hause'," +
					"zimmer int NOT NULL COMMENT '4 Anzahl der Zimmer'," +
					"anzahlWohnungen int NOT NULL COMMENT '5 Anzahl der Wohnungen'," +
					"flaeche int NOT NULL COMMENT '6 Flaechenangabe'," +
					"heitzungstyp char(1) NOT NULL COMMENT '7 Heitzungstyp'," +
					
					"createUser char(10) NOT NULL COMMENT '8 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '9 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '10 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '11 Aenderungs Datum'," + 
					"PRIMARY KEY (objektId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Haus'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableHaus:", e);
			System.out.println(this.getClass().getName() + "createTableHaus:" + e);
		}//catch
	}//createTableHaus
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
    	
    	CreateTableHaus selinas = new CreateTableHaus();
    	dbConn.getConnection();
    	selinas.createTableHaus(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTable
