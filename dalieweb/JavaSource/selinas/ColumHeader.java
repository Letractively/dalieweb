/*
 * Created of DV0101 on 10.10.2009 21:18:11
 *
 * Filename	  ColumHeader.java
 */
package selinas;

import java.util.Hashtable;

/**
 * retain Information of ColumHeaders.
 *
 * @version 	1.00 10.10.2009 um 21:18:11
 * @author 		DV0101
 */
public class ColumHeader {
 
	/** HeaderTyp:Navigationsdetail 
	 * Verwendung: tagsupport:DokumentTypTag
	 * JSP-Verwendung: selinas003.jsp -> Dokumente anzeigen präsentations-mode  */
	private static final String[] columsOfTyp_0 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","3%",
	"<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","25%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung nach Datum der Erstellung' target='_self'>erstellt</a>","16%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	
	private static final String[] columsOfTyp_0EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","3%",
	"<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","9%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","25%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=G' title='sorting by organization' target='_self'>Organization</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","16%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","17%"};
	
	/** HeaderTyp:Navigationsdetail 
	 * Verwendung: tagsupport:DokumentTypTag
	 * JSP-Verwendung: selinas003.jsp -> Dokumente anzeigen präsentations-mode */
	private static final String[] columsOfTyp_0d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","3%",
	"<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","25%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","16%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	
	private static final String[] columsOfTyp_0dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","3%",
	"<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","9%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","25%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=G' title='sorting by organization' target='_self'>Organization</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","16%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","17%"};
	
	
	/** HeaderTyp:Ihre Anlagen 
	 * Verwendung: tagsupport:DokumentLinkTag
	 * JSP-Verwendung: selinas003.jsp -> AnlagenLinks anzeigen präsentatins-mode */
	private static final String[] columsOfTyp_1 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=N' title='Sortierung nach Dateiname' target='_self'>Anlagen</a>","55%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=D' title='Sortierung nach Datum nach upload' target='_self'>vom </a>","40%"};
	
	private static final String[] columsOfTyp_1EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=N' title='sorting by filename' target='_self'>attachments</a>","55%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=D' title='sorting by date of download' target='_self'>from </a>","40%"};
	
	/** Sortierimg: absteigend */
	private static final String[] columsOfTyp_1d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=N' title='Sortierung nach Dateiname' target='_self'>Anlagen</a>","55%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=D' title='Sortierung nach Datum nach upload' target='_self'>vom </a>","40%"};
	
	private static final String[] columsOfTyp_1dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=N' title='sorting by filename' target='_self'>attachments</a>","55%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=D' title='sorting by date of download' target='_self'>from </a>","40%"};
	
	
	/** HeaderTyp:Auswahl aller Dokumente ermöglichen 
	 * Verwendung: tagsupport:DokumentDataTag
	 * JSP-Verwendung: selinas002.jsp  */
	private static final String[] columsOfTyp_2 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","1%",
	 "Typ des Dokuments","12%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","7%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","20%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","21%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=OG' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","9%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach Datum der letzten Änderung' target='_self'>letzte Änderung</a>","16%"};
	
	private static final String[] columsOfTyp_2EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","1%",
	 "typ of Documents","12%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","7%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","20%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","21%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=OG' title='sorting by organization' target='_self'>Organization</a>","9%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","16%"};

	
	/** HeaderTyp:Adressdetail 
	 * Verwendung: tagsupport:AdressDataTag
	 * JSP-Verwendung: selinas005.jsp  */
	private static final String[] columsOfTyp_3 = 
	{"Adresse","25%",
	 "Name","25%",
	 "erstellt","25%",
	 "letzte Änderung","25%"};
	
	private static final String[] columsOfTyp_3EN = 
	{"Adress","25%",
	 "Name","25%",
	 "Created by","25%",
	 "edited by","25%"};
	
	/** HeaderTyp:Auswahl der Dokumente nach DokumentTyp ermöglichen.
	 * Verwendung: tagsupport:DokumentDataTag
	 * JSP-Verwendung: selinas002.jsp  */
	private static final String[] columsOfTyp_4 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:absteigend'/>","1%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","20%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","29%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","10%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","16%"};
	
	/** Sortierimg: absteigend */
	private static final String[] columsOfTyp_4EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","1%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","9%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","20%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","29%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=G' title='sorting by organization' target='_self'>Organization</a>","10%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","16%"};
	 
	
	/** HeaderTyp:NavigationsHilfe
	 * Sortierung: aufsteigend
	 * Verwendung: TagSupport: selinas004FDTag 
	 * Verwendung: JSPSeite  : selinas004.jsp  */
	private static final String[] columsOfTyp_5 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","3%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","25%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","16%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	
	/** Sortierimg: aufsteigend */
	private static final String[] columsOfTyp_5EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","3%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","22%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","9%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Description</a>","25%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=G' title='sorting by organization' target='_self'>Organization</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","16%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","17%"};
	
	/** Sortierimg: absteigend */
	private static final String[] columsOfTyp_5d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","3%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","25%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","16%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	/** Sortierimg: absteigend */
	private static final String[] columsOfTyp_5dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","3%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=T' title='sorting by title' target='_self'>Title</a>","22%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=N' title='sorting by document number' target='_self'>Number</a>","9%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=D' title='sorting by description' target='_self'>Descripten</a>","25%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=G' title='sorting by drganization' target='_self'>Organization</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","16%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","17%"};
	 
	
	/** HeaderTyp:Anzeige der Anlagen
	 * Sortierung: aufsteigend 
	 * Verwendung: TagSupport: selians004FLTag
	 * Verwendung: JSPSeite  : selinas004.jsp  */
	private static final String[] columsOfTyp_6 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=N' title='Sortierung nach Dateiname' target='_self'>Anlagen</a>","55%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=D' title='Sortierung nach Datum nach upload' target='_self'>vom </a>","40%"};
	
	private static final String[] columsOfTyp_6EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=N' title='sorting by filename' target='_self'>attachments</a>","55%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=D' title='sorting by date of download' target='_self'>from </a>","40%"};
	
	private static final String[] columsOfTyp_6d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=N' title='Sortierung nach Dateiname' target='_self'>Anlagen</a>","55%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=D' title='Sortierung nach Datum nach upload' target='_self'>vom </a>","40%"};
	
	private static final String[] columsOfTyp_6dEN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=N' title='sorting by filename' target='_self'>attachments</a>","55%",
	 "<a href='/dalieweb/GoToSelinas004Servlet?linkOrderByTyp=D' title='sorting by date of download' target='_self'>from </a>","40%"};
	
	
	/** HeaderTyp:AuswahlHilfe Dokumenttypen
	 * Sortierimg: aufsteigend 
	 * Verwendung: TagSupport: selinas025FTTag
	 * Verwendung: JSPSeite  : selinas025.jsp  */
	private static final String[] columsOfTyp_7 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=T' title='Sortierung nach Typenschlüssel' target='_self'>Typ</a>","10%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=B' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","20%",
	 "gefundene Dokumente","25%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","20%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","20%"};
	
	private static final String[] columsOfTyp_7EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:descending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=T' title='sorting by type designation code' target='_self'>Code</a>","10%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=B' title='sorting by descripten' target='_self'>Descripten</a>","20%",
	 "counts of Documents","25%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","20%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CHANGEDATE' title='Sorting by date of last modification' target='_self'>edited by</a>","20%"};
	
	private static final String[] columsOfTyp_7d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=T' title='Sortierung nach Typenschlüssel' target='_self'>Typ</a>","10%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=B' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","20%",
	 "gefundene Dokumente","25%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","20%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","20%"};
	
	private static final String[] columsOfTyp_7dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:descending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=T' title='sorting by type designation code' target='_self'>Code</a>","10%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=B' title='sorting by descripten' target='_self'>Descripten</a>","20%",
	 "count of Documents","25%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","20%",
	 "<a href='/dalieweb/GoToSelinas025Servlet?typOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","20%"};
	
	/** HeaderTyp:AuswahlHilfe Userverwaltung
	 * Sortierimg: aufsteigend 
	 * Verwendung: TagSupport: selinas030FUTag
	 * Verwendung: JSPSeite  : selinas030.jsp  */
	private static final String[] columsOfTyp_8 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=N' title='Sortierung nach Name' target='_self'>Name des Users</a>","15%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=U' title='Sortierung nach Benutzer' target='_self'>Benutzer</a>","10%",
	 "Status","10%",
	 "Berechtigung","10",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","25%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","25%"};
	
	private static final String[] columsOfTyp_8EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=N' title='sorting by name of user' target='_self'>Name of UsersId</a>","15%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=U' title='sorting by user' target='_self'>User</a>","10%",
	 "Status","10%",
	 "authority","10",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","25%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","25%"};
	
	private static final String[] columsOfTyp_8d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","5%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=N' title='Sortierung nach Name' target='_self'>Name des Users</a>","15%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=U' title='Sortierung nach UserId' target='_self'>Benutzer</a>","10%",
	 "Status","10%",
	 "Berechtigung","10",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","25%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","25%"};
	
	private static final String[] columsOfTyp_8dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:ascending'/>","5%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=N' title='sorting by name of user' target='_self'>Name of UsersId</a>","15%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=U' title='sorting by userId' target='_self'>User</a>","10%",
	 "Status","10%",
	 "authority","10",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","25%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","25%"};
	
	private static Hashtable memberTable = init();
	private static Hashtable init() {
        Hashtable members = new Hashtable();
        members.put("1DE",columsOfTyp_0);//selinas003.jsp -> Dokumente anzeigen präsentations-mode
        members.put("1EN",columsOfTyp_0EN);
        members.put("1DED",columsOfTyp_0d);//selinas003.jsp -> Dokumente anzeigen präsentations-mode
        members.put("1END",columsOfTyp_0dEN);//selinas003.jsp -> Dokumente anzeigen präsentations-mode
        
        members.put("2DE",columsOfTyp_1);//selinas003.jsp -> AnlagenLinks anzeigen präsentatins-mode
        members.put("2EN",columsOfTyp_1EN);//selinas003.jsp -> AnlagenLinks anzeigen präsentatins-mode
        members.put("2DED",columsOfTyp_1d);//selinas003.jsp -> AnlagenLinks anzeigen präsentatins-mode
        members.put("2END",columsOfTyp_1dEN);//selinas003.jsp -> AnlagenLinks anzeigen präsentatins-mode
        
        members.put("3DE",columsOfTyp_2);//selinas002.jsp -> Anzeige aller Dokumente ohne selection.
        members.put("3EN",columsOfTyp_2EN);
        
        members.put("ADE",columsOfTyp_3);//selinas005.jsp -> Adressverwaltung
        members.put("AEN",columsOfTyp_3EN);
        
        members.put("4DE",columsOfTyp_4);//selinas002.jsp -> Anzeige der Dokumente nach Auswahl von Formularart
        members.put("4EN",columsOfTyp_4EN);
        
        members.put("5DE",columsOfTyp_5);//selians004.JSP -> Dokument bearbeiten NavigationsHilfe 
        members.put("5EN",columsOfTyp_5EN);
        members.put("5DED",columsOfTyp_5d);//selinas004.JSP -> Dokument bearbeiten NavigationsHilfe absteigend
        members.put("5END",columsOfTyp_5dEN);
        
        members.put("6DE",columsOfTyp_6);//selinas004.JSP -> Anzeige der Links
        members.put("6EN",columsOfTyp_6EN);
        members.put("6DED",columsOfTyp_6d);//selinas004.JSP -> Anzeige der Links absteigend
        members.put("6END",columsOfTyp_6dEN);
        
        members.put("7DE",columsOfTyp_7);//selinas025.JSP -> Anzeige der Dokumenttypen
        members.put("7EN",columsOfTyp_7EN);
        members.put("7DED",columsOfTyp_7d);//selinas025.JSP -> Anzeige der Dokumenttypen absteigend
        members.put("7END",columsOfTyp_7dEN);
        
        members.put("8DE",columsOfTyp_8);//selinas030.JSP -> Anzeige Userverwaltung
        members.put("8EN",columsOfTyp_8EN);
        members.put("8DED",columsOfTyp_8d);//selinas030.JSP -> Anzeige Userverwaltung absteigend
        members.put("8END",columsOfTyp_8dEN);
        return members;
    }//init
	
	/**
     * Returns a new ColumHeader based on the given String value.
     * @param string
    */ 
    public static String[] valueOf(String typ, String sprache){
        String[] obj = null;
        if (typ != null) 
            obj = (String[]) memberTable.get(typ + sprache);
        if (obj == null) {
            String err = "'" + typ + "' is not a valid";
            throw new IllegalArgumentException(err);
        }//endif
        return obj;
    }//valueOf 
    /**
     * Returns a new ColumHeader based on the given String value.
     * @param string
    */ 
    public static String[] valueOf(String typ, String sprache,String sortierung){
        String[] obj = null;
        if (sortierung.endsWith("D")){;
        	if (typ != null) 
        		obj = (String[]) memberTable.get(typ + sprache + "D");
        	if (obj == null) {
        		String err = "'" + typ + "' is not a valid";
        		throw new IllegalArgumentException(err);
        	}//endif
        }else{
        	if (typ != null) 
        		obj = (String[]) memberTable.get(typ + sprache);
        	if (obj == null) {
        		String err = "'" + typ + "' is not a valid";
        		throw new IllegalArgumentException(err);
        	}//endif
        }//endif
        return obj;
    }//valueOf 
}//class ColumHeader
