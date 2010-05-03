/*
 * Created of DV0101 on 09.04.2010 10:09:48
 *
 * Filename	  SelinasNavTag.java
 */
package tagLibrary;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import database.dateien.Selinas;

import selinas.SelinasModul;
import selinas.SelinasUser;
import selinas.bean.SelinasSession;

/**
 * TagSupport -> Auswahl der Module ermöglichen.
 *
 * @version 	1.00 09.04.2010 um 10:09:48
 * @author 		DV0101
 * <br><br>
 */
public class SelinasNavTag extends TagSupport {
	/* Anzeige Name des User's und Auswahl der Module ermöglichen. */

	private SelinasModul modulTyp;
	private SelinasUser selinasuser;
	private SelinasSession show;
	
	public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        if (session.getAttribute("SelinasModul") != null) {
            modulTyp = (SelinasModul) session.getAttribute("SelinasModul");    
            
            if (session.getAttribute("User") != null) {
                selinasuser = (SelinasUser) session.getAttribute("User");
            
                if (session.getAttribute("Selinas") != null) {
        			show = new SelinasSession((Selinas) session.getAttribute("Selinas")); 
            try {
                JspWriter out = pageContext.getOut();
                	out.println("<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'99%\'" +
                		"style=\'margin-top: 4px; \'><tr>" +
                		"<td valign=\'middle\' align=\'left\' style=\'border-color: #B2BCC6;" +
						"border-bottom-width: 0px;" +
						"border-right-width: 0px;" +
						"border-left-width: 0px;" +
						"border-top-width: 0px;" +
						"border-style: solid;" +
						"margin: 0px 0px;" +
						"padding: 0px 0px;\'></td>" +
						"<td valign=\'middle\' align=\'right\' " +
						"style=\'border-color: #B2BCC6;" +
						"border-bottom-width: 0px;" +
						"border-right-width: 0px;" +
						"border-left-width: 0px;" +
						"border-top-width: 0px;" +
						"border-style: solid;" +
						"margin: 0px 0px;" +
						"padding: 0px 0px;\'>" + 
							"<table cellspacing=\'0\' cellpadding=\'0\'><tr>" +
								"<td style=\'border-top: 1px solid #90AFD4; " +
								"border-right: 0px solid #0C2E9E; " +
								"border-bottom: 1px solid #0C2E9E; " +
								"border-left: 1px solid #90AFD4; " +
								"background-color: #D6D8BA;\'>&nbsp;&nbsp;</td>" +
								"<td style=\'" +
								"font: bold 10px Helvetica, sans-serif;"+
								"color: #2D5893;" +
								"background-color: #D6D8BA;" +
								"border-top: 1px solid #90AFD4;" +
								"border-bottom: 1px solid #0C2E9E; " +
								"border-left: 0px solid #0C2E9E; " +
								"padding-right: 4px;" +
								"margin: 0px; \'>"+ selinasuser.user.getName() + "," + selinasuser.user.getVorname() + "</td>" +
								"<td valign=\'middle\' align=\'left\' style=\'border-color: #B2BCC6;" +
								"border-bottom-width: 0px;" +
								"border-right-width: 0px;" +
								"border-left-width: 0px;" +
								"border-top-width: 0px;" +
								"border-style: solid;\'>" +
								"<img id=\'show1\' src=\'./bilder/spacer.gif\' class=\'admin3\' alt=\'\' title=\'\'/>" +
									"<div id=\'panel1\' style=\'border: 1px solid #7992B8;\'>" +
										"<div class=\'hd\' style=\'border-left: 1px solid #7992B8; border-bottom: 1px solid #7992B8;\'><img src='/dalieweb/bilder/arrow.gif' title='"+show.session.getImage1()+"' alt='"+show.session.getImage1()+"'/>&nbsp;&nbsp;Navigation</div>" +
										"<div class=\'bd\' style=\'border-left: 1px solid #7992B8; border-right: 1px solid #0C2E9E;\'>" +
										"<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' width=\'99%\'>" +
										"<tr><td style=\' border-color: #B2BCC6;" +
								"border-bottom-width: 0px;" +
								"border-right-width: 0px;" +
								"border-left-width: 0px;" +
								"border-top-width: 0px;" +
								"border-style: solid; \'> <a href='/dalieweb/AdminOfSelina' title='"/* Selinas:LINK2 Administration von Selina */+ show.session.getLink3t() +"' target=\'_self\'><span>"+show.session.getLink3()+"</span></a></td></tr>" +
										"<tr><td style=\'border-color: #B2BCC6;" +
								"border-bottom-width: 0px;" +
								"border-right-width: 0px;" +
								"border-left-width: 0px;" +
								"border-top-width: 0px;" +
								"border-style: solid;\'> <a href='/dalieweb/LogOnImmobilienToInitialize' title='"/* Selinas:LINK2 Administration von Selina */+ show.session.getLink3t() +"' target=\'_self\'><span>"+show.session.getLink3()+"</span></a></td></tr>" +
										"<tr><td style=\'border-color: #B2BCC6;" +
								"border-bottom-width: 0px;" +
								"border-right-width: 0px;" +
								"border-left-width: 0px;" +
								"border-top-width: 0px;" +
								"border-style: solid;\'>&nbsp;</td></tr>" +
										"<tr><td style=\'border-color: #B2BCC6;" +
								"border-bottom-width: 0px;" +
								"border-right-width: 0px;" +
								"border-left-width: 0px;" +
								"border-top-width: 0px;" +
								"border-style: solid;\'> <a href=\'/dalieweb/LogOffSelina\' target=\'_self\' class=\'link\'>Log off</a></td></tr>" +
										"</table></div>" +
									"</div>" +
								"</td>" +
							"</tr></table>" +
						"</td></tr></table>"); 
                	return EVAL_BODY_INCLUDE;//Evaluate body into existing out stream
            	} catch (Exception e) {
            		throw new JspException(e.getMessage());
            	}//catch
            	
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
        	throw new JspException("SelinasModul object in session "
        			+ session.getAttribute("SelinasModul")
					+ " has not the valid type");
        }//session.getAttribute("SelinasModul")
        
    }//doStartTag
	
}//class SelinasNavTag
