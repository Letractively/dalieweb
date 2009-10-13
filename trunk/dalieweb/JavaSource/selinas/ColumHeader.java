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

	public static final String[] columsOfTyp_0 = {"Typ des Dokuments","","Titel","Beschreibung","Ersteller","",""};
	public static final String[] columsOfTyp_1 = {"Links zum Dokument"};
	
	private static Hashtable memberTable = init();
	
	private static Hashtable init() {
        Hashtable members = new Hashtable();
        members.put("1",columsOfTyp_0);
        members.put("2",columsOfTyp_1);
        return members;
    }//init
	
	/**
     * Returns a new ColumHeader based on the given String value.
     * @param string
    */
    public static String[] valueOf(String string){
        String[] obj = null;
        if (string != null) 
            obj = (String[]) memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid";
            throw new IllegalArgumentException(err);
        }//endif
        return obj;
    }//valueOf 
}//class ColumHeader
