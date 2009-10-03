/*
 * Created of DV0101 on 01.05.2009 20:42:59
 *
 * Filename	  Link.java
 */
package database.dateien;

import help.HelpDate;

import java.util.Vector;

/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 20:42:59
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Link {

    /** pfadOfLink = uploade/11K012.pdf */
    private String pfadOfLink;//upload/11KO12.pdf
    /** nameOfLink = original Name of Uploadfile */
    private String nameOfLink;//senderbelegung
    /** contentType = application of UploadFile */
    private String contentType;//application/pdf
    /** sizeInBytes = the value of bytes */
    private long sizeInBytes;//1789 bytes 
    
    
    /** User of create this Objekt*/
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp of create*/
    private String createDate;//Datum der Erstellung
    /** User of last modifikation */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp of last modifikation */
    private String changeDate;//Datum der letzten Änderung
    
    public Link() {
    }//Link
    public Link(Vector columns) throws Exception {       
        this.pfadOfLink = columns.elementAt(5).toString();
        this.nameOfLink = columns.elementAt(6).toString();
        this.contentType = columns.elementAt(7).toString();
        this.sizeInBytes = Long.parseLong(columns.elementAt(8).toString());
        this.createUserId = columns.elementAt(9).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(10).toString());
        this.changeUserId = columns.elementAt(11).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(12).toString());
    }//Link
    
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
     * @return Returns the contentType.
     */
    public String getContentType() {
        return contentType;
    }
    /**
     * @param contentType The contentType to set.
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
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
     * @return Returns the nameOfLink.
     */
    public String getNameOfLink() {
        return nameOfLink;
    }
    /**
     * @param nameOfLink The nameOfLink to set.
     */
    public void setNameOfLink(String nameOfLink) {
        this.nameOfLink = nameOfLink;
    }
    /**
     * @return Returns the pfadOfLink.
     */
    public String getPfadOfLink() {
        return pfadOfLink;
    }
    /**
     * @param pfadOfLink The pfadOfLink to set.
     */
    public void setPfadOfLink(String pfadOfLink) {
        this.pfadOfLink = pfadOfLink;
    }
    /**
     * @return Returns the sizeInBytes.
     */
    public long getSizeInBytes() {
        return sizeInBytes;
    }
    /**
     * @param sizeInBytes The sizeInBytes to set.
     */
    public void setSizeInBytes(long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }
    
}//class Link
