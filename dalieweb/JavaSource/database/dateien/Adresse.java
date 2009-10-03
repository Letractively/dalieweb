/*
 * Created of DV0101 on 04.05.2009 07:34:16
 *
 * Filename	  Adresse.java
 */
package database.dateien;

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
    /** Strasse */
    private String strasse = "";//strasse Wilhelm Pieck Straﬂe
    /** Nummer der Strasse */
    private String nummer = "";//nummer 16
    /** PLZ vom Ort */
    private String plz = "";//plz 6902
    /** Ort */
    private String ort = "";//ort Jena
    /** Telefon */
    private String telefon = "";//04711/4711
    /** Fax */
    private String fax = "";//04711/4799
    /** @MailAdresse */
    private String mail = "";//xyz@mailto.de
    
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
    }//construktor
    public Adresse(Vector columns){
        this.adressId = Integer.parseInt(columns.elementAt(0).toString());
        this.adressArt = columns.elementAt(1).toString();
        this.strasse = columns.elementAt(2).toString(); 
        this.nummer = columns.elementAt(3).toString();
        this.plz = columns.elementAt(4).toString();
        this.ort = columns.elementAt(5).toString();
        this.telefon = columns.elementAt(6).toString();
        this.fax = columns.elementAt(7).toString();
        this.mail = columns.elementAt(8).toString();
    }//construktor
    
    
    
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
}//class Adresse
