/*
 * Created on 09.02.2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package inserat;

import java.util.Vector;

import database.Database;
import database.getDatabase.DataSetAdresse;

import inserat.typ.InseratTyp;

/**
 * @author DV0101
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Inserat {

	/** KundenNummer des Dokuments  */
    private int kundenId;//KundenNr = 04711
    /** StandortId */ 
    private int standortId;//Standort 1 zu Kunde 07411
	/** gueltigAb: Datum der Veröffentlichung */
	private String gueltigAb;
	/** ansprechpartner: Ansprechpartner für dieses Inserat */
	Ansprechpartner ansprechpartner;
	
	InseratTyp insertTyp;
	
	/** beschreibung: erfassete Objektbescheibung */
	private String beschreibung,
	/** aussstatung: erfasste Ausstattung */
	ausstattung,
	/** lage: vom User erfasste Lagebeschreibung*/
	lage,
	/** sonstiges: vom User erfasste sonstige Angaben*/
	sonstiges,
	/** zusatzLinks: vom User erfasste Links */
	zusatzLinks;
	
	Inserat(){
	}//Inserat;
	Inserat(Database dbConn, Vector column) throws Exception{
		this.kundenId = Integer.parseInt(column.elementAt(0).toString());
		this.standortId = Integer.parseInt(column.elementAt(1).toString());
		this.gueltigAb = column.elementAt(2).toString();
		this.ansprechpartner = new Ansprechpartner("name","vorname",DataSetAdresse.chain(dbConn,1,"adressArt","userId"));
		this.insertTyp = new
	}
}//class Inserat
