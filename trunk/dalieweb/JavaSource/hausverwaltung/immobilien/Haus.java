/*
 * Created of DV0101 on 11.02.2010 13:25:12
 *
 * Filename	  Haus.java
 */
package hausverwaltung.immobilien;

import help.HelpDate;

import java.util.Vector;

import database.Database;
import database.dateien.Typen;
import database.getDatabase.DataSetTypen;

/**
 * Objekt that describes the attributes of haus.
 *
 * @version 	1.00 11.02 2010 um 13:25:12
 * @author 		DV0101
 * <br><br>
 */
public class Haus extends ImmobilienTyp {

	/** objketId: eindeutige Nummer */
	private int objektId;
	
	/** baujahr: Datum der Fertigstellung */
	private String baujahr;
	/** zustand: gepflegt, renovierungsbedürftig */
	private Typen zustand;
	/** typ: Reihenhaus, Einfamilienhaus usw. */
	private Typen typ;
	/** zimmer: 2 */
	private short zimmer;
	/** anzahlWohnung: Anzahl der Wohnungseinheiten im Haus */
	private int anzahlWohnung;
	/** flaeche: in qm ca. */
	private int flaeche;
	/** heitzungstyp: Gasheitzung, Elektorheitzung */
	private String heitzungstyp;
	/** Ausstattung: Balkon,Gaeste-WC,Einbauküche,Keller usw.  */
//	private WohnungsProfil ausstattung;
	
	/** Kennzeichen des User der Dokument erstellt hat */
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der Erstellung */
    private String createDate;//Datum der Erstellung
    /** Kennzeichen des User der letzten Aenderung */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der letzten Aenderung */
    private String changeDate;//Datum der letzten Änderung
	
    public Haus(){
    }//Haus
    public Haus(Database dbConn,Vector columns) throws Exception{
    	this.objektId = Integer.parseInt(columns.elementAt(0).toString());
		this.baujahr = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(1).toString());
		this.zustand = DataSetTypen.chainDatenTypHausZustand(dbConn,columns.elementAt(2).toString());
		this.typ = DataSetTypen.chainDatenTypHausTyp(dbConn,columns.elementAt(3).toString());
		this.zimmer = Short.parseShort(columns.elementAt(4).toString());
		this.anzahlWohnung = Integer.parseInt(columns.elementAt(5).toString());
		this.flaeche = Integer.parseInt(columns.elementAt(6).toString());
		this.heitzungstyp = columns.elementAt(7).toString();
		
		this.createUserId =  columns.elementAt(8).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(9).toString());
        this.changeUserId =  columns.elementAt(10).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(11).toString());
	}//Haus
    
    
    
	/**
	 * @return Returns the anzahlWohnung.
	 */
	public int getAnzahlWohnung() {
		return anzahlWohnung;
	}
	/**
	 * @param anzahlWohnung The anzahlWohnung to set.
	 */
	public void setAnzahlWohnung(int anzahlWohnung) {
		this.anzahlWohnung = anzahlWohnung;
	}
	/**
	 * @return Returns the baujahr.
	 */
	public String getBaujahr() {
		return baujahr;
	}
	/**
	 * @param baujahr The baujahr to set.
	 */
	public void setBaujahr(String baujahr) {
		this.baujahr = baujahr;
	}
	/**
	 * @return Returns the changeDate.
	 */
	public String getChangeDate() {
		return changeDate;
	}
	/**
	 * @param changeDate The changeDate to set.
	 */
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	/**
	 * @return Returns the changeUserId.
	 */
	public String getChangeUserId() {
		return changeUserId;
	}
	/**
	 * @param changeUserId The changeUserId to set.
	 */
	public void setChangeUserId(String changeUserId) {
		this.changeUserId = changeUserId;
	}
	/**
	 * @return Returns the createDate.
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate The createDate to set.
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return Returns the createUserId.
	 */
	public String getCreateUserId() {
		return createUserId;
	}
	/**
	 * @param createUserId The createUserId to set.
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * @return Returns the flaeche.
	 */
	public int getFlaeche() {
		return flaeche;
	}
	/**
	 * @param flaeche The flaeche to set.
	 */
	public void setFlaeche(int flaeche) {
		this.flaeche = flaeche;
	}
	/**
	 * @return Returns the heitzungstyp.
	 */
	public String getHeitzungstyp() {
		return heitzungstyp;
	}
	/**
	 * @param heitzungstyp The heitzungstyp to set.
	 */
	public void setHeitzungstyp(String heitzungstyp) {
		this.heitzungstyp = heitzungstyp;
	}
	/**
	 * @return Returns the objektId.
	 */
	public int getObjektId() {
		return objektId;
	}
	/**
	 * @param objektId The objektId to set.
	 */
	public void setObjektId(int objektId) {
		this.objektId = objektId;
	}
	/**
	 * @return Returns the typ.
	 */
	public Typen getTyp() {
		return typ;
	}
	/**
	 * @param typ The typ to set.
	 */
	public void setTyp(Typen typ) {
		this.typ = typ;
	}
	/**
	 * @return Returns the zimmer.
	 */
	public short getZimmer() {
		return zimmer;
	}
	/**
	 * @param zimmer The zimmer to set.
	 */
	public void setZimmer(short zimmer) {
		this.zimmer = zimmer;
	}
	/**
	 * @return Returns the zustand.
	 */
	public Typen getZustand() {
		return zustand;
	}
	/**
	 * @param zustand The zustand to set.
	 */
	public void setZustand(Typen zustand) {
		this.zustand = zustand;
	}
}//class Haus
