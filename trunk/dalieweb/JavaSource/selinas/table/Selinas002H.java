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
public class Selinas002H extends TableHeader{

	/** HeaderTyp:Auswahl aller Dokumente ermöglichen 
	 * Verwendung: tagsupport:DokumentDataTag
	 * JSP-Verwendung: selinas002.jsp  */
	private static final String[] columsOfTyp_0 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","1%",
	 "Typ des Dokuments","14%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","10%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","22%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=OG' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach Datum der letzten Änderung' target='_self'>letzte Änderung</a>","13%"};
	
	/** Sortierung: absteigend */
	private static final String[] columsOfTyp_0d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","1%",
	 "Typ des Dokuments","14%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","10%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","22%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=OG' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach Datum der letzten Änderung' target='_self'>letzte Änderung</a>","13%"};
	
	/** Sortierung: aufsteigend */
	private static final String[] columsOfTyp_0EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","1%",
	 "typ of Documents","14%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","10%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","22%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=OG' title='sorting by organization' target='_self'>Organization</a>","8%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","13%"};
	
	/** Sortierung: absteigend */
	private static final String[] columsOfTyp_0dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","1%",
	 "typ of Documents","14%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","22%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=OG' title='sorting by organization' target='_self'>Organization</a>","8%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","13%"};
	
	/** HeaderTyp:Auswahl der Dokumente nach DokumentTyp ermöglichen.
     * Verwendung: tagsupport:DokumentDataTag
     * JSP-Verwendung: selinas002.jsp  */
    private static final String[] columsOfTyp_1 = 
    {"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:absteigend'/>","1%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","11%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","19%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","29%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","11%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","14%"};
    
    private static final String[] columsOfTyp_1d = 
    {"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","1%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","11%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","19%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","29%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","11%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","14%"};
    
    /** Sortierimg: absteigend */
    private static final String[] columsOfTyp_1EN = 
    {"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","1%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","11%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","19%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","29%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=G' title='sorting by organization' target='_self'>Organization</a>","11%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","14%"};

    /** Sortierimg: absteigend */
    private static final String[] columsOfTyp_1dEN = 
    {"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","1%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","11%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","19%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","29%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=G' title='sorting by organization' target='_self'>Organization</a>","11%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","14%"};
	
	public Selinas002H(){
		super(init());
	}//Selinas002H
	
	static Hashtable init() {
		Hashtable members = new Hashtable();
		members.put("2DE",columsOfTyp_0);//selinas002.jsp -> Anzeige aller Dokumente ohne selection.
	    members.put("2EN",columsOfTyp_0EN);
	    members.put("2DED",columsOfTyp_0d);//
	    members.put("2END",columsOfTyp_0dEN);//
	    
	    members.put("1DE",columsOfTyp_1);//selinas002.jsp -> Anzeige aller Dokumente ohne selection.
	    members.put("1EN",columsOfTyp_1EN);
	    members.put("1DED",columsOfTyp_1d);//
	    members.put("1END",columsOfTyp_1dEN);
		return members;
	}//init
	
}//class Selinas002H
