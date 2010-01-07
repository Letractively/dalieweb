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
						"kundenId int NOT NULL COMMENT 'Kunden Id'," +
						"standortId int NOT NULL COMMENT 'Standort Id'," +
						"sprachId char(2) NOT NULL COMMENT 'Sprach Id'," +

						"hinweis1 char(30) NOT NULL COMMENT 'Zugangsdaten'," +
						"hinweis2 char(30) NOT NULL COMMENT 'Hinweis'," +
						"hinweis3 char(30) NOT NULL COMMENT 'Hinweis'," +
						"hinweis4 char(30) NOT NULL COMMENT 'Hinweis'," +
						"userId char(30) NOT NULL COMMENT 'Benutzer'," +
						"name char(50) NOT NULL COMMENT 'Name'," +
						"vorname char(50) NOT NULL COMMENT 'Vorname'," +
						"password char(30) NOT NULL COMMENT 'Passwort'," +
						"passwordcheck char(30) NOT NULL COMMENT 'Passwort wiederholung'," +
						"adressArt char(30) NOT NULL COMMENT 'Typ der Adresse'," +
						"strasse char(30) NOT NULL COMMENT 'Strasse'," +
						"nummer char(30) NOT NULL COMMENT 'Nummer'," +
						"plz char(30) NOT NULL COMMENT 'Postleitzahl'," +
						"ort char(30) NOT NULL COMMENT 'Ort'," +
						"telefon char(30) NOT NULL COMMENT 'Telefon'," +
						"fax char(30) NOT NULL COMMENT 'Fax'," +
						"mail char(30) NOT NULL COMMENT 'Mail'," +
						
						"dokumentNr char(30) NOT NULL COMMENT 'Dokument-Nr'," +
						"dokumentTyp char(30) NOT NULL COMMENT 'Dokument-Typ'," +
						"titel char(30) NOT NULL COMMENT 'Titel'," +
						"descripten char(30) NOT NULL COMMENT 'Beschreibung'," +
						"content char(30) NOT NULL COMMENT 'Inhalt'," +
						"gliederung char(30) NOT NULL COMMENT 'Gliederung'," +
						"archiv char(30) NOT NULL COMMENT 'Archiv'," +
						"vorgabe char(30) NOT NULL COMMENT 'Vorgabe'," +
						"status char(30) NOT NULL COMMENT 'Status'," +
						
						"catpion1 char(100) NOT NULL COMMENT 'Adressverwaltung'," +
						"caption2 char(100) NOT NULL COMMENT 'Details'," +
						"caption3 char(100) NOT NULL COMMENT 'Verwaltung der Dokumenttypen'," +
						"caption4 char(100) NOT NULL COMMENT 'Userverwaltung'," +
						"caption5 char(100) NOT NULL COMMENT 'Benutzerangaben'," +
						"caption6 char(100) NOT NULL COMMENT 'Adresse'," +
						"caption7 char(100) NOT NULL COMMENT 'Passwort'," +
						"caption8 char(100) NOT NULL COMMENT 'Caption 8'," +
						"caption9 char(100) NOT NULL COMMENT 'Caption 9'," +
						"caption10 char(100) NOT NULL COMMENT 'Caption 10'," +
						
						"button1 char(150) NOT NULL COMMENT 'Verarbeitung starten'," +
						"button2 char(150) NOT NULL COMMENT 'Beenden'," +
						"button3 char(150) NOT NULL COMMENT '<< zurück'," +
						"button4 char(150) NOT NULL COMMENT 'Dokument bearbeiten'," +
						"button5 char(150) NOT NULL COMMENT 'vorwärts >>'," +
						"button6 char(150) NOT NULL COMMENT 'Dokument drucken'," +
						"button7 char(150) NOT NULL COMMENT 'Upload starten'," +
						"button8 char(150) NOT NULL COMMENT 'Dokument verarbeiten'," +
						"button9 char(150) NOT NULL COMMENT 'Dokument kopieren'," +
						"button10 char(150) NOT NULL COMMENT 'Dokument löschen'," +
						"button11 text(50) NOT NULL COMMENT 'Dokument anlegen'," +
						"button12 text(50) NOT NULL COMMENT 'Dokumenttyp löschen'," +
						"button13 text(50) NOT NULL COMMENT 'Dokumenttyp anlegen'," +
						
						"link1 char(150) NOT NULL COMMENT 'Übersicht'," +
						"link1t char(150) NOT NULL COMMENT 'zurück zur Übersicht'," +
						"link2 char(150) NOT NULL COMMENT 'Auswahl Ihres Dokumentes'," +
						"link2t char(150) NOT NULL COMMENT 'Auswahl nach Dokumenttyp'," +
						"link3 char(150) NOT NULL COMMENT 'Administration'," +
						"link3t char(150) NOT NULL COMMENT 'Administration von Selinas'," +
						"link4 char(150) NOT NULL COMMENT 'Adressen'," +
						"link4t char(150) NOT NULL COMMENT 'zur Adressverwaltung'," +
						"link5 char(150) NOT NULL COMMENT 'Dokumenttypen'," +
						"link5t char(150) NOT NULL COMMENT 'Dokumenttypen anlegen,..'," +
						"link6 char(150) NOT NULL COMMENT 'Userverwaltung'," +
						"link6t char(150) NOT NULL COMMENT 'User anlegen,..'," +
						"link7 char(150) NOT NULL COMMENT 'Link7'," +
						"link7t char(150) NOT NULL COMMENT 'Link7t'," +
						"link8 char(150) NOT NULL COMMENT 'Link8'," +
						"link8t char(150) NOT NULL COMMENT 'Link8t'," +
						"link9 char(150) NOT NULL COMMENT 'Link9'," +
						"link9t char(150) NOT NULL COMMENT 'Link9t'," +
						"link10 char(150) NOT NULL COMMENT 'Link10'," +
						"link10t char(150) NOT NULL COMMENT 'Link10t'," +
						
						"image1 char(150) NOT NULL COMMENT 'Ihr Standpunkt'," +
						"image2 char(150) NOT NULL COMMENT 'Übersicht'," +
						"image3 char(150) NOT NULL COMMENT 'Adressverwaltung'," +
						"image4 char(150) NOT NULL COMMENT 'Dokumenttypen'," +
						"image5 char(150) NOT NULL COMMENT 'Userverwaltung'," +
						"image6 char(150) NOT NULL COMMENT 'Image6'," +
						"image7 char(150) NOT NULL COMMENT 'Image7'," +
						"image8 char(150) NOT NULL COMMENT 'Image8'," +
						"image9 char(150) NOT NULL COMMENT 'Image9'," +
						"image10 char(150) NOT NULL COMMENT 'Image10'," +
						
						"createUser char(30) NOT NULL COMMENT 'Ersteller'," +
						"createDate char(30) NOT NULL COMMENT 'erstellt am'," +
						"changeUser char(30) NOT NULL COMMENT 'Verwaltet'," + 
						"changeDate char(30) NOT NULL COMMENT 'verwaltet am'," + 
						
					"PRIMARY KEY (kundenId,standortId,sprachId)" +
					")ENGINE = myisam CHARACTER SET latin1 COLLATE latin1_german1_ci COMMENT = 'selinas'");
		} catch (Exception e) {
			LoggerHelper.log("CreateTableSelinas1","Exception of createTable-SQL:", e);
			System.out.println(this.getClass().getName()+".createTableSelinas1.:" + e);
		}//catch
	}//createTableSelinas1
	
	public static void main(String args[]) throws Exception{
		Database dbConn = new Database("mySql","localhost","schemas","kunde","pw");
    	
    	CreateTableSelinas selinas = new CreateTableSelinas();
    	
    	dbConn.getConnection();
    	selinas.createTableSelinas(dbConn); 
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateTableSelinas
