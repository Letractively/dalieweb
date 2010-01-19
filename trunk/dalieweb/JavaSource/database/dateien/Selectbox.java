package database.dateien;

import java.util.Vector;

import database.Database;
import database.getDatabase.DataSetSelectOptionen;

/**
 * @author dv0101 am 08.01.2009 um 20:30:10
 * <br>
 * <b>Selectbox</b><br><br>
 * private int kundenId<br>
 * private int standortId<br>
 * private String selectbox<br>
 * private String sprachId<br>
 * private Vector optionen<br>
 * private String createUserId<br>
 * private String createDate<br>
 * private String changeUser<br>
 * private String changeDate<br>
 * 
 */
public class Selectbox {
    
    private int kundenId;//KundenNr 04711
    private int standortId;//Standort 2
    private String selectbox;//Selectbox:Formular oder Selectbox:Sprache
    private String sprachId;//SprachId in welcher die Selectbox betrieben werden soll EN = englisch oder in DE = deutsch
    /**
     * Vector optionen wird aus dem 
     * Objekt SelectboxOptionen erstellt.<br>
     * Dazu wird die keyOption übergeben.
     * Eine keyOptionValue wäre z.B. KA = Bitte auswählen
     */
    public Vector optionen;//alle SelectboxOptionen:<option value='KA'>[Bitte auswählen]</option><option value='AA'>Arbeitsanweisung</option>

    private String createUserId;//DV0101 AnmeldeKennnung am System
    private String createDate;//Datum der Erstellung
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    private String changeDate;//Datum der letzten Änderung
    
    /**
     * <b>Selectbox</b><br>
     * private int kundenId<br>
     * private int standortId<br>
     * private String selectbox<br>
     * private String sprachId<br>
     * private Vector optionen<br>
     * private String createUserId<br>
     * private String createDate<br>
     * private String changeUserId<br>
     * private String changeDate<br>
     */
    public Selectbox(){
    }//Selectbox
    public Selectbox(Database dbConn, Vector columns, String keyOption) throws Exception {       
        this.kundenId = Integer.parseInt(columns.elementAt(0).toString());
        this.standortId = Integer.parseInt(columns.elementAt(1).toString());
        this.selectbox = columns.elementAt(2).toString();
        this.sprachId = columns.elementAt(3).toString();
        this.optionen = DataSetSelectOptionen.chain(dbConn,this.selectbox,this.sprachId, keyOption);
        this.createUserId = columns.elementAt(4).toString();
        this.createDate = columns.elementAt(5).toString();
        this.changeUserId = columns.elementAt(6).toString();
        this.changeDate = columns.elementAt(7).toString();
    }//Selectbox
    
    
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
	 * @return Returns the optionen.
	 */
	public Vector getOptionen() {
		return optionen;
	}
	/**
	 * @param optionen The optionen to set.
	 */
	public void setOptionen(Vector optionen) {
		this.optionen = optionen;
	}
	/**
	 * @return Returns the selectbox.
	 */
	public String getSelectbox() {
		return selectbox;
	}
	/**
	 * @param selectbox The selectbox to set.
	 */
	public void setSelectbox(String selectbox) {
		this.selectbox = selectbox;
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
}//class Selectbox
