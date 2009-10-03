/*
 * Created of DV0101 on 01.05.2009 18:37:20
 *
 * Filename	  User.java
 */
package database.dateien;

import help.HelpDate;

import java.util.Vector;

import model.Person;

/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 18:37:20
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class User extends Person {

    private String userId;//DV0101 AnmeldeKennnung am System
    private String userStatus;//aktiv/inkativ
    private String password;//geheim
    private int permitId;//Berechtiung 0 nothing 10 all
    private int kundenId;//KundenNr 04711
    private int standortId;//Standort 2
    private String sprachId;//EN = englisch/DE = deutsch 
    private int selinasId; //Verwaltungs KundenNr 04711
    private int selinasStandortId;//Verwaltungs Standort 2 
   
    /** User of create this Objekt*/
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp of create*/
    private String createDate;//Datum der Erstellung
    /** User of last modifikation */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp of last modifikation */
    private String changeDate;//Datum der letzten Änderung
    /**
     * <b>User</b> extends Person<br><br>
     * private String userId<br>
     * private Adresse userAdresse<br>	
     * private String userStatus<br>
     * private String password<br>
     * private int permitId<br>
     * private int kundenId<br>
     * private String standortId<br>
     * private String sprachId<br>
     * private String createUserId<br>
     * private String createDate<br>
     * private String changeUserId<br>
     * private String changeDate<br>
     */
    public User(){
    }//user
    public User(Vector columns) throws Exception {
        this.userId = columns.elementAt(0).toString();
        this.userStatus = columns.elementAt(1).toString();
        this.password = columns.elementAt(2).toString();
        this.setName(columns.elementAt(3).toString());
        this.setVorname(columns.elementAt(4).toString());
        this.setGeburtstag(HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(5).toString()));
        this.permitId = Integer.parseInt(columns.elementAt(6).toString());
        this.kundenId = Integer.parseInt(columns.elementAt(7).toString());
        this.standortId = Integer.parseInt(columns.elementAt(8).toString());
        this.sprachId = columns.elementAt(9).toString();
        this.selinasId = Integer.parseInt(columns.elementAt(10).toString());
        this.selinasStandortId = Integer.parseInt(columns.elementAt(11).toString());
        
        this.createUserId = columns.elementAt(12).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(13).toString());
        this.changeUserId = columns.elementAt(14).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(15).toString());
    }//user
    
    /**
     * @return Returns the permitId "Berechtiung 0 nothing 10 all".
     */
    public int getPermitId() {
        return permitId;
    }
    /**
     * @return Returns the kundenId "KundenNr 04711".
     */
    public int getKundenId() {
        return kundenId;
    }
    /**
     * @param kundenId The kundenId "KundenNr 04711" to set.
     */
    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }
    /**
     * @return Returns the standortId "Standort 2".
     */
    public int getStandortId() {
        return standortId;
    }
    /**
     * @param standortId The standortId "Standort 2" to set.
     */
    public void setStandortId(int standortId) {
        this.standortId = standortId;
    }
    /**
     * @return Returns the userId "DV0101 AnmeldeKennnung am System".
     */
    public String getUserId() {
        return userId;
    }
    /**
     * @param userId The userId "DV0101 AnmeldeKennnung am System" to set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * @return Returns the selinasId (VerwaltungsId).
     */
    public int getSelinasId() {
        return selinasId;
    }
    /**
     * @param selinasId The selinasId (VerwaltungsId) to set.
     */
    public void setSelinasId(int selinasId) {
        this.selinasId = selinasId;
    }
    /**
     * @return Returns the selinasStandortId.
     */
    public int getSelinasStandortId() {
        return selinasStandortId;
    }
    /**
     * @param selinasStandortId The selinasStandortId to set.
     */
    public void setSelinasStandortId(int selinasStandortId) {
        this.selinasStandortId = selinasStandortId;
    }
    
    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @return Returns the userStatus.
     */
    public String getUserStatus() {
        return userStatus;
    }
}//class User
