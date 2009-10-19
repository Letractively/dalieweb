/*
 * Created of DV0101 on 01.05.2009 20:45:32
 *
 * Filename	  DataSetLink.java
 */
package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.Dokument;
import database.dateien.Link;
import database.dateien.User;

/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 20:45:32
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class DataSetLink {

    /**
     * <b>get DokumentLinks of Database Table dokumentlink</b>
     * <br><b>read:Key String dokumentTyp,int dokumentNr , int dokumentId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>int dokumentTyp = 'AA'</li>
     * <li>int dokumentNr = 1</li>
     * <li>int dokumentId = 1</li>
     * </ul>
     * @return
     * <ul>
     * <li>Vector of DokumentLinks</li>
     * </ul>
     */
    public static synchronized Vector read(Database dbConn,int kundenId,int standortId,String dokumentTyp,int dokumentNr,int dokumentId) throws Exception {
        Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumentlinks " +
				"where kundenId = " + kundenId + " and standortId = " + standortId +
				" and dokumentTyp = '"+ dokumentTyp+ "'" + " and dokumentNr = "+ dokumentNr + " and dokumentId = "+ dokumentId + 
				" ORDER BY dokumentTyp, dokumentNr, dokumentId, pfadOfLink");
		if(rows.size() == 0)
    	    throw new Exception("Record not Found");
		for (int i = 0; i < rows.size(); i++){
			liste.addElement(new Link((Vector) rows.elementAt(i)));
		}//for
		return liste;
    }//read
    
    /**
     * <b>get DokumentLinks of Database Table dokumentlink</b>
     * <br><b>read:Key String dokumentTyp,int dokumentNr , int dokumentId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>int dokumentTyp = 'AA'</li>
     * <li>int dokumentNr = 1</li>
     * <li>int dokumentId = 1</li>
     * </ul>
     * @return
     * <ul>
     * <li>Vector of DokumentLinks</li>
     * </ul>
     */
    public static synchronized Vector read(Database dbConn,Dokument dokument) throws Exception {
        Vector liste = new Vector();
		Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".dokumentlinks " +
				"where kundenId = " + dokument.getKundenId() + " and standortId = " + dokument.getStandortId() +
				" and dokumentTyp = '"+ dokument.getDokumentTyp()+ "'" + " and dokumentNr = "+ dokument.getNummer() + " and dokumentId = "+ dokument.getId() + 
				" ORDER BY dokumentTyp, dokumentNr, dokumentId, pfadOfLink");
		if(rows.size() == 0)
    	    throw new Exception("Record not Found");
		for (int i = 0; i < rows.size(); i++){
			liste.addElement(new Link((Vector) rows.elementAt(i)));
		}//for
		return liste;
    }//read
    
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
    public static synchronized void insert(Database dbConn, Dokument dokument,Link link ,User user) throws Exception{
        dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".dokumentlinks " +
                "values(" + dokument.getKundenId()+ "," + dokument.getStandortId()+ "," +
                "'"+dokument.getDokumentTyp()+"'," + dokument.getNummer()+ "," + dokument.getId()+ "," +
                "'"+link.getPfadOfLink()+"'," + "'"+link.getNameOfLink()+"'," +
                "'"+link.getContentType()+"'," + link.getSizeInBytes()+"," +
                "'"+user.getUserId()+"'," + "now()," + "'"+user.getUserId()+"'," + "now())");
    }//insert
    
}//class DataSetLink
