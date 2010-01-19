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
public class Selinas004H extends TableHeader {
	
	/** HeaderTyp:Anzeige der Anlagen
	 * Sortierung: aufsteigend 
	 * Verwendung: TagSupport: selians004FLTag
	 * Verwendung: JSPSeite  : selinas004.jsp  */
	private static final String[] columsOfTyp_0 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=N' title='Sortierung nach Dateiname' target='_self'>Anlagen</a>","21%",
	 "Notizen","40%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=D' title='Sortierung nach Datum nach upload' target='_self'>vom </a>","24%",
	 "erfassen","5%",
	 "löschen","5%"};
	
	private static final String[] columsOfTyp_0EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=N' title='sorting by filename' target='_self'>attachments</a>","55%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=D' title='sorting by date of download' target='_self'>from </a>","40%"};
	
	private static final String[] columsOfTyp_0d = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","5%",
			 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=N' title='Sortierung nach Dateiname' target='_self'>Anlagen</a>","21%",
			 "Notizen","40%",
			 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=D' title='Sortierung nach Datum nach upload' target='_self'>vom </a>","22%",
			 "erfassen","7%",
			 "löschen","5%"};
	
	private static final String[] columsOfTyp_0dEN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=N' title='sorting by filename' target='_self'>attachments</a>","55%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=D' title='sorting by date of download' target='_self'>from </a>","40%"};
	
	
	/** HeaderTyp:NavigationsHilfe
	 * Sortierung: aufsteigend
	 * Verwendung: TagSupport: selinas004FDTag 
	 * Verwendung: JSPSeite  : selinas004.jsp  */
	private static final String[] columsOfTyp_1 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","3%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","25%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","16%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	
	/** Sortierimg: aufsteigend */
	private static final String[] columsOfTyp_1EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","3%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","22%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","9%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","25%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=G' title='sorting by organization' target='_self'>Organization</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","16%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","17%"};
	
	/** Sortierimg: absteigend */
	private static final String[] columsOfTyp_1d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","3%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","25%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","16%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	/** Sortierimg: absteigend */
	private static final String[] columsOfTyp_1dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","3%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","22%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","9%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Descripten</a>","25%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=G' title='sorting by drganization' target='_self'>Organization</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","16%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","17%"};
	
	public Selinas004H(){
		super(init());
	}//Selinas002H
	
	static Hashtable init() {
		Hashtable members = new Hashtable();
		members.put("4DE",columsOfTyp_0);//selinas004.jsp -> Anzeige aller Anlagen.
	    members.put("4EN",columsOfTyp_0EN);
	    members.put("4DED",columsOfTyp_0d);//
	    members.put("4END",columsOfTyp_0dEN);//
	    
	    members.put("1DE",columsOfTyp_1);//selinas004.jsp -> Dokumente anzeigen Verarbeitungs-mode
        members.put("1EN",columsOfTyp_1EN);
        members.put("1DED",columsOfTyp_1d);
        members.put("1END",columsOfTyp_1dEN);
	    
		return members;
	}//init
	
}//class Selinas004H
