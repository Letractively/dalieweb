/*
 * Created of DV0101 on 09.02.2010 17:18:12
 *
 * Filename	  DataSetEigentuemer.java
 */
package database.getDatabase;

import hausverwaltung.Eigentuemer;
import java.util.Vector;

import database.Database;
import database.dateien.Adresse;
import database.dateien.User;


/**
* Class description goes here.
*
* @version 	1.00 09.02.2010 um 17:18:12
* @author 		DV0101
* 
* @see 		Eigentuemer
* <br>
* 
*/
public class DataSetEigentuemer {
	
	/**
     * <b>Eigentuemer aus Datenbank Tabelle Eigentuemer</b>
     * <br><b>chain:Key objektId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int objektId</li></ul>
     * @return
     * <ul><li>Vector allEigentuemerOfObjekt</li></ul>
     */
    public static synchronized Vector reade(Database dbConn,int objektId) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".eigentuemer " +
        		"where objektId = "+ objektId +
        		" order by objektId, seit");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        Vector allOwner = new Vector();
        for(int i = 0;i < rows.size();i++) {
        	allOwner.addElement(new Adresse((Vector) rows.elementAt(i)));
        }//for
        return allOwner;
    }//chain
	
    /**
     * <b>ermittle den derzeitigen Eigentuemer zum Objekt</b>
     * <br><b>chain:Key objektId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int objektId</li></ul>
     * @return
     * <ul><li>Eigenttuemer ofObjekt</li></ul>
     */
    public static synchronized Eigentuemer toDetermineCurrentOwner(Database dbConn,int objektId) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".eigentuemer " +
        		"where objektId = "+ objektId +" and CURDATE() >= seit " +
        		"order by objektId, seit desc ");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Eigentuemer((Vector)rows.elementAt(0));
    }//toDetermineCurrentOwner
    /**
     * <b>ermittle den nächsten Eingetragen Eigentuemer zum Objekt</b>
     * <br><b>chain:Key objektId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int objektId</li></ul>
     * @return
     * <ul><li>Eigenttuemer ofObjekt</li></ul>
     */
    public static synchronized Eigentuemer toDetermineNextOwner(Database dbConn,int objektId) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".eigentuemer " +
        		"where objektId = "+ objektId +" and CURDATE() <= seit " +
        		"order by objektId, seit");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Eigentuemer((Vector)rows.elementAt(0));
    }//toDetermineNextOwner
    
    /**
     * <b>ermittle den ersten Eigentuemer zum Objekt</b>
     * <br><b>chain:Key objektId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int objektId</li></ul>
     * @return
     * <ul><li>Eigenttuemer ofObjekt</li></ul>
     */
    public static synchronized Eigentuemer toDetermineFirstOwner(Database dbConn,int objektId) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".eigentuemer " +
        		"where objektId = "+ objektId +" and CURDATE() < seit " +
        		"order by objektId, seit");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Eigentuemer((Vector)rows.elementAt(0));
    }//toDetermineFirstOwner
    
    /**
     * <b>insert Eigenttuemer on Datenbank </b>
     * <br><b>insert:Key none</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn</li>
     * <li>User user</li>
     * <li>Eigentuemer eigentuemer</li>
     * </ul>
     * @return
     * <ul><li>none</li></ul>
     */
    public static synchronized void insert(Database dbConn, User user ,Eigentuemer owner) throws Exception {
    	/* Verwendung: */
		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".eigentuemer " +
				"values("+owner.getObjektId()+",'"+owner.getName()+"'," +
				"'"+owner.getVorname()+"',now()," +  
				"now(),'"+user.getUserId()+"'," +
				"now(),'"+user.getUserId()+"',now())");
    }//insert
}//class DataSetEigentuemer
