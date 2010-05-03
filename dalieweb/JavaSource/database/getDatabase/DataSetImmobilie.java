/*
 * Created of DV0101 on 09.02.2010 12:49:48
 *
 * Filename	  Immobilie.java
 */
package database.getDatabase;

import hausverwaltung.Immobilie;
import hausverwaltung.immobilien.Parkplatz;
import hausverwaltung.immobilien.Wohnung;

import java.util.Hashtable;
import java.util.Vector;

import database.Database;
import database.dateien.User;

/**
 * Class for SQL-Connection Table Immobilie.
 *
 * @version 	1.00 09.02.2010 um 12:49:48
 * @author 		DV0101
 * 
 * @see 		Immobilie
 */
public class DataSetImmobilie {
	
	/** oderByTypOf_0 = Table immobilie by*/
	public static final String orderByTypOf_0 = "kundenId, standortId";
	/** oderByTypOf_1 = Table immobilie by*/
	public static final String orderByTypOf_1 = "kundenId, standortId, objektId";
	/** oderByTypOf_2 = Table immobilie by*/
	public static final String orderByTypOf_2 = "kundenId, standortId, objektId desc";
	/** oderByTypOf_3 = Table immobilie by*/
	public static final String orderByTypOf_3 = "kundenId, standortId, createDate desc";
	/** oderByTypOf_4 = Table immobilie by*/
	public static final String orderByTypOf_4 = "kundenId, standortId, changeDate desc";
	/** oderByTypOf_3 = Table immobilie by*/
	public static final String orderByTypOf_5 = "kundenId, standortId, createDate";
	/** oderByTypOf_4 = Table immobilie by*/
	public static final String orderByTypOf_6 = "kundenId, standortId, changeDate";
	
	private static Hashtable memberTable = init();
	private static Hashtable init() {
        Hashtable members = new Hashtable();
        members.put("K",orderByTypOf_0);//order by kundenId, standortId
        members.put("O",orderByTypOf_1);//order by kundenId, standortId, objektId
        members.put("OD",orderByTypOf_2);//order by kundenId, standortId, objektId desc
        members.put("CREATEDATE",orderByTypOf_3);//order by createDate desc
        members.put("CHANGEDATE",orderByTypOf_4);//order by changeDate desc
        members.put("CREATEDATED",orderByTypOf_5);//order by createDate 
        members.put("CHANGEDATED",orderByTypOf_6);//order by changeDate
        return members;
    }//init
	
	 /**
     * <b>Immobilie aus Datenbank Tabelle Immobilie</b>
     * <br><b>chain:Key objketId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int objektId</li></ul>
     * @return
     * <ul><li>Immobilie immobilie</li></ul> 
     */
    public static synchronized Immobilie chain(Database dbConn,int kundenId,int standortId, int objektId) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".immobilie " +
        		"where kundenId = "+kundenId+" and standortId = "+standortId+" and objektId = "+ objektId +
				" ORDER BY kundenId,standortId,objektId");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Immobilie(dbConn,(Vector)rows.elementAt(0));
    }//chain
    /**
     * <b>Immobilie aus Datenbank Tabelle Immobilie</b>
     * <br><b>chain:Key kundenId,standortId,objketId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>Immobilie immobilie</li></ul>
     * @return
     * <ul><li>Immobilie immobilie</li></ul> 
     */
    public static synchronized Immobilie chain(Database dbConn,Immobilie immobilie) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".immobilie " +
        		"where kundenId = "+immobilie.getKundenId()+" and standortId = "+immobilie.getStandortId()+" and objektId = "+immobilie.getObjektId()+
				" ORDER BY kundenId,standortId,objektId");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Immobilie(dbConn,(Vector)rows.elementAt(0));
    }//chain
    
    /**
     * <b>Immobilie aus Datenbank Tabelle Immobilie</b>
     * <br><b>reade:Key kundenId,standortId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int kundenId</li>
     * 		<li>int standortId</li></ul>
     * @return
     * <ul><li>Vector allImmobilien</li></ul> 
     */
    public static synchronized Vector reade(Database dbConn,int kundenId,int standortId) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".immobilie " +
        	"where kundenId = "+ kundenId +" and standortId = "+ standortId +
        	" ORDER BY kundenId,standortId,objektId");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        Vector allImobilienOfKundenId = new Vector();
        for (int i = 0; i < rows.size(); i++){
        	allImobilienOfKundenId.addElement(new Immobilie(dbConn,(Vector) rows.elementAt(i)));
		}//for
        return allImobilienOfKundenId;
    }//reade
    /**
     * <b>Immobilie aus Datenbank Tabelle Immobilie</b>
     * <br><b>reade:Key kundenId,standortId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int kundenId</li>
     * 		<li>int standortId</li></ul>
     * @return
     * <ul><li>Vector allImmobilien</li></ul> 
     */
    public static synchronized Vector reade(Database dbConn,User user) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".immobilie " +
        	"where kundenId = "+ user.getKundenId() +" and standortId = "+ user.getSelinasStandortId() +
        	" ORDER BY kundenId,standortId,objektId");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        Vector allImobilienOfKundenId = new Vector();
        for (int i = 0; i < rows.size(); i++){
        	allImobilienOfKundenId.addElement(new Immobilie(dbConn,(Vector) rows.elementAt(i)));
		}//for
        return allImobilienOfKundenId;
    }//reade
    
    /**
     * <b>Immobilie aus Datenbank Tabelle Immobilie</b>
     * <br><b>reade:Key kundenId,standortId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>int kundenId</li>
     * 		<li>int standortId</li></ul>
     * @return
     * <ul><li>Vector allImmobilien</li></ul> 
     */
    public static synchronized Vector reade(Database dbConn,User user,String orderBy) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".immobilie " +
        	"where kundenId = "+ user.getKundenId() +" and standortId = "+ user.getSelinasStandortId() +
			" ORDER BY "+valueOf(orderBy)+"");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        Vector allImobilienOfKundenId = new Vector();
        for (int i = 0; i < rows.size(); i++){
        	allImobilienOfKundenId.addElement(new Immobilie(dbConn,(Vector) rows.elementAt(i)));
		}//for
        return allImobilienOfKundenId;
    }//reade
    
    /**
     * <b>insert Immobilie on Datenbank </b>
     * <br><b>insert:Key none</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn</li>
     * <li>User user</li>
     * <li>Immobilie immobilie</li>
     * </ul>
     * @return
     * <ul><li>none</li></ul>
     */
    public static synchronized void insert(Database dbConn, User user ,Immobilie immobilie) throws Exception {
    	/* Verwendung: */
		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".immobilie " +
				"values("+immobilie.getKundenId()+"," +immobilie.getStandortId()+"," +
				immobilie.getObjektId()+"," + "'"+user.getUserId()+"'," +
				"now()," + "'"+user.getUserId()+"'," + "now())");
		
		if(immobilie.getTyp().isWohnung())
			DataSetWohnung.insert(dbConn,user,(Wohnung)immobilie.getTyp());
		if(immobilie.getTyp().isParkplatz())
			DataSetParkplatz.insert(dbConn,user,(Parkplatz)immobilie.getTyp());
		
		DataSetAdresse.insert(dbConn, user, immobilie.getAdresse());
		DataSetEigentuemer.insert(dbConn,user,immobilie.getEigentuemer());
		
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
    
}//class DataSetImmobilie
