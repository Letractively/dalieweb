/*
 * Created of DV0101 on 01.05.2009 15:39:04
 *
 * Filename	  DataSetDokument.java
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
 * @version 	1.00 01.05.2009 um 15:39:04
 * @author 		DV0101
 * @see 		Dokument
 * <br><br>
 * public    = "false" sichtbar ausserhalb<br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 */
public class DataSetDokument {
	
	
	 /** oderByTypOf_0 = Table dokument by*/
	public static final String orderByTypOf_0 = "kundenId, standortId, typ, gliederung";
	/** oderByTypOf_1 = Table dokument by*/
	public static final String orderByTypOf_1 = "kundenId, standortId, titel";
	/** oderByTypOf_2 = Table dokument by*/
	public static final String orderByTypOf_2 = "kundenId, standortId, descripten";
	/** oderByTypOf_3 = Table dokument by*/
	public static final String orderByTypOf_3 = "kundenId, standortId, createDate desc";
	/** oderByTypOf_4 = Table dokument by*/
	public static final String orderByTypOf_4 = "kundenId, standortId, changeDate desc";
	/** oderByTypOf_5 = Table dokument by*/
	public static final String orderByTypOf_5 = "kundenId, standortId, gliederung";
	/** oderByTypOf_6 = Table dokument by*/
	public static final String orderByTypOf_6 = "kundenId, standortId, nummer, id";
	/** oderByTypOf_7 = Table dokument by*/
	public static final String orderByTypOf_7 = "kundenId, standortId, typ, nummer, id";
	/** oderByTypOf_6 = Table dokument by*/
	public static final String orderByTypOf_8 = "kundenId, standortId, nummer, id desc";
	 /** oderByTypOf_0 = Table dokument by*/
	public static final String orderByTypOf_9 = "kundenId, standortId, typ, gliederung desc";
	/** oderByTypOf_1 = Table dokument by*/
	public static final String orderByTypOf_10 = "kundenId, standortId, titel desc";
	/** oderByTypOf_2 = Table dokument by*/
	public static final String orderByTypOf_11 = "kundenId, standortId, descripten desc";
	/** oderByTypOf_5 = Table dokument by*/
	public static final String orderByTypOf_12 = "kundenId, standortId, gliederung desc";
	/** oderByTypOf_3 = Table dokument by*/
	public static final String orderByTypOf_13 = "kundenId, standortId, createDate";
	/** oderByTypOf_4 = Table dokument by*/
	public static final String orderByTypOf_14 = "kundenId, standortId, changeDate";
	/** oderByTypOf_7 = Table dokument by*/
	public static final String orderByTypOf_15 = "kundenId, standortId, typ, nummer, id desc";
	
	private static Hashtable memberTable = init();
	private static Hashtable init() {
        Hashtable members = new Hashtable();
        members.put("G",orderByTypOf_0);//order by gliederung
        members.put("T",orderByTypOf_1);//order by titel
        members.put("D",orderByTypOf_2);//order by descripten
        members.put("CREATEDATE",orderByTypOf_3);//order by createDate
        members.put("CHANGEDATE",orderByTypOf_4);//order by changeDate
        members.put("OG",orderByTypOf_5);//order by only by gliederung
        members.put("N",orderByTypOf_6);//order by only dokumentNr
        members.put("TNI",orderByTypOf_7);//order by only dokumentTyp,Nummer,Id
        members.put("ND",orderByTypOf_8);//order by only dokumentNr desc
        members.put("GD",orderByTypOf_9);//order by gliederung desc
        members.put("TD",orderByTypOf_10);//order by titel desc
        members.put("DD",orderByTypOf_11);//order by descripten desc
        members.put("OGD",orderByTypOf_12);//order by only by gliederung desc
        members.put("CREATEDATED",orderByTypOf_13);//order by createDate
        members.put("CHANGEDATED",orderByTypOf_14);//order by changeDate
        members.put("TNID",orderByTypOf_15);//order by only dokumentTyp,Nummer,Id desc
        return members;
    }//init

