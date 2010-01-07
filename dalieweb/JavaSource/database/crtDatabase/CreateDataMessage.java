/*
 * Created of DV0101 on 06.01.2010 05:46:17
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
public class CreateDataMessage {
	/* Um sicher zustellen, dass immer korrekte Einträge für die Message vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen 
	 * 
	 * Kopierhilfe: dataMessage.insertMessage(dbConn,"","DE","E",""); 
	 * Kopierhilfe: dataMessage.insertMessage(dbConn,"","EN","E",""); */
	
	static Database dbConn;
	
	public synchronized void deleteMessage(Database dbConn,String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".message " +
	        		"where sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteMessage:" + e);
		}//catch
	}//deleteMessage

	public synchronized void insertMessage(Database dbConn,String messageId,String sprachId,String messageTyp,
			String message){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".message " +
				"values('"+messageId+"','" +sprachId+"','"+messageTyp+"','"+message+"'," + 
				"'DV0101'," + "now()," + 
				"'DV0101'," + "now())");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteMessage:" + e);
		}//catch
	}//insertMessage
	
	 public static void main(String args[]) throws Exception{
    	dbConn = new Database("mySql","localhost","schemas","kunde","pw");
    	
    	CreateDataMessage dataMessage = new CreateDataMessage();
    	
    	dbConn.getConnection();
    	dataMessage.deleteMessage(dbConn,"DE");
    	dataMessage.insertMessage(dbConn,"Beschreibung","DE","E","Beschreibung <b>ungültig</b>, bitte prüfen.");
    	dataMessage.insertMessage(dbConn,"DeleteDokumentTyp","DE","E","Dokumenttyp löschen nicht möglich, da noch Dokumente zum Dokumenttyp gefunden wurden.");
    	dataMessage.insertMessage(dbConn,"DokumentNr","DE","E","Nummer des Dokument ist ungültig<br/>Bitte<b> Eingabe </b>prüfen");
    	dataMessage.insertMessage(dbConn,"DokumentTyp","DE","E","Dokumententyp ist nicht gültig<br/>Bitte<b> Eingabe </b>prüfen");
    	dataMessage.insertMessage(dbConn,"Hausnummer","DE","E","<b>gültige</b> Hausnummer, bitte angeben.");
    	dataMessage.insertMessage(dbConn,"Login","DE","E","<h1>Sie konnten nicht angemeldet werden.</h1><p>Bitte überprüfen Sie <strong>Benutzer</strong> und Passwortangaben, und versuchen Sie es erneut.</p>");
    	dataMessage.insertMessage(dbConn,"Login001","DE","E","<p>Bitte geben Sie ihren <strong>Benutzer</strong> und ihr Passwort ein, und versuchen es erneut. </p>");
    	dataMessage.insertMessage(dbConn,"Login1","DE","E","<h1>Sie konnten nicht angemeldet werden.</h1>Bitte geben Sie Ihre Benutzer<b>nummer</b> und Ihr Passwort ein und versuchen Sie es erneut.</p>");
    	dataMessage.insertMessage(dbConn,"Loginfehler","DE","E","<h1>Login erforderlich</h1><p>Sie müssen sich zunächst anmelden, um diese Seite zu benutzen!</p>");
    	dataMessage.insertMessage(dbConn,"Logout","DE","E","<h1>Logout</h1><p>Sie haben sich erfolgreich abgemeldet.</p><p>Falls Sie sich erneut anmelden möchten, können Sie das hier tun:</p>");
    	dataMessage.insertMessage(dbConn,"Name","DE","E","<b>Name</b>,wird benötigt.");
    	dataMessage.insertMessage(dbConn,"Ort","DE","E","Bitte <b>gültigen</b> Ort eintragen, dieser wird für Adresse benötigt.");
    	dataMessage.insertMessage(dbConn,"Postleitzahl","DE","E","<b>gültige</b> Postleitzahl, bitte angeben.");
    	dataMessage.insertMessage(dbConn,"Strasse","DE","E","<b>gültige<b> Strasse, bitte angeben.");
    	dataMessage.insertMessage(dbConn,"Titel","DE","E","Titel <b>ungültig</b>");
    	dataMessage.insertMessage(dbConn,"Vorname","DE","E","<b>Vornamen</b>, bitte angeben.");
    	dataMessage.insertMessage(dbConn,"Land","DE","E","Bitte <b>gültiges</b> Land angeben, ist Bestandteil einer gültigen Adresse.");
    	dataMessage.insertMessage(dbConn,"Passwort","DE","E","Passworteingabe mit Passwortwiederholung nicht indetisch");
    	
    	dataMessage.deleteMessage(dbConn,"EN");
    	dataMessage.insertMessage(dbConn,"Beschreibung","EN","E","Description <b>error</ b>,please check.");
    	dataMessage.insertMessage(dbConn,"DeleteDokumentTyp","EN","E","Delete this document is not possible as yet documents have been found to document.");
    	dataMessage.insertMessage(dbConn,"DokumentNr","EN","E","Number of Dokument is not vaild<br/>Please<b> check </b>input");
    	dataMessage.insertMessage(dbConn,"DokumentTyp","EN","E","Document type is not valid<br/>Please<b> check </b> entry");
    	dataMessage.insertMessage(dbConn,"Hausnummer","EN","E","<b> invalid </ b> number, please specify.");
    	dataMessage.insertMessage(dbConn,"Login","EN","E","<h1>They could not logged.</h1><p>Please check your user ID and password and try again.");
    	dataMessage.insertMessage(dbConn,"Login001","EN","E","<p>Please enter your <strong> user </ strong> and your password and try again.</ p>");
    	dataMessage.insertMessage(dbConn,"Login1","EN","E","<h1>They could not be logged.</h1><p>Please enter your user <b>ID</b> and password and try again.");
    	dataMessage.insertMessage(dbConn,"Loginfehler","EN","E","<h1>Login required</h1><p>You must first register in order to use this page!</p>");
    	dataMessage.insertMessage(dbConn,"Logout","EN","E","<h1>Logout</h1><p>You have successfully logged out.</p><p>If you log in again, you can do so. </p>");
    	dataMessage.insertMessage(dbConn,"Name","EN","E","<b>Name</ b>, is required.");
    	dataMessage.insertMessage(dbConn,"Ort","EN","E","Please <b> valid </ b> Cityname you enter, this is needed to address.");
    	dataMessage.insertMessage(dbConn,"Postleitzahl","EN","E","<b> valid </ b> zip code, please specify.");
    	dataMessage.insertMessage(dbConn,"Strasse","EN","E","<b> valid <b> street, please specify.");
    	dataMessage.insertMessage(dbConn,"Titel","EN","E","Title <b> error </ b>");
    	dataMessage.insertMessage(dbConn,"Vorname","EN","E","<b> First </ b>, please specify.");
    	dataMessage.insertMessage(dbConn,"Land","EN","E","Please enter a valid <b>country</ b>, is part of a valid address.");
    	dataMessage.insertMessage(dbConn,"Passwort","EN","E","Forgot your password entry with no repetition indet");
    	
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
}//class CreateDataMessage
