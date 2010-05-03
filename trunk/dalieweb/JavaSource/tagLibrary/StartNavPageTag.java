/*
 * Created of DV0101 on 03.05.2010 07:41:32
 *
 * Filename	  StartNavPageTag.java
 */
package tagLibrary;

import help.HelpString;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import selinas.SelinasUser;
import selinas.bean.SelinasSession;
import database.Database;
import database.dateien.Dokument;
import database.dateien.Selinas;
import database.getDatabase.DataSetDokument;


/**
 * <b>Class</b> StartNavPageTag<br>Zeige alle die Listenelemente wie <li>1.1 Titel<li>2.1 Titel,<br><br> 
 * zu dem der User Dokumente erfasst hat.<br><br>
 * <b>Attribute</b><li>current -> die Auswahl des Dokumenttyps die der User gerade betrachtet.<br>
 * <br>
 * @version 1.00 on 03.05.2010 um 07:41:32
 * @author DV0101
 */
public class StartNavPageTag extends TagSupport {
	 /* this Objekt create a <hmtl-list> to use of navitation on startpage selinas  */
	
	private Database dbConn;
    private SelinasUser selinasuser;
    private SelinasSession show;
    private Dokument dokumentOfSession;
    private String language;
    private String selectTyp;
            int counter = 0;
    
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
            			
                try {
                 	JspWriter out = pageContext.getOut();
            		if(((String)session.getAttribute("SelectTyp")).equalsIgnoreCase("UB")){//Element Übersicht is aktiv
            			/* Initialize of String */
            			counter = 9;
            			return SKIP_PAGE;//Skip the rest of the page.
            		}else{
            			try{
            				counter = 0;
            				ulli = "<div id=\"navigationPage\"><ul>";
            				dbConn.getConnection();
            				/* Suche Dokumente zum ausgewählten Dokumenttyp -> gefundenen schreibe ein Listenelemente an den htmlContent */
            				writeDokumentDataToPageContext(DataSetDokument.reade(dbConn,selinasuser.user,DataSetDokument.chain(dbConn, selinasuser.user,(String)session.getAttribute("SelectTyp")),"G"));
            				dbConn.close();
            			}catch(Exception e){
            				System.out.println("Hinweis: keine Dokumente zum dokumentOfSession gefunden");
            			}//try
            		}//endif
            		
                    while(counter <= 8) {//minimum 8 ListenElemente
                    	ulli = ulli + "<li>&nbsp;</li>";
                       	counter ++;
                    }//while
                       	
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
            out.println("</ul></div><!-- /navigationPage -->");
            	return EVAL_PAGE;//Continue evaluating the page.
            }catch(IOException iex) {
                return SKIP_PAGE;//Skip the rest of the page.
            }//catch
    }//doEndTag
	
	/** To find the internal state */
    public void release() {
    	dbConn = null;
    	selinasuser = null;
    	show = null;
    	selectTyp = null;
    	language = null;
    	ulli = null;
       super.release();
    }//release
	
    /** Writes Dokument-Informations for one Dokument to the page body */
	private String writeDokumentDataToPageContext(Vector dokuments) {
		for(int i = 0; i <= dokuments.size(); i++){
			Dokument dokument = (Dokument)dokuments.elementAt(i);
			if(dokument.getId() == 1){
			ulli = ulli + "<li><a href='/dalieweb/DokumentToRequestServlet?dokumentTyp="+dokument.getTyp()+"&amp;dokumentNr="+dokument.getNummer()+"&amp;dokumentId="+dokument.getId()+"' target='_parent'>"+ + dokument.getNummer() +"."+ dokument.getId()+ "&nbsp;&nbsp;"+ HelpString.collapseSpacesWP(dokument.getTitel(),12) + "</a></li>";
            counter ++;
			}
		}//for
	    return ulli;	
	}//writeDokumentDataToPageContext
	
}//class StartNavTag
