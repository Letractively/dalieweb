/*
 * Created of DV0101 on 06.01.2010 08:42:02
 *
 * Filename	  CreateDataSelinas.java
 */
package database.crtDatabase;

import help.LoggerHelper;
import database.Database;

/**
 * Create Table:SELINAS om Database.
 *
 * @version 	1.00 06.01.2010 um 08:42:02
 * @author 		DV0101
 * <br><br>
 */
public class CreateTableSelinas {
	
	public synchronized void createTableSelinas(Database dbConn){
		try {
			dbConn.executeUpdate(
					"CREATE TABLE "+dbConn.getDbSchema()+".selinas(" +
						"kundenId int NOT NULL COMMENT '0 Kunden Id'," +
						"standortId int NOT NULL COMMENT '1 Standort Id'," +
						"sprachId char(2) NOT NULL COMMENT '2 Sprach Id'," +

						"hinweis1 char(30) NOT NULL COMMENT '3 Zugangsdaten'," +
						"hinweis2 char(30) NOT NULL COMMENT '4 Hinweis'," +
						"hinweis3 char(30) NOT NULL COMMENT '5 Hinweis'," +
						"hinweis4 char(30) NOT NULL COMMENT '6 Hinweis'," +
						"userId char(30) NOT NULL COMMENT '7 Benutzer'," +
						"name char(50) NOT NULL COMMENT '8 Name'," +
						"vorname char(50) NOT NULL COMMENT '9 Vorname'," +
						"password char(30) NOT NULL COMMENT '10 Passwort'," +
						"passwordcheck char(30) NOT NULL COMMENT '11 Passwort wiederholung'," +
						"adressArt char(30) NOT NULL COMMENT '12 Typ der Adresse'," +
						"strasse char(30) NOT NULL COMMENT '13 Strasse'," +
						"nummer char(30) NOT NULL COMMENT '14 Nummer'," +
						"plz char(30) NOT NULL COMMENT '15 Postleitzahl'," +
						"ort char(30) NOT NULL COMMENT '16 Ort'," +
						"telefon char(30) NOT NULL COMMENT '17 Telefon'," +
						"fax char(30) NOT NULL COMMENT '18 Fax'," +
						"mail char(30) NOT NULL COMMENT '19 Mail'," +
						
						"dokumentNr char(30) NOT NULL COMMENT '20 Dokument-Nr'," +
						"dokumentTyp char(30) NOT NULL COMMENT '21 Dokument-Typ'," +
						"titel char(30) NOT NULL COMMENT '22 Titel'," +
						"descripten char(30) NOT NULL COMMENT '23 Beschreibung'," +
						"content char(30) NOT NULL COMMENT '24 Inhalt'," +
						"gliederung char(30) NOT NULL COMMENT '25 Gliederung'," +
						"archiv char(30) NOT NULL COMMENT '26 Archiv'," +
						"vorgabe char(30) NOT NULL COMMENT '27 Vorgabe'," +
						"status char(30) NOT NULL COMMENT '28 Status'," +
						
						"catpion1 char(100) NOT NULL COMMENT '29 Adressverwaltung'," +
						"caption2 char(100) NOT NULL COMMENT '30 Details'," +
						"caption3 char(100) NOT NULL COMMENT '31 Verwaltung der Dokumenttypen'," +
						"caption4 char(100) NOT NULL COMMENT '32 Userverwaltung'," +
						"caption5 char(100) NOT NULL COMMENT '33 Benutzerangaben'," +
						"caption6 char(100) NOT NULL COMMENT '34 Adresse'," +
						"caption7 char(100) NOT NULL COMMENT '35 Passwort'," +
						"caption8 char(100) NOT NULL COMMENT '36 Caption 8'," +
						"caption9 char(100) NOT NULL COMMENT '37 Caption 9'," +
						"caption10 char(100) NOT NULL COMMENT '38 Caption 10'," +
						
						"button1 char(150) NOT NULL COMMENT '39 Verarbeitung starten'," +
						"button2 char(150) NOT NULL COMMENT '40 Beenden'," +
						"button3 char(150) NOT NULL COMMENT '41 << zurück'," +
						"button4 char(150) NOT NULL COMMENT '42 Dokument bearbeiten'," +
						"button5 char(150) NOT NULL COMMENT '43 vorwärts >>'," +
						"button6 char(150) NOT NULL COMMENT '44 Dokument drucken'," +
						"button7 char(150) NOT NULL COMMENT '45 Upload starten'," +
						"button8 char(150) NOT NULL COMMENT '46 Dokument verarbeiten'," +
						"button9 char(150) NOT NULL COMMENT '47 Dokument kopieren'," +
						"button10 char(150) NOT NULL COMMENT '48 Dokument löschen'," +
						"button11 text(50) NOT NULL COMMENT '49 Dokument anlegen'," +
						"button12 text(50) NOT NULL COMMENT '50 Dokumenttyp löschen'," +
						"button13 text(50) NOT NULL COMMENT '51 Dokumenttyp anlegen'," +
						
						"link1 char(150) NOT NULL COMMENT '52 Übersicht'," +
						"link1t char(150) NOT NULL COMMENT '53 zurück zur Übersicht'," +
						"link2 char(150) NOT NULL COMMENT '54 Auswahl Ihres Dokumentes'," +
						"link2t char(150) NOT NULL COMMENT '55 Auswahl nach Dokumenttyp'," +
						"link3 char(150) NOT NULL COMMENT '56 Administration'," +
						"link3t char(150) NOT NULL COMMENT '57 Administration von Selinas'," +
						"link4 char(150) NOT NULL COMMENT '58 Adressen'," +
						"link4t char(150) NOT NULL COMMENT '59 zur Adressverwaltung'," +
						"link5 char(150) NOT NULL COMMENT '60 Dokumenttypen'," +
						"link5t char(150) NOT NULL COMMENT '61 Dokumenttypen anlegen,..'," +
						"link6 char(150) NOT NULL COMMENT '62 Userverwaltung'," +
						"link6t char(150) NOT NULL COMMENT '63 User anlegen,..'," +
						"link7 char(150) NOT NULL COMMENT '64 Link7'," +
						"link7t char(150) NOT NULL COMMENT '65 Link7t'," +
						"link8 char(150) NOT NULL COMMENT '66 Link8'," +
						"link8t char(150) NOT NULL COMMENT '67 Link8t'," +
						"link9 char(150) NOT NULL COMMENT '68 Link9'," +
						"link9t char(150) NOT NULL COMMENT '69 Link9t'," +
						"link10 char(150) NOT NULL COMMENT '70 Link10'," +
						"link10t char(150) NOT NULL COMMENT '71 Link10t'," +
						
						"image1 char(150) NOT NULL COMMENT '72 Ihr Standpunkt'," +
						"image2 char(150) NOT NULL COMMENT '73 Übersicht'," +
						"image3 char(150) NOT NULL COMMENT '74 Adressverwaltung'," +
						"image4 char(150) NOT NULL COMMENT '75 Dokumenttypen'," +
						"image5 char(150) NOT NULL COMMENT '76 Userverwaltung'," +
						"image6 char(150) NOT NULL COMMENT '77 Image6'," +
						"image7 char(150) NOT NULL COMMENT '78 Image7'," +
						"image8 char(150) NOT NULL COMMENT '79 Image8'," +
						"image9 char(150) NOT NULL COMMENT '80 Image9'," +
						"image10 char(150) NOT NULL COMMENT '81 Image10'," +
						
						"createUser char(30) NOT NULL COMMENT '82 Ersteller'," +
						"createDate char(30) NOT NULL COMMENT '83 erstellt am'," +
						"changeUser char(30) NOT NULL COMMENT '84 Verwaltet'," + 
						"changeDate char(30) NOT NULL COMMENT '85 verwaltet am'," + 
						
					"PRIMARY KEY (kundenId,standortId,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'selinas'");
		} catch (Exception e) {
			LoggerHelper.log("CreateTableSelinas1","Exception of createTable-SQL:", e);
			System.out.println(this.getClass().getName()+".createTableSelinas1.:" + e);
		}//catch
	}//createTableSelinas1
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
		
    	CreateTableSelinas selinas = new CreateTableSelinas();
    	
    	dbConn.getConnection();
    	selinas.createTableSelinas(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableSelinas
