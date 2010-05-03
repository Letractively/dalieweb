/*
 * Created of DV0101 on 16.02.2010 10:45:59
 *
 * Filename	  CreateTableTypWohnungstyp.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 16.02.2010 um 10:45:59
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableTypWohnungstyp {
	/* Datei.STAWHGTYP: Wohnungstyp 
	 * D=Dachgeschoﬂ,M=Maisonette,E=Etagenwohnung */

	public synchronized void createTableSTAWHGTYP(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".STAWHGTYP( " +
					"typId char(1) NOT NULL COMMENT '0 TypId'," +
					"sprachId char(2) NOT NULL COMMENT '1 Key'," +
					"description char(100) NOT NULL COMMENT '2 Beschreibung'," +
					
					"createUser char(10) NOT NULL COMMENT '3 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '4 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '5 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '6 Aenderungs Datum'," + 
					"PRIMARY KEY (typId,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Stammdatendatei: Wohnungstyp'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableSTAWHGTYP:", e);
			System.out.println(this.getClass().getName() + "createTableSTAWHGTYP:" + e);
		}//catch
	}//createTableUser
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
		
    	CreateTableTypWohnungstyp selinas = new CreateTableTypWohnungstyp();
    	dbConn.getConnection();
    	selinas.createTableSTAWHGTYP(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableWohnungstyp
