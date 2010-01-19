package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.Selectbox;
import database.dateien.User;

public class DataSetSelectbox {
    
    /**
     * <b>Selectbox aus Datenbank Tabelle selectbox</b>
     * <br><b>chain:Key User user, String nameOfSelectbox,String optionId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>User.kundenId = 1 Kundennummer</li>
     * <li>User.standortId = 1 Standort</li>
     * <li>String nameOfSelectbox = Formular</li>
     * <li>String keyOption = KA</li>
     * </ul>
     *	@return
     * <ul><li><SELECT name="Formular">
     * <option value='KA'>[Bitte auswählen]</option><option value='AA'>Arbeitsanweisung</option>
     * <option value='FO'>Forumular</option><option value='KO'>Konzept</option>
     * <option value='LB'>Leitbild</option><option value='ORG'>Organigramm</option>
     * <option value='QMH'>QM Handbuch</option><option value='VA'>Verfahrensanweisung</option></select>
     * </li></ul>
     */
    public static synchronized Selectbox chain(Database dbConn,int kundenId, 
    	int standortId, String nameOfSelectbox,
			String sprachId,String keyOption) throws Exception {
    	
    	Vector rows = null;
    	if(sprachId.equalsIgnoreCase("KA")){
    		rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".selectbox " +
        	        "where kundenId = "+kundenId +
        			" and standortId = "+standortId +
        			" and sprachId = 'KA'" +
        			" and selectbox = '"+nameOfSelectbox+"'");
    	} else {
    		rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".selectbox " +
            	        "where kundenId = "+kundenId +
            			" and standortId = "+standortId +
            			" and sprachId = '"+sprachId+"'" +
            			" and selectbox = '"+nameOfSelectbox+"'");
    	}//endif
       return new Selectbox(dbConn,(Vector)rows.elementAt(0),keyOption);
    }//chain
    
    public static synchronized Selectbox chain(Database dbConn,int kundenId, 
        	int standortId, String nameOfSelectbox, String sprachId) throws Exception {
    	/* Verwendung: LogOnSelinaInializeServlet() */
    	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".selectbox " +
    	        "where kundenId = "+kundenId +
    			" and standortId = "+standortId +
    			" and sprachId = '"+sprachId+"'" +
    			" and selectbox = '"+nameOfSelectbox+"'");
        	 if(rows.size() == 0)
        	    throw new Exception("Record not Found");
        	 return new Selectbox(dbConn,(Vector)rows.elementAt(0),sprachId);
        }//chain
    
    public static synchronized void insert(Database dbConn,User user, 
    		String nameOfSelectbox, String sprachId ) throws Exception {
    		/* Verwendung: LogOnSelinaInializeServlet() */
    		dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectbox " +
    				"values("+user.getKundenId()+"," +user.getStandortId()+"," +
    				"'"+nameOfSelectbox+"','"+sprachId+"'," +
    				"'"+user.getUserId()+"'," +
    				"now()," + "'"+user.getUserId()+"'," + "now())");
        }//insert
        
}//class Selectbox

