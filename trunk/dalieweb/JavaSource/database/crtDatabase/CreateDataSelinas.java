/*
 * Created of DV0101 on 06.01.2010 10:04:18
 *
 * Filename	  CreateDataMessage.java
 */
package database.crtDatabase;

import database.Database;

/**
 * Create Content of Database.
 *
 * @version 	1.00 06.01.2010 um 05:46:17
 * @author 		DV0101
 * <br><br>
 */
public class CreateDataSelinas {
	/* Um sicher zustellen, dass immer korrekte Einträge für Selinas vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen */
	
	public synchronized void deleteSelinas(Database dbConn,int kundenId, int standortId, String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".selinas " +
					"where kundenId = " + kundenId +
					" and standortId = " + standortId +
	    	        " and sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteSelinas:" + e);
		}//catch
	}//deleteSelinas

	public synchronized void insertSelinasDE(Database dbConn){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selinas " +
				"values(" +
				"1," + //kundenId
				"1," +//standortId
				"'DE'," +//sprachId
				"'Zugangsdaten'," +//hinweis1
				"'Hinweis'," +//hinweis2
				"'Hinweis'," +//hinweis3
				"'Hinweis'," +//hinweis4
				"'Benutzer'," +//userId
				"'Name'," +//name
				"'Vorname'," +//vorname
				"'Passwort'," +//password
				"'Wiederholung'," +//passwordcheck
				"'Typ der Adresse'," +//adressArt
				"'Strasse'," +//strasse
				"'Hausnummer'," +//nummer
				"'Postleitzahl'," +//plz
				"'Ort'," +//ort
				"'Telefon'," +//telefon
				"'Fax'," +//fax
				"'Mail-Adresse'," +//mail
				"'Nummer'," +//dokumentNr
				"'Dokumenttyp'," +//dokumenttyp
				"'Titel'," +//titel
				"'Beschreibung'," +//descripten
				"'Inhalt'," +//content
				"'Gliederung'," +//gliederung
				"'Archiv'," +//archiv
				"'Vorgabe'," +//vorgabe
				"'Status'," +//status
				"'Adressverwaltung'," +//caption1
				"'Details'," +//caption2
				"'Verwaltung der Dokumenttypen'," +//caption3
				"'Userverwaltung'," +//caption4
				"'Benutzerangaben:'," +//caption5
				"'Adresse:'," +//caption6
				"'Passwort:'," +//caption7
				"'Dokumenten-Typus:'," +//caption8
				"'Ihre Anlangen auswählen'," +//caption9
				"'Ihre Notizen erfassen'," +//caption10
				"'Verarbeitung <span style=\"text-decoration:underline\">s</span>tarten'," +//Button1
				"'B<span style=\"text-decoration:underline\">e</span>enden'," +//Button2
				"'<< <span style=\"text-decoration:underline\">z</span>urück'," +//Button3
				"'Dokument <span style=\"text-decoration:underline\">b</span>earbeiten'," +//Button4
				"'<span style=\"text-decoration:underline\">v</span>orwärts >>'," +//Button5
				"'Dokument <span style=\"text-decoration:underline\">d</span>rucken'," +//Button6
				"'Upload <span style=\"text-decoration:underline\">s</span>tarten'," +//Button7
				"'Dokument <span style=\"text-decoration:underline\">v</span>erarbeiten'," +//Button8
				"'Dokument <span style=\"text-decoration:underline\">k</span>opieren'," +//Button9
				"'Dokument <span style=\"text-decoration:underline\">l</span>öschen'," +//Button10
				"'Dokument <span style=\"text-decoration:underline\">a</span>nlegen'," +//Button11
				"'Dokumenttyp <span style=\"text-decoration:underline\">l</span>öschen'," +//Button12
				"'Dokumenttyp <span style=\"text-decoration:underline\">a</span>nlegen'," +//Button13
				"'Übersicht',"+//link1
				"'zurück zur Übersicht',"+//link1t
				"'Auswahl Ihres Dokumentes:',"+//link2
				"'Auswahl nach Dokumenttyp',"+//link2t
				"'Administration',"+//link3
				"'Administration von Selinas',"+//link3t
				"'Adressen',"+//link4
				"'zur Adressverwaltung',"+//link4t
				"'Dokumenttypen',"+//link5
				"'Dokumenttypen anlegen,ändern oder löschen',"+//link5t
				"'Userverwaltung',"+//link6
				"'User anlegen,ändern oder löschen',"+//link6t
				"'Link7',"+//link7
				"'Link7',"+//link7t
				"'Link8',"+//link8
				"'Link8',"+//link8t
				"'Link9',"+//link9
				"'Link9',"+//link9t
				"'Link10',"+//link10
				"'Link10',"+//link10t
				"'Ihr Standpunkt',"+//image1
				"'Übersicht',"+//image2
				"'Adressenverwaltung',"+//image3
				"'Dokumenttypen',"+//image4
				"'Userverwaltung',"+//image5
				"'Image6',"+//image6
				"'Image7',"+//image7
				"'Image8',"+//image8
				"'Image9',"+//image9
				"'Image10',"+//image10
				"'erstellt von:'," + "'erstellt am:'," + 
				"'geändert von'," + "'geändert am')");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertSelinaDE:" + e);
		}//catch
	}//insertSelinasDE
	
	public synchronized void insertSelinasEN(Database dbConn){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selinas " +
				"values(" +
				"1," + //kundenId
				"1," +//standortId
				"'EN'," +//sprachId
				"'Login'," +//hinweis1
				"'Hinweis'," +//hinweis2
				"'Hinweis'," +//hinweis3
				"'Hinweis'," +//hinweis4
				"'User'," +//userId
				"'Name'," +//name
				"'First name'," +//vorname
				"'Password'," +//password
				"'repetion'," +//passwordcheck
				"'Adress Type'," +//adressArt
				"'street'," +//strasse
				"'street number'," +//nummer
				"'zip code'," +//plz
				"'place'," +//ort
				"'phone'," +//telefon
				"'fax'," +//fax
				"'mailadress'," +//mail
				"'Number of Dokument'," +//dokumentNr
				"'Type of Dokument'," +//dokumenttyp
				"'Title'," +//titel
				"'Description'," +//descripten
				"'Text'," +//content
				"'Organization'," +//gliederung
				"'Archives'," +//archiv
				"'Default'," +//vorgabe
				"'Status'," +//status
				"'Adress Administration'," +//caption1
				"'Details'," +//caption2
				"'Administration of document types'," +//caption3
				"'User Management'," +//caption4
				"'User Information:'," +//caption5
				"'Adress:'," +//caption6
				"'Password:'," +//caption7
				"'Document-Figure:'," +//caption8
				"'select your attachment'," +//caption9
				"'your memo'," +//caption10
				"'processing start'," +//Button1
				"'finish'," +//Button2
				"'<< backward'," +//Button3
				"'Document <span style=\"text-decoration:underline\">e</span>dit'," +//Button4
				"'<span style=\"text-decoration:underline\">f</span>orward >>'," +//Button5
				"'Dokument <span style=\"text-decoration:underline\">p</span>rint'," +//Button6
				"'Upload <span style=\"text-decoration:underline\">s</span>tart'," +//Button7
				"'Dokument <span style=\"text-decoration:underline\">p</span>rocess'," +//Button8
				"'Dokument <span style=\"text-decoration:underline\">c</span>opy'," +//Button9
				"'Dokument <span style=\"text-decoration:underline\">d</span>elete'," +//Button10
				"'Dokument <span style=\"text-decoration:underline\">c</span>reating'," +//Button11
				"'Dokumenttyp <span style=\"text-decoration:underline\">d</span>elete'," +//Button12
				"'Dokumenttyp <span style=\"text-decoration:underline\">p</span>rocess'," +//Button13
				"'Overview',"+//link1
				"'back to overview',"+//link1t
				"'select your document:',"+//link2
				"'selection of documents',"+//link2t
				"'administration',"+//link3
				"'for the adminstration of Selina',"+//link3t
				"'Adresses',"+//link4
				"'for address',"+//link4t
				"'Typ of Documents',"+//link5
				"'creating a document type, change or delete',"+//link5t
				"'User adminstration',"+//link6
				"'user to create, modify or delete',"+//link6t
				"'Link7',"+//link7
				"'Link7',"+//link7t
				"'Link8',"+//link8
				"'Link8',"+//link8t
				"'Link9',"+//link9
				"'Link9',"+//link9t
				"'Link10',"+//link10
				"'Link10',"+//link10t
				"'navigationshelp',"+//image1
				"'Overview',"+//image2
				"'Adresses administrion',"+//image3
				"'Typ of Dokuments',"+//image4
				"'User administration',"+//image5
				"'Image6',"+//image6
				"'Image7',"+//image7
				"'Image8',"+//image8
				"'Image9',"+//image9
				"'Image10',"+//image10
				"'created by:'," + "'created on:'," + 
				"'edited by'," + "'changed')");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertSelinaEN:" + e);
		}//catch
	}//insertSelinasEN
	
	 public static void main(String args[]) throws Exception{
	 	Database dbConn = new Database("mySql","localhost","selina","web4857","xxx");
    	
	 	CreateDataSelinas selinas = new CreateDataSelinas();
    	
    	dbConn.getConnection();
    	selinas.deleteSelinas(dbConn,1,1,"DE");
    	selinas.deleteSelinas(dbConn,1,1,"EN");
    	selinas.insertSelinasDE(dbConn);
    	selinas.insertSelinasEN(dbConn);
    	
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateDataSelinas
