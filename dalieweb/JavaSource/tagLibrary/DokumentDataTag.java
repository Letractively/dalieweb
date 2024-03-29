/*
 * DokumentDataTag.java 
 * @author Administrator on 28.12.2008 um 15:29:40 
 */
package tagLibrary;

import help.HelpString;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import database.Database;
import database.dateien.Dokument;
import database.dateien.Selinas;
import database.dateien.Typ;
import database.getDatabase.DataSetDokument;
import database.getDatabase.DataSetTyp;
import selinas.table.Selinas002H;
import selinas.SelinasUser;
import selinas.bean.SelinasSession;

/**
 * <b>Class</b> DokumentDataTag<br>Table of Dokument<br>
 * <b>Attribute</b><li>Database<li>User<li>Selinas<li>farbe<li>header<li>data<li>tableTagClass<br>
 * 
 * @version 1.00 on 28.12.2008 um 15:29:40
 * @author dv0101
 */
public class DokumentDataTag extends TagSupport {
    /* this Objekt create a Table with Data from selinas.Dokument  */
    	
    private Database dbConn;
    private SelinasUser selinasuser;
    private SelinasSession show;
    private String language;

	
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
	private String orderByTyp = "TNI";//default orderTyp is: DokumentTyp,Number and Id
	
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
            			
            		if(session.getAttribute("DokumentOrderByTyp") != null)
                		orderByTyp = (String) session.getAttribute("DokumentOrderByTyp");
                 try {
                 	JspWriter out = pageContext.getOut();
                 	try{
                        dbConn.getConnection();
                        if(((String)session.getAttribute("SelectTyp")).equalsIgnoreCase("UB")){//Element �bersicht is aktiv
                        	out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0' class="+ FB+ tableTagClass + FB+ ">"
                        	    + writeDokumentHeaderToPageContext(columnHeader)
							    + writeDokumentDataToPageContext(DataSetDokument.readeO(dbConn, selinasuser.user,orderByTyp)));
                        }else{
                        	out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0' class="+ FB+ tableTagClass + FB+ ">"
                        		+ writeDokumentHeaderToPageContext(Selinas002H.valueOf("1",language,orderByTyp))
                                + writeDokumentDataToPageContextTyp(DataSetDokument.reade(dbConn, selinasuser.user,(String)session.getAttribute("SelectTyp"),orderByTyp)));	
                        }//endif
                        dbConn.close();
                 	}catch(Exception e){//no DokumentLinks found
                    	out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0' class="+ FB+ tableTagClass + FB+ ">" 
                    			+ writeDokumentHeaderToPageContext(columnHeader));
                    }//catch    
                        return EVAL_BODY_INCLUDE;//Evaluate body into existing out stream, and start next with doEndTag()
                    
                    } catch (Exception e) {
                        throw new JspException("Create of TableContent "
                                + " Exception " + e.getMessage()
                                + " is not vaild");
                    }//try 
                    
            		} else {
                    	throw new JspException("SelinasSession object in session "
                    		+ session.getAttribute("Dokument")
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
			tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
					"<td width='15%'>" + dokumentTyp.getDescription() +"</td>" +
					"<td width='5%'><a href="+FB+((HttpServletResponse) pageContext.getResponse()).encodeURL("../DokumentToRequestServlet?dokumentTyp="+data.getTyp()+"&amp;dokumentNr="+data.getNummer()+"&amp;dokumentId="+data.getId())+FB+" title='"+show.session.getLink2() + data.getTitel()+" ' target='_parent' class='link'>" + data.getNummer()+"."+ data.getId() +"</a></td>" +
					"<td width='20%'>" + HelpString.collapseSpaces(data.getTitel()) +"</td>" +
					"<td width='25%'>" + HelpString.collapseSpaces(data.getDescripten(),32) + "</td>" +
					"<td width='5%'>" + data.getGliederung() +"</td>" +
					"<td width='15%'>" + data.getCreateUser() +"<br />"+  data.getCreateDate() +"</td>" +
					"<td width='15%'>" + data.getChangeUser() +"<br />"+  data.getChangeDate() +"</td>" +
					"</tr>";
		}//for	
	    return tableTRTD;	
	}//writeDokumentDataToPageContext
	
	private String writeDokumentDataToPageContextTyp(Vector dokumente) throws Exception {
	    String tableTRTD = "";
	    if (data.equalsIgnoreCase("J"))
	    for (int i = 0; i < dokumente.size(); i++){         
			Dokument data  = ((Dokument)dokumente.elementAt(i));
			tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
				"<td width='10%'>" + data.getNummer()+"."+ data.getId() +"</td>" +
				"<td width='20%'><a href="+FB+((HttpServletResponse) pageContext.getResponse()).encodeURL("../DokumentToRequestServlet?dokumentTyp="+data.getTyp()+"&amp;dokumentNr="+data.getNummer()+"&amp;dokumentId="+data.getId())+FB+" title='" +show.session.getLink2() + data.getTitel()+" ' target='_parent' class='link'>" + HelpString.collapseSpaces(data.getTitel())+"</a></td>" +
				"<td width='30%'>" + HelpString.collapseSpaces(data.getDescripten(),32) + "</td>" +
				"<td width='10%'>" + data.getGliederung() +"</td>" +
				"<td width='15%'>" + data.getCreateUser() +"<br />"+  data.getCreateDate() +"</td>" +
				"<td width='15%'>" + data.getChangeUser() +"<br />"+  data.getChangeDate() +"</td>" +
				"</tr>";
		}//for	
	    return tableTRTD;	
	}//writeDokumentDataToPageContext
	
	/** To find the internal state */
    public void release() {
        /* Der JSP-Container ruft die Methode release() auf, um den  */
        /* internen Zustand der Aktionsklasse zur�ckzusetzen. */
      dbConn = null;
      selinasuser = null;
      show = null;
      farbe = null;
      columnHeader = null;
      language = null;
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
}//class DokumentDataTag