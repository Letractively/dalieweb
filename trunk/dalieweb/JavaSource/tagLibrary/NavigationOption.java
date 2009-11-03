/*
 * Created of DV0101 on 15.06.2009 07:34:32
 *
 * Filename	  NavigationOption.java
 */
package tagLibrary;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import lebenslauf.Navigation;

/**
 * Class description goes here.
 *
 * @version 	1.00 15.06.2009 um 07:34:32
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class NavigationOption extends TagSupport {
    
    private Navigation navigation;
    
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        if (session.getAttribute("Navigation") != null) {
            navigation = (Navigation) session.getAttribute("Navigation");    
            try {
                JspWriter out = pageContext.getOut();
                if (navigation.indicator.equals("")) {
                	return Tag.SKIP_BODY; // Ignore body of the tag
                } else {
                    if(navigation.indicator.equalsIgnoreCase("B")) {
                        out.println("<table><tr><td>PERSONENDATEN</td><td class='aktiv'><span style='font-size:17px'><em>B</em></span>ERUFSLAUFBAHN</td><td>BILDUNGSWEG</td><td>PROJEKTE</td><td>LEHRGÄNGE</td><td>PERSÖNLICHES</td></tr></table>");
                    } else if(navigation.indicator.equalsIgnoreCase("K")) {
                        out.println("<table><tr><td class='aktiv'><span style='font-size:17px'><em>P</em></span>ERSONENDATEN</td><td>BERUFSLAUFBAHN</td><td>BILDUNGSWEG</td><td>PROJEKTE</td><td>LEHRGÄNGE</td><td>PERSÖNLICHES</td></tr></table>");
                    } else if(navigation.indicator.equalsIgnoreCase("P")) {
                        out.println("<table><tr><td>PERSONENDATEN</td><td>BERUFSLAUFBAHN</td><td>BILDUNGSWEG</td><td class='aktiv'><span style='font-size:17px'><em>P</em></span>ROJEKTE</td><td>LEHRGÄNGE</td><td>PERSÖNLICHES</td></tr></table>");    
                    } else if(navigation.indicator.equalsIgnoreCase("L")) {
                        out.println("<table><tr><td>PERSONENDATEN</td><td>BERUFSLAUFBAHN</td><td>BILDUNGSWEG</td><td>PROJEKTE</td><td class='aktiv'><span style='font-size:17px'><em>L</em></span>EHRGÄNGE</td><td>PERSÖHNLICHES</td></tr></table>");
                    } else if(navigation.indicator.equalsIgnoreCase("S")) {
                        out.println("<table><tr><td>PERSONENDATEN</td><td>BERUFSLAUFBAHN</td><td>BILDUNGSWEG</td><td>PROJEKTE</td><td>LEHRGÄNGE</td><td class='aktiv'><span style='font-size:17px'><em>P</em></span>ERSÖNLICHES</td></tr></table>");
                    } else if(navigation.indicator.equalsIgnoreCase("A")) {
                        out.println("<table><tr><td>PERSONENDATEN</td><td>BERUFSLAUFBAHN</td><td class='aktiv'><span style='font-size:17px'><em>B</em></span>ILDUNGSWEG</td><td>PROJEKTE</td><td>LEHRGÄNGE</td><td>PERSÖNLICHES</td></tr></table>");
                    }else {
                        out.println("<table><tr><td class='aktiv'>"+navigation.indicator+"</td></tr></table>");
                    }//endif
                return EVAL_BODY_INCLUDE;//Evaluate body into existing out stream
            }//endif message != null
        } catch (Exception e) {
            throw new JspException(e.getMessage());
        }//catch
    } else {
        throw new JspException("Navigation object in session "
                + session.getAttribute("Navigation")
                + " has not the valid type");
    }//session.getAttribute("Database")
    }//doStartTag
}//class NavigationOption
