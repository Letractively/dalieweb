/*
 * Created of DV0101 on 09.02.2010 08:00:01
 *
 * Filename	  Immobilie.java
 */
package hausverwaltung;

import java.util.Vector;

import hausverwaltung.immobilien.ImmobilienTyp;
import help.HelpDate;
import database.Database;
import database.dateien.Adresse;
import database.getDatabase.DataSetAdresse;
import database.getDatabase.DataSetEigentuemer;
import database.getDatabase.DataSetImmobilienTyp;

/**
 * Objekt that describes the attributes of immobilie.
 *
 * @version 	1.00 09.02.2010 um 08:00:01
 * @author 		DV0101
 * <br><br>
 */
public class Immobilie {
	
	 /** KundenNummer des Dokuments  */
    private int kundenId;//KundenNr = 04711
    /** StandortId */ 
    private int standortId;//Standort 1 zu Kunde 07411
    
	/** objketId: eindeutige Nummer */
	private int objektId;
	/** typ: (W)ohnung,(P)arkplatz,(H)aus usw.*/
	private ImmobilienTyp typ;
	
	/** adresse: Standort der Immobilie */
	private Adresse adresse;
	/** eignentuemer: eigentuemer der Immobilie mit Anschrift usw.*/
	private Eigentuemer eigentuemer;
	
	/** Kennzeichen des User der Dokument erstellt hat */
	private String createUserId;//DV0101 AnmeldeKennnung am System
	/** Timestamp der Erstellung */
	private String createDate;//Datum der Erstellung
	/** Kennzeichen des User der letzten Aenderung */
	private String changeUserId;//DV0101 AnmeldeKennnung am System
	/** Timestamp der letzten Aenderung */
	private String changeDate;//Datum der letzten Änderung
	
	public Immobilie(){
	}//Immobilie
	public Immobilie(Database dbConn, Vector columns)throws Exception{
		this.kundenId = Integer.parseInt(columns.elementAt(0).toString());
		this.standortId = Integer.parseInt(columns.elementAt(1).toString());
		this.objektId = Integer.parseInt(columns.elementAt(2).toString());
		this.typ = DataSetImmobilienTyp.chain(dbConn,this.objektId);
		this.adresse = DataSetAdresse.chain(dbConn,this.objektId,"I");
		this.eigentuemer = DataSetEigentuemer.toDetermineCurrentOwner(dbConn,this.objektId);
		
		this.createUserId =  columns.elementAt(3).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(4).toString());
        this.changeUserId =  columns.elementAt(5).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(6).toString());
	}//Immobilie
	
	
	/**
	 * @return Returns the adresse.
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse The adresse to set.
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
	 * @return Returns the eigentuemer.
	 */
	public Eigentuemer getEigentuemer() {
		return eigentuemer;
	}
	/**
	 * @param eigentuemer The eigentuemer to set.
	 */
	public void setEigentuemer(Eigentuemer eigentuemer) {
		this.eigentuemer = eigentuemer;
	}
	/**
	 * @return Returns the kundenId.
	 */
	public int getKundenId() {
		return kundenId;
	}
	/**
	 * @param kundenId The kundenId to set.
	 */
	public void setKundenId(int kundenId) {
		this.kundenId = kundenId;
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
	 * @return Returns the standortId.
	 */
	public int getStandortId() {
		return standortId;
	}
	/**
	 * @param standortId The standortId to set.
	 */
	public void setStandortId(int standortId) {
		this.standortId = standortId;
	}
	/**
	 * @return Returns the typ.
	 */
	public ImmobilienTyp getTyp() {
		return typ;
	}
	/**
	 * @param typ The typ to set.
	 */
	public void setTyp(ImmobilienTyp typ) {
		this.typ = typ;
	}
}//class Immobilie
