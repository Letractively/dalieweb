/*
* Created of DV0101 on 23.01.2010 10:52:46
*
* Filename	  CreateDataTypWohnungszustand.java
*/
package database.crtDatabase;

import database.Database;

/**
* Create Content of Database.
*
* @version 	1.00 08.01.2010 um 10:52:46
* @author 		DV0101
* <br><br>
*/
public class CreateDataTypWohnungszustand {
	/* Um sicher zustellen, dass immer korrekte Einträge für die Statis vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen 
	 * 
	 * Kopierhilfe: dataTyp.insertTyp(dbConn,"","DE",""); 
	 * Kopierhilfe: dataTyp.insertTyp(dbConn,"","EN",""); */
	
	static Database dbConn;
	
	public synchronized void deleteTyp(Database dbConn,String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".stawhgzus " +
	        		"where sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteTyp:" + e);
		}//catch
	}//deleteStatus
	
	public synchronized void insertTyp(Database dbConn,String typId,String sprachId,String description){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".stawhgzus " +
				"values('"+typId+"','" +sprachId+"','"+description+"'," + 
				"'DV0101'," + "now()," + 
				"'DV0101'," + "now())");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertTyp:" + e);
		}//catch
	}//insertTyp
	
	 public static void main(String args[]) throws Exception{
   	dbConn = new Database("mySql","localhost","selina","web4857","xxx");
   	
   	CreateDataTypWohnungszustand dataTyp = new CreateDataTypWohnungszustand();
   	
   	dbConn.getConnection();
   	
   	dataTyp.deleteTyp(dbConn,"");
   	dataTyp.insertTyp(dbConn,"T","","Top gepflegt");
   	dataTyp.insertTyp(dbConn,"G","","gepflegt");
   	dataTyp.insertTyp(dbConn,"R","","Renovierungsbedürftig");
   	
   	dataTyp.deleteTyp(dbConn,"DE");
   	dataTyp.insertTyp(dbConn,"T","DE","Top gepflegt");
   	dataTyp.insertTyp(dbConn,"G","DE","gepflegt");
   	dataTyp.insertTyp(dbConn,"R","DE","Renovierungsbedürftig");
   	
   	dataTyp.deleteTyp(dbConn,"EN");
   	dataTyp.insertTyp(dbConn,"T","EN","top care");
   	dataTyp.insertTyp(dbConn,"G","EN","well looked");
   	dataTyp.insertTyp(dbConn,"R","EN","renovation");
   	
   	dbConn.close();
   	System.out.println("Fertig");
	 }//main
	
}//class CreateDataTypWohnungszustand
