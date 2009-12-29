/*
 * Created of DV0101 on 04.05.2009 07:58:14
 *
 * Filename	  DataSetTyp.java
 */
package database.getDatabase;

import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;

import database.Database;
import database.dateien.Dokument;
import database.dateien.Typ;
import database.dateien.User;

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

	/** oderByTypOf_0 = Table dokumentTyp by*/
	public static final String orderByTypOf_0 = "kundenId, standortId, descripten, createDate desc";
	 /** oderByTypOf_0 = Table dokumentTyp by*/
	public static final String orderByTypOf_0d = "kundenId, standortId, descripten desc, createDate desc";
	/** oderByTypOf_0 = Table dokumentTyp by*/
	public static final String orderByTypOf_1 = "kundenId, standortId, createDate desc";
	/** oderByTypOf_0 = Table dokumentTyp by*/
	public static final String orderByTypOf_1d = "kundenId, standortId, createDate";
	/** oderByTypOf_0 = Table dokumentTyp by*/
	public static final String orderByTypOf_2 = "kundenId, standortId, changeDate desc";
	/** oderByTypOf_0 = Table dokumentTyp by*/
	public static final String orderByTypOf_2d = "kundenId, standortId, changeDate";
	/** oderByTypOf_0 = Table dokumentTyp by*/
	public static final String orderByTypOf_3 = "kundenId, standortId, dokumentTyp, createDate desc";
	 /** oderByTypOf_0 = Table dokumentTyp by*/
	public static final String orderByTypOf_3d = "kundenId, standortId, dokumentTyp desc, createDate desc";
	
	private static Hashtable memberTable = init();
	private static Hashtable init() {
        Hashtable members = new Hashtable();
        members.put("B",orderByTypOf_0);//order by Beschreibung
        members.put("BD",orderByTypOf_0d);//order by Beschreibung desc
        members.put("CREATEDATE",orderByTypOf_1);//order by ErstellTag desc
        members.put("CREATEDATED",orderByTypOf_1d);//order by ErstellTag
        members.put("CHANGEDATE",orderByTypOf_2);//order by ChangeDate desc
        members.put("CHANGEDATED",orderByTypOf_2d);//order by ChangeDate
        members.put("T",orderByTypOf_3);//order by DokumentTyp
        members.put("TD",orderByTypOf_3d);//order by DokumentTyp desc
        return members;
    }//init
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
    public static synchronized Typ chain(Database dbConn,int kundenId,int standortId,String dokumenttyp) throws Exception {
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumenttyp " +
    			"where kundenId = "+kundenId+" " +
        		"and standortId = "+standortId+" " +
        		"and dokumentTyp = '"+dokumenttyp+"' " +
        		"and sprachId = ''");
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
    public static synchronized Typ chain(Database dbConn,User user,Typ typ) throws Exception {
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumenttyp " +
    			"where kundenId = "+user.getKundenId()+" " +
        		"and standortId = "+user.getStandortId()+" " +
        		"and dokumentTyp = '"+typ.getTyp()+"' " +
        		"and sprachId = ''");
        if(rows.size() == 0)
            throw new Exception("Record not Found");
        return new Typ((Vector)rows.elementAt(0));            
    }//getTypOfDokument
    
    /**
     * <b>Anzahl der Datensätze aus Datenbank Tabelle dokumenttyp</b>
     * <br><b>chain:Key int kundenId, int standortId, String dokumenttyp</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>int kundenId = 1</li>
     * <li>int standortId = 1</li>
     * <li>String dokumentyp = FO = Formular </li>
     * </ul>
     * @return
     * <ul>
     * <li>int count</li>
     * </ul>
     */
    public static synchronized int getCounter(Database dbConn,User user,String dokumenttyp) throws Exception {
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
    			"where kundenId = "+user.getKundenId()+" " +
        		"and standortId = "+user.getStandortId()+" " +
        		"and dokumentTyp = '"+dokumenttyp+"'");
        return rows.size();            
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
        			"and sprachId = ''");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	return new Typ((Vector)rows.elementAt(0));            
    }//getTypOfDokument
    
    /**
     * <b>Dokumenttyp aus Datenbank Tabelle dokumenttyp</b>
     * <br><b>chain:Key user,String sprachId,String orderBy</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>int kundenId = 1</li>
     * <li>int standortId = 1</li>
     * <li>String sprachId = DE</li>
     * <li>String oderBy = B</li>
     * </ul>
     * @return
     * <ul>
     * <li>Dokumentyp dokumenttyp</li>
     * </ul>
     */
    public static synchronized Vector reade(Database dbConn,User user,String oderBy) throws Exception {
    	Vector liste = new Vector();
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumenttyp " +
                "where kundenId = "+user.getKundenId()+" " +
        		"and standortId = "+user.getStandortId()+" " +
        		"and sprachId = ''" +
				" ORDER BY "+valueOf(oderBy)+"");
        if(rows.size() == 0)
            throw new Exception("Record not Found");
        for (int i = 0; i < rows.size(); i++){
    		liste.addElement(new Typ((Vector) rows.elementAt(i)));
    	}//for
    	return liste;        
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
     * <li>Vector Dokumenttyp</li>
     * </ul>
     */
    public static synchronized Vector reade(Database dbConn,User user) throws Exception {
    	Vector liste = new Vector();
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumenttyp " +
                "where kundenId = "+user.getKundenId()+" " +
        		"and standortId = "+user.getStandortId()+" " +
        		"and sprachId = ''" +
    			" ORDER BY kundenId, standortId, descripten, createDate desc");
        if(rows.size() == 0)
            throw new Exception("Record not Found");
        for (int i = 0; i < rows.size(); i++){
    		liste.addElement(new Typ((Vector) rows.elementAt(i)));
    	}//for
    	return liste;        
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
     * <li>Vector Dokumenttyp</li>
     * </ul>
     */
    public static synchronized Vector reade(Database dbConn,int kundenId, int standortId) throws Exception {
    	Vector liste = new Vector();
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumenttyp " +
                "where kundenId = "+kundenId+" " +
        		"and standortId = "+standortId+" " +
        		"and sprachId = ''" +
    			" ORDER BY kundenId, standortId, descripten, createDate desc");
        if(rows.size() == 0)
            throw new Exception("Record not Found");
        for (int i = 0; i < rows.size(); i++){
    		liste.addElement(new Typ((Vector) rows.elementAt(i)));
    	}//for
    	return liste;        
    }//reade
    /**
     * <b>insert Typ on Datenbank </b>
     * <br><b>insert:Key none </b>
     * <br><b>public</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn</li>
     * <li>User user</li>
     * </ul>
     * @return
     * <ul><li>none</li></ul>
     */
    public static synchronized void insert(Database dbConn, User user, Typ typ) throws Exception{
		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".dokumenttyp " +
				"values("+user.getKundenId()+"," +user.getStandortId()+"," +
				"'"+typ.getTyp()+"','','"+typ.getDescription()+"'," + 
				"'"+user.getUserId()+"'," + "now()," + 
				"'"+user.getUserId()+"'," + "now())");
    }//insert
    public static synchronized void update(Database dbConn, User user, Typ typ) throws Exception {
        dbConn.executeUpdate("update "+dbConn.getDbSchema()+".dokumenttyp " +
                "set" +
				" descripten = '"+ typ.getDescription()+"'," +
                " changeUser = '"+ user.getUserId()+ "'," + " changeDate = now() " +
                " where kundenId = "+ user.getKundenId() + " and standortId = "+user.getStandortId() +
                " and dokumentTyp = '"+typ.getTyp() + "'" + 
                " and sprachId = ''");
    }//update
    
    /**
     * <b>delete DokumentTyp on Datenbank </b>
     * <br><b>delete:Key kundenId, standortId, dokumenttyp</b>
     * <br><b>public</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn</li>
     * <li>String kundenId</li>
     * <li>String standortId</li>
     * <li>String dokumentTyp</li>
     * </ul>
     * @return
     * <ul><li>none</li></ul>
     */
    public static synchronized void delete(Database dbConn,int kundenId, int standortId,String dokumentTyp) throws Exception {
        dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".dokumenttyp" +
                " where " +
                " dokumentTyp = '"+ dokumentTyp + "'" + " and standortId = " + standortId +
                " and kundenId = " + kundenId);
    }//delete
    
    /**
     * Returns a String with order by value based on the given String value.
     * @param string
    */ 
    private static String valueOf(String typOf){
        String obj = null;
        if (typOf != null) 
            obj = (String) memberTable.get(typOf);
        if (obj == null) {
            String err = "'" + typOf + "' is not a valid";
            	throw new IllegalArgumentException(err);
        }//endif
        return obj;
    }//valueOf 
    
    /** Create a new KeyValue */
    public static String createRandomString() {
		String str = new String(
				"QAa0bcLdUK2eHfJgTP8XhiFj61DOklNm9nBoI5pGqYVrs3CtSuMZvwWx4yE7zR");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int te = 0;
		for (int i = 1; i <= 2; i++) {
			te = r.nextInt(62);
			sb.append(str.charAt(te));
		}//for
		return sb.toString();
	}   

}//class DataSetTyp
