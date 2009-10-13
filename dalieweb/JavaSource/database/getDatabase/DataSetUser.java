/*
 * Created of DV0101 on 01.05.2009 18:49:34
 *
 * Filename	  DataSetUser.java
 */
package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.User;

/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 18:49:34
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetUser {

    /**
     * <b>User aus Datenbank Tabelle user</b>
     * <br><b>chain:Key userId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String userId = DV0101 AnmeldeKennnung am System</li>
     * </ul>
     * @return
     * <ul><li>User user</li></ul>
     */
    public static synchronized User chain(Database dbConn,String userId) throws Exception {
        	User user = null;
        	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".user " +
        			"where userId = '"+userId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	for (int i = 0; i < rows.size(); i++){
        	    return new User((Vector)rows.elementAt(i));
        	}//for
        	return user;
    }//chain 
    
}//class DataSetUser
