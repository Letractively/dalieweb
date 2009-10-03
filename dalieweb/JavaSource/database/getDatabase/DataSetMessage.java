/*
 * Created of DV0101 on 01.05.2009 20:11:22
 *
 * Filename	  DataSetMessage.java
 */
package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.Message;



/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 20:11:22
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetMessage {

    /**
     * <b>Message aus Datenbank Tabelle message</b>
     * <br><b>chain:Key messageId,sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String messageId</li>
     * <li>String messageId</li>
     * </ul>
     * @return
     * <ul><li>Message message</li></ul>
     */
    public static Message chain(Database dbConn,String messageId,String sprachId) throws Exception {
        	Message message = null;
        	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".message" +
        	        " where messageId = '"+messageId+"' and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	for (int i = 0; i < rows.size(); i++){
        	    return new Message((Vector)rows.elementAt(0));
        	}//for
        	return message;
    }//chain
    
}//class DataSetMessage
