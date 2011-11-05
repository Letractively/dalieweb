package selinas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ErrorBean implements Serializable {
	
	private String message;
	private List<String> errorList;
	
	public ErrorBean() {
		this.message = null;
		this.errorList = new ArrayList<String>();
	}

	public void addEntryToErrorList(String message){
		if (!foundErrorMessage(message)) {
			
			errorList.add(message);
		}
		
	}
	
	 /**
     * To check whether the specified element exists in Java ArrayList use
     * boolean contains(Object element) method.
     * It returns true if the ArrayList contains the specified object, false otherwise.
     * */
    public boolean foundErrorMessage(String message) {
    	
    	return errorList.contains(message);
    	
    } //foundErrorMessage
	
	public boolean isError(){
		
		if ( this.message != null && this.message.length() > 0 || 
				this.errorList != null && this.errorList.size() == 0) {
			
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList.clear();
		this.errorList = errorList;
	}
	
}
