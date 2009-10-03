/*
 * Created of DV0101 on 02.10.2009 07:31:51
 *
 * Filename	  LogProcessingTimeFilter.java
 */
package help;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Class description goes here.
 *
 * @version 	1.00 02.10.2009 um 07:31:51
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class LogProcessingTimeFilter implements Filter {

    // Instanzvariable zum Speichern der Filterkonfiguration deklarieren
    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
      this.filterConfig = filterConfig;
    }//init

    public void destroy() {
      filterConfig = null; 
    }//destroy

    public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException,ServletException {
      // Zeit vor der Bearbeitung der Anfrage erfassen
      long startTime = System.currentTimeMillis();
      // Nächsten Filter aufrufen
      chain.doFilter(request, response);
      // Zeit nach der Bearbeitung der Anfrage erfassen
      long endTime = System.currentTimeMillis();
      
      // Aufgerufene URL ermitteln
      String url = "";
      if (request instanceof HttpServletRequest) {
          url = ((HttpServletRequest) request).getRequestURI();
      }//endif

      // Aufgerufene URL mit Bearbeitungszeit ausgeben
      filterConfig.getServletContext().log("Bearbeituntszeit der URL: " + url + (endTime - startTime)+ " ms");
    }//doFilter
  }//class LogProcessingTimeFilter
