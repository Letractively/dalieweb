/*
 * Created of DV0101 on 09.02.2010 13:51:37
 *
 * Filename	  DataSetImmobilieTyp.java
 */
package database.getDatabase;

import hausverwaltung.Immobilie;
import hausverwaltung.immobilien.Haus;
import hausverwaltung.immobilien.ImmobilienTyp;
import hausverwaltung.immobilien.Parkplatz;
import hausverwaltung.immobilien.Wohnung;

import java.util.Vector;

import database.Database;

/**
 * Class for SQL-Connection Table Wohnung or Parkplatz.
 *
 * @version 	1.00 09.02.2010 um 12:49:48
 * @author 		DV0101
 * 
 * @see 		Immobilie
 */
public class DataSetImmobilienTyp {

	/**
     * <b>Immobilie aus Datenbank Tabelle oder Parkplatz</b>
     * <br><b>chain:Key objketId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int objektId</li></ul>
     * @return
     * <ul><li>ImmobilienTyp wohnung oder parkplatz</li></ul> 
     */
	public static synchronized ImmobilienTyp chain(Database dbConn,int objektId) throws Exception {
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".wohnung " +
    		"where objektId = "+ objektId );
        if(rows.size() == 0){//no Record
        	rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".parkplatz " +
        		"where objektId = "+ objektId );
            if(rows.size() > 0){//Record exist
        		return new ImmobilienTyp(new Parkplatz((Vector)rows.elementAt(0)));
            }else{
            	rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".haus " +
                		"where objektId = "+ objektId );
            	if(rows.size() > 0)//Record exist
            		return new ImmobilienTyp(new Haus(dbConn,(Vector)rows.elementAt(0)));
            	else
            		throw new Exception("Record not Found");
            }//endif
        }//endif 
        return new ImmobilienTyp(new Wohnung(dbConn,(Vector)rows.elementAt(0)));
    }//ImmobilienTyp
	
}//class DataSetImmobilienTyp
