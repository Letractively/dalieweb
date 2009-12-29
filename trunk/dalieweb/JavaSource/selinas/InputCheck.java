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
	
	String inputName = "";
    String inputValue = "";
    int count = 0;
    public Message error;
    
    /** 1. prüfen des UserInputs  */
    public InputCheck(Database dbConn, String inputName, String inputValue, String sprachId) throws Exception{
        this.inputName = inputName;
        this.inputValue = inputValue;
        this.error = DataSetMessage.chain(dbConn,inputName,sprachId);
    }//InputCheck
    
    /** 2. prüfen anzahl gefundener Sätze */
    public InputCheck(Database dbConn,String inputName,int count ,String sprachId) throws Exception{
    	this.count = count;
    	this.error = DataSetMessage.chain(dbConn,inputName,sprachId);
    }//InputCheck
    
    /** check UserInput */
    public boolean checkInput(){
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
    
    /** check Anzahl der Datenbanksätze*/
    public boolean checkCount() {
		if (count == 0) {
			return false;
		} else {
			return true;
		}//endif
	}//checkCount
    
}//class InputCheck
