/*
 * Created of DV0101 on 04.05.2009 08:02:27
 *
 * Filename	  Status.java
 */
package database.dateien;

import help.HelpDate;

import java.util.Vector;

/**
 * Class description goes here.
 *
 * @version 	1.00 04.05.2009 um 08:02:27
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Status {
    
    /** KundenNummer des Status  */
    private int kundenId;//KundenNr = 04711
    /** StandortId */ 
    private int standortId;//Standort 1 zu Kunde 07411
    /** Key of Status */
    private String statusId = "";//(A)ktiv or (I)naktiv
    /** Key Sprachschlüssel */
    private String sprachId;//EN = englisch/DE = deutsch
    /** Beschreibung des Status */
    private String descripten;//Beschreibung des Status

    /** Kennzeichen des User der Status erstellt hat */
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der Erstellung */
    private String createDate;//Datum der Erstellung
    /** Kennzeichen des User der letzten Aenderung */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der letzten Aenderung */
    private String changeDate;//Datum der letzten Änderung
    
    public Status() {
    }//Status
    public Status(Vector columns) {
        //this.kundenId = Integer.parseInt(columns.elementAt(0).toString());
        //this.standortId = Integer.parseInt(columns.elementAt(1).toString());
        this.statusId = columns.elementAt(0).toString();
        this.sprachId = columns.elementAt(1).toString();
        this.descripten = columns.elementAt(2).toString();
        
        this.createUserId =  columns.elementAt(3).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(4).toString());
        this.changeUserId =  columns.elementAt(5).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(6).toString());       
    }//Status
    
    
    
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
     * @return Returns the descripten.
     */
    public String getDescripten() {
        return descripten;
    }
    /**
     * @param descripten The descripten to set.
     */
    public void setDescripten(String descripten) {
        this.descripten = descripten;
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
     * @return Returns the sprachId.
     */
    public String getSprachId() {
        return sprachId;
    }
    /**
     * @param sprachId The sprachId to set.
     */
    public void setSprachId(String sprachId) {
        this.sprachId = sprachId;
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
     * @return Returns the statusId.
     */
    public String getStatusId() {
        return statusId;
    }
    /**
     * @param statusId The statusId to set.
     */
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }
}//class Status
