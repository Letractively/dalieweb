/*
 * Created on 11.01.2010
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
public class Selinas020H extends TableHeader {
	
	/** HeaderTyp:Adressdetail 
	 * Verwendung: tagsupport:AdressDataTag
	 * JSP-Verwendung: selinas005.jsp  */
	private static final String[] columsOfTyp_0 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Sortierung aufsteigend' title='Sortierung aufsteigend'/>","1%",
			"Adressetyp","12%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=N' title='Sortierung nach Name' target='_self'>Name</a>","17%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=S' title='Sortierung nach Strasse' target='_self'>Strasse</a>","12%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=P' title='Sortierung nach Postleitzahl' target='_self'>Postleitzahl</a>","8%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=O' title='Sortierung nach Ort' target='_self'>Ort</a>","10%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=L' title='Sortierung nach Land' target='_self'>Land</a>","10%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","15%"};
	
	private static final String[] columsOfTyp_0d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Sortierung aufsteigend' title='Sortierung aufsteigend'/>","1%",
			"Adressetyp","12%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=N' title='Sortierung nach Name' target='_self'>Name</a>","17%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=S' title='Sortierung nach Strasse' target='_self'>Strasse</a>","12%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=P' title='Sortierung nach Postleitzahl' target='_self'>Postleitzahl</a>","8%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=O' title='Sortierung nach Ort' target='_self'>Ort</a>","10%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=L' title='Sortierung nach Name' target='_self'>Land</a>","10%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
				"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","15%"};
	
	private static final String[] columsOfTyp_0EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","1%",
			"Adressetyp","12%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=N' title='sort by name' target='_self'>Name</a>","17%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=S' title='sort by adressstreet' target='_self'>Street</a>","12%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=P' title='sort by zip code' target='_self'>Zip code</a>","8%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=O' title='sort by location' target='_self'>Location</a>","10%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=L' title='sort by country' target='_self'>country</a>","10%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","15%"};
	
	private static final String[] columsOfTyp_0dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","1%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=N' title='sort by name' target='_self'>Name</a>","17%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=S' title='sort by adressstreet' target='_self'>Street</a>","12%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=P' title='sort by zip code' target='_self'>Zip code</a>","8%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=O' title='sort by location' target='_self'>Location</a>","10%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=L' title='sort by country' target='_self'>country</a>","10%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
			"<a href='/dalieweb/GoToSelinas020Servlet?adressOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","15%"};
	
	
	public Selinas020H(){
		super(init());
	}//Selinas002H
	
	static Hashtable init() {
		Hashtable members = new Hashtable();
		members.put("20DE",columsOfTyp_0);//selinas002.jsp -> Anzeige aller Dokumente ohne selection.
	    members.put("20EN",columsOfTyp_0EN);
	    members.put("20DED",columsOfTyp_0d);//
	    members.put("20END",columsOfTyp_0dEN);//
		return members;
	}//init
	
}//class Selinas020H
