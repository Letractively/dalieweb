/*
 * Created of DV0101 on 01.05.2009 19:00:13
 *
 * Filename	  DataSetSelinas.java
 */
package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.Selinas;

/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 19:00:13
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetSelinas {
    
    public static synchronized Selinas chain(Database dbConn,int kundenId,int standortId,String sprachId) throws Exception {
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".selinas " +
    			"where kundenId = "+kundenId+"" +
    			 	" and standortId = "+standortId+""+
    			 	" and sprachId = '"+sprachId+"'");
    	if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Selinas((Vector)rows.elementAt(0));
    }//chain

}//class DataSetSelinas
