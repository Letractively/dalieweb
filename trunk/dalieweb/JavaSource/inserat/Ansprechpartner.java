/*
 * Created on 09.02.2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package inserat;

import database.dateien.Adresse;

/**
 * @author DV0101
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Ansprechpartner {
	
	String name,vorname;
	Adresse kontakt;
	
	Ansprechpartner(String name,String vorname,Adresse kontakt){
		this.name = name;
		this.vorname = vorname;
		this.kontakt = kontakt;
	}//Ansprechpartner
	
}//class Ansprechpartner
