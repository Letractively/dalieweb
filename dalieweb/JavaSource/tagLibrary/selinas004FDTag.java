/*
 * DokumentTypTag.java 
 * @author Administrator on 14.12.2009 um 09:17:24 
 */
package tagLibrary;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import selinas.SelinasUser;
import database.Database;
import database.dateien.Dokument;
import database.dateien.Typ;
import database.getDatabase.DataSetDokument;
import database.getDatabase.DataSetTyp;

/**
 * <b>Class</b> selinas004FDTag<br>Table of selected Dokuments<br>
 * <b>Attribute</b><li>Database<li>User<li>Selinas<li>farbe<li>header<li>data<li>tableTagClass<br>
 * 
 * @version 1.00 on 14.12.2009 um 09:17:24
 * @author Administrator
 */
public class selinas004FDTag extends TagSupport{
	 /* this Objekt create a Table with Data from database.dateien.Dokument  */
	
	private Database dbConn;
    private SelinasUser selinasuser;
    
    /** separator " */
    final String FB = "\"";//wird als " interpretiert
    /** color of Tablerow first row = #FFFFFF second row =#F0FAFF */
    private String[] farbe = {"#FFFFFF","#EEE6D2"};//1.Farbe wei� 2. grau/blau
    /** Yes or No Y = Show Header of Table*/
    private String header = "J";//Yes = show Header
    /** Yes or No Y = Show Data of Table*/
    private String data = "J";//Yes = show Data
	/** join for ccsValue  */
	private String tableTagClass = "";
	/** List of ColumnHeader */
	private String[] columnHeader;
	/** value of order by  */
	private String orderByTyp = "TNI";//default orderTyp is order by gliederung
	/** Dokument of Session*/
	private Dokument dokumentOfSession;
	
	public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        if (session.getAttribute("Database") != null) {
            dbConn = (Database) session.getAttribute("Database");
            if (session.getAttribute("User") != null) {
                selinasuser = (SelinasUser) session.getAttribute("User");
                
                if(session.getAttribute("DokumentOrderByTyp") != null)
            		orderByTyp = (String) session.getAttribute("DokumentOrderByTyp");
                
                if (session.getAttribute("Dokument") != null)
    				dokumentOfSession = (Dokument)session.getAttribute("Dokument");
                
                 try {
                 	JspWriter out = pageContext.getOut();
                 	
                 	try{
                        dbConn.getConnection();
                        out.println("<table cellspacing='0' cellpadding='0' width='100%' class="+ FB+ tableTagClass + FB+ ">"                       		
                        		+ writeDokumentHeaderToPageContext(columnHeader)
                                + writeDokumentDataToPageContext(DataSetDokument.reade(dbConn, selinasuser.user,dokumentOfSession.getTyp(),dokumentOfSession.getNummer(),orderByTyp)));
                        dbConn.close();
                 	}catch(Exception e){//no DokumentLinks found
                    	out.println("<table class="+ FB+ tableTagClass + FB+ ">" 
                    			+ writeDokumentHeaderToPageContext(columnHeader));
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
	
	 
	 
	 private String writeDokumentDataToPageContext(Vector dokumente) throws Exception {
	    String tableTRTD = "";
	    if (data.equalsIgnoreCase("J"))
	    for (int i = 0; i < dokumente.size(); i++){         
			Dokument data  = ((Dokument)dokumente.elementAt(i));
			Typ dokumentTyp = DataSetTyp.chain(dbConn,data);
			if(data.getId() == dokumentOfSession.getId()){
				tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
				"<td class='aktiv' width='25%'>" + data.getTitel() +"</td>" +
				"<td class='aktiv' width='10%'><a class='link' href="+FB+((HttpServletResponse) pageContext.getResponse()).encodeURL("../DokumentToRequestServlet1?dokumentTyp="+data.getTyp()+"&amp;dokumentNr="+data.getNummer()+"&amp;dokumentId="+data.getId())+FB+" target='_parent'>"+ "<strong>&nbsp;" + data.getNummer()+ "." +data.getId()+"&nbsp;</strong>"+"</a></td>" +
				"<td class='aktiv' width='25%'>" + data.getDescripten() + "</td>" +
				"<td class='aktiv' width='8%'>" + data.getGliederung() +"</td>" +
				"<td class='aktiv' width='16%'>" + data.getCreateUser() +"<br />"+  data.getCreateDate() +"</td>" +
				"<td class='aktiv' width='16%'>" + data.getChangeUser() +"<br />"+  data.getChangeDate() +"</td>" +
				"</tr>";
			}else{
				tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
				"<td width='25%'>" + data.getTitel() +"</td>" +
				"<td width='10%'><a class='link' href="+FB+((HttpServletResponse) pageContext.getResponse()).encodeURL("../DokumentToRequestServlet1?dokumentTyp="+data.getTyp()+"&amp;dokumentNr="+data.getNummer()+"&amp;dokumentId="+data.getId())+FB+" target='_parent'>"+ "&nbsp;" + data.getNummer()+ "." +data.getId()+"&nbsp;"+"</a></td>" +
				"<td width='25%'>" + data.getDescripten() + "</td>" +
				"<td width='8%'>" + data.getGliederung() +"</td>" +
				"<td width='16%'>" + data.getCreateUser() +"<br />"+  data.getCreateDate() +"</td>" +
				"<td width='16%'>" + data.getChangeUser() +"<br />"+  data.getChangeDate() +"</td>" +
				"</tr>";
			}//endif i == 0 
		}//for	
	    return tableTRTD;	
	}//writeDokumentDataToPageContext
	
	 
	/** To find the internal state */
    public void release() {
        /* Der JSP-Container ruft die Methode release() auf, um den  */
        /* internen Zustand der Aktionsklasse zur�ckzusetzen. */
      dbConn = null;
      selinasuser = null;
      farbe = null;
      columnHeader = null;
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
	
}//class selinas004FDTag

