/*
 * Created of DV0101 on 04.05.2009 07:40:28
 *
 * Filename	  DataSetAdresse.java
 */
package database.getDatabase;

import java.util.Hashtable;
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
	
	/** oderByTypOf_0 = Table dokument by*/
	public static final String orderByTypOf_0 = "adressId, userId, adressArt";
	/** oderByTypOf_1 = Table dokument by*/
	public static final String orderByTypOf_1 = "strasse";
	/** oderByTypOf_2 = Table dokument by*/
	public static final String orderByTypOf_2 = "nummer";
	/** oderByTypOf_3 = Table dokument by*/
	public static final String orderByTypOf_3 = "adressId, createDate desc";
	/** oderByTypOf_4 = Table dokument by*/
	public static final String orderByTypOf_4 = "adressId, changeDate desc";
	/** oderByTypOf_5 = Table dokument by*/
	public static final String orderByTypOf_5 = "plz";
	/** oderByTypOf_6 = Table dokument by*/
	public static final String orderByTypOf_6 = "ort";
	/** oderByTypOf_7 = Table dokument by*/
	public static final String orderByTypOf_7 = "land";
	/** oderByTypOf_6 = Table dokument by*/
	public static final String orderByTypOf_8 = "adressId, userId desc, adressArt";
	 /** oderByTypOf_0 = Table dokument by*/
	public static final String orderByTypOf_9 = "strasse desc";
	/** oderByTypOf_1 = Table dokument by*/
	public static final String orderByTypOf_10 = "nummer desc";
	/** oderByTypOf_2 = Table dokument by*/
	public static final String orderByTypOf_11 = "adressId, createDate";
	/** oderByTypOf_5 = Table dokument by*/
	public static final String orderByTypOf_12 = "adressId, changeDate";
	/** oderByTypOf_3 = Table dokument by*/
	public static final String orderByTypOf_13 = "plz desc";
	/** oderByTypOf_4 = Table dokument by*/
	public static final String orderByTypOf_14 = "ort desc";
	/** oderByTypOf_7 = Table dokument by*/
	public static final String orderByTypOf_15 = "land desc";
	
	private static Hashtable memberTable = init();
	private static Hashtable init() {
        Hashtable members = new Hashtable();
        members.put("U",orderByTypOf_0);//order by userId
        members.put("S",orderByTypOf_1);//order by strasse
        members.put("N",orderByTypOf_2);//order by nummer
        members.put("CREATEDATE",orderByTypOf_3);//order by createDate desc
        members.put("CHANGEDATE",orderByTypOf_4);//order by changeDate desc
        members.put("P",orderByTypOf_5);//order by only by plz
        members.put("O",orderByTypOf_6);//order by only ort
        members.put("L",orderByTypOf_7);//order by only land
        members.put("UD",orderByTypOf_8);//order by only userId desc
        members.put("SD",orderByTypOf_9);//order by strasse desc
        members.put("ND",orderByTypOf_10);//order by nummer desc
        members.put("CREATEDATED",orderByTypOf_11);//order by createDate
        members.put("CHANGEDATED",orderByTypOf_12);//order by changeDate
        members.put("PD",orderByTypOf_13);//order by plz desc
        members.put("OD",orderByTypOf_14);//order by ort des
        members.put("LD",orderByTypOf_15);//order by land desc
        return members;
    }//init

    /**
     * <b>Adresse aus Datenbank Tabelle Adresse</b>
     * <br><b>chain:Key adressId,adressArt,userId</b>
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
    public static synchronized Adresse chain(Database dbConn,int adressId,String adressArt, String userId) throws Exception {
    	/* Verwendung:	DokumentToReportServlet */
    	/* 			  	SelinasSession.getAdressOfDatabase*/
    	/*              SelinasSession.getAdressOfUpdate*/
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".adressen " +
        		"where adressId = "+ adressId + " and adressArt = '"+adressArt+"' and userId = '"+userId+"'");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Adresse((Vector)rows.elementAt(0));
    }//chain
    
    /**
     * <b>Adresse aus Datenbank Tabelle Adresse</b>
     * <br><b>chain:Key adressId,adressArt</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn	</li>
     * <li>int adressId	(adressId = objektId 04711)</li>
     * <li>String adressArt (adressArt = (I)mmobilie)</li>
     * </ul>
     * @return
     * <ul><li> Adresse ImmobilienAdresse</li></ul>
     */
    public static synchronized Adresse chain(Database dbConn,int adressId,String adressArt) throws Exception {
    	/* Verwendung:	Kontruktor Immobilie */
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
    public static synchronized Vector readeOfKundenId(Database dbConn, int adressId) throws Exception {
    	/*Verwendung: AdressDataTag -> Anzeige aller Adressen zum User */
        Vector allAdressen = new Vector();
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".adressen " +
        		"where adressId = "+adressId + 
				" ORDER BY "+valueOf("U")+"");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        for(int i = 0;i < rows.size();i++) {
        	allAdressen.addElement(new Adresse((Vector) rows.elementAt(i)));
        }//for
        return allAdressen;
    }//read
    
    public static synchronized Vector readeOfKundenId(Database dbConn, int adressId,String orderBy) throws Exception {
    	/*Verwendung: selinas020FATag -> Anzeigen aller Adressen zum User */
        Vector allAdressen = new Vector();
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".adressen " +
        		"where adressId = "+adressId +
        		" ORDER BY "+valueOf(orderBy)+"");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        for(int i = 0;i < rows.size();i++) {
        	allAdressen.addElement(new Adresse((Vector) rows.elementAt(i)));
        }//for
        return allAdressen;
    }//read 
    public static synchronized void update(Database dbConn, User user, Adresse adress) throws Exception {
    	/*Verwendung:	SelinasSession.getAdressOfDatabase*/
        dbConn.executeUpdate("update "+dbConn.getDbSchema()+".adressen " +
                "set strasse = '"+ adress.getStrasse() + "'," +
                " nummer = '"+ adress.getNummer() + "'," + " plz = '"+ adress.getPlz() +"',"+
                " ort = '"+ adress.getOrt() +"'," +
                " land = '" + adress.getLand()+ "'," +
				" telefon = '"+ adress.getTelefon()  +"',"+
                " fax = '"+ adress.getFax() +"'," + " mail = '"+ adress.getMail() +"',"+
                " changeUser = '"+user.getUserId()+"'," + " changeDate = now() " +
                " where adressId = "+ user.getKundenId() + " and adressArt = '"+ adress.getAdressArt()+"' and userId = '"+adress.getUserId()+"'");
    }//update
    
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
				"'"+adresse.getUserId()+"'," +
		        "'" + adresse.getStrasse() + "'," + "'" + adresse.getNummer() + "'," +
		        "'" + adresse.getPlz() + "'," + "'" + adresse.getOrt() + "'," +
				"'" + adresse.getLand()+ "'," +
		        "'" + adresse.getTelefon() + "'," + "'" + adresse.getFax() + "'," +
				"'" + adresse.getMail() + "'," + 
				"'"+user.getUserId()+"'," + "now()," + "'"+user.getUserId()+"'," + "now())");
	}//insert
    
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
    
}//class DataSetAdresse
