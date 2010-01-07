/*
 * selinas030FUTag.java 
 * @author Administrator on 29.12.2009 um 09:32:45 
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
import database.dateien.User;
import database.getDatabase.DataSetUser;
import database.getDatabase.DataSetStatus;

/**
 * <b>Class</b>selinas030FUTag:<br>Create a Table with all User<br>
 * <b>Attribute</b> <li>Variable<li>Variable<br>
 * 
 * @version 1.00 on 29.12.2009 um 09:32:45
 * @author dv0101
 */
public class selinas030FUTag extends TagSupport {

	private Database dbConn;
	private SelinasUser selinasuser;
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
	private String orderByTyp = "U";//default orderTyp is order by UserId
	/** User of Session*/
	private User userOfSession;
	
	 public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession();
        if (session.getAttribute("Database") != null) {
            dbConn = (Database) session.getAttribute("Database");
            if(session.getAttribute("User") != null){
            	selinasuser = (SelinasUser) session.getAttribute("User");
            	if(session.getAttribute("Speech") != null){
            		speech = (String) session.getAttribute("Speech");
            	
            	if(session.getAttribute("UserOrderByTyp") != null)
            		orderByTyp = (String) session.getAttribute("UserOrderByTyp");
            	
            	 if (session.getAttribute("ShowUser") != null)
    				userOfSession = (User)session.getAttribute("ShowUser");
            	
                try {
                    JspWriter out = pageContext.getOut();
                    try{
                    	dbConn.getConnection();
                    	out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0' class="+ FB+ tableTagClass + FB+ ">"
                    			+ writeDokumentHeaderToPageContext(columnHeader)
								+ writeDokumentDataToPageContext(DataSetUser.reade(dbConn,selinasuser.user,orderByTyp)));    
                    	dbConn.close();
                    }catch(Exception e){//no User found
                    	out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0' class="+ FB+ tableTagClass + FB+ ">" 
                    			+ writeDokumentHeaderToPageContext(columnHeader));
                    }//catch
                    return EVAL_BODY_INCLUDE;////Start next: doEndTag()              
                
                } catch (Exception e) {
               	    throw new JspException("UserOfSelinas"
               	    	+ " is failed");
                    }//try
                
            	} else {
            		throw new JspException("Speech object in session "
            				+ session.getAttribute("Speech")
							+ " has not the valid type");
            	}//session.getAttribute("Speech")
      	
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
			return EVAL_PAGE;
		} catch (Exception e) {
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
	private String writeDokumentDataToPageContext(Vector user) throws Exception {
	    String tableTRTD = "";
	    if (data.equalsIgnoreCase("J"))
	    for (int i = 0; i < user.size(); i++){         
			User showUser  = ((User)user.elementAt(i));
			if(showUser.getUserId().equalsIgnoreCase(userOfSession.getUserId())){
				tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
					"<td class='aktiv' width='25%'><em>"+ showUser.getName() + "," + showUser.getVorname()+ "</em></td>" +
					"<td class='aktiv' width='15%'><a href='"+((HttpServletResponse) pageContext.getResponse()).encodeURL("../UserToRequestServlet?user="+showUser.getUserId()+"")+"' target='_parent'><em>" + showUser.getUserId() +"</em></a></td>" +
					"<td class='aktiv' width='20%'>"+ showUser.getUserStatus() + " = " + DataSetStatus.chain(dbConn,showUser.getUserStatus(),speech).getDescripten() + "</td>" +
					"<td class='aktiv' width='5%'><em>"+ showUser.getPermitId() + "</em></td>" +
					"<td class='aktiv' width='15%'><em>"+ showUser.getCreateDate() + "</em></td>" +
					"<td class='aktiv' width='20%'><em>"+ showUser.getChangeDate() + "</em></td>" +
					"</tr>";
			}else{
				tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
					"<td width='25%' class="+FB+FB+">"+ showUser.getName() + "," + showUser.getVorname()+ "</td>" +
					"<td width='15%' class="+FB+FB+"><a href='"+((HttpServletResponse) pageContext.getResponse()).encodeURL("../UserToRequestServlet?user="+showUser.getUserId()+"")+"' target='_parent'>" + showUser.getUserId() +"</a></td>" +
					"<td width='20%' class="+FB+FB+">"+ showUser.getUserStatus() + " = " + DataSetStatus.chain(dbConn,showUser.getUserStatus(),speech).getDescripten() + "</td>" +
					"<td width='5%' class="+FB+FB+">"+ showUser.getPermitId() + "</td>" +
					"<td width='15%' class="+FB+FB+">"+ showUser.getCreateDate() + "</td>" +
					"<td width='20%' class="+FB+FB+">"+ showUser.getChangeDate() + "</td>" +
					"</tr>";
			}//endif
		}//for	
	    return tableTRTD;	
	}//writeDokumentDataToPageContext
	
	/** To find the internal state */
	public void release() {
		dbConn = null;
		selinasuser = null;
		farbe = null;
		speech = null;
		super.release();
	}//release
    
    /** @param String farbe1 for farbe[0] to set */
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
	
}//class selinas030FUTag
