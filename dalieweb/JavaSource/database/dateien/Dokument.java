/*
 * Created of DV0101 on 01.05.2009 19:06:07
 *
 * Filename	  Dokument.java
 */
package database.dateien;

import help.HelpDate;

import java.util.Vector;

/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 19:06:07
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Dokument {

    /** KundenNummer des Dokuments  */
    private int kundenId;//KundenNr = 04711
    /** StandortId */ 
    private int standortId;//Standort 1 zu Kunde 07411
    /** DokuemtenTyp Typ z.b. Arbeitsanweisung */
    private String typ;//Arbeitsanweisung
    /** Nummer des Dokuments */
    private int nummer;//dokumentNr
    /** DokumentenId */
    private int id;//Id des Dokuments
    
    /** Beschreibt den dokumentenStatus (A)ktiv/(I)naktiv */
    private String status;//Status aktiv/inaktiv
    /** Titel */
    private String titel;//Titel des Dokuments
    /** kurze Beschreibung vom Dokument */
    private String descripten;//Beschreibung des Dokument
    /** Textinhalt vom Dokument */
    private String content;//Inhalt Longtext
    /** Gliederung */
    private String gliederung;//Gliederung 1.1 oder 1.2 freiwählbar
    /** Aufbewahrungsort vom Dokument */
    private String archiv;  //Keller oder Tresor
    /** Lagerdauer vom Aufbewahrungsort */
    private String archivDate;// default is heute + 1 Jahr
    /** Vorgabefunktion */
    private String vorgabe; //Ja/nein
    /** SprachId des Dokuments */
    private String sprachId;//Sprachschlüssel des Dokuments
    
    /** Kennzeichen des User der Dokument erstellt hat */
    private String createUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der Erstellung */
    private String createDate;//Datum der Erstellung
    /** Kennzeichen des User der letzten Aenderung */
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    /** Timestamp der letzten Aenderung */
    private String changeDate;//Datum der letzten Änderung
    
    /**
     *<b>Dokument</b><br><br>
     * private String typ<br>
     * private int nummer<br>
     * private int Id<br>
     * private String status<br>
     * private String titel<br>
     * private String descripten<br>
     * private String content<br>
     * private String gliederung<br>
     * private String archiv<br>
     * private String archivDate<br>
     * private String vorgabe<br>
     * private String sprachId<br>
     * private String createUser<br>
     * private String createDate<br>
     * private String changeUser<br>
     * private String changeDate<br>
     */
    public Dokument(){
    }//Dokument
    public Dokument(Vector columns) throws Exception {
        this.kundenId = Integer.parseInt(columns.elementAt(0).toString());
        this.standortId = Integer.parseInt(columns.elementAt(1).toString());
        this.typ = columns.elementAt(2).toString();
        this.nummer = Integer.parseInt(columns.elementAt(3).toString());
        this.id = Integer.parseInt(columns.elementAt(4).toString());
       
        this.status = columns.elementAt(5).toString();
        this.titel = columns.elementAt(6).toString();
        this.descripten = columns.elementAt(7).toString();
        this.content = columns.elementAt(8).toString();
        this.gliederung = columns.elementAt(9).toString();
        this.archiv = columns.elementAt(10).toString();
        this.archivDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(11).toString());
        this.vorgabe = columns.elementAt(12).toString();
        this.sprachId = columns.elementAt(13).toString();
        
        this.createUserId =  columns.elementAt(14).toString();
        this.createDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(15).toString());
        this.changeUserId =  columns.elementAt(16).toString();
        this.changeDate = HelpDate.getTT_MM_JJJJ_HHMMSSDB(columns.elementAt(17).toString());
    }//Dokument  
    
    public boolean getUserckeck(User user){
    	if(this.status.equalsIgnoreCase("P")){
    		if(this.kundenId == user.getKundenId() &&
    			this.standortId == user.getStandortId() &&
				this.createUserId.equalsIgnoreCase(user.getUserId())){
    			return true;
    		}else{
    			return false;
    		}
    	}else{
    		if(this.kundenId == user.getKundenId() &&
        		this.standortId == user.getStandortId() &&
        		Integer.parseInt(this.status) <= user.getUserAutorisierungsId()){
        			return true;
        		}else{
        			return false;
        		}
    	} //endif P
    }//getUser
    
    /**
     * @return Returns the archiv.
     */
    public String getArchiv() {
        return archiv;
    }
    /**
     * @param archiv The archiv to set.
     */
    public void setArchiv(String archiv) {
        this.archiv = archiv;
    }
    /**
     * @return Returns the archivDate.
     * <BR> String of Date with Format TT.MM.JJJJJ
     */
    public String getArchivDate() {
        return archivDate;//01.01.0000;
    }//getArchivDate
    /**
     * @param archivDate The archivDate to set.
     */
    public void setArchivDate(String archivDate) {
        this.archivDate = archivDate;
    }
    /**
     * @return Returns the changeDate.
     * <BR> String of Date with Format TT.MM.JJJJJ
     */
    public String getChangeDate() {
        return changeDate;//01.01.0000
    }//getChangeDate
    /**
     * @return Returns changeUser.
     * <BR> ChangeUser
     */
    public String getChangeUser() {
        return changeUserId;//DV0101
    }//getChangeUser
    /**
     * @return Returns the content.
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content The content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * @return Returns the createDate.
     * <BR> String of Date with Format TT.MM.JJJJJ
     */
    public String getCreateDate() {
        return createDate;//01.01.0000
    }
    /**
     * @param archivDate The archivDate to set.
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    /**
     * @return Returns createUser
     * <BR>CreateUser
     */
    public String getCreateUser() {
        return createUserId;
    }//getCreateUser
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
     * @return Returns the dokumentId.
     */
    public int getId() {
        return id;
    }
	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
    /**
     * @return Returns the dokumentNr.
     */
    public int getNummer() {
        return nummer;
    }
    /**
     * @param dokumentNr The dokumentNr to set.
     */
    public void setNr(int nr) {
        this.nummer = nr;
    }
    
    /**
     * @return Returns the dokumentStatus.
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param dokumentStatus The dokumentStatus to set.
     */
    public void setStatus(String dokumentStatus) {
        this.status = dokumentStatus;
    }
    /**
     * @return Returns the dokumentTyp.
     */
    public String getTyp() {
        return typ;
    }
    
    /**
     * @param dokumentTyp The dokumentTyp to set.
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }
    /**
     * @return Returns the gliederung.
     */
    public String getGliederung() {
        return gliederung;
    }
    /**
     * @param gliederung The gliederung to set.
     */
    public void setGliederung(String gliederung) {
        this.gliederung = gliederung;
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
     * @return Returns the titel.
     */
    public String getTitel() {
        return titel;
    }
    /**
     * @param titel The titel to set.
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }
    /**
     * @return Returns the vorgabe.
     */
    public String getVorgabe() {
        return vorgabe;
    }
    /**
     * @param vorgabe The vorgabe to set.
     */
    public void setVorgabe(String vorgabe) {
        this.vorgabe = vorgabe;
    }
    
}//class Dokument
