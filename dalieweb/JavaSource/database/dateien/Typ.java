/*
 * Created of DV0101 on 04.05.2009 07:50:57
 *
 * Filename	  Typ.java
 */
package database.dateien;

import help.HelpDate;

import java.util.Vector;

/**
 * Class description goes here.
 *
 * @version 	1.00 04.05.2009 um 07:50:57
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Typ {
    
    private String typ;//AA
    private String description;// Arbeitsanweisung

    /** Kennzeichen des User der Typ erstellt hat */
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der Erstellung */
    private String createDate;//Datum der Erstellung
    /** Kennzeichen des User der letzten Aenderung */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der letzten Aenderung */
    private String changeDate;//Datum der letzten Änderung
    
    
    public Typ() {
    }//Typ
    public Typ(Vector columns) throws Exception {       
        this.typ = columns.elementAt(2).toString();
        this.description = columns.elementAt(4).toString();
        
        this.createUserId = columns.elementAt(5).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(6).toString());
        this.changeUserId = columns.elementAt(7).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(8).toString());
    }//Typ
    
    
    
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
     * @return Returns the changeUser.
     */
    public String getChangeUser() {
        return changeUserId;
    }
    /**
     * @param changeUser The changeUser to set.
     */
    public void setChangeUser(String changeUserId) {
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
     * @return Returns the createUser.
     */
    public String getCreateUser() {
        return createUserId;
    }
    /**
     * @param createUser The createUser to set.
     */
    public void setCreateUser(String createUserId) {
        this.createUserId = createUserId;
    }
    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return Returns the typ.
     */
    public String getTyp() {
        return typ;
    }
    /**
     * @param typ The typ to set.
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }
}//class Typ