    /**
     * <b>Dokument aus Datenbank Tabelle Dokument</b>
     * <br><b>chain:Key user.getKundenId, user.getStandortId, int dokumentNr, dokumentId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>User user	</li>
     * 		<li>int dokumentNr</li>
     * 		<li>int dokumentId</li></ul>
     * @return
     * <ul><li>Dokument dokument</li></ul>
     */
    public static synchronized Dokument chain(Database dbConn,User user,String typ,int nr,int id) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
        		"where kundenId = "+user.getKundenId() + " and standortId = "+user.getStandortId() +
        			" and typ = '"+typ+"'" + " and nummer = "+nr +
        			" and id = "+id+"");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Dokument((Vector)rows.elementAt(0));
    }//chain
    /**
     * <b>Dokument aus Datenbank Tabelle Dokument</b>
     * <br><b>chain:Key user.getKundenId, user.getStandortId, int dokumentNr, dokumentId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	<li>Database dbConn	</li>
     * 		<li>User user	</li>
     * 		<li>int dokumentNr</li>
     * 		<li>int dokumentId</li></ul>
     * @return
     * <ul><li>Dokument dokument</li></ul>
     */
    public static synchronized Dokument chain(Database dbConn,User user,Dokument dokument) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
        		"where kundenId = "+user.getKundenId() + " and standortId = "+user.getStandortId() +
        			" and typ = '"+dokument.getTyp()+"'" + " and nummer = "+ dokument.getNummer() +
        			" and id = "+dokument.getId()+"");
        if(rows.size() == 0)
    	    throw new Exception("Record not Found");
        return new Dokument((Vector)rows.elementAt(0));
    }//chain
    
    public static synchronized Dokument chain(Database dbConn, User user, String typ) throws Exception{
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId() + 
				" and typ = '"+ typ +"'");
		if(rows.size() == 0)
    	    throw new Exception("Record not Found");
		 return new Dokument((Vector)rows.elementAt(0));
	}//chain
    
    /**
     * <b>alle Dokument(e) aus Datenbank Tabelle Dokument</b>
     * <br><b>reade:Key User.getKundenId, User.getStandortId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn	</li>
     * <li>User user	</li>
     * </ul>
     * @return
     * <ul><li> Vector Dokument(e)</li></ul>
     */
    public static synchronized Vector reade(Database dbConn, User user) throws Exception {
    	/* Verwendung: ohne */
		Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId() +
				" ORDER BY kundenId, standortId, typ, nummerr, id");
		if(rows.size() == 0)
    	    throw new Exception("Record not Found");
		for (int i = 0; i < rows.size(); i++){
			liste.addElement(new Dokument((Vector) rows.elementAt(i)));
		}//for
		return liste;
	}//query	
    /**
     * <b>alle Dokument(e) aus Datenbank Tabelle Dokument</b>
     * <br><b>reade:Key User.getKundenId, User.getStandortId</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn	</li>
     * <li>User user	</li>
     * </ul>
     * @return
     * <ul><li> Vector Dokument(e)</li></ul>
     */
    public static synchronized Vector readeO(Database dbConn, User user,String orderBy) throws Exception{
    	/* Verwendung DokumentDataTag -> JSP:SELINAS002.jsp Anzeige aller Dokumente  */
		Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId()+
				" and createUser = '"+user.getUserId()+"' or "  +
				" kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId()+
				" and createUser <> '"+user.getUserId()+"'" +
				" and status <= "+user.getUserAutorisierungsId()+" and status <> 'P'" +
				" ORDER BY "+valueOf(orderBy)+"");
		if(rows.size() == 0)
    	    throw new Exception("Record not Found");
		for (int i = 0; i < rows.size(); i++){
			liste.addElement(new Dokument((Vector) rows.elementAt(i)));
		}//for
		return liste;
	}//query	
    
    /**
     * <b>alle Dokument(e) aus Datenbank Tabelle Dokument</b>
     * <br>finde alle Dokumente zum DokumentTyp
     * <br><b>reade:Key User.getKundenId, User.getStandortId String dokumentTypKey</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn	</li>
     * <li>User user	</li>
     * </ul>
     * @return
     * <ul><li> Vector Dokument(e)</li></ul>
     */
    public static synchronized Vector reade1(Database dbConn, User user, String typ) throws Exception{
    	/* Verwendung DokumentNavTag -> lese alle Dokumente zum gefundenen DokumentTyp */
		Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId() + 
				" and typ = '"+ typ +"' and createUser = '"+user.getUserId()+"' or " +
				" kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId()+
				" and typ = '"+ typ +"' and createUser <> '"+user.getUserId()+ "'" +
				" and status <= "+user.getUserAutorisierungsId()+" and status <> 'P'" +
				" ORDER BY kundenId, standortId, typ, nummer, id");
		if(rows.size() == 0)
    	    throw new Exception("Record not Found");
		for (int i = 0; i < rows.size(); i++){
			liste.addElement(new Dokument((Vector) rows.elementAt(i)));
		}//for
		return liste;
	}//query	
    /**
     * <b>alle Dokument(e) aus Datenbank Tabelle Dokument</b>
     * <br>finde alle Dokumente zum DokumentTyp, lesen nach oderBy Key
     * <br><b>reade:Key User.getKundenId, User.getStandortId String dokumentTypKey</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn	</li>
     * <li>User user	</li>
     * </ul>
     * @return
     * <ul><li> Vector Dokument(e)</li></ul>
     */
    public static synchronized Vector reade(Database dbConn, User user, String typ,String orderBy) throws Exception{
    	/* Verwendung DokumentDataTag -> JSP:SELINAS002.jsp Anzeige aller Dokumente  */
    	/* 			  DokumentDataTag -> JSP:SELINAS002.jsp Anzeige aller Dokument nach Auswahl Dokumenttyp */
		Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId() + 
				" and typ = '"+ typ +"' and createUser = '"+user.getUserId()+"' or " +
				" kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId()+
				" and typ = '"+ typ +"' and createUser <> '"+user.getUserId()+ "'" +
				" and status <= "+user.getUserAutorisierungsId()+" and status <> 'P'" +
				" ORDER BY "+valueOf(orderBy)+"");
		if(rows.size() == 0)
    	    throw new Exception("Record not Found");
		for (int i = 0; i < rows.size(); i++){
			liste.addElement(new Dokument((Vector) rows.elementAt(i)));
		}//for
		return liste;
	}//query	
    /**
     * <b>alle Dokument(e) aus Datenbank Tabelle Dokument</b>
     * <br>finde alle Dokumente zum DokumentTyp, lesen nach oderBy Key
     * <br><b>reade:Key User.getKundenId, User.getStandortId String dokumentTypKey</b>
     * <br><b>public static</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn	</li>
     * <li>User user	</li>
     * </ul>
     * @return
     * <ul><li> Vector Dokument(e)</li></ul>
     */
    public static synchronized Vector reade(Database dbConn, User user, String typ,int nr,String orderBy) throws Exception {
    	/* Verwendung: DokumentTypTag -> zeige alle Dokumente zum DokumentTyp */
		Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId() + 
				" and typ = '"+ typ +"' and nummer = " + nr + " and createUser = '"+user.getUserId()+"' or " +
				" kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId()+
				" and typ = '"+ typ +"' and nummer = " + nr + " and createUser <> '"+user.getUserId()+"'" +
				" and status <= "+user.getUserAutorisierungsId()+ " and status <> 'P'" +
				" ORDER BY "+valueOf(orderBy)+"");
		if(rows.size() == 0)
    	    throw new Exception("Record not Found");
		for (int i = 0; i < rows.size(); i++){
			liste.addElement(new Dokument((Vector) rows.elementAt(i)));
		}//for
		return liste;
	}//query	
    /**
     * <b>insert Dokument on Datenbank </b>
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
    public static synchronized void insert(Database dbConn, User user, Dokument dokument) throws Exception {
    	/* Verwendung: Selinas.session.getDokumentOfInitialize() */
		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".dokument " +
				"values("+user.getKundenId()+"," +user.getStandortId()+"," +
				"'"+dokument.getTyp()+"'," +dokument.getNummer()+","
				+ getNextdokumentId(dbConn,user, dokument)+"," +
				"'"+dokument.getStatus()+"'," + "'"+dokument.getTitel()+"'," +
				"'"+dokument.getDescripten()+"'," + "'"+dokument.getContent()+"'," +
				"'"+dokument.getGliederung()+"'," + "'"+dokument.getArchiv()+"'," +
				"date_add(now(),interval 1 YEAR)," + "'"+dokument.getVorgabe()+"'," +
				"'"+dokument.getSprachId()+"'," + "'"+user.getUserId()+"'," +
				"now()," + "'"+user.getUserId()+"'," + "now())");
    }//insert
    
    public static synchronized void update(Database dbConn, User user, Dokument dokument) throws Exception {    	
        dbConn.executeUpdate("update "+dbConn.getDbSchema()+".dokument " +
                "set status = '"+ dokument.getStatus() + "'," +
                " titel = '"+dokument.getTitel()+"'," + " descripten = '"+dokument.getDescripten()+"',"+
                " content = '"+dokument.getContent()+"'," + " gliederung = '"+dokument.getGliederung()+"',"+
                " archiv = '"+dokument.getArchiv()+"'," + " vorgabe = '"+dokument.getVorgabe()+"',"+
                " changeUser = '"+user.getUserId()+"'," + " changeDate = now() " +
                " where kundenId = "+ user.getKundenId() + " and standortId = "+user.getStandortId()+
                " and typ = '"+dokument.getTyp() + "'" + " and nummer = "+dokument.getNummer() +
                " and id = "+ dokument.getId() );
    }//update
    
    /**
     * <b>delete Dokument on Datenbank </b>
     * <br><b>delete:Key kundenId, standortId, dokumenttyp, dokumentNr, dokumentId </b>
     * <br><b>public</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn</li>
     * <li>String kundenId</li>
     * <li>String standortId</li>
     * <li>String dokumentTyp</li>
     * <li>String dokumentNr</li>
     * <li>String dokunetId</li>
     * </ul>
     * @return
     * <ul><li>none</li></ul>
     */
    public static synchronized void delete(Database dbConn,int kundenId, int standortId,String typ,int nr, int id) throws Exception {
        dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".dokument" +
                " where nummer = " + nr + " and id = " + id +
                " and typ = '"+ typ + "'" + " and standortId = " + standortId +
                " and kundenId = " + kundenId);
    }//delete
    /**
     * <b>delete Dokument on Datenbank </b>
     * <br><b>delete:Key User, Dokument </b>
     * <br><b>public</b><br>
     * @param
     * <ul>	
     * <li>Database dbConn</li>
     * <li>User user</li>
     * <li>Dokument dokument</li>
     * </ul>
     * @return
     * <ul><li>none</li></ul>
     */
    public static synchronized void delete(Database dbConn,Dokument dokument) throws Exception {
        dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".dokument" +
        		 " where kundenId = "+ dokument.getKundenId() + " and standortId = "+dokument.getStandortId()+
	             " and typ = '"+dokument.getTyp() + "'" + " and nummer = "+dokument.getNummer() +
	             " and id = "+ dokument.getId() );
    }//delete
    
    
    /**
     * @return Returns the nextdokumentId.
     */
    public static synchronized int getNextdokumentId(Database dbConn, User user, Dokument dokument) throws Exception {
        int id = 0;
        while(true) {
        Vector rows = dbConn.executeQuery("select * from "
                + dbConn.getDbSchema() + ".dokument " + " where kundenId = "
                + user.getKundenId() + " and standortId = " + user.getStandortId() + ""
                + " and typ = '" + dokument.getTyp() + "'" + " and nummer = " + dokument.getNummer()
                + " and id = " + ++id);
        if(rows.size() == 0)
            break;
        }//while
        return id;
    }//getNextdokumentId
    
    /**
     * @return Returns the nextdokumentId.
     */
    public static synchronized int getBackdokument(Database dbConn, User user, Dokument dokument) throws Exception {
        int id = dokument.getId();
        while(true) {   
        Vector rows = dbConn.executeQuery("select * from "
                + dbConn.getDbSchema() + ".dokument " + " where kundenId = "
                + user.getKundenId() + " and standortId = " + user.getStandortId() + ""
                + " and typ = '" + dokument.getTyp() + "'" + " and nummer = " + dokument.getNummer()
                + " and id = " + --id);
        if(rows.size() == 1)//satz gefunden
        	break;
        if(id == 0){//kleinster Satz
        	id++;
        	break;
        }
        }//while
        return id;
    }//getNextdokumentId
    
    public static synchronized Dokument foundBackDokument(Database dbConn, User user,Dokument dokument,String orderBy) throws Exception{
    	/* Verwendung SelinasSession.getBackDokumentOfDatabase -> selinas003.jsp Anzeige der ausgewählten Dokumente << backward  */
    	Dokument nextDokument = null;
		Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+dokument.getKundenId()+ " and standortId = "+dokument.getStandortId() +
				" and typ = '"+dokument.getTyp()+"' and nummer = "+dokument.getNummer()+" and id < "+dokument.getId() +
				" and createUser = '"+user.getUserId()+"' or "  +
				" kundenId = "+dokument.getKundenId()+ " and standortId = "+dokument.getStandortId() +
				" and typ = '"+dokument.getTyp()+"' and nummer = "+dokument.getNummer()+" and id < "+dokument.getId() +
				" and createUser <> '"+user.getUserId()+"'" +
				" and status <= "+user.getUserAutorisierungsId()+" and status <> 'P'" +
				" ORDER BY "+valueOf(orderBy)+"");
		if(rows.size() == 0)
    	    return dokument;
		for (int i = 0; i < rows.size(); i++){
			nextDokument = new Dokument((Vector) rows.elementAt(i));
			if(nextDokument.getUserckeck(user))
				return nextDokument;
		}//for
		return dokument;
	}//foundNextDokument	
    
    
    /**
     * @return Returns the nextdokumentId.
     */
    public static synchronized int getNextdokument(Database dbConn, User user, Dokument dokument) throws Exception {
    	/* Verwendung SelinasSession.getNextDokumentOfDatabase1 -> selinas003.jsp Anzeige der ausgewählten Dokumente << backward  */
        int id = dokument.getId();
        Vector anzahl = dbConn.executeQuery("select * from "
                + dbConn.getDbSchema() + ".dokument " + " where kundenId = "
                + user.getKundenId() + " and standortId = " + user.getStandortId() + ""
                + " and typ = '" + dokument.getTyp() + "'" + " and nummer = " + dokument.getNummer());
        while(true) {   
        Vector rows = dbConn.executeQuery("select * from "
                + dbConn.getDbSchema() + ".dokument " + " where kundenId = "
                + user.getKundenId() + " and standortId = " + user.getStandortId() + ""
                + " and typ = '" + dokument.getTyp() + "'" + " and nummer = " + dokument.getNummer()
                + " and id = " + ++id);
        if(rows.size() == 1)//satz gefunden
        	break;
        if(id > anzahl.size()){//id ist größer als alle gefunden Sätze
        	id--;
        	break;
        }//endif
        }//while
        return id;
    }//getNextdokumentId
    
    public static synchronized Dokument foundNextDokument(Database dbConn, User user,Dokument dokument,String orderBy) throws Exception{
    	/* Verwendung SelinasSession.getNextDokumentOfDatabase -> selinas003.jsp Anzeige der ausgewählten Dokumente >> forward  */
    	Dokument nextDokument = null;
		Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+dokument.getKundenId()+ " and standortId = "+dokument.getStandortId() +
				" and typ = '"+dokument.getTyp()+"' and nummer = "+dokument.getNummer()+" and id > "+dokument.getId() +
				" and createUser = '"+user.getUserId()+"' or "  +
				" kundenId = "+dokument.getKundenId()+ " and standortId = "+dokument.getStandortId() +
				" and typ = '"+dokument.getTyp()+"' and nummer = "+dokument.getNummer()+" and id > "+dokument.getId() +
				" and createUser <> '"+user.getUserId()+"'" +
				" and status <= "+user.getUserAutorisierungsId()+" and status <> 'P'" +
				" ORDER BY "+valueOf(orderBy)+"");
		if(rows.size() == 0)
    	    return dokument;
		for (int i = 0; i < rows.size(); i++){
			nextDokument = new Dokument((Vector) rows.elementAt(i));
			if(nextDokument.getUserckeck(user))
				return nextDokument;
		}//for
		return dokument;
	}//foundNextDokument	
    
    
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
    
}//class DataSetDokument
