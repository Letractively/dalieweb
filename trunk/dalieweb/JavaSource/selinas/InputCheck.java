/*
 * Created on 07.10.2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package selinas;

import database.Database;
import database.dateien.Message;
import database.getDatabase.DataSetMessage;

/**
 * @author DV0101
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InputCheck {
	
	String inputName;
    String inputValue;
    public Message error;
    
    public InputCheck(Database dbConn, String inputName, String inputValue, String sprachId) throws Exception{
        this.inputName = inputName;
        this.inputValue = inputValue;
        this.error = DataSetMessage.chain(dbConn,inputName,sprachId);
    }//InputCheck
    
    public boolean CheckInput(){
        if (error.getErrorTyp().equalsIgnoreCase("W") || error.getErrorTyp().equalsIgnoreCase(""))
           	return false;
        if ( inputValue == null || inputValue.equals("") || 
                inputValue.equalsIgnoreCase("KA") ||
                inputValue.equals(inputName)){
            	return true;
        	}else{
        	    return false;   
      		}//endif    
    }//checkInput
    
}//class InputCheck
