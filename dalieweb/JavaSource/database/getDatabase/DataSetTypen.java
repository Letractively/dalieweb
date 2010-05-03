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
    public static synchronized Typen chainDatenTypAdresse(Database dbConn,String typId,String sprachId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".typ " +
                "where typId = '"+typId+"' " +
        		"and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
	
	/**
     * <b>Typ aus Datenbank Tabelle STAWHGTYP</b>
     * <br><b>chain:Key String typId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typId = (D)achgeschoss </li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chainDatenTypWohnungsTyp(Database dbConn,String typId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".stawhgtyp " +
                "where typId = '"+typId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
	
    /**
     * <b>Typ aus Datenbank Tabelle STAWHGTYP</b>
     * <br><b>chain:Key String typId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typId = (D)achgeschoss </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chainDatenTypWohnungsTyp(Database dbConn,String typId,String sprachId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".stawhgtyp " +
                "where typId = '"+typId+"' " +
        		"and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
    
    /**
     * <b>Typ aus Datenbank Tabelle STAWHGZUS</b>
     * <br><b>chain:Key String typId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typId = (T)op gepflegt </li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chainDatenTypWohnungsZustand(Database dbConn,String typId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".stawhgzus " +
                "where typId = '"+typId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
    
    /**
     * <b>Typ aus Datenbank Tabelle STAWHGZUS</b>
     * <br><b>chain:Key String typId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typId = (T)op gepflegt </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chainDatenTypWohnungsZustand(Database dbConn,String typId,String sprachId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".stawhgzus " +
                "where typId = '"+typId+"'" +
				"and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
    
    /**
     * <b>Typ aus Datenbank Tabelle STAHAUTYP</b>
     * <br><b>chain:Key String typId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typId = (R)eihenhaus </li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chainDatenTypHausTyp(Database dbConn,String typId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".stahautyp " +
                "where typId = '"+typId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
	
    /**
     * <b>Typ aus Datenbank Tabelle STAHAUTYP</b>
     * <br><b>chain:Key String typId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typId = (R)eihenhaus </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chainDatenTypHausTyp(Database dbConn,String typId,String sprachId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".stahautyp " +
                "where typId = '"+typId+"' " +
        		"and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
    
    /**
     * <b>Typ aus Datenbank Tabelle STAHAUZUS</b>
     * <br><b>chain:Key String typId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typId = (T)op gepflegt </li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chainDatenTypHausZustand(Database dbConn,String typId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".stahauzus " +
                "where typId = '"+typId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
    
    /**
     * <b>Typ aus Datenbank Tabelle STAHAUZUS</b>
     * <br><b>chain:Key String typId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typId = (T)op gepflegt </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chainDatenTypHausZustand(Database dbConn,String typId,String sprachId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".stahauzus " +
                "where typId = '"+typId+"'" +
				"and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
    
    /**
     * <b>Typ aus Datenbank Tabelle STASELMOD</b>
     * <br><b>chain:Key String typId, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String typId = (D)okumentenverwaltung </li>
     * <li>String sprachId = DE</li>
     * </ul>
     * @return
     * <ul>
     * <li>Typ typ</li>
     * </ul>
     */
    public static synchronized Typen chainDatenTypSelinasModel(Database dbConn,String typId,String sprachId) throws Exception {
    	Vector rows = dbConn.executeQuery("select typId, description, createUser, createDate, changeUser, changeDate from "+dbConn.getDbSchema()+".staselmod " +
                "where typId = '"+typId+"'" +
				"and sprachId = '"+sprachId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typen((Vector)rows.elementAt(0));            
    }//chain
}//class DataSetTypen
