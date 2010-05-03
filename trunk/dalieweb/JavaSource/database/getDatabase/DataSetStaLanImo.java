/*
 * Created of DV0101 on 16.02.2010 18:52:03
 *
 * Filename	  DataSetStaLanImo.java
 */
package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.StaLanImo;

/**
 * Class description goes here.
 *
 * @version 	1.00 16.02.2010 um 18:52:03
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetStaLanImo {
		
	public static synchronized StaLanImo chain(Database dbConn,int kundenId,int standortId,String sprachId) throws Exception {
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".stalanimo" +
    			" where kundenId = " + kundenId +
    			 	" and standortId = " + standortId+
    			 	" and sprachId = '" + sprachId + "'");
    	if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new StaLanImo((Vector)rows.elementAt(0));
    }//chain
	
}//class DataSetStaLanImo
