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
    
    
}//class Selectbox
