/*
 * Created of DV0101 on 08.01.2010 07:24:33
 *
 * Filename	  CreateTableDokument.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 08.01.2010 um 07:24:33
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableDokument {

	public synchronized void createTableDokument(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".dokument( " +
					"kundenId int NOT NULL COMMENT '0 KundenId'," +
					"standortId int NOT NULL COMMENT '1 StandortId'," +
					"typ char(3) NOT NULL COMMENT '2 TypKey des Dokuments'," +
					"nummer int NOT NULL COMMENT '3 Nummer des Dokuments'," +
					"id int NOT NULL COMMENT '4 interne Id des Dokuments'," +
					
					"status char(2) NOT NULL COMMENT '5 Status'," +
					"titel char(50) NOT NULL COMMENT '6 Titel'," +
					"descripten char(100) NOT NULL COMMENT '7 Beschreibung'," +
					"content LONGTEXT NOT NULL COMMENT '8 Inhalt'," +
					"gliederung char(10) NOT NULL COMMENT '9 Gliederung'," +
					"archiv char(50) NOT NULL COMMENT '10 Archiv Ort'," +
					"archivDate DATETIME NOT NULL COMMENT '11 Archiv bis'," +
					"vorgabe char(3) NOT NULL COMMENT '12 Vorgabe'," +
					"sprachId char(2) NOT NULL COMMENT '13 SprachKey'," +
							
					"createUser char(10) NOT NULL COMMENT '14 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '15 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '16 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '17 Aenderungs Datum'," + 
					"PRIMARY KEY (kundenId,standortId,typ,nummer,id)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'Dokument'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableDokument:", e);
			System.out.println(this.getClass().getName() + "createTableDokument:" + e);
		}//catch
	}//createTableUser
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
    	
    	CreateTableDokument selinas = new CreateTableDokument();
    	dbConn.getConnection();
    	selinas.createTableDokument(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
	
}//class CreateTableDokumnet
