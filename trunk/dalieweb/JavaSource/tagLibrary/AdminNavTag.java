/*
 * StartNavTag.java 
 * @author Administrator on 16.11.2009 um 14:40:10 
 */
package tagLibrary;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import selinas.SelinasUser;
import selinas.bean.SelinasSession;
import database.Database;
import database.dateien.Selinas;

/**
 * <b>Class</b> AdminNavTag<br>Zeige alle die Listenelemente wie <li>Adressen<li>User,<br><br> 
 * die ein Selinasuser zum administrieren braucht.<br><br>
 * <b>Attribute</b><li>current -> die Auswahl des Dokumenttyps die der User gerade betrachtet.<br>
 * <br>
 * @version 1.00 on 16.11.2009 um 14:40:10
 * @author Administrator
 */
public class AdminNavTag extends TagSupport {
	 /* this Objekt create a <hmtl-list> to use of navitation on administration selinas  */
	
	private Database dbConn;
    private SelinasUser selinasuser;
    private SelinasSession show;
    private String language;
    private String selectTyp;
    
    /** separator " */
    final String FB = "\"";//wird als " interpretiert
    /** String of HTML-List <ul><li></li></ul> */
	String ulli = "";//htmlContent
	
	public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        if (session.getAttribute("Database") != null) {
            dbConn = (Database) session.getAttribute("Database");
            if(session.getAttribute("Speech") != null){
            	language = (String)session.getAttribute("Speech");     
            	if (session.getAttribute("User") != null) {
            		selinasuser = (SelinasUser) session.getAttribute("User");
            		if (session.getAttribute("Selinas") != null) {
            			show = new SelinasSession((Selinas) session.getAttribute("Selinas")); 
            			
            			/* Initialize of String */
            			ulli = "<ul><li class='current'><a href='/dalieweb/AdminOfServlet?selectTyp=UB' title='Übersicht der Adressverwaltung'><span>Adressverwaltung</span></a></li>";	
            			try {
            				JspWriter out = pageContext.getOut();
            				out.println(ulli);
            				
            				return EVAL_BODY_INCLUDE;//Evaluate body into existing out stream, and start next with doEndTag()
                 		
            			} catch (Exception e) {
            				throw new JspException("Create of ListContent "
                            + " Exception " + e.getMessage()
                            + " is not vaild");
            			}//try 
                
            		} else {
                    	throw new JspException("SelinasSession object in session "
                    		+ session.getAttribute("Selinas")
                            + " has not the valid type");
                	}//session.getAttribute("Selinas")           
            	} else {
            		throw new JspException("User object in session "
                        + session.getAttribute("User")
						+ " has not the valid type");
            	}//session.getAttribute("User")
            } else {
                throw new JspException("Speech object in session "
                        + session.getAttribute("Speech")
                        + " has not the valid type");
            }//session.getAttribute("Speech")
        } else {
            throw new JspException("Database object in session "
                    + session.getAttribute("Database")
                    + " has not the valid type");
        }//session.getAttribute("Database")
    }//doStartTag
	
	public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();
            out.println("</ul>");
            	return EVAL_PAGE;//Continue evaluating the page.
            }catch(IOException iex) {
                return SKIP_PAGE;//Skip the rest of the page.
            }//catch
    }//doEndTag
}//class AdminNavTag
