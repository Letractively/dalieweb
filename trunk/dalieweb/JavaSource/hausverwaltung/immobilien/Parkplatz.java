/*
 * Created of DV0101 on 09.02.2010 11:28:25
 *
 * Filename	  Parkplatz.java
 */
package hausverwaltung.immobilien;


import help.HelpDate;

import java.util.Vector;

/**
 * Objekt that describes the attributes of parkplatz.
 *
 * @version 	1.00 09.02 2010 um 11:28:25
 * @author 		DV0101
 * <br><br>
 */
public class Parkplatz extends ImmobilienTyp {

	private int ObjektId;
	private int miete;
	
	/** Kennzeichen des User der Dokument erstellt hat */
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der Erstellung */
    private String createDate;//Datum der Erstellung
    /** Kennzeichen des User der letzten Aenderung */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der letzten Aenderung */
    private String changeDate;//Datum der letzten Änderung
	
	public Parkplatz(){
	}//Parkplatz
	public Parkplatz(Vector columns){
		this.ObjektId = Integer.parseInt(columns.elementAt(0).toString());
		this.miete = Integer.parseInt(columns.elementAt(1).toString());
		
		this.createUserId =  columns.elementAt(2).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(3).toString());
        this.changeUserId =  columns.elementAt(4).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(5).toString());
	}//Parkplatz
	
	
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
	 * @return Returns the miete.
	 */
	public int getMiete() {
		return miete;
	}
	/**
	 * @param miete The miete to set.
	 */
	public void setMiete(int miete) {
		this.miete = miete;
	}
	/**
	 * @return Returns the objektId.
	 */
	public int getObjektId() {
		return ObjektId;
	}
	/**
	 * @param objektId The objektId to set.
	 */
	public void setObjektId(int objektId) {
		ObjektId = objektId;
	}
}//class Parkplatz
