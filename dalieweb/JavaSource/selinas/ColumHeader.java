/*
 * Created of DV0101 on 10.10.2009 21:18:11
 *
 * Filename	  ColumHeader.java
 */
package selinas;

import java.util.Hashtable;

/**
 * retain Information of ColumHeaders.
 *
 * @version 	1.00 10.10.2009 um 21:18:11
 * @author 		DV0101
 */
public class ColumHeader {

	public static final String[] columsOfTyp_0 = {"Gliederung","15%","Titel","15%","Beschreibung","25%","erstellt","25%","letzte Änderung","25%"};
	public static final String[] columsOfTyp_1 = {"Links zum Dokument"};
	public static final String[] columsOfTyp_2 = {"Typ des Dokuments","15%","Gliederung","15%","Titel","15%","Beschreibung","25%","erstellt","15%","letzte Änderung","25"};
	
	private static Hashtable memberTable = init();
	
	private static Hashtable init() {
        Hashtable members = new Hashtable();
        members.put("1DE",columsOfTyp_0);
        members.put("2DE",columsOfTyp_1);
        members.put("3DE",columsOfTyp_2);
        return members;
    }//init
	
	/**
     * Returns a new ColumHeader based on the given String value.
     * @param string
    */
    public static String[] valueOf(String typ, String sprache){
        String[] obj = null;
        if (typ != null) 
            obj = (String[]) memberTable.get(typ + sprache);
        if (obj == null) {
            String err = "'" + typ + "' is not a valid";
            throw new IllegalArgumentException(err);
        }//endif
        return obj;
    }//valueOf 
}//class ColumHeader
