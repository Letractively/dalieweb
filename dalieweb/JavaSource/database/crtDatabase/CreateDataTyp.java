/*
* Created of DV0101 on 23.01.2010 08:40:22
*
* Filename	  CreateDataTyp.java
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
public class CreateDataTyp {
	/* Um sicher zustellen, dass immer korrekte Einträge für die Statis vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen 
	 * 
	 * Kopierhilfe: dataTyp.insertTyp(dbConn,"","DE",""); 
	 * Kopierhilfe: dataTyp.insertTyp(dbConn,"","EN",""); */
	
	static Database dbConn;
	
	public synchronized void deleteTyp(Database dbConn,String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".typ " +
	        		"where sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteTyp:" + e);
		}//catch
	}//deleteStatus
	
	public synchronized void insertTyp(Database dbConn,String typId,String sprachId,String description){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".typ " +
				"values('"+typId+"','" +sprachId+"','"+description+"'," + 
				"'DV0101'," + "now()," + 
				"'DV0101'," + "now())");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertTyp:" + e);
		}//catch
	}//insertTyp
	
	 public static void main(String args[]) throws Exception{
   	dbConn = new Database("mySql","localhost","selina","web4857","xxx");
   	
   	CreateDataTyp dataTyp = new CreateDataTyp();
   	
   	dbConn.getConnection();
   	dataTyp.deleteTyp(dbConn,"DE");
   	dataTyp.insertTyp(dbConn,"U","DE","Adresse des Users");
   	dataTyp.insertTyp(dbConn,"R","DE","Rechungsadresse");
   	
   	
   	dataTyp.deleteTyp(dbConn,"EN");
   	dataTyp.insertTyp(dbConn,"U","EN","Adress of User");
   	dataTyp.insertTyp(dbConn,"R","EN","Adress to Bill");
   	
   	dbConn.close();
   	System.out.println("Fertig");
	 }//main
	
}//class CreateDataTyp
