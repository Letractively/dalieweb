/*
 * DokumentNavTag.java 
 * @author Administrator on 09.11.2009 um 08:34:40 
 */
package tagLibrary;

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
import database.dateien.Typ;
import database.getDatabase.DataSetDokument;
import database.getDatabase.DataSetTyp;


/**
 * <b>Class</b> DokumentNavTag<br>Table of selected Dokuments<br>
 * <b>Attribute</b><li>Database<li>User<li>Selinas<li>farbe<li>header<li>data<li>tableTagClass<br>
 * 
 * @version 1.00 on 18.10.2009 um 09:34:40
 * @author Administrator
 */
public class DokumentNavTag extends TagSupport {
	 /* this Objekt create a <hmtl-list> to use of navitation on selinas  */
	
	private Database dbConn;
    private SelinasUser selinasuser;
    private SelinasSession show;
    
    /** separator " */
    final String FB = "\"";//wird als " interpretiert
    
    /** to find some typ is aktiv  */
	private String current = null;
	
    /** String of HTML-List <ul><li></li></ul> */
	String ulli = "";//htmlContent
    
    
    
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        if (session.getAttribute("Database") != null) {
            dbConn = (Database) session.getAttribute("Database");
            if (session.getAttribute("User") != null) {
                selinasuser = (SelinasUser) session.getAttribute("User");
                if (session.getAttribute("Selinas") != null) {
                	show = new SelinasSession((Selinas) session.getAttribute("Selinas")); 
                    
                	/* Initialize of String */
                	ulli = "<ul><li><a href='/dalieweb/GoToStartServlet' title='zurück zur Übersicht'><span>"+ show.session.getLink1() +"</span></a></li>";
        
                try {
                 	JspWriter out = pageContext.getOut();
           
                 	try{
                        dbConn.getConnection();
                        /* finde alle DokumentTypen zum User */
                        Vector allDokumentTypenOfUser = DataSetTyp.reade(dbConn,selinasuser.user.getKundenId(),selinasuser.user.getStandortId(),"DE");
                        for (int i = 0; i < allDokumentTypenOfUser.size(); i++){
                        	/* get Objekt of DokumentTyp */
                        	Typ typOfDokument = (Typ)allDokumentTypenOfUser.elementAt(i);
                        	
                        	try{
                        		/* Suche Dokumente zum DokumentTyp  */
                        		Vector dokuments  = DataSetDokument.reade(dbConn, selinasuser.user,typOfDokument.getTyp());
                        		/* gefunden -> schreibe ein Listenelemente an den htmlContent */
                				writeDokumentDataToPageContext(typOfDokument,(Dokument)dokuments.elementAt(0),current);	
                        	}catch(Exception e){
                        		System.out.println("Hinweis: keine Dokumente zum Dokumenttyp gefunden");
                        	}//try
                        }//for
                        dbConn.close();
                 	}catch(Exception e){//no DokumentTypen found
                    	out.println("<ul><li><a href='/dalieweb/GoToStartServlet' title='zurück zur Übersicht'><span>"+ show.session.getLink1() +"</span></a></li><li><a href='#' title='zurück zur Startseite'><span>noch ein test</span></a></li>");
                    }//catch    
                 	
                        out.println(ulli + "<li><a href='#' title='muss noch programmiert werden'><span>Support</span></a></li>");
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
	
    /** To find the internal state */
    public void release() {
        /* Der JSP-Container ruft die Methode release() auf, um den  */
        /* internen Zustand der Aktionsklasse zurückzusetzen. */
      dbConn = null;
      selinasuser = null;
      current = null;
      super.release();
    }//release
    
    /** @param String current */
	public void setCurrent(String typ) {
		current = typ;
	}//setData
    
    /**
     * Writes Dokument-Informations for one Dokument to the page body
     */
	private String writeDokumentDataToPageContext(Typ typ,Dokument dokument,String current) {
			if(typ.getTyp().equalsIgnoreCase(current)){
				ulli = ulli + "<li class='current'><a href='/dalieweb/DokumentToRequestServlet?dokumentTyp="+typ.getTyp()+"&amp;dokumentNr="+dokument.getNummer()+"&amp;dokumentId="+dokument.getId()+"' target='_parent'>"+ typ.getDescription() + "</a></li>";
			}else{
				ulli = ulli + "<li><a href='/dalieweb/DokumentToRequestServlet?dokumentTyp="+typ.getTyp()+"&amp;dokumentNr="+dokument.getNummer()+"&amp;dokumentId="+dokument.getId()+"' target='_parent'>"+ typ.getDescription() + "</a></li>";
			}
	    return ulli;	
	}//writeDokumentDataToPageContext

}//class DokumentNavTag
