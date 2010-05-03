/*
 * Created of DV0101 on 09.04.2010   08:41:43
 *
 * Filename	  CreateTableTypSelinasModul.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 09.01.2010 um  08:41:43
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableTypSelinasModul {
	/* Datei.STASELMOD: Selinasmodul 
	 * D=okumente,I=mmobilienverwaltung */

	
	public synchronized void createTableSTASELMOD(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".staselmod( " +
					"typId char(1) NOT NULL COMMENT '0 TypId'," +
					"sprachId char(2) NOT NULL COMMENT '1 Key'," +
					"description char(100) NOT NULL COMMENT '2 Beschreibung'," +
					
					"createUser char(10) NOT NULL COMMENT '3 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '4 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '5 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '6 Aenderungs Datum'," + 
					"PRIMARY KEY (typId,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Stammdatendatei: SelinasModule'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableSTASELMOD:", e);
			System.out.println(this.getClass().getName() + "createTableSTASELMOD:" + e);
		}//catch
	}//createTableSTASELMOD
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
		
    	CreateTableTypSelinasModul selinas = new CreateTableTypSelinasModul();
    	dbConn.getConnection();
    	selinas.createTableSTASELMOD(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableTypSelinasModul
