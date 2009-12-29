package database.dateien;

import java.util.Vector;

/**
 * @author dv0101 am 08.01.2009 um 20:48:56
 * <br>
 * <b>SelectboxOptionen</b><br>
 * private String value<br>
 * private String description<br>
 * private String createUserId<br>
 * private String createDate<br>
 * private String changeUser<br>
 * private String changeDate<br>
 * <br>
 * SelectboxOption<br>
 * option value='value' and description<br>
 * option value='value' and description
 */
public class SelectboxOptionen {

	private String optionId;//AA = erzeuge alle Optionen zur OptionsId AA
    private String optionValue;//eine Option könnte sein KA 
    private String optionDescription;//keine Auswahl [Bitte Auswählen]
    
    private String createUserId;//DV0101 AnmeldeKennnung am System
    private String createDate;//Datum der Erstellung
    private String changeUserId;//DV0101 AnmeldeKennnung am System
    private String changeDate;//Datum der letzten Änderung
    
    /**
     * <b>SelectboxOptionen</b><br>
     * private String value<br>
     * private String description<br>
     * private String createUserId<br>
     * private String createDate<br>
     * private String changeUserId<br>
     * private String changeDate<br>
     */
    public SelectboxOptionen() {
    }//SelectboxOptionen
    public SelectboxOptionen(Vector columns) throws Exception {       
        this.optionId = columns.elementAt(2).toString();
        this.optionValue = columns.elementAt(3).toString();
        this.optionDescription = columns.elementAt(4).toString();
        this.createUserId = columns.elementAt(5).toString();
        this.createDate = columns.elementAt(6).toString();
        this.changeUserId = columns.elementAt(7).toString();
        this.changeDate = columns.elementAt(8).toString();
    }//SelectboxOptionen
    
    
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
	 * @return Returns the optionDescription.
	 */
	public String getOptionDescription() {
		return optionDescription;
	}
	/**
	 * @param optionDescription The optionDescription to set.
	 */
	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}
	/**
	 * @return Returns the optionId.
	 */
	public String getOptionId() {
		return optionId;
	}
	/**
	 * @param optionId The optionId to set.
	 */
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	/**
	 * @return Returns the optionValue.
	 */
	public String getOptionValue() {
		return optionValue;
	}
	/**
	 * @param optionValue The optionValue to set.
	 */
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
}//class SelectboxOptionen
