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
public class Selinas003H extends TableHeader {
	
	/** HeaderTyp:Ihre Anlagen 
	 * Verwendung: tagsupport:DokumentLinkTag
	 * JSP-Verwendung: selinas003.jsp -> AnlagenLinks anzeigen präsentatins-mode */
	private static final String[] columsOfTyp_0 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=N' title='Sortierung nach Dateiname' target='_self'>Anlagen</a>","55%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=D' title='Sortierung nach Datum nach upload' target='_self'>vom </a>","40%"};
	
	private static final String[] columsOfTyp_0EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=N' title='sorting by filename' target='_self'>attachments</a>","55%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=D' title='sorting by date of download' target='_self'>from </a>","40%"};
	
	/** Sortierimg: absteigend */
	private static final String[] columsOfTyp_0d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=N' title='Sortierung nach Dateiname' target='_self'>Anlagen</a>","55%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=D' title='Sortierung nach Datum nach upload' target='_self'>vom </a>","40%"};
	
	private static final String[] columsOfTyp_0dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=N' title='sorting by filename' target='_self'>attachments</a>","55%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=D' title='sorting by date of download' target='_self'>from </a>","40%"};
	
	/** HeaderTyp:Navigationsdetail 
	 * Verwendung: tagsupport:DokumentTypTag
	 * JSP-Verwendung: selinas003.jsp -> Dokumente anzeigen präsentations-mode  */
	private static final String[] columsOfTyp_1 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","3%",
	"<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","25%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung nach Datum der Erstellung' target='_self'>erstellt</a>","16%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	
	private static final String[] columsOfTyp_1EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","3%",
	"<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","9%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","25%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=G' title='sorting by organization' target='_self'>Organization</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","16%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","17%"};

	private static final String[] columsOfTyp_1d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","3%",
	"<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","25%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","16%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	
	private static final String[] columsOfTyp_1dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","3%",
	"<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","9%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","25%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=G' title='sorting by organization' target='_self'>Organization</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","16%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","17%"};
	
	public Selinas003H(){
		super(init());
	}//Selinas003H
	
	static Hashtable init() {
		Hashtable members = new Hashtable();
		members.put("3DE",columsOfTyp_0);//selinas003.jsp -> Anzeige aller Anlagen.
	    members.put("3EN",columsOfTyp_0EN);
	    members.put("3DED",columsOfTyp_0d);//
	    members.put("3END",columsOfTyp_0dEN);//
	    
	    members.put("1DE",columsOfTyp_1);//selinas003.jsp -> Dokumente anzeigen präsentations-mode
        members.put("1EN",columsOfTyp_1EN);
        members.put("1DED",columsOfTyp_1d);
        members.put("1END",columsOfTyp_1dEN);
	    
		return members;
	}//init
	
}//class Selinas003H
