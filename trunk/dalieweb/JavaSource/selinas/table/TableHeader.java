/*
 * Created on 10.01.2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package selinas.table;

import java.util.Hashtable;

/**
 * @author DV0101
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TableHeader {

	static Hashtable memberTable;
	
	TableHeader(Hashtable table){
		memberTable = table;
	}//TableHeader
	
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
    /**
     * Returns a new ColumHeader based on the given String value.
     * @param string
    */ 
    public static String[] valueOf(String typ, String sprache,String sortierung){
        String[] obj = null;
        if (sortierung.endsWith("D")){;
        	if (typ != null) 
        		obj = (String[]) memberTable.get(typ + sprache + "D");
        	if (obj == null) {
        		String err = "'" + typ + "' is not a valid";
        		throw new IllegalArgumentException(err);
        	}//endif
        }else{
        	if (typ != null) 
        		obj = (String[]) memberTable.get(typ + sprache);
        	if (obj == null) {
        		String err = "'" + typ + "' is not a valid";
        		throw new IllegalArgumentException(err);
        	}//endif
        }//endif
        return obj;
    }//valueOf 
	
	
}//class TableHeader
