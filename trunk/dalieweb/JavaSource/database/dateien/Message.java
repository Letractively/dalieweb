/*
 * Created of DV0101 on 01.05.2009 20:09:01
 *
 * Filename	  Message.java
 */
package database.dateien;

import help.HelpDate;

import java.util.Vector;


/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 20:09:01
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Message {
    
    /** Typ of Error (E)rror or (W)arnig */
    private String errorTyp = "";//(E)rror or (W)aring
    /** Messagetext of Error */
    private String errorMsg = "";// Error Text 

    /** User of create this Objekt*/
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp of create*/
    private String createDate;//Datum der Erstellung
    /** User of last modifikation */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp of last modifikation */
    private String changeDate;//Datum der letzten Änderung
    /**
     * <b>Message</b><br><br>
     * private String errorTyp<br>
     * private String errorMsg<br>	
     */
    public Message(){
    }//Message
    public Message(Vector columns){
        this.errorTyp = columns.elementAt(2).toString();
        this.errorMsg = columns.elementAt(3).toString();
        
        this.createUserId = columns.elementAt(4).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(5).toString());
        this.changeUserId = columns.elementAt(6).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(7).toString());
    }//Message
    
    
    
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
     * @return Returns the errorMsg.
     */
    public String getErrorMsg() {
        return errorMsg;
    }
    /**
     * @param errorMsg The errorMsg to set.
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    /**
     * @return Returns the errorTyp.
     */
    public String getErrorTyp() {
        return errorTyp;
    }
    /**
     * @param errorTyp The errorTyp to set.
     */
    public void setErrorTyp(String errorTyp) {
        this.errorTyp = errorTyp;
    }
}//class Message
