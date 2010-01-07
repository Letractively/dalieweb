/*
 * Created of DV0101 on 04.05.2009 07:34:16
 *
 * Filename	  Adresse.java
 */
package database.dateien;

import help.HelpDate;

import java.util.Vector;

/**
 * Class description goes here.
 *
 * @version 	1.00 04.05.2009 um 07:34:16
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Adresse {

    /** AdresseId = KundenNr */
    private int adressId = 0;//adressId = KundenNr 04711
    /** AdressArt (U)ser,(R)erchnung oder (K)undenadresse */
    private String adressArt = "";//adressArt = (U)ser,(R)echnungs oder (K)Kundenadresse
    /** UserId */
    private String userId = "";
    /** Strasse */
    private String strasse = "";//strasse Wilhelm Pieck Straße
    /** Nummer der Strasse */
    private String nummer = "";//nummer 16
    /** PLZ vom Ort */
    private String plz = "";//plz 6902
    /** Ort */
    private String ort = "";//ort Jena
    /** Land */
    private String land = "";//land DDR
    /** Telefon */
    private String telefon = "";//04711/4711
    /** Fax */
    private String fax = "";//04711/4799
    /** @MailAdresse */
    private String mail = "";//xyz@mailto.de
    
    /** Kennzeichen des User der Typ erstellt hat */
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der Erstellung */
    private String createDate;//Datum der Erstellung
    /** Kennzeichen des User der letzten Aenderung */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der letzten Aenderung */
    private String changeDate;//Datum der letzten Änderung
    
    /**
     * <b>Adresse</b><br><br>
     * private String adressId<br>
     * private String adressArt<br>
     * private String strasse<br>
     * private String nummer<br>
     * private Strint ort<br>
     * private String telefon<br>
     * private String fax<br>
     * private String mail<br>
     */
    public Adresse(){
    }//Adresse
    public Adresse(Vector columns){
        this.adressId = Integer.parseInt(columns.elementAt(0).toString());
        this.adressArt = columns.elementAt(1).toString();
        this.userId = columns.elementAt(2).toString();
        this.strasse = columns.elementAt(3).toString(); 
        this.nummer = columns.elementAt(4).toString();
        this.plz = columns.elementAt(5).toString();
        this.ort = columns.elementAt(6).toString();
        this.land = columns.elementAt(7).toString();
        
        this.telefon = columns.elementAt(8).toString();
        this.fax = columns.elementAt(9).toString();
        this.mail = columns.elementAt(10).toString();
        
        this.createUserId = columns.elementAt(11).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(12).toString());
        this.changeUserId = columns.elementAt(13).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(14).toString());
    }//Adresse
    
    
	/**
	 * @return Returns the adressArt.
	 */
	public String getAdressArt() {
		return adressArt;
	}
	/**
	 * @param adressArt The adressArt to set.
	 */
	public void setAdressArt(String adressArt) {
		this.adressArt = adressArt;
	}
	/**
	 * @return Returns the adressId.
	 */
	public int getAdressId() {
		return adressId;
	}
	/**
	 * @param adressId The adressId to set.
	 */
	public void setAdressId(int adressId) {
		this.adressId = adressId;
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
	 * @return Returns the fax.
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax The fax to set.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return Returns the land.
	 */
	public String getLand() {
		return land;
	}
	/**
	 * @param land The land to set.
	 */
	public void setLand(String land) {
		this.land = land;
	}
	/**
	 * @return Returns the mail.
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail The mail to set.
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return Returns the nummer.
	 */
	public String getNummer() {
		return nummer;
	}
	/**
	 * @param nummer The nummer to set.
	 */
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	/**
	 * @return Returns the ort.
	 */
	public String getOrt() {
		return ort;
	}
	/**
	 * @param ort The ort to set.
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}
	/**
	 * @return Returns the plz.
	 */
	public String getPlz() {
		return plz;
	}
	/**
	 * @param plz The plz to set.
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}
	/**
	 * @return Returns the strasse.
	 */
	public String getStrasse() {
		return strasse;
	}
	/**
	 * @param strasse The strasse to set.
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	/**
	 * @return Returns the telefon.
	 */
	public String getTelefon() {
		return telefon;
	}
	/**
	 * @param telefon The telefon to set.
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	/**
	 * @return Returns the userId.
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}//class Adresse
