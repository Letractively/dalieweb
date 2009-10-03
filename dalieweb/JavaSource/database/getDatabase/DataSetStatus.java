/*
 * Created of DV0101 on 04.05.2009 08:25:29
 *
 * Filename	  DataSetStatus.java
 */
package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.Status;

/**
 * Class description goes here.
 *
 * @version 	1.00 04.05.2009 um 08:25:29
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetStatus {

    /**
     * <b>Status aus Datenbank Tabelle status</b>
     * <br><b>chain:Key statusId, sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String statusId = "A"ktiv or "I"inaktiv</li>
     * <li>String sprachId = EN = englisch/DE = deutsch</li>
     * </ul>
     * @return
     * <ul><li>User user</li></ul>
     */
    public static Status chain(Database dbConn,String statusId,String sprachId) throws Exception {
        	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".status " +
        			"where statusId = '"+statusId+"'" + " and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
            return new Status((Vector)rows.elementAt(0));
    }//chain
    
}//class DataSetStatus
