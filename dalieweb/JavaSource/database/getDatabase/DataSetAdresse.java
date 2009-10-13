/*
 * Created of DV0101 on 04.05.2009 07:40:28
 *
 * Filename	  DataSetAdresse.java
 */
package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.Adresse;
import database.dateien.User;

/**
 * Class description goes here.
 *
 * @version 	1.00 04.05.2009 um 07:40:28
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetAdresse {

    /**
     * <b>Adresse aus Datenbank Tabelle Adresse</b>
     * <br><b>chain:Key adressId,adressArt</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn	</li>
     * <li>int adressId	(adressId = KundenNr 04711)</li>
     * <li>String adressArt (adressArt = (U)ser,(R)echnungs oder (K)Kundenadresse)</li>
     * </ul>
     * @return
     * <ul><li> Vector Adresse(n)</li></ul>
     */
    public static synchronized Adresse chain(Database dbConn,int adressId,String adressArt) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".adressen " +
        		"where adressId = "+ adressId + " and adressArt = '"+adressArt+"'");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Adresse((Vector)rows.elementAt(0));
    }//chain
    /**
     * <b>alle Adresse aus der Datenbank</b>
     * <br><b>read:Key none</b>
     * <br><b>public static </b><br>
     * @param
     * <ul>	<li>Database dbConn	</li></ul>
     * @return
     * <ul><li> Vector Adresse(n)</li></ul>
     */
    public static synchronized Vector read(Database dbConn) throws Exception {
        Vector allAdressen = new Vector();
        Vector rows = dbConn.executeQuery("select * from"+dbConn.getDbSchema()+".adressen");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        for(int i = 0;i < rows.size();i++) {
            allAdressen.addElement((Adresse)rows.elementAt(1));
        }//for
        return allAdressen;
    }//read
    /**
    * <b>alle Adresse(n) aus der Datenbank </b>
     * <br><b>reade:Key adressId</b>
     * <br><b>public</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn	</li>
     * <li>int adressId	(adressId = KundenNr 04711) </li>
     * </ul>
     * @return
     * <ul><li> Vector Adresse(n)</li></ul>
     */
    public static synchronized Vector reade(Database dbConn,int adressId) throws Exception {
        Vector allAdressen = new Vector();
        Vector rows = dbConn.executeQuery("select * from"+dbConn.getDbSchema()+".adressen " +
        		"where adressId = "+adressId+"");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        for(int i = 0;i < rows.size();i++) {
            allAdressen.addElement((Adresse)rows.elementAt(i));
        }//for
        return allAdressen;
    }//reade
    /**
     * <b>insert Adresse on Datenbank </b>
     * <br><b>insert:Key none </b>
     * <br><b>public</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li></ul>
     * @return
     * <ul><li>none</li></ul>
     */
    public static synchronized void insert(Database dbConn, User user, Adresse adresse) throws Exception{
		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".adressen " +
				"values(" + user.getKundenId()+"," + "'" + adresse.getAdressArt() + "'," +
		        "'" + adresse.getStrasse() + "'," + "'" + adresse.getNummer() + "'," +
		        "'" + adresse.getPlz() + "'," + "'" + adresse.getOrt() + "'," +
		        "'" + adresse.getTelefon() + "'," + "'" + adresse.getFax() + "'," +
				"'" + adresse.getMail() + "'");
	}//insert
    
}//class DataSetAdresse
