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
 * <b>Class</b> DokumentNavTag<br>Zeige alle die Listenelemente wie <li>Arbeitsanweisung<li>Formulare,<br><br> 
 * zu dem der User Dokumente erfasst hat.<br><br>
 * <b>Attribute</b><li>current -> die Auswahl des Dokumenttyps die der User gerade betrachtet.<br>
 * <br>
 * @version 1.00 on 18.10.2009 um 09:34:40
 * @author Administrator
 */
public class DokumentNavTag extends TagSupport {
	 /* this Objekt create a <hmtl-list> to use of navitation on selinas  */
	
	private Database dbConn;
    private SelinasUser selinasuser;
    private SelinasSession show;
    private Dokument memory;
    private Dokument dokumentOfSession;
    private String language;
    
    /** separator " */
    final String FB = "\"";//wird als " interpretiert    
    /** to find some Dokument is aktiv  */
	private Dokument current = null;
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
            			if (session.getAttribute("Dokument") != null){
            				dokumentOfSession = (Dokument)session.getAttribute("Dokument");
               
                try {
                 	JspWriter out = pageContext.getOut();
                 	try{
                        dbConn.getConnection();
                        /* finde den DokumentTyp zum Dokument aus der UserSession */
                        Typ typOfDokument = DataSetTyp.chain(dbConn,dokumentOfSession);
                        ulli = "<ul><li><a href='/dalieweb/GoToStartServlet?selectTyp=UB' title='zurück zur Übersicht'>" +
                        		"<span>"+ show.session.getLink1() +"</span></a></li> " +
                        		"<li>"+ typOfDokument.getDescription() +"</li>";
                        int counter = 2;
                        try{
                        	/* lese alle Dokumente zum gefundenen DokumentTyp  */
                        	Vector dokuments  = DataSetDokument.reade(dbConn, selinasuser.user,typOfDokument.getTyp());
                        	for(int x = 0; x < dokuments.size();x++){
                        		if(x == 0){//erster Satz des gefunden Dokumentes
                        			memory = (Dokument)dokuments.elementAt(0);//speichern
                        			/* ListenElemete ausgeben: Typ,erstes Dokument 
                        			und derzeitiges Verarbeitungsdokument, wird gebraucht um CSS-Eigenschaften zusetzten. */
                        			writeDokumentDataToPageContext((Dokument)dokuments.elementAt(0),current);
                        			counter ++;
                        		}else{
                        			/* Dokument nur ausgben -> wenn DokumentNr gewechselt hat. */
                        			if(memory.getNummer() != ((Dokument)dokuments.elementAt(x)).getNummer()){
                        				/* ListenElemete ausgeben: gelesenes Dokument 
	                        			und derzeitiges Verarbeitungsdokument, wird gebraucht um CSS-Eigenschaften zusetzten. */
                        				writeDokumentDataToPageContext((Dokument)dokuments.elementAt(x),current);
                        				counter ++;
                        			}//endif
                        			memory = (Dokument)dokuments.elementAt(x);//verarbeitets Dokument wieder merken
                        		}//endif
                        	}//for
                        	while(counter <= 8) {//minimum 5 ListenElemente
                        		ulli = ulli + "<li>&nbsp;</li>";
                                counter ++;
                                }//while
                        }catch(Exception e){
                        	out.println(ulli);
                        }//try
                        dbConn.close();
                 		}catch(Exception e){//no DokumentTypen found
                 			out.println("<ul><li><a href='/dalieweb/GoToStartServlet?selectTyp=UB' title='zurück zur Übersicht'><span>"+ show.session.getLink1() +"</span></a></li>");
                 		}//catch    
                        out.println(ulli);
                 		return EVAL_BODY_INCLUDE;//Evaluate body into existing out stream, and start next with doEndTag()
                 		
                	} catch (Exception e) {
                		throw new JspException("Create of ListContent "
                				+ " Exception " + e.getMessage()
								+ " is not vaild");
                	}//try 
                	
            			} else {
                        	throw new JspException("SelinasSession object in session "
                        		+ session.getAttribute("Dokument")
                                + " has not the valid type");
                    	}//session.getAttribute("Selinas") 
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
	
    /** To find the internal state */
    public void release() {
        /* Der JSP-Container ruft die Methode release() auf, um den  */
        /* internen Zustand der Aktionsklasse zurückzusetzen. */
      dbConn = null;
      selinasuser = null;
      current = null;
      language = null;
      super.release();
    }//release
    
    /** @param Dokument current */
	public void setCurrent(Dokument dokument) {
		current = dokument;
	}//setData
    
    /** Writes Dokument-Informations for one Dokument to the page body */
	private String writeDokumentDataToPageContext1(Typ typ,Dokument dokument,Dokument current) {
		if(dokument.getNummer() == current.getNummer()){
			ulli = ulli + "<li class='current'><img src='/dalieweb/bilder/arrow.gif'/>&nbsp;"+ dokument.getNummer()+"." + dokument.getId() + ".&nbsp;&nbsp;"+ dokument.getTitel() + "</li>";
		}else{
			ulli = ulli + "<li><a href='/dalieweb/DokumentToRequestServlet?dokumentTyp="+dokument.getDokumentTyp()+"&amp;dokumentNr="+dokument.getNummer()+"&amp;dokumentId="+dokument.getId()+"' target='_parent'>"+ + dokument.getNummer() +"."+ dokument.getId()+ "&nbsp;&nbsp;"+ dokument.getTitel()  + "</a></li>";
		}//endif
	   return ulli;	
	}//writeDokumentDataToPageContext1
	
	/** Writes Dokument-Informations for one Dokument to the page body */
	private String writeDokumentDataToPageContext(Dokument dokument, Dokument current) {
		if(dokument.getNummer() == current.getNummer()){	
			ulli = ulli + "<li class='current'><img src='/dalieweb/bilder/arrow.gif' title='standpunkt' alt='standpunkt'/>&nbsp;&nbsp;"+ dokument.getNummer()+ "." + dokument.getId()+ "&nbsp;&nbsp;"+ dokument.getTitel()  + "</li>";
		}else{
			ulli = ulli + "<li><a href='/dalieweb/DokumentToRequestServlet?dokumentTyp="+dokument.getDokumentTyp()+"&amp;dokumentNr="+dokument.getNummer()+"&amp;dokumentId="+dokument.getId()+"' target='_parent'>"+ + dokument.getNummer() +"."+ dokument.getId()+ "&nbsp;&nbsp;"+ dokument.getTitel()  + "</a></li>";
		}
	    return ulli;	
	}//writeDokumentDataToPageContext2

}//class DokumentNavTag
