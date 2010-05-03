/*
 * Created of DV0101 on 11.02.2010 17:33:53
 *
 * Filename	  DataSetWohnung.java
 */
package database.getDatabase;

import java.util.Vector;

import hausverwaltung.immobilien.Parkplatz;
import database.Database;
import database.dateien.User;

/**
 * Class for SQL-Connection Table parkplatz.
 *
 * @version 	1.00 09.02.2010 um 16:39:50
 * @author 		DV0101
 * 
 * @see 		Parkplatz
 */
public class DataSetParkplatz {

	/**
     * <b>Parkplatz aus Datenbank Tabelle Parkplatz</b>
     * <br><b>chain:Key objketId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int objektId</li></ul>
     * @return
     * <ul><li>Immobilie immobilie</li></ul> 
     */
	public static synchronized Parkplatz chain(Database dbConn,int objektId) throws Exception {
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".parkplatz " +
    			"where objektId = "+ objektId );
    	if(rows.size() == 0)
        	 throw new Exception("Record not Found");
        return new Parkplatz((Vector)rows.elementAt(0));
	}    
	/**
     * <b>insert Parkplatz on Datenbank </b>
     * <br><b>insert:Key none</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn</li>
     * <li>User user</li>
     * <li>Parkplatz parkplatz</li>
     * </ul>
     * @return
     * <ul><li>none</li></ul>
     */
    public static synchronized void insert(Database dbConn,User user,Parkplatz parkplatz) throws Exception {
    	/* Verwendung: */
		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".wohnung " +
				"values("+parkplatz.getObjektId()+",'"+parkplatz.getMiete()+"'," +
				"'"+user.getUserId()+"'," +
				"now()," + "'"+user.getUserId()+"'," + "now())");
    }//insert
	
}//class DataSetParkplatz
