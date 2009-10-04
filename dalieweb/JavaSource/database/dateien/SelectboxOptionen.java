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
     * @return Returns the optionDescription.
     */
    public String getOptionDescription() {
        return optionDescription;
    }
    /**
     * @return Returns the optionId.
     */
    public String getOptionId() {
        return optionId;
    }
    /**
     * @return Returns the optionValue.
     */
    public String getOptionValue() {
        return optionValue;
    }
}//class SelectboxOptionen
