/*
 * Created of DV0101 on 16.11.2009 12:31:14
 *
 * Filename	  DataSetTypen.java
 */
package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.Typen;

/**
 * Class description goes here.
 *
 * @version 	1.00 16.11.2009 um 12:31:14
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetTypen {
	
	/**
     * <b>Typ aus Datenbank Tabelle Typ</b>
     * <br><b>chain:Key String typId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typ = (U)seradresse </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chain(Database dbConn,String typId,String sprachId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".typ " +
                "where typId = '"+typId+"' " +
        		"and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
	
    /**
     * <b>Typ aus Datenbank Tabelle Typ</b>
     * <br><b>chain:Key String typId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typ = (U)seradresse </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chain(Database dbConn,String typId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".typ " +
                "where typId = '"+typId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
    
}//class DataSetTypen
