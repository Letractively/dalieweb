/*
 * Created of DV0101 on 11.01.2010 11:01:18
 *
 * Filename	  DataSetAdresse.java
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
import database.dateien.Adresse;
import database.dateien.Typen;
import database.dateien.User;
import database.getDatabase.DataSetAdresse;
import database.getDatabase.DataSetTypen;
import database.getDatabase.DataSetUser;

/**
 * Class description goes here.
 *
 * @version 	1.00 11.01.2010 um 11:01:18
 * @author 		DV0101
 * <br><br>
 */
public class selinas020FATag extends TagSupport {
	/* this Objekt create a Table with Data from selinas.Adresse  */

	private Database dbConn;
	private SelinasUser selinasuser;
	private User adressUser;
	private String language;
	
	/** separator " */
    final String FB = "\"";//wird als " interpretiert
    /** color of Tablerow first row = #FFFFFF second row =#F0FAFF */
    private String[] farbe = {"#FFFFFF","#EEE6D2"};//1.Farbe weiß 2. grau/blau
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
	/** Adresse of Session*/
	private Adresse adressOfSession;
	
	public int doStartTag() throws JspException {
        HttpSession session = pageContext.getSession(); 
        if (session.getAttribute("Database") != null) {
            dbConn = (Database) session.getAttribute("Database");
            if(session.getAttribute("Speech") != null){
            	language = (String)session.getAttribute("Speech");  
            	if (session.getAttribute("User") != null) {
            		selinasuser = (SelinasUser) session.getAttribute("User");
                
            		if(session.getAttribute("AdressOrderByTyp") != null)
                		orderByTyp = (String) session.getAttribute("AdressOrderByTyp");
            		
            		if (session.getAttribute("Adresse") != null)
        				adressOfSession = (Adresse)session.getAttribute("Adresse");
            		
            		try {
            			JspWriter out = pageContext.getOut();
            			try{
            				dbConn.getConnection();
            				out.println("<table width='100%' border='0' cellspacing='0' cellpadding='0' class="+ FB+ tableTagClass + FB+ ">"
                        	    + writeDokumentHeaderToPageContext(columnHeader)
							    + writeDokumentDataToPageContext(DataSetAdresse.readeOfKundenId(dbConn, selinasuser.user.getKundenId(),orderByTyp)));
            				dbConn.close();
            			}catch(Exception e){//no DokumentLinks found
            				out.println("<table width='100%' border='0' cellspacing='0' cellpadding='5' class="+ FB+ tableTagClass + FB+ ">" 
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
	 
	private String writeDokumentDataToPageContext(Vector adressen) throws Exception {
	    String tableTRTD = "";
	    if (data.equalsIgnoreCase("J"))
	    for (int i = 0; i < adressen.size(); i++){ 
			Adresse adresse  = ((Adresse)adressen.elementAt(i));
			Typen typen = DataSetTypen.chainDatenTypAdresse(dbConn,adresse.getAdressArt(),language);
			adressUser = DataSetUser.chain(dbConn,adresse.getUserId());
			if(adresse.getAdressArt().equalsIgnoreCase(adressOfSession.getAdressArt()) &&
				adresse.getUserId().equalsIgnoreCase(adressOfSession.getUserId())){
			tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
					"<td width='10%' class='aktiv'><em>" + adresse.getAdressArt() + " = " + typen.getDescription() +"</em></td>" +
					"<td width='20%' class='aktiv'><a href='/dalieweb/AdressToRequestServlet?adressId="+adresse.getAdressId()+"&amp;adressArt="+adresse.getAdressArt()+"&amp;userId="+adresse.getUserId()+"' target='_parent' class='link'><em>" + adresse.getUserId() + "&nbsp;-&nbsp;" + adressUser.getName() +",&nbsp;"+ adressUser.getVorname() +"</em></a></td>" +
					"<td width='15%' class='aktiv'><em>" + adresse.getStrasse()+"</em></td>" +
					"<td width='5%' class='aktiv'><em>" + adresse.getPlz()+"</em></td>" +
					"<td width='10%' class='aktiv'><em>" + adresse.getOrt()+"</em></td>" +
					"<td width='10%' class='aktiv'><em>" + adresse.getLand()+"</em></td>" +
					"<td width='15%' class='aktiv'><em>" + adresse.getCreateUserId() + "<br /> "+  adresse.getCreateDate() +"</em></td>" +
					"<td width='15%' class='aktiv'><em>" + adresse.getChangeUserId() + "<br />" +adresse.getChangeDate() +"</em></td>" +
					"</tr>";
			}else{
				tableTRTD = tableTRTD + "<tr bgcolor='" + farbe[i % 2] + "'>" +
				"<td width='10%'>" + adresse.getAdressArt() + " = " + typen.getDescription() +"</td>" +
				"<td width='20%'><a href='/dalieweb/AdressToRequestServlet?adressId="+adresse.getAdressId()+"&amp;adressArt="+adresse.getAdressArt()+"&amp;userId="+adresse.getUserId()+"' target='_parent' class='link'>" + adresse.getUserId() + "&nbsp;-&nbsp;" + adressUser.getName() +",&nbsp;"+ adressUser.getVorname() +"</a></td>" +
				"<td width='15%'>" + adresse.getStrasse()+"</td>" +
				"<td width='5%'>" + adresse.getPlz()+"</td>" +
				"<td width='10%'>" + adresse.getOrt()+"</td>" +
				"<td width='10%'>" + adresse.getLand()+"</td>" +
				"<td width='15%'>" + adresse.getCreateUserId() + "<br /> "+  adresse.getCreateDate() +"</td>" +
				"<td width='15%'>" + adresse.getChangeUserId() + "<br />" +adresse.getChangeDate() +"</td>" +
					"</tr>";
			}//endif
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
	
}//class selinas020FATag
