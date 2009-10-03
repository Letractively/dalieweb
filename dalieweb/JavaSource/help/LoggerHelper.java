/*
 * Created of DV0101 on 10.06.2009 21:56:46
 *
 * Filename	  LoggerHelper.java
 */
package help;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasse zum Protokollieren von Meldungen.
 *
 * @version 	1.00 10.06.2009 um 21:56:46
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class LoggerHelper {

    private static Logger logger;

    /**
     * Liefert eine Logger-Instanz.
     * 
     * @return Logger-Instanz vom Typ <code>Logger</code>
     */
    private static Logger getLogger() {
      if (logger == null) {
        logger = Logger.getLogger("help");
      }//endif
      return logger;
    }//getLogger

    /**
     * Protokolliert einen Fehler.
     * 
     * @param th
     *          <code>Throwable</code> mit dem ausgelösten Fehler
     */
    public static void log(Throwable th) {
      getLogger().log(Level.SEVERE, null, th);
    }//log

    /**
     * Protokolliert einen Fehler und gibt aus, in welcher Klasse und Methode
     * dieser Fehler aufgetreten ist.
     * 
     * @param className
     *          <code>String</code> mit der Klasse, in der der Fehler
     *          aufgetreten ist
     * @param methodName
     *          <code>String</code> mit der Methode, in der der Fehler
     *          aufgetreten ist
     * @param th
     *          <code>Throwable</code> mit dem ausgelösten Fehler
     */
    public static void log(String className, String methodName, Throwable th) {
      getLogger().logp(Level.SEVERE, className, methodName, null, th);
    }//log
    
}//class LoggerHelper
