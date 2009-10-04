package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.SelectboxOptionen;

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
    public static Vector chain(Database dbConn,String nameOfSelectbox,String sprachId,String optionId) throws Exception {
        Vector allOptionen = new Vector();
        	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".selectoptionen " +
        	        "where selectbox = '"+nameOfSelectbox+"' " +
        	        "and sprachId = '"+sprachId+"' "+
        			"and optionId = '"+optionId+"' ");
        	 for(int i = 0;i < rows.size();i++) {
                 allOptionen.addElement(new SelectboxOptionen((Vector) rows.elementAt(i)));
             }//for
             return allOptionen;
    }//chain
	
}//class DataSetSelectOptionen
