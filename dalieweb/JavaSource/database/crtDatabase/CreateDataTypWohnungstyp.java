/*
* Created of DV0101 on 23.01.2010 11:08:47
*
* Filename	  CreateDataTypWohnungszustand.java
*/
package database.crtDatabase;

import database.Database;

/**
* Create Content of Database.
*
* @version 	1.00 08.01.2010 um 11:08:47
* @author 		DV0101
* <br><br>
*/
public class CreateDataTypWohnungstyp {
	/* Um sicher zustellen, dass immer korrekte Einträge für die Statis vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen 
	 * 
	 * Kopierhilfe: dataTyp.insertTyp(dbConn,"","DE",""); 
	 * Kopierhilfe: dataTyp.insertTyp(dbConn,"","EN",""); */
	
	static Database dbConn;
	
	public synchronized void deleteTyp(Database dbConn,String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".stawhgtyp " +
	        		"where sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteTyp:" + e);
		}//catch
	}//deleteStatus
	
	public synchronized void insertTyp(Database dbConn,String typId,String sprachId,String description){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".stawhgtyp " +
				"values('"+typId+"','" +sprachId+"','"+description+"'," + 
				"'DV0101'," + "now()," + 
				"'DV0101'," + "now())");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertTyp:" + e);
		}//catch
	}//insertTyp
	
	 public static void main(String args[]) throws Exception{
   	dbConn = new Database("mySql","localhost","selina","web4857","xxx");
   	
   	CreateDataTypWohnungstyp dataTyp = new CreateDataTypWohnungstyp();
   	
   	dbConn.getConnection();
   	
   	dataTyp.deleteTyp(dbConn,"");
   	dataTyp.insertTyp(dbConn,"D","","Dachgeschoss");
   	dataTyp.insertTyp(dbConn,"E","","Etagenwohnung");
   	dataTyp.insertTyp(dbConn,"G","","Erdgeschoss");
   	dataTyp.insertTyp(dbConn,"S","","Stockwerk");
   	
   	dataTyp.deleteTyp(dbConn,"DE");
   	dataTyp.insertTyp(dbConn,"D","DE","Dachgeschoss");
   	dataTyp.insertTyp(dbConn,"E","DE","Etagenwohnung");
   	dataTyp.insertTyp(dbConn,"G","DE","Erdgeschoss");
   	dataTyp.insertTyp(dbConn,"S","DE","Stockwerk");
   	
   	dataTyp.deleteTyp(dbConn,"EN");
   	dataTyp.insertTyp(dbConn,"D","EN","attic");
   	dataTyp.insertTyp(dbConn,"E","EN","apartment");
   	dataTyp.insertTyp(dbConn,"G","EN","ground");
   	dataTyp.insertTyp(dbConn,"S","EN","floor");
   	
   	dbConn.close();
   	System.out.println("Fertig");
	 }//main
	
}//class CreateDataTypWohnungstyp
