/*
 * Created of DV0101 on 06.01.2010 12:02:39
 *
 * Filename	  CreateDataMessage.java
 */
package database.crtDatabase;

import database.Database;

/**
 * Create Content of Database.
 *
 * @version 	1.00 06.01.2010 um 12:02:39
 * @author 		DV0101
 * <br><br>
 */
public class CreateDataSelinas1 {
	/* Um sicher zustellen, dass immer korrekte Einträge für Selinas1 vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen */
	
	public synchronized void deleteSelinas1(Database dbConn,int kundenId, int standortId, String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".selinas1 " +
					"where kundenId = " + kundenId +
					" and standortId = " + standortId +
	    	        " and sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteSelinas1:" + e);
		}//catch
	}//deleteSelinas1
	
	public synchronized void insertSelinas1DE(Database dbConn){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selinas1 " +
				"values(" +
				"1," + //kundenId
				"1," +//standortId
				"'DE'," +//sprachId
				
				"'User <span style=\"text-decoration:underline\">l</span>öschen'," +//Button14
				"'User <span style=\"text-decoration:underline\">a</span>nlegen'," +//Button15
				"'Adresse <span style=\"text-decoration:underline\">a</span>nlegen'," +//Button16
				"'Button17'," +//Button17
				"'Button18'," +//Button18
				"'Button19'," +//Button19
				"'Button20'," +//Button20
				"'Button21'," +//Button21
				"'Button22'," +//Button22
				"'Button23'," +//Button23
				"'Button24'," +//Button24
				"'Button25'," +//Button25
				
				"'Berechtigung',"+//permitId
				"'Geburtstag',"+//geburtstag
				"'Land',"+//land
				"'Autorisierungsstufe',"+//userAppId
				"'Dokumentsicherheit',"+//dokumentPermitId
				"'Adresse gehört zu:',"+//Bezeichnung für Bezug zur Adresse
				"'[Bitte auswählen]')");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertSelina1DE:" + e);
		}//catch
	}//insertSelinas1DE
	
	public synchronized void insertSelinas1EN(Database dbConn){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selinas1 " +
				"values(" +
				"1," + //kundenId
				"1," +//standortId
				"'EN'," +//sprachId
				
				"'User <span style=\"text-decoration:underline\">d</span>elet'," +//Button14
				"'User <span style=\"text-decoration:underline\">c</span>reatin'," +//Button15
				"'Contact <span style=\"text-decoration:underline\">c</span>reate'," +//Button16
				"'Button17'," +//Button17
				"'Button18'," +//Button18
				"'Button19'," +//Button19
				"'Button20'," +//Button20
				"'Button21'," +//Button21
				"'Button22'," +//Button22
				"'Button23'," +//Button23
				"'Button24'," +//Button24
				"'Button25'," +//Button25
				
				"'Authorization',"+//permitId
				"'date of birth',"+//geburtstag
				"'contry',"+//land
				"'Authorization-Id',"+//userAppId
				"'Document Security Id',"+//dokumentPermitId
				"'Address belongs to',"+//userAdressId
				"'[Please select]')");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertSelina1EN:" + e);
		}//catch
	}//insertSelinas1DE
	
	 public static void main(String args[]) throws Exception{
	 	Database dbConn = new Database("mySql","localhost","selina","web4857","xxxx");
    	 
	 	CreateDataSelinas1 selinas = new CreateDataSelinas1();
    	
    	dbConn.getConnection();
    	selinas.deleteSelinas1(dbConn,1,1,"DE");
    	selinas.deleteSelinas1(dbConn,1,1,"EN");
    	selinas.insertSelinas1DE(dbConn);
    	selinas.insertSelinas1EN(dbConn);
    	
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
	
}//class CreateDataSelinas1
