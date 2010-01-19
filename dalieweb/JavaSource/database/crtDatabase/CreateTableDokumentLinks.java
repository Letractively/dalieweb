/*
 * Created of DV0101 on 08.01.2010 08:21:18
 *
 * Filename	  CreateTableDokumentLinks.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table on Database.
 *
 * @version 	1.00 08.01.2010 um 08:21:18
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableDokumentLinks {

	public synchronized void createTableDokumentLinks(Database dbConn){
		try {
			dbConn.executeUpdate(
				"CREATE TABLE "+dbConn.getDbSchema()+".dokumentlinks( " +
					"kundenId int NOT NULL COMMENT '0 KundenId'," +
					"standortId int NOT NULL COMMENT '1 StandortId'," +
					"dokumentTyp char(3) NOT NULL COMMENT '2 TypKey des Dokuments'," +
					"dokumentNr int NOT NULL COMMENT '3 Nummer des Dokuments'," +
					"dokumentId int NOT NULL COMMENT '4 interne Id des Dokuments'," +
					
					"pfadOfLink char(100) NOT NULL COMMENT '5 Pfadangabe der Datei'," +
					"nameOfLink char(100) NOT NULL COMMENT '6 Name der Datei'," +
					"notizOfLink char(255) NOT NULL COMMENT '7 Notizen zum Link'," +
					"contentTyp char(50) NOT NULL COMMENT '8 Typ der Datei'," +
					"applicationsId int NOT NULL COMMENT '9 interne Id'," +
					"applicationsPfad char(100) NOT NULL COMMENT '10 interner Pfad'," +
					"sizeInBytes bigint NOT NULL COMMENT '11 SizeOnByte der Datei'," +
					
					"createUser char(10) NOT NULL COMMENT '12 Erstell USER'," +
					"createDate DATETIME NOT NULL COMMENT '13 Erstell Datum'," +
					"changeUser char(10) NOT NULL COMMENT '14 Aenderungs USER'," + 
					"changeDate DATETIME NOT NULL COMMENT '15 Aenderungs Datum'" + 
					
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'DokumentLinks'");
		} catch (Exception e) {
			LoggerHelper.log(this.getClass().getName(),"createTableDokumentLinks:", e);
			System.out.println(this.getClass().getName() + "createTableDokumentLinks:" + e);
		}//catch
	}//createTableUser
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
		
    	CreateTableDokumentLinks selinas = new CreateTableDokumentLinks();
    	dbConn.getConnection();
    	selinas.createTableDokumentLinks(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableDokumentLinks
