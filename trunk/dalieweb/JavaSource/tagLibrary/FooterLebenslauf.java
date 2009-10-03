/*
 * Created of DV0101 on 31.05.2009 15:13:38
 *
 * Filename	  Footer.java
 */
package tagLibrary;

import help.HelpDate;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Print the Content of Footer for Lebenslauf.
 *
 * @version 	1.00 31.05.2009 um 15:13:38
 * @author 		DV0101
 * <br>
 */
public class FooterLebenslauf extends TagSupport {

    /** Content of Footer */
    public int doStartTag() {
        try {
            JspWriter out = pageContext.getOut();
            out.println("<p>Copyright &#169; "+ HelpDate.getJJJJ()+" Uwe Dalies</p>");
            return EVAL_PAGE;
            }catch(Exception e) {
                return SKIP_PAGE;//End of Processing        
            }//catch
    }//doStartTag
    
}//class Footer
