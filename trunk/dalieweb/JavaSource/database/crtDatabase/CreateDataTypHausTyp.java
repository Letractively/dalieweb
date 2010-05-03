/*
* Created of DV0101 on 22.02.2010 09:30:09
*
* Filename	  CreateDataTypHaustyp.java
*/
package database.crtDatabase;

import database.Database;

/**
* Create Content of Database.
*
* @version 	1.00 22.02.2010 um 11:08:47
* @author 		DV0101
* <br><br>
*/
public class CreateDataTypHausTyp {
	/* Um sicher zustellen, dass immer korrekte Einträge für die Statis vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen 
	 * 
	 * Kopierhilfe: dataTyp.insertTyp(dbConn,"","DE",""); 
	 * Kopierhilfe: dataTyp.insertTyp(dbConn,"","EN",""); */
	
	static Database dbConn;
	
	public synchronized void deleteTyp(Database dbConn,String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".stahautyp " +
	        		"where sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteTyp:" + e);
		}//catch
	}//deleteStatus
	
	public synchronized void insertTyp(Database dbConn,String typId,String sprachId,String description){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".stahautyp " +
				"values('"+typId+"','" +sprachId+"','"+description+"'," + 
				"'DV0101'," + "now()," + 
				"'DV0101'," + "now())");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertTyp:" + e);
		}//catch
	}//insertTyp
	
	 public static void main(String args[]) throws Exception{
   	dbConn = new Database("mySql","localhost","selina","web4857","xxx");
   	
   	CreateDataTypHausTyp dataTyp = new CreateDataTypHausTyp();
   	
   	dbConn.getConnection();
   	
   	dataTyp.deleteTyp(dbConn,"");
   	dataTyp.insertTyp(dbConn,"R","","Reihenhaus");
   	dataTyp.insertTyp(dbConn,"E","","Einfamilienhaus");
   	dataTyp.insertTyp(dbConn,"M","","Mietshaus");
   	
   	dataTyp.deleteTyp(dbConn,"DE");
   	dataTyp.insertTyp(dbConn,"R","DE","Reihenhaus");
   	dataTyp.insertTyp(dbConn,"E","DE","Einfamilienhaus");
   	dataTyp.insertTyp(dbConn,"M","DE","Mietshaus");
   	
   	dataTyp.deleteTyp(dbConn,"EN");
   	dataTyp.insertTyp(dbConn,"R","EN","Terraced");
   	dataTyp.insertTyp(dbConn,"E","EN","Detached");
   	dataTyp.insertTyp(dbConn,"M","EN","Tenement");
   	
   	dbConn.close();
   	System.out.println("Fertig");
	 }//main
	
	
}//class CreateDataTypHausTyp
