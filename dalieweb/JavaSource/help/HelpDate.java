/*
 * Created of DV0101 on 01.05.2009 19:10:32
 *
 * Filename	  HelpDate.java
 */
package help;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.time.DateFormatUtils;

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
    
    static public String getTT_MMMM_JJJJ(String dbDate) {
    	SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyy");
    	df.setLenient(false);
    	Date date = null;
		try {
			date = df.parse(dbDate.substring(8, 10) + "." + dbDate.substring(5, 7) + "."
			        + dbDate.substring(0, 4));
		} catch (ParseException e) {
			System.err.println(e.getMessage() + dbDate.substring(8, 10) + "." + dbDate.substring(5, 7) + "."
			        + dbDate.substring(0, 4));
		}
    	return DateFormatUtils.format(date,"dd.MMMM.yyyy");
    }//getTT_MM_JJJJ
   
    static public String getTT_MMMM_JJJJ_HHMMSS(String dbDate) {
    	SimpleDateFormat df = new SimpleDateFormat("dd.MMMM.yyyy");
    	df.setLenient(false);
    	Date date = null;
		try {
			date = df.parse(dbDate + " 12:12:12");
		} catch (ParseException e) {
			Calendar cal = Calendar.getInstance();
	    	return DateFormatUtils.format(cal.getTime(),"yyyy-MM-dd HH:mm:ss");
		}
    	return DateFormatUtils.format(date,"yyyy-MM-dd HH:mm:ss");
    }//getTT_MM_JJJJ_HHMMSSDB
    
    static public String getTT_MMMM_JJJJ_HHMMSS() {
    	Calendar cal = Calendar.getInstance();
    	return DateFormatUtils.format(cal.getTime(),"yyyy-MM-dd HH:mm:ss");
    }//getTT_MM_JJJJ_HHMMSSDB
    
}//class HelpDate
