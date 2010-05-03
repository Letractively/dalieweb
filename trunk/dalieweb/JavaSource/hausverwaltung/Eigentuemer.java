/*
 * Created of DV0101 on 09.02.2010 08:02:58
 *
 * Filename	  DataSetEigentuemer.java
 */
package hausverwaltung;

import help.HelpDate;

import java.util.Vector;

import model.Person;
import database.dateien.Adresse;

/**
* Eigenschaften eines Eigentuemers, 
* der eine Immobilie besitzt.
*
* @version 	1.00 09.02.2010 um 08:02:58
* @author 		DV0101
* 
* <br>
* 
*/
public class Eigentuemer extends Person {

	/** objketId: ObjektNr der Eignettuemerimmobilie */
	private int objektId;
	/** kontakt: Kontaktadresse des Eigentuemers */
	private Adresse kontakt;
	/** seit: Eigentuemer seit*/
	private String	seit;
	
	/** User of create this Objekt*/
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp of create*/
    private String createDate;//Datum der Erstellung
    /** User of last modifikation */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp of last modifikation */
    private String changeDate;//Datum der letzten Änderung
	
	public Eigentuemer(){
	}//Eignetuemer
	public Eigentuemer(Vector columns){
		this.objektId = Integer.parseInt(columns.elementAt(0).toString());
		this.setName(columns.elementAt(1).toString());
        this.setVorname(columns.elementAt(2).toString());
        this.setGeburtstag(HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(3).toString()));
        this.seit = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(4).toString());
		
        this.createUserId = columns.elementAt(5).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(6).toString());
        this.changeUserId = columns.elementAt(7).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(8).toString());
	}//Eigentuemer
	
	
	
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
	 * @return Returns the kontakt.
	 */
	public Adresse getKontakt() {
		return kontakt;
	}
	/**
	 * @param kontakt The kontakt to set.
	 */
	public void setKontakt(Adresse kontakt) {
		this.kontakt = kontakt;
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
	 * @return Returns the seit.
	 */
	public String getSeit() {
		return seit;
	}
	/**
	 * @param seit The seit to set.
	 */
	public void setSeit(String seit) {
		this.seit = seit;
	}
}//class Eigentuemer
