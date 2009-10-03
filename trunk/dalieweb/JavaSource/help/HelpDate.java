/*
 * Created of DV0101 on 01.05.2009 19:10:32
 *
 * Filename	  HelpDate.java
 */
package help;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class description goes here.
 *
 * @version 	1.00 01.05.2009 um 19:10:32
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class HelpDate {

    Calendar cal = Calendar.getInstance();

    /**
     * @return das Laufzeit-Datum Format TT.MM.JJJJ HH:MM:SS
     */
    public String getTT_MM_JJJJ_HHMMSS() {
        DateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return formater.format(cal.getTime());
    }//getjjmmyy

    /**
     * @return das Laufzeit-Datum Format JJJJ
     */
    static public String getJJJJ() {
        DateFormat formater = new SimpleDateFormat("yyyy");
        return formater.format(Calendar.getInstance().getTime());
    }//getJJJJ

    static public String getTT_MM_JJJJ_HHMMSSDB(String dbDate) {
        return dbDate.substring(8, 10) + "." + dbDate.substring(5, 7) + "."
                + dbDate.substring(0, 4) + " um " + dbDate.substring(11, 19);
    }//getTT_MM_JJJJ_HHMMSSDB

}//class HelpDate
