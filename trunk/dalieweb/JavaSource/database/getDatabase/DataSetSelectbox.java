package database.getDatabase;

import java.util.Vector;

import database.Database;
import database.dateien.Selectbox;

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
    public static Selectbox chain(Database dbConn,int kundenId, int standortId, String nameOfSelectbox,String keyOption) throws Exception {
        	Vector rows = dbConn.executeQuery("select * from "+dbConn.getDbSchema()+".selectbox " +
        	        "where kundenId = "+kundenId+" " +
        			"and standortId = "+standortId+" " +
        			"and sprachId = 'DE' " +
        			"and selectbox = '"+nameOfSelectbox+"'");
            return new Selectbox(dbConn,(Vector)rows.elementAt(0),keyOption);
    }//chain
    
}//class Selectbox

