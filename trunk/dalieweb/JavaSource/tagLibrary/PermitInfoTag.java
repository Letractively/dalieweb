/*
 * PermitInfoTag.java 
 * @author DV0101 on 14.02.2010 um 09:32:30 
 */
package tagLibrary;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import selinas.SelinasUser;
import database.Database;
import database.dateien.Dokument;
import database.dateien.User;
import database.getDatabase.DataSetUser;

/**
 * <b>Class</b> PermitInfoTag<br>Table of User<br>
 * <b>Attribute</b><li>Database<li>User<li>Selinas<li>farbe<li>header<li>data<li>tableTagClass<br>
 * 
 * @version 1.00 on 14.12.2009 um 09:17:24
 * @author Administrator
 */
public class PermitInfoTag extends TagSupport {
	
	private Database dbConn;
    private SelinasUser selinasuser;
    
    /** separator " */
    final String FB = "\"";//wird als " interpretiert
    /** color of Tablerow first row = #FFFFFF second row =#F0FAFF */
    private String[] farbe = {"#FFFFFF","#EEE6D2"};//1.Farbe weiß 2. grau/blau
	/** join for ccsValue  */
	private String tableTagClass = "";
	/** Dokument of Session*/
	private Dokument dokumentOfSession;
	
	
	public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        if (session.getAttribute("Database") != null) {
            dbConn = (Database) session.getAttribute("Database");
            if (session.getAttribute("User") != null) {
                selinasuser = (SelinasUser) session.getAttribute("User");
                
                if (session.getAttribute("Dokument") != null)
    				dokumentOfSession = (Dokument)session.getAttribute("Dokument");
                
                 try {
                 	JspWriter out = pageContext.getOut();
                 	
                 	try{
                        dbConn.getConnection();
                        if(dokumentOfSession.getStatus().equalsIgnoreCase("p"))
                        	out.println("<table cellspacing='0' cellpadding='0' width='100%' class="+ FB+ tableTagClass + FB+ ">"    
                               	+ writeDokumentDataToPageContext(selinasuser.user));
                        else
                       		out.println("<table cellspacing='0' cellpadding='0' width='100%' class="+ FB+ tableTagClass + FB+ ">"                     	
                            		+ writeDokumentDataToPageContext(DataSetUser.reade(dbConn,dokumentOfSession)));
                        dbConn.close();
                 	}catch(Exception e){//no DokumentLinks found
                    	out.println("<table class="+ FB+ tableTagClass + FB+ "><th><td>&nbsp;</td></th>"); 
                    			
                    }//catch    
                        return EVAL_BODY_INCLUDE;//Evaluate body into existing out stream, and start next with doEndTag()
                    
                    } catch (Exception e) {
                        throw new JspException("Create of TableContent "
                                + " Exception " + e.getMessage()
                                + " is not vaild");
                    }//try 
      
            } else {
                throw new JspException("User object in session "
                        + session.getAttribute("User")
                        + " has not the valid type");
            }//session.getAttribute("User")
        } else {
            throw new JspException("Database object in session "
                    + session.getAttribute("Database")
                    + " has not the valid type");
        }//session.getAttribute("Database")
    }//doStartTag
	
	public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();
            out.println("</table>");
            	return EVAL_PAGE;//Continue evaluating the page.
            }catch(IOException iex) {
                return SKIP_PAGE;//Skip the rest of the page.
            }//catch
    }//doEndTag
	
	private String writeDokumentDataToPageContext(User user) throws Exception {
	    String tableTRTD = "";
	    tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[1] + "'>" +
	    "<td>"+ user.getUserId() +"&nbsp;"+user.getName() +","+ user.getVorname() +"&nbsp;&nbsp;</td></tr>";
	    return tableTRTD;	
	}//writeDokumentDataToPageContext
	
	private String writeDokumentDataToPageContext(Vector allUser) throws Exception {
		String tableTRTD = "";
		 for (int i = 0; i < allUser.size(); i++){         
			User user  = ((User)allUser.elementAt(i));
			tableTRTD += "<tr bgcolor='" + farbe[i % 2] + "'><td>"+ user.getUserId() +"&nbsp;"+user.getName() +","+ user.getVorname() +"&nbsp;&nbsp;</td></tr>";
    	 }//for
	    return tableTRTD;	
	}//writeDokumentDataToPageContext
	
	/** To find the internal state */
    public void release() {
        /* Der JSP-Container ruft die Methode release() auf, um den  */
        /* internen Zustand der Aktionsklasse zurückzusetzen. */
      dbConn = null;
      selinasuser = null;
      farbe = null;
      tableTagClass = null;
      dokumentOfSession = null;
      super.release();
    }//release
    
    /** @param String farbe1 for farbe[0] to set. */
    public void setFarbe1(String farbe1) {
		farbe[0] = farbe1;
	}//setFarbe1
    /** @param String farbe2 for farbe[1] to set*/
	public void setFarbe2(String farbe2) {
		farbe[1] = farbe2;
	}//setFarbe2
	/** @param String css for tableTagClass */
	public void setTableTagClass(String css) {
		tableTagClass = css;
	}//setTABLE
	
	
}//class PermitInfoTag
