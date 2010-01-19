/*
 * Created of DV0101 on 08.01.2010 09:36:48
 *
 * Filename	  CreateDataUser.java
 */
package database.crtDatabase;

import database.Database;

/**
 * Create Content of Database.
 *
 * @version 	1.00 08.01.2010 um 09:01:48
 * @author 		DV0101
 * <br><br>
 */
public class CreateDataUser {
	/* Um sicher zustellen, dass immer korrekte Einträge für die User vorhanden sind,
	 * muss diese Klasse nach der Installation von Selinas ausgeführt werden.
	 * Achtung -> Databaseconnecten parameter prüfen */
	
	static Database dbConn;
	
	public synchronized void deleteUser(Database dbConn,String userId){
		try {
			dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".user " +
	        		"where userId = '"+userId+"'");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteUser:" + e);
		}//catch
	}//deleteUser
	
	public synchronized void insertUser(Database dbConn,String userId,String statusId,String passwort, 
			String name, String vorname,int berechtigungsId, int userAutorisierungsId, int kundenId, int standortId, String sprachId){
		try {
			dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".user " +
				"values('"+userId+"'," +
				"'"+statusId+"'," +
				"'"+passwort+"','"+name+"','"+vorname+"', now()," + berechtigungsId + ","+ userAutorisierungsId + "," + kundenId + ","+ standortId + "," +
				"'"+sprachId+"'," + 
				"1,1," +
				"'DV0101'," + "now()," + 
				"'DV0101'," + "now())");
		} catch (Exception e) {
			System.out.println(this.getClass().getName()+".deleteMessage:" + e);
		}//catch
	}//insertUser
	
	 public static void main(String args[]) throws Exception{
    	dbConn = new Database("mySql","localhost","selina","web4857","xxx");
    	
    	CreateDataUser dataUser = new CreateDataUser();
    	
    	dbConn.getConnection();
    	//dataUser.deleteUser(dbConn,"DE0101");
    	//dataUser.deleteUser(dbConn,"DE0102");
    	//dataUser.deleteUser(dbConn,"DE0103");
    	//dataUser.deleteUser(dbConn,"DE0104");
    	//dataUser.deleteUser(dbConn,"DE0105");
    	//dataUser.deleteUser(dbConn,"DV0101");
    	
    	dataUser.insertUser(dbConn,"DE0101","A","selina","Marx","Karl",1,10,1,1,"");
    	dataUser.insertUser(dbConn,"DE0102","A","selina","Einstein","Albert",2,10,1,1,"");
    	dataUser.insertUser(dbConn,"DE0103","A","selina","Thälmann","Ernst",3,10,1,1,"");
    	dataUser.insertUser(dbConn,"DE0104","A","selina","Friedrich","Engels",4,10,1,1,"");
    	dataUser.insertUser(dbConn,"DE0105","A","selina","leutheusser-schnarrenberger","sabine",5,10,1,1,"");
    	dataUser.insertUser(dbConn,"DV0101","A","selina","Dalies","Uwe",5,10,1,1,"");
    	
    	dbConn.close();
    	System.out.println("Fertig");
	 }//main
	
}//class CreateDataUser
