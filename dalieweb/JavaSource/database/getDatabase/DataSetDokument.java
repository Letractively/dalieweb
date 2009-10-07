/*
 * Created of DV0101 on 01.05.2009 15:39:04
 *
 * Filename	  DataSetDokument.java
 */
package database.getDatabase;

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
    public static Dokument chain(Database dbConn,User user,String dokumentTyp,int dokumentNr,int dokumentId) throws Exception {
        Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
        		"where kundenId = "+user.getKundenId() + " and standortId = "+user.getStandortId() +
        			" and dokumentTyp = '"+dokumentTyp+"'" + " and dokumentNr = "+dokumentNr +
        			" and dokumentId = "+dokumentId+"");
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
    public static Vector reade(Database dbConn, User user) throws Exception{
		Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId() +
				" ORDER BY kundenId, standortId, dokumentTyp, dokumentNr, dokumentId");
		if(rows.size() == 0)
    	    throw new Exception("Record not Found");
		for (int i = 0; i < rows.size(); i++){
			liste.addElement(new Dokument((Vector) rows.elementAt(i)));
		}//for
		return liste;
	}//query	
    /**
     * <b>alle Dokument(e) aus Datenbank Tabelle Dokument</b>
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
    public static Vector reade(Database dbConn, User user, String dokumentTyp) throws Exception{
		Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokument " +
				"where kundenId = "+user.getKundenId()+ " and standortId = "+user.getStandortId() + 
				" and dokumentTyp = '"+ dokumentTyp +"'" +
				" ORDER BY kundenId, standortId, dokumentTyp, dokumentNr, dokumentId");
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
    public static void insert(Database dbConn, User user, Dokument dokument) throws Exception{
		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".dokument " +
				"values("+user.getKundenId()+"," +user.getStandortId()+"," +
				"'"+dokument.getDokumentTyp()+"'," +dokument.getNummer()+","
				+ getNextdokumentId(dbConn,user, dokument)+"," +
				"'"+dokument.getStatus()+"'," + "'"+dokument.getTitel()+"'," +
				"'"+dokument.getDescripten()+"'," + "'"+dokument.getContent()+"'," +
				"'"+dokument.getGliederung()+"'," + "'"+dokument.getArchiv()+"'," +
				"date_add(now(),interval 1 YEAR)," + "'"+dokument.getVorgabe()+"'," +
				"'"+dokument.getSprachId()+"'," + "'"+user.getUserId()+"'," +
				"now()," + "'"+user.getUserId()+"'," + "now())");
    }//insert
    
    public void update(Database dbConn, User user, Dokument dokument) throws Exception {
        dbConn.executeUpdate("update "+dbConn.getDbSchema()+".dokument" +
                "set dokumentStatus = '"+ dokument.getStatus() + "'," +
                " titel = '"+dokument.getTitel()+"'," + " descripten = '"+dokument.getDescripten()+"',"+
                " content = '"+dokument.getContent()+"'," + " gliederung = '"+dokument.getGliederung()+"',"+
                " archiv = '"+dokument.getArchiv()+"'," + " vorgabe = '"+dokument.getVorgabe()+"',"+
                " changeUser = '"+user.getUserId()+"'," + " changeDate = now() " +
                " where kundenId = "+ user.getKundenId() + " and standortId = "+user.getStandortId()+
                " and dokumentTyp = '"+dokument.getDokumentTyp() + "'" + " and dokumentNr = "+dokument.getNummer() +
                " and dokumentId = "+ dokument.getId() );
    }//update
    
    public void delete(Database dbConn,int kundenId, int standortId,String dokumentTyp,int dokumentNr, int dokumentId) throws Exception {
        dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".dokument " +
                "where dokumentNr = " + dokumentNr + " and dokumentId = " + dokumentId +
                " and dokumentTyp = '"+ dokumentTyp + "'" + " and standortId = " + standortId +
                " and kundenId = " + kundenId);
    }//delete
    
    /**
     * @return Returns the nextdokumentId.
     */
    public static int getNextdokumentId(Database dbConn, User user, Dokument dokument) throws Exception {
        int id = 0;
        while(true) {
        Vector rows = dbConn.executeQuery("select * from "
                + dbConn.getDbSchema() + ".dokument " + " where kundenId = "
                + user.getKundenId() + " and standortId = " + user.getStandortId() + ""
                + " and dokumentTyp = '" + dokument.getDokumentTyp() + "'" + " and dokumentNr = " + dokument.getNummer()
                + " and dokumentId = " + ++id);
        if(rows.size() == 0)
            break;
        }//while
        return id;
    }//getNextdokumentId
    
}//class DataSetDokument
