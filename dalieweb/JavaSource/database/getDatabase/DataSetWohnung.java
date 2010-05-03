/*
 * Created of DV0101 on 11.02.2010 16:39:50
 *
 * Filename	  DataSetWohnung.java
 */
package database.getDatabase;


import hausverwaltung.immobilien.Wohnung;

import java.util.Vector;

import database.Database;
import database.dateien.User;

/**
 * Class for SQL-Connection Table ImmobilienTyp.
 *
 * @version 	1.00 09.02.2010 um 16:39:50
 * @author 		DV0101
 * 
 * @see 		Wohnung
 */
public class DataSetWohnung {

	/**
     * <b>Wohnung aus Datenbank Tabelle Wohnung</b>
     * <br><b>chain:Key objketId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int objektId</li></ul>
     * @return
     * <ul><li>Immobilie immobilie</li></ul> 
     */
	public static synchronized Wohnung chain(Database dbConn,int objektId) throws Exception {
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".wohnung " +
    			"where objektId = "+ objektId );
    	if(rows.size() == 0)
        	 throw new Exception("Record not Found");
        return (new Wohnung(dbConn,(Vector)rows.elementAt(0)));
    }//chain
	
	/**
     * <b>insert Wohnung on Datenbank </b>
     * <br><b>insert:Key none</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn</li>
     * <li>User user</li>
     * <li>Wohnung wohnung</li>
     * </ul>
     * @return
     * <ul><li>none</li></ul>
     */
    public static synchronized void insert(Database dbConn,User user,Wohnung wohnung) throws Exception {
    	/* Verwendung: */
		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".wohnung " +
				"values("+wohnung.getObjektId()+",'"+wohnung.getBaujahr()+"'," +
				"'"+wohnung.getZustand()+"','"+wohnung.getTyp()+"'," +  
				wohnung.getZimmer()+","+wohnung.getFlaeche()+"'," +
				"'"+wohnung.getHeitzungstyp()+ "'"+user.getUserId()+"'," +
				"now()," + "'"+user.getUserId()+"'," + "now())");
    }//insert
	
}//class Wohnung
