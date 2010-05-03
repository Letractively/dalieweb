/*
 * Created on 15.02.2010
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
public class Immo001H extends TableHeader {
	
	/** HeaderTyp:Auswahl aller Immobilien ermöglichen 
	 * Verwendung: tagsupport:Immo001FITag
	 * JSP-Verwendung: immo001.jsp  */
	private static final String[] columsOfTyp_0 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:aufsteigend'/>","1%",
	 "Name des Eigentümers","19%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=O' title='Sortierung nach Objektnummer' target='_self'>Nummer</a>","10%",
	 "Typ","15%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=CHANGEDATE' title='Sortierung nach Datum der letzten Änderung' target='_self'>letzte Änderung</a>","13%"};
	
	/** Sortierung: absteigend */
	private static final String[] columsOfTyp_0d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","1%",
	 "Name des Eigentümers","19%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=O' title='Sortierung nach Objektnummer' target='_self'>Nummer</a>","10%",
	 "Typ","15%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=CHANGEDATE' title='Sortierung nach Datum der letzten Änderung' target='_self'>letzte Änderung</a>","13%"};
	
	
	private static final String[] columsOfTyp_1 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Type of Order: Descending' title='Type of Order: Descending'/>","1%",
	 "Owner's name","19%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=O' title='Sort By Number' target='_self'>Number</a>","10%",
	 "Typ","15%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","13%"};
	
	/** Sortierung: absteigend */
	private static final String[] columsOfTyp_1d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Type of Order: Descending' title='Type of Order: Descending'/>","1%",
	 "Owner's name","19%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=O' title='Sort By Number' target='_self'>Number</a>","10%",
	 "Typ","15%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
	 "<a href='/dalieweb/GoToImmo001Servlet?immobilienOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","13%"};
	
	public Immo001H(){
		super(init());
	}//Immo001H
	
	static Hashtable init() {
		Hashtable members = new Hashtable();
		members.put("1DE",columsOfTyp_0);//immo001.jsp -> Anzeige aller Immobilien ohne selection.
	    members.put("1DED",columsOfTyp_0d);
	    members.put("1EN",columsOfTyp_1);
	    members.put("1END",columsOfTyp_1d);
		return members;
	}//init
	
}//class Immo001H
