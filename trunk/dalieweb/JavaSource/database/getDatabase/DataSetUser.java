/*
 * Created of DV0101 on 01.05.2009 18:49:34
 *
 * Filename	  DataSetUser.java
 */
package database.getDatabase;

import java.util.Hashtable;
import java.util.Vector;

import database.Database;
import database.dateien.Dokument;
import database.dateien.User;

/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 18:49:34
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetUser {

	/** oderByTypOf_0 = Table user order by userId*/
	public static final String orderByTypOf_0 = "userId";
	/** oderByTypOf_0d = Table user order by userId desc*/
	public static final String orderByTypOf_0d = "userId desc";
	/** oderByTypOf_1 = Table user order by CreateDate desc*/
	public static final String orderByTypOf_1 = "createDate desc";
	/** oderByTypOf_1d = Table user order by CreateDate */
	public static final String orderByTypOf_1d = "createDate";
	/** oderByTypOf_2 = Table user order by ChangeDate desc */
	public static final String orderByTypOf_2 = "changeDate desc";
	/** oderByTypOf_2d = Tabl user oder by ChangeDate by*/
	public static final String orderByTypOf_2d = "changeDate";
	/** oderByTypOf_3 = Table user order by name, vorname */
	public static final String orderByTypOf_3 = "name, vorname";
	/** oderByTypOf_3d = Tabl user oder by ChangeDate by*/
	public static final String orderByTypOf_3d = "name desc, vorname";
	
	private static Hashtable memberTable = init();
	private static Hashtable init() {
        Hashtable members = new Hashtable();
        members.put("U",orderByTypOf_0);//order by UserID 
        members.put("UD",orderByTypOf_0d);//order by UserId desc
        members.put("CREATEDATE",orderByTypOf_1);//order by ErstellTag desc
        members.put("CREATEDATED",orderByTypOf_1d);//order by ErstellTag
        members.put("CHANGEDATE",orderByTypOf_2);//order by ChangeDate desc
        members.put("CHANGEDATED",orderByTypOf_2d);//order by ChangeDate
        members.put("N",orderByTypOf_3);//order by Name,Vorname 
        members.put("ND",orderByTypOf_3d);//order by Name,Vorname desc
        return members;
    }//init
	
    /**
     * <b>User aus Datenbank Tabelle user</b>
     * <br><b>chain:Key userId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String userId = DV0101 AnmeldeKennnung am System</li>
     * </ul>
     * @return
     * <ul><li>User user</li></ul>
     */
    public static synchronized User chain(Database dbConn,String userId) throws Exception {
    	/* Verwendung: LogOnSelina -> Login on Selina */
        	User user = null;
        	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".user " +
        			"where userId = '"+userId+"'");
        	if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	for (int i = 0; i < rows.size(); i++){
        	    return new User((Vector)rows.elementAt(i));
        	}//for
        	return user;
    }//chain 
    
    /**
     * <b>User aus Datenbank Tabelle user</b>
     * <br>finde alle User die zum User geh�ren
     * <br><b>reade:Key User.kundenId,User.standortId,String orderBy</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>int kundenId = 1</li>
     * <li>int standortId = 1</li>
     * <li>String oderBy = B</li>
     * </ul>
     * @return
     * <ul>
     * <li>Vector of User</li>
     * </ul>
     */
    public static synchronized Vector reade(Database dbConn,User user,String oderBy) throws Exception {
    	/* Verwendung:	selinas030FUTag -> Frame zur Anzeige aller User */
    	Vector liste = new Vector();
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".user " +
                "where kundenId = " + user.getKundenId() +
        		" and standortId = " + user.getStandortId() +
				" and userAutorisierungsId <= " + user.getUserAutorisierungsId() +
				" ORDER BY "+valueOf(oderBy)+"");
        if(rows.size() == 0)
            throw new Exception("Record not Found");
        for (int i = 0; i < rows.size(); i++){
    		liste.addElement(new User((Vector) rows.elementAt(i)));
    	}//for
    	return liste;        
    }//reade
    
    /**
     * <b>User aus Datenbank Tabelle user</b>
     * <br>finde alle aktiven User, die diese Dokument bearbeiten k�nnen.
     * <br><b>reade:Key Dokument.kundenId,Dokument.standortId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>Dokument dokument</li>
     * </ul>
     * @return
     * <ul>
     * <li>Vector of User</li>
     * </ul>
     */
    public static synchronized Vector reade(Database dbConn, Dokument dokument) throws Exception {
    	/* Verwendung:	PermitServlet -> finde alle aktiven User die diese Dokument bearbeiten k�nnen. */
    	Vector liste = new Vector();
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".user " +
                "where kundenId = " + dokument.getKundenId() +
        		" and standortId = " + dokument.getStandortId() +
				" and status = 'A'" +
				" and userAutorisierungsId >= " + dokument.getStatus());
				
        if(rows.size() == 0)
            throw new Exception("Record not Found");
        for (int i = 0; i < rows.size(); i++){
    		liste.addElement(new User((Vector) rows.elementAt(i)));
    	}//for
    	return liste;        
    }//reade
    
    /**
     * <b>insert User on Datenbank </b>
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
    public static synchronized void insert(Database dbConn, User user) throws Exception {
    	/* Verwendung: Selinas.session.getUserOfInitialize() */
		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".user " +
				"values('"+user.getUserId()+"','"+user.getUserStatus()+"'," +
				"'"+user.getPassword()+"','"+user.getName()+"'," + 
				"'"+user.getVorname()+"',now()," +
				user.getPermitId()+","+user.getUserAutorisierungsId() + "," +
				user.getKundenId()+","+user.getStandortId() + "," +
				"'"+user.getSprachId()+"',"+user.getSelinasId() + "," +
				user.getSelinasStandortId() + ",'"+user.getCreateUserId()+"'," +
				"now(),'"+user.getCreateUserId()+"',now())");
    }//insert
    
    public static synchronized void update(Database dbConn, User user, User ofUpdate) throws Exception {
        dbConn.executeUpdate("update "+dbConn.getDbSchema()+".user " +
                "set" +
				" status = '"+ ofUpdate.getUserStatus()+"'," +
				" password = '"+ofUpdate.getPassword()+"'," +
				" name = '"+ofUpdate.getName()+"'," +
				" vorname = '"+ofUpdate.getVorname()+"'," +
				//" geburtstag = '"+ofUpdate.getGeburtstag()+"'," +
				" berechtigungsId = "+ofUpdate.getPermitId()+"," +
				" userAutorisierungsId = '"+ofUpdate.getUserAutorisierungsId()+"'," +
                " changeUser = '"+ user.getUserId()+ "'," + " changeDate = now() " +
                " where kundenId = "+ user.getKundenId() + " and standortId = "+user.getStandortId() +
                " and userId = '"+ ofUpdate.getUserId()+"'");
    }//update
    
    /**
     * <b>User aus Datenbank Tabelle user</b>
     * <br>finde alle User die zum User geh�ren
     * <br><b>reade:Key User.kundenId,User.standortId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>int kundenId = 1</li>
     * <li>int standortId = 1</li>
     * </ul>
     * @return
     * <ul>
     * <li>User user</li>
     * </ul>
     */
    public static synchronized User determineLastUserId(Database dbConn,User user) throws Exception {
    	/* Verwendung:	SelinasSession.getUserOfInitialize -> create a new UserAccount */
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".user " +
                "where kundenId = " + user.getKundenId() +
        		" and standortId = " + user.getStandortId());
        if(rows.size() == 0)
            throw new Exception("Record not Found");
        return new User((Vector)rows.elementAt(rows.size()-1));      
    }//reade
    
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
    
}//class DataSetUser
