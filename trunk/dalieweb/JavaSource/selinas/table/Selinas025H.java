/*
 * Created on 12.01.2010
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
public class Selinas025H extends TableHeader{
	
	/** HeaderTyp:AuswahlHilfe Dokumenttypen
	 * Sortierimg: aufsteigend 
	 * Verwendung: TagSupport: selinas025FTTag
	 * Verwendung: JSPSeite  : selinas025.jsp  */
	private static final String[] columsOfTyp_0 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=T' title='Sortierung nach Typenschlüssel' target='_self'>Typ</a>","10%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=B' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","20%",
	 "gefundene Dokumente","25%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","20%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","20%"};
	
	private static final String[] columsOfTyp_0EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:descending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=T' title='sorting by type designation code' target='_self'>Code</a>","10%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=B' title='sorting by descripten' target='_self'>Descripten</a>","20%",
	 "counts of Documents","25%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","20%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","20%"};
	
	private static final String[] columsOfTyp_0d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=T' title='Sortierung nach Typenschlüssel' target='_self'>Typ</a>","10%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=B' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","20%",
	 "gefundene Dokumente","25%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","20%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","20%"};
	
	private static final String[] columsOfTyp_0dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=T' title='sorting by type designation code' target='_self'>Code</a>","10%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=B' title='sorting by descripten' target='_self'>Descripten</a>","20%",
	 "count of Documents","25%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","20%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","20%"};
	
	public Selinas025H(){
		super(init());
	}//Selinas025H
	
	static Hashtable init() {
		Hashtable members = new Hashtable();
		members.put("25DE",columsOfTyp_0);//selinas025.jsp -> Verwaltung aller Dokumenttypen.
	    members.put("25EN",columsOfTyp_0EN);
	    members.put("25DED",columsOfTyp_0d);//
	    members.put("25END",columsOfTyp_0dEN);//
	    
	    
		return members;
	}//init
}//class Selinas025H
