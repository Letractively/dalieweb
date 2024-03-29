/*
 * StartNavTag.java 
 * @author Administrator on 11.11.2009 um 07:40:34 
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
import database.dateien.Selinas;
import database.dateien.Typ;
import database.getDatabase.DataSetDokument;
import database.getDatabase.DataSetTyp;


/**
 * <b>Class</b> DokumentNavTag<br>Zeige alle die Listenelemente wie <li>Arbeitsanweisung<li>Formulare,<br><br> 
 * zu dem der User Dokumente erfasst hat.<br><br>
 * <b>Attribute</b><li>current -> die Auswahl des Dokumenttyps die der User gerade betrachtet.<br>
 * <br>
 * @version 1.00 on 11.11.2009 um 07:40:34
 * @author Administrator
 */
public class StartNavTag extends TagSupport {
	 /* this Objekt create a <hmtl-list> to use of navitation on startpage selinas  */
	
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
            			            			
                try {
                 	JspWriter out = pageContext.getOut();
            		int counter = 0;
            		if(((String)session.getAttribute("SelectTyp")).equalsIgnoreCase("UB")){//Element �bersicht is aktiv
            			/* Initialize of String */
            			ulli = "<ul><li class='current'><img src='/dalieweb/bilder/arrow.gif' title='"+show.session.getImage1()+"' alt='"+show.session.getImage1()+"'/>&nbsp;&nbsp;<span>"+ show.session.getLink1() +"</span></li>";
            			counter = 2;
            		}else{
            			ulli = "<ul><li><a href='/dalieweb/GoToStartServlet?selectTyp=UB' " +
            					"title='"+show.session.getLink1t()+"'><span>"+ show.session.getLink1() +"</span></a></li>";
            			counter = 1;
            		}//endif
                 	try{
                        dbConn.getConnection();
                        /* finde alle DokumentTypen zum User */
                        Vector allDokumentTypenOfUser = DataSetTyp.reade(dbConn,selinasuser.user.getKundenId(),selinasuser.user.getStandortId());
                        for (int i = 0; i < allDokumentTypenOfUser.size(); i++){
                        	/* get Objekt of DokumentTyp */
                        	Typ typOfDokument = (Typ)allDokumentTypenOfUser.elementAt(i);
                        	
                        	try{
                        		/* Suche Dokumente zum DokumentTyp  */
                        		DataSetDokument.chain(dbConn, selinasuser.user,typOfDokument.getTyp());
                        		/* gefunden -> schreibe ein Listenelemente an den htmlContent */
                				writeDokumentDataToPageContext(typOfDokument,(String)session.getAttribute("SelectTyp"));
                				counter ++;
                        	}catch(Exception e){
                        		System.out.println("Hinweis: kein Dokument zum Dokumenttyp gefunden");
                        	}//try
                        }//for
                        dbConn.close();
                 	}catch(Exception e){//no DokumentTypen found
                    	out.println("<li><a href='/dalieweb/AdminOfSelina' title='"/* Selinas:LINK2 Administration von Selina */+ show.session.getLink3t() +"'><span>"+show.session.getLink3()+"</span></a></li>");
                 	}//catch    
                 	
                       	while(counter <= 8) {//minimum 8 ListenElemente
                       		ulli = ulli + "<li>&nbsp;</li>";
                       		counter ++;
                       	}//while
                       	
                 	if(((String)session.getAttribute("SelectTyp")).equalsIgnoreCase("UB"))
                 		ulli += "<li><a href='/dalieweb/AdminOfSelina' title='"/* Selinas:LINK2 Administration von Selina */+ show.session.getLink3t() +"'><span>"+show.session.getLink3()+"</span></a></li>";
                    
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
	
	 /**
     * Writes Dokument-Informations for one Dokument to the page body
     */
	private String writeDokumentDataToPageContext(Typ typ,String current) {
		if(typ.getTyp().equalsIgnoreCase(current)){
			ulli = ulli + "<li class='current'><img src='/dalieweb/bilder/arrow.gif' title='"+show.session.getImage1()+"' alt='"+show.session.getImage1()+"'/>&nbsp;&nbsp;"+ HelpString.collapseSpacesWP(typ.getDescription(),19) + "</li>";
		}else{
			ulli = ulli + "<li><a href='/dalieweb/GoToStartServlet?selectTyp="+typ.getTyp()+"' title='"/* Selinas:LINK2 Auswahl nach Dokumenttyp */+ show.session.getLink2t() + typ.getDescription()+"' target='_parent'>"+ HelpString.collapseSpacesWP(typ.getDescription(),19) + "</a></li>";
		}
	    return ulli;	
	}//writeDokumentDataToPageContext
	
}//class StartNavTag
