package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.SelectboxOptionen;
import database.dateien.User;

/**
 * @author DV0101
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DataSetSelectOptionen {
	
	/**
     * <b>SelectboxOptionen aus Datenbank Tabelle selectoptionen</b>
     * <br><b>chain:Key String nameOfSelectbox, String sprachId</b>
     * <br><br><b>public static</b><br>
     * @param
     * <ul>
     * <li>Database dbConn</li>
     * <li>String sprachId = DE</li>
     * <li>String nameofSelectbox = Formular </li>
     * </ul>
     * @return
     * <ul>
     * <li>Vector of SelectboxOptionen</li>
     * <li><option value='KA'>[Bitte auswählen]</option><option value='AA'>Arbeitsanweisung</option></li>
     * </ul>
     */
    public static synchronized Vector chain(Database dbConn,String nameOfSelectbox,String sprachId,String optionId) throws Exception {
        Vector allOptionen = new Vector();
        Vector first = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".selectoptionen " +
    	        "where selectbox = '"+nameOfSelectbox+"'" +
    	        " and sprachId = '"+sprachId+"'"+
    			" and optionId = '"+optionId+"'" +
				" and optionValue = '"+optionId+"'" +
    			" ORDER BY selectbox, sprachId, optionId, optionValue");
        for(int i = 0;i < first.size();i++) {
            allOptionen.addElement(new SelectboxOptionen((Vector) first.elementAt(i)));
        }//for
        	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".selectoptionen " +
        		"where selectbox = '"+nameOfSelectbox+"'" +
                " and sprachId = '"+sprachId+"'"+
        		" and optionId = '"+optionId+"'" +
				" and optionValue <> '"+optionId+"'" +
        		" ORDER BY selectbox, sprachId, optionId, optionValue");
        	for(int i = 0;i < rows.size();i++) {
                allOptionen.addElement(new SelectboxOptionen((Vector) rows.elementAt(i)));
        	}//for
        return allOptionen;
    }//chain
	
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
    public static synchronized void insert(Database dbConn,User user,String nameOfSelectbox,String sprachId,SelectboxOptionen option) throws Exception{
		/* Verwendung: SelinasSession.getTypOfInitialize */
    	dbConn.executeUpdate("insert into "+dbConn.getDbSchema()+".selectoptionen " +
				"values('"+nameOfSelectbox+"','" +sprachId+"'," +
				"'"+option.getOptionId()+"','"+option.getOptionValue()+"'," + 
				"'"+option.getOptionDescription()+"',"+
				"'"+user.getUserId()+"'," + "now()," + 
				"'"+user.getUserId()+"'," + "now())");
    }//insert
    
    public static synchronized void update(Database dbConn,User user,String nameOfSelectbox,String sprachId,SelectboxOptionen option) throws Exception {
        dbConn.executeUpdate("update "+dbConn.getDbSchema()+".selectoptionen " +
                "set" +
				" optionDescripten = '"+ option.getOptionDescription()+"'," +
                " changeUser = '"+ user.getUserId()+ "'," + " changeDate = now() " +
                " where selectbox = '"+ nameOfSelectbox + "' and sprachId = '"+sprachId +"'" +
                " and optionId = '"+option.getOptionId() + "' and optionValue = '"+option.getOptionValue()+"'");
    }//update
    
    public static synchronized void delete(Database dbConn,String nameOfSelectbox,String sprachId,String optionId,String optionValue) throws Exception {
    	dbConn.executeUpdate("delete from "+dbConn.getDbSchema()+".selectoptionen " +
        		"where selectbox = '"+nameOfSelectbox+"'" +
    	        " and sprachId = '"+sprachId+"'"+
    			" and optionId = '"+optionId+"'" +
    			" and optionValue = '"+optionValue+"'");
    }//delete
}//class DataSetSelectOptionen
