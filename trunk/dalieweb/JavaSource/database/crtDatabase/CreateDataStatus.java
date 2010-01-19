/*
 * Created of DV0101 on 08.01.2010 09:01:22
 *
 * Filename	  CreateDataStatus.java
 */
package database.crtDatabase;

import database.Database;

/**
 * Create Content of Database.
 *
 * @version 	1.00 08.01.2010 um 09:01:22
 * @author 		DV0101
 * <br><br>
 */
public class CreateDataStatus {
	/* Um sicher zustellen, dass immer korrekte Einträge für die Statis vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen 
	 * 
	 * Kopierhilfe: dataStatus.insertStatus(dbConn,"","DE","E",""); 
	 * Kopierhilfe: dataStatus.insertStatus(dbConn,"","EN","E",""); */
	
	static Database dbConn;
	
	public synchronized void deleteStatus(Database dbConn,String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".status " +
	        		"where sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteStatus:" + e);
		}//catch
	}//deleteStatus
	
	public synchronized void insertStatus(Database dbConn,String statusId,String sprachId,String description, String notizen){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".status " +
				"values('"+statusId+"','" +sprachId+"','"+description+"','"+notizen+"'," + 
				"'DV0101'," + "now()," + 
				"'DV0101'," + "now())");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteMessage:" + e);
		}//catch
	}//insertStatus
	
	 public static void main(String args[]) throws Exception{
    	dbConn = new Database("mySql","localhost","selinas","web4857","xxx");
    	
    	CreateDataStatus dataStatus = new CreateDataStatus();
    	
    	dbConn.getConnection();
    	dataStatus.deleteStatus(dbConn,"DE");
    	dataStatus.insertStatus(dbConn,"A","DE","Aktiv","Userstatus aktiv");
    	dataStatus.insertStatus(dbConn,"I","DE","Inaktiv","Userstatus inaktiv");
    	
    	
    	dataStatus.deleteStatus(dbConn,"EN");
    	dataStatus.insertStatus(dbConn,"A","EN","activ","Userstatus aktiv");
    	dataStatus.insertStatus(dbConn,"I","EN","inactiv","Userstatus inaktiv");
    	
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateDataStatus
