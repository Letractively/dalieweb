/*
* Created of DV0101 on 09.04.2010  08:53:17
*
* Filename	  CreateDataTypSelinasModul.java
*/
package database.crtDatabase;

import database.Database;

/**
* Create Content of Database.
*
* @version 	1.00 09.04.2010 um  08:53:17
* @author 		DV0101
* <br><br>
*/
public class CreateDataTypSelinasModul {

	static Database dbConn;
	
	public synchronized void deleteTyp(Database dbConn,String sprachId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".staselmod " +
	        		"where sprachId = '"+sprachId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteTyp:" + e);
		}//catch
	}//deleteStatus
	
	public synchronized void insertTyp(Database dbConn,String typId,String sprachId,String description){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".staselmod " +
				"values('"+typId+"','" +sprachId+"','"+description+"'," + 
				"'DV0101'," + "now()," + 
				"'DV0101'," + "now())");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".insertTyp:" + e);
		}//catch
	}//insertTyp
	
	 public static void main(String args[]) throws Exception{
   	dbConn = new Database("mySql","localhost","selina","web4857","xxx");
   	
   	CreateDataTypSelinasModul dataTyp = new CreateDataTypSelinasModul();
   	
   	dbConn.getConnection();
   	
   	dataTyp.deleteTyp(dbConn,"DE");
   	dataTyp.insertTyp(dbConn,"D","DE","Dokumentenverwaltung");
   	dataTyp.insertTyp(dbConn,"I","DE","Immobilienverwaltung");
   	
   	dataTyp.deleteTyp(dbConn,"EN");
   	dataTyp.insertTyp(dbConn,"D","EN","Document Management");
   	dataTyp.insertTyp(dbConn,"I","EN","Property Management");
   	
   	dbConn.close();
   	System.out.println("Fertig");
	 }//main
	
}//class CreateDataTypSelinasModul
