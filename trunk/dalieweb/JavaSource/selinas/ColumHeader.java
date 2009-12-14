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
	 * JSP-Verwendung: selinas003.jsp  */
	private static final String[] columsOfTyp_0 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ of Sort' title='Tyo of Sort'/>","3%",
	"<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","22%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","25%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","8%", 
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","16%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	
	/** HeaderTyp:Ihre Anlagen 
	 * Verwendung: tagsupport:DokumentLinkTag
	 * JSP-Verwendung: selinas003.jsp  */
	private static final String[] columsOfTyp_1 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ of Sort' title='Tyo of Sort'/>","3%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=N' title='Sortierung nach Dateiname' target='_self'>Anlagen</a>","55%",
	 "<a href='/dalieweb/GoToSelinas003Servlet?linkOrderByTyp=D' title='Sortierung nach Datum nach upload' target='_self'>vom </a>","42%"};
	
	/** HeaderTyp:Auswahl aller Dokumente ermöglichen 
	 * Verwendung: tagsupport:DokumentDataTag
	 * JSP-Verwendung: selinas002.jsp  */
	private static final String[] columsOfTyp_2 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ of Sort' title='Tyo of Sort'/>","1%",
	 "Typ des Dokuments","12%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","7%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","20%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","21%",
     "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=OG' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","9%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach Datum der letzten Änderung' target='_self'>letzte Änderung</a>","16%"};
	
	/** HeaderTyp:Adressdetail 
	 * Verwendung: tagsupport:AdressDataTag
	 * JSP-Verwendung: selinas005.jsp  */
	private static final String[] columsOfTyp_3 = 
	{"Adresse","25%",
	 "Name","25%",
	 "erstellt","25%",
	 "letzte Änderung","25%"};
	
	/** HeaderTyp:Auswahl der Dokumente nach DokumentTyp ermöglichen.
	 * Verwendung: tagsupport:DokumentDataTag
	 * JSP-Verwendung: selinas002.jsp  */
	private static final String[] columsOfTyp_4 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ of Sort' title='Tyo of Sort'/>","1%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=N' title='Sortierung nach Dokumenten-Nr' target='_self'>Nummer</a>","9%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=T' title='Sortierung nach Titel' target='_self'>Titel</a>","20%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=D' title='Sortierung nach Beschreibung' target='_self'>Beschreibung</a>","29%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=G' title='Sortierung nach Gliederung' target='_self'>Gliederung</a>","10%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","15%",
	 "<a href='/dalieweb/GoToSelinas002Servlet?dokumentOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","16%"};
	
	private static Hashtable memberTable = init();
	private static Hashtable init() {
        Hashtable members = new Hashtable();
        members.put("1DE",columsOfTyp_0);
        members.put("2DE",columsOfTyp_1); 
        members.put("3DE",columsOfTyp_2);
        members.put("ADE",columsOfTyp_3);
        members.put("4DE",columsOfTyp_4);
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
}//class ColumHeader
