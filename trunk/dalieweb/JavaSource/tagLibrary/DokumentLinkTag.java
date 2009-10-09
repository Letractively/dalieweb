/*
 * DokumentSelectLinkTag.java 
 * @author Administrator on 03.04.2009 um 21:49:11 
 */
package tagLibrary;

import java.util.Vector;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import database.Database;
import database.dateien.Link;
import database.dateien.Dokument;
import database.getDatabase.DataSetLink;;

/**
 * <b>Class</b>DokumentLinkTag:<br>descripten<br>
 * <b>Attribute</b> <li>Variable<li>Variable<br>
 * 
 * @version 1.00 on 03.04.2009 um 21:49:11
 * @author dv0101
 */
public class DokumentLinkTag extends TagSupport{

	private Database dbConn;
    private Dokument dokument;
	
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
	
	
	
    public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        if (session.getAttribute("Database") != null) {
            dbConn = (Database) session.getAttribute("Database");
            if(session.getAttribute("Dokument") != null){
            	dokument = (Dokument) session.getAttribute("Dokument");
            
                try {
                    JspWriter out = pageContext.getOut();
                    dbConn.getConnection();
                    out.println("<table class="+ FB+ tableTagClass + FB+ ">"
                    	+ writeDokumentHeaderToPageContext(columnHeader)
                    	+ writeDokumentDataToPageContext(DataSetLink.read(dbConn,dokument)));   
                    dbConn.close();
                    
                    return EVAL_BODY_INCLUDE;////Start next: doEntTag()              
                
                } catch (Exception e) {
               	    throw new JspException("LinksofDokument"
               	    	+ " is failed");
                    }//try 
            } else {
                throw new JspException("Dokument object in session "
                    + session.getAttribute("Dokument")
                    + " has not the valid type");
            }//session.getAttribute("Dokument")
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
        	for(int i = 0; i < columnHeader.length; i++){
        		TableTRTH = TableTRTH + "<th>"+ columnHeader[i].toString() +"</th>";
        	}//for
        TableTRTH = TableTRTH + "</tr>";
        }//endif
	   return TableTRTH;
	}//writeDokumentHeaderToPageContext
    
    
    /**
     * Writes Dokument-Informations for one Dokument to the page body
     */
	private String writeDokumentDataToPageContext(Vector dokumentLinks) {
	    String tableTRTD = "";
	    if (data.equalsIgnoreCase("J"))
	    for (int i = 0; i < dokumentLinks.size(); i++){         
			Link link  = ((Link)dokumentLinks.elementAt(i));
			tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
					"<td class="+FB+FB+"><a href='"+((HttpServletResponse) pageContext.getResponse()).encodeURL(link.getPfadOfLink())+"' target='_blank'>" + link.getNameOfLink() +"</a></td>" +
					"</tr>";
		}//for	
	    return tableTRTD;	
	}//writeDokumentDataToPageContext

	/** To find the internal state */
     public void release() {
     	dbConn = null;
        dokument = null;
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
    
}//class DokumentLinkTag
