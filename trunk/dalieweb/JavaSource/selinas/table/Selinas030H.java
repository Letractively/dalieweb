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
public class Selinas030H extends TableHeader {
	

	/** HeaderTyp:AuswahlHilfe Userverwaltung
	 * Sortierimg: aufsteigend 
	 * Verwendung: TagSupport: selinas030FUTag
	 * Verwendung: JSPSeite  : selinas030.jsp  */
	private static final String[] columsOfTyp_0 = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='Typ der Sortierung:aufsteigend' title='Typ der Sortierung:aufsteigend'/>","1%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=N' title='Sortierung nach Name' target='_self'>Name des Users</a>","21%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=U' title='Sortierung nach Benutzer' target='_self'>Benutzer</a>","15%",
	 "Status","14%",
	 "Berechtigung","12%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","20%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	
	private static final String[] columsOfTyp_0EN = 
	{"<img src='/dalieweb/bilder/arrow_a.gif' alt='type of sorting:ascending' title='type of sorting:ascending'/>","1%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=N' title='sorting by name of user' target='_self'>Name of UsersId</a>","21%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=U' title='sorting by user' target='_self'>User</a>","15%",
	 "Status","14%",
	 "authority","12%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","20%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","17%"};
	
	private static final String[] columsOfTyp_0d = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='Typ der Sortierung:absteigend' title='Typ der Sortierung:absteigend'/>","1%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=N' title='Sortierung nach Name' target='_self'>Name des Users</a>","21%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=U' title='Sortierung nach UserId' target='_self'>Benutzer</a>","15%",
	 "Status","14%",
	 "Berechtigung","12%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CREATEDATE' title='Sortierung Datum der Erstellung' target='_self'>erstellt</a>","20%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CHANGEDATE' title='Sortierung nach dem Datum der letzten Änderung' target='_self'>letzte Änderung</a>","17%"};
	
	private static final String[] columsOfTyp_0dEN = 
	{"<img src='/dalieweb/bilder/arrow_d.gif' alt='type of sorting:descending' title='type of sorting:ascending'/>","1%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=N' title='sorting by name of user' target='_self'>Name of UsersId</a>","21%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=U' title='sorting by userId' target='_self'>User</a>","15%",
	 "Status","14%",
	 "authority","12%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CREATEDATE' title='sort by date of creation' target='_self'>Created by</a>","20%",
	 "<a href='/dalieweb/GoToSelinas030Servlet?userOrderByTyp=CHANGEDATE' title='sorting by date of last modification' target='_self'>edited by</a>","17%"};
	
	public Selinas030H(){
		super(init());
	}//Selinas030H
	
	static Hashtable init() {
		Hashtable members = new Hashtable();
		members.put("30DE",columsOfTyp_0);//selinas030.jsp -> Verwaltung aller User zum User.
	    members.put("30EN",columsOfTyp_0EN);
	    members.put("30DED",columsOfTyp_0d);//
	    members.put("30END",columsOfTyp_0dEN);//
		return members;
	}//init
	
}//class Selinas030H
