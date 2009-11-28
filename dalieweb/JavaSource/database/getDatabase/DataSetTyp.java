/*
 * Created of DV0101 on 04.05.2009 07:58:14
 *
 * Filename	  DataSetTyp.java
 */
package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.Dokument;
import database.dateien.Typ;

/**
 * Class description goes here.
 *
 * @version 	1.00 04.05.2009 um 07:58:14
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetTyp {

    /**
     * <b>Dokumenttyp aus Datenbank Tabelle dokumenttyp</b>
     * <br><b>chain:Key int kundenId, int standortId, String dokumenttyp, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>int kundenId = 1</li>
     * <li>int standortId = 1</li>
     * <li>String dokumentyp = FO = Formular </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Dokumentyp dokumenttyp</li>
     * </ul>
     */
    public static synchronized Typ chain(Database dbConn,int kundenId,int standortId,String dokumenttyp,String sprachId) throws Exception {
    		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumenttyp " +
        	        "where kundenId = "+kundenId+" " +
        			"and standortId = "+standortId+" " +
        			"and dokumentTyp = '"+dokumenttyp+"' " +
        			"and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typ((Vector)rows.elementAt(0));            
    }//getTypOfDokument
    
    /**
     * <b>Dokumenttyp aus Datenbank Tabelle dokumenttyp</b>
     * <br><b>chain:Key int kundenId, int standortId, String dokumenttyp, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>int kundenId = 1</li>
     * <li>int standortId = 1</li>
     * <li>String dokumentyp = FO = Formular </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Dokumentyp dokumenttyp</li>
     * </ul>
     */
    public static synchronized Typ chain(Database dbConn,Dokument dokument) throws Exception {
        	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumenttyp " +
        	        "where kundenId = "+dokument.getKundenId()+" " +
        			"and standortId = "+dokument.getStandortId()+" " +
        			"and dokumentTyp = '"+dokument.getDokumentTyp()+"' " +
        			"and sprachId = '"+dokument.getSprachId()+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typ((Vector)rows.elementAt(0));            
    }//getTypOfDokument
    
    /**
     * <b>Dokumenttyp aus Datenbank Tabelle dokumenttyp</b>
     * <br><b>chain:Key int kundenId, int standortId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>int kundenId = 1</li>
     * <li>int standortId = 1</li>
     * <li>String dokumentyp = FO = Formular </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Dokumentyp dokumenttyp</li>
     * </ul>
     */
    public static synchronized Vector reade(Database dbConn,int kundenId,int standortId,String sprachId) throws Exception {
    	Vector liste = new Vector();
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumenttyp " +
                "where kundenId = "+kundenId+" " +
        		"and standortId = "+standortId+" " +
        		"and sprachId = '"+sprachId+"'");
        if(rows.size() == 0)
            throw new Exception("Record not Found");
        for (int i = 0; i < rows.size(); i++){
    		liste.addElement(new Typ((Vector) rows.elementAt(i)));
    	}//for
    	return liste;        
    }//getTypOfDokument
    
}//class DataSetTyp
