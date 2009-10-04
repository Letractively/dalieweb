package selinas.bean;

import database.dateien.Selinas;

/**
 * @author dv0101 am 29.12.2008 um 09:15:45
 *
 * selinas.java
 * 
 */

public class SelinasSession {

	public Selinas session;
	private String[] columHeader = {"Typ des Dokuments","","Titel","Beschreibung","Ersteller","",""};
    
    public SelinasSession(Selinas session){
    	this.session = session;
    }//Selinas
    
	/** @return Returns the columHeader.*/
	public String[] getColumHeader() {
		return columHeader;
	}
}//class selinas


