/*
 * selinas025FTTag.java 
 * @author Administrator on 16.12.2009 um 16:42:55 
 */
package tagLibrary;

import java.util.Vector;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import selinas.SelinasUser;
import database.Database;
import database.dateien.Typ;
import database.getDatabase.DataSetTyp;

/**
 * <b>Class</b>selinas025FTTag:<br>Create a Table with all DokumentTypen<br>
 * <b>Attribute</b> <li>Variable<li>Variable<br>
 * 
 * @version 1.00 on 16.12.2009 um 16:42:55
 * @author dv0101
 */
public class selinas025FTTag extends TagSupport {

	private Database dbConn;
	private SelinasUser selinasuser;
    private Typ typOfSession;
    private String speech;
	 
	/** separator " */
    final String FB = "\"";//wird als " interpretiert
    /** color of Tablerow first row = #FFFFFF second row =#F0FAFF */
    private String[] farbe = {"#FFFFFF","#F0FAFF"};//1.Farbe weiﬂ 2. grau/blau
	/** Yes or No Y = Show Header of Table*/
    private String header = "J";//Yes = show Header
    /** Yes or No Y = Show Data of Table*/
    private String data = "J";//Yes = show Data
	/** join for ccsValue  */
	private String tableTagClass = "";
	/** List of ColumnHeader */
	private String[] columnHeader;
	/** value of order by  */
	private String orderByTyp = "B";//default orderTyp is order by Name
	
	
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        if (session.getAttribute("Database") != null) {
            dbConn = (Database) session.getAttribute("Database");
            if(session.getAttribute("User") != null){
            	selinasuser = (SelinasUser) session.getAttribute("User");
            	if(session.getAttribute("Speech") != null){
            		speech = (String) session.getAttribute("Speech");
            	
            	if(session.getAttribute("TypOrderByTyp") != null)
            		orderByTyp = (String) session.getAttribute("TypOrderByTyp");
            	
            	 if (session.getAttribute("Typ") != null)
    				typOfSession = (Typ)session.getAttribute("Typ");
            	
                try {
                    JspWriter out = pageContext.getOut();
                    try{
                    	dbConn.getConnection();
                    	out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0' class="+ FB+ tableTagClass + FB+ ">"
                    			+ writeDokumentHeaderToPageContext(columnHeader)
								+ writeDokumentDataToPageContext(DataSetTyp.reade(dbConn,selinasuser.user,orderByTyp)));    
                    	dbConn.close();
                    }catch(Exception e){//no DokumentLinks found
                    	out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0' class="+ FB+ tableTagClass + FB+ ">" 
                    			+ writeDokumentHeaderToPageContext(columnHeader));
                    }//catch
                    return EVAL_BODY_INCLUDE;////Start next: doEndTag()              
                
                } catch (Exception e) {
               	    throw new JspException("LinksofDokument"
               	    	+ " is failed");
                    }//try 
            	} else {
            		throw new JspException("Speech object in session "
            				+ session.getAttribute("Speech")
							+ " has not the valid type");
            	}//session.getAttribute("Dokument")
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
    
    public int doEndTag(){
        try {
            JspWriter out = pageContext.getOut();
            out.println("</table>");
            return EVAL_PAGE;
            }catch(Exception e) {
                return SKIP_PAGE;//End of Processing        
            }//catch
    }//doEndTag
    
    /** Writes Header-Informations for one Dokument to the page body */
    private String writeDokumentHeaderToPageContext(String[] columnHeader) throws Exception {
	    String TableTRTH = "";
        if (header.equalsIgnoreCase("J")){
        	TableTRTH = "<tr>";
        	for(int i = 0; i < columnHeader.length; i+=2){
        		TableTRTH = TableTRTH + "<th width='"+ columnHeader[i+1].toString() +"'>"+ columnHeader[i].toString() +"</th>";
        	}//for    	
        TableTRTH = TableTRTH + "</tr>";
        }//endif
	   return TableTRTH;
	}//writeDokumentHeaderToPageContext
    
    /**
     * Writes Dokument-Informations for one Dokument to the page body
     */
	private String writeDokumentDataToPageContext(Vector dokumentTypen) throws Exception {
	    String tableTRTD = "";
	    if (data.equalsIgnoreCase("J"))
	    for (int i = 0; i < dokumentTypen.size(); i++){         
			Typ typ  = ((Typ)dokumentTypen.elementAt(i));
			if(typ.getTyp().equalsIgnoreCase(typOfSession.getTyp())){
				tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
					"<td class='aktiv' width='15%'><em>"+ typ.getTyp() + "</em></td>" +
					"<td class='aktiv' width='25%'><a href='"+((HttpServletResponse) pageContext.getResponse()).encodeURL("../TypToRequestServlet?typ="+typ.getTyp()+"")+"' target='_parent'><em>" + typ.getDescription() +"</em></a></td>" +
					"<td class='aktiv' width='20%'>"+ DataSetTyp.getCounter(dbConn,selinasuser.user,typ.getTyp()) + "</td>" +
					"<td class='aktiv' width='20%'><em>"+ typ.getCreateDate() + "</em></td>" +
					"<td class='aktiv' width='20%'><em>"+ typ.getChangeDate() + "</em></td>" +
					"</tr>";
			}else{
				tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
					"<td width='15%' class="+FB+FB+">"+ typ.getTyp() + "</td>" +
					"<td width='25%' class="+FB+FB+"><a href='"+((HttpServletResponse) pageContext.getResponse()).encodeURL("../TypToRequestServlet?typ="+typ.getTyp()+"")+"' target='_parent'>" + typ.getDescription() +"</a></td>" +
					"<td width='20%' class="+FB+FB+">"+ DataSetTyp.getCounter(dbConn,selinasuser.user,typ.getTyp()) + "</td>" +
					"<td width='20%' class="+FB+FB+">"+ typ.getCreateDate() + "</td>" +
					"<td width='20%' class="+FB+FB+">"+ typ.getChangeDate() + "</td>" +
					"</tr>";
			}//endif
		}//for	
	    return tableTRTD;	
	}//writeDokumentDataToPageContext

	/** To find the internal state */
     public void release() {
     	dbConn = null;
        typOfSession = null;
        selinasuser = null;
        farbe = null;
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
 	/** @param String ja/nein for header to set */
     public void setHeader(String janein) {
 		header = janein;
 	}//setHeader
     /** @param String ja/nein for data to set */
 	public void setData(String janein) {
 		data = janein;
 	}//setData
 	/** @param String css for tableTagClass */
 	public void setTableTagClass(String css) {
 		tableTagClass = css;
 	}//setTABLE
 	/** @param Vector columnHeader */
	public void setColumnHeader(String[] columnHeader){
		this.columnHeader = columnHeader;
	}//setColumnHeader
	
	
}//class selinas025FTTag
