/*
 * Created of DV0101 on 11.01.2009 02:59:14
 *
 * Filename	  SelectboxDokumentStatus.java
 */
package tagLibrary;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import selinas.SelinasUser;
import database.Database;
import database.dateien.Dokument;
import database.dateien.Selectbox;
import database.dateien.SelectboxOptionen;
import database.getDatabase.DataSetSelectbox;

/**
 * create a select box for status documents.
 *
 * @version 	1.00 11.01.2009 um 02:59:14
 * @author 		DV0101
 * <br><br>
 */
public class SelectboxDokumentStatus extends TagSupport{

	protected String optionen = "";
	private Database dbConn;
	private SelinasUser selinasuser;
	private Dokument dokument;
	    

	/** FB = Feldbegrenzer z.B "DV0101" */
	public String FB = "\"";//wird als " interpretiert 
	/** HTML-Attribute: name */
	private String name="Speech"; 
	/** HTML-Attribute: id */
	private String id="";  
	/** userPermitId: SessionAttribute -> UserBerechtiungsId */
	private String userPermitId = "0";
	/** permitId: Berechtigungsstufe */
	private String permitId="0";//deaktiviert
	/** HTML-Attribute: tabindex*/ 
	private String tabindex="1";
	/** Argument für SelectboxKey*/ 
	private String argument = "KA";
	/** HTML-Attribute: ccs*/
	private String ccsStyle="";
	/** SprachKey */
	private String language;
	    
	/**
	* <b> create HTML-Tag selectBox </b>
	* <br><b>public</b><br>
    * @param
    * <ul>	<li>String compelling name</li>
    * 		<li>String non compelling id</li>
    * 		<li>String non compelling permitId</li>
    * 		<li>String non compelling tabindex</li>
    * 		<li>String compelling key DE=deutsch/EN=englisch</li>
    * 		<li>String non compelling ccsStyle</li>
    * </ul>
    * @return
    * <ul><li><SELECT name="speech" id="speech" disabled tabindex="3"><BR>
    * <option value="DE" class="">deutsch</option><option value="EN" class="">englisch</option></SELECT>
    * </li></ul>
    */
   public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			HttpSession session = pageContext.getSession();
			if (session.getAttribute("Database") != null) {
				dbConn = (Database) session.getAttribute("Database");
				if (session.getAttribute("User") != null) {
					selinasuser = (SelinasUser) session.getAttribute("User");
					if (session.getAttribute("Speech") != null) {
						language = (String) session.getAttribute("Speech");
						if(session.getAttribute("Dokument") != null){
							dokument = (Dokument)session.getAttribute("Dokument");	
							
							if (session.getAttribute("PermitId") != null)
								userPermitId = (String) session
										.getAttribute("PermitId");

							try {
								dbConn.getConnection();
								optionen = "";
								Selectbox selectbox = DataSetSelectbox.chain(
										dbConn, selinasuser.user.getSelinasId(),
										selinasuser.user.getSelinasStandortId(),
										name, language, argument);
								for (int i = 0; i < selectbox.optionen.size(); i++) {
									SelectboxOptionen sbo = (SelectboxOptionen) selectbox.optionen.elementAt(i);
									if(sbo.getOptionValue().equalsIgnoreCase("P")){
										/* Option (P)rivat nur erlauben, wenn User Dokument erstellt hat. */
										if(dokument.getCreateUser().equals(selinasuser.user.getUserId())){
											optionen = optionen + "<option value='"+ sbo.getOptionValue() + 
											"'class='" + ccsStyle + "'>"
												+ sbo.getOptionDescription()
												+ "</option>";
										}//endif
									}else if(/* Optionen- Auswahl nur ermöglichen bis eigener AutoriesierungsId */
											(Integer.parseInt(sbo.getOptionValue())) <= selinasuser.user.getUserAutorisierungsId()){
												optionen = optionen + "<option value='"+ sbo.getOptionValue() + 
												"'class='" + ccsStyle + "'>"
												+ sbo.getOptionDescription()
												+ "</option>";
									}//endif
								}//for
								dbConn.close();
							} catch (Exception e) {
								throw new JspException("Selectbox object "
										+ " has not the valid type");
							}//Selectbox.chain

						} else {
							throw new JspException("Dokument object in session "
									+ session.getAttribute("Dokument")
									+ " has not the valid type");
						}//session.getAttribute("Dokument")
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

			out.println("<select name=" + FB + name + FB + " id=" + FB + id
					+ FB + getPermitAttribut() + " tabindex=" + FB + tabindex
					+ FB + ">" + optionen);
		} catch (IOException iex) {
			throw new JspException(iex.getMessage());
		}//catch
		return EVAL_BODY_INCLUDE;
	}//doStartTag
	    
	   public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();
			out.println("</select>");
		} catch (IOException iex) {
			System.out.println(iex.getMessage());
		}//catch
		return EVAL_PAGE;
	}//doEndTag

	private String getPermitAttribut() {
		if (Integer.parseInt(userPermitId) >= Integer.parseInt(permitId)) {
			return "";
		} else {
			return " disabled='disabled'";
		}//endif
	}//getPermitAttribut
	   
	   /** To find the internal state */
	public void release() {
		/* Der JSP-Container ruft die Methode release() auf, um den */
		/* internen Zustand der Aktionsklasse zurückzusetzen. */
		dbConn = null;
		selinasuser = null;
		dokument = null;
		optionen = null;
		name = null;
		ccsStyle = null;
		language = null;
		id = null;
		permitId = null;
		tabindex = null;
		super.release();
	}//release

	/** @param String name for name */
	public void setName(String name) {
		this.name = name;
		setId(name);
	}//setName

	/** @param String ccsStyle for ccsStyle */
	public void setCcsStyle(String ccsStyle) {
		this.ccsStyle = ccsStyle;
	}//setCcsStyle

	/** @param String id for id */
	public void setId(String id) {
		this.id = id;
	}//setId

	public void setArgument(String argument) {
		this.argument = argument;
	}//setKey

	/** @param String id for permitId  */
	public void setPermitId(String id) {
		this.permitId = id;
	}//setPermitId

	/** @param String tabindex for tabindex */
	public void setTabindex(String tabindex) {
		this.tabindex = tabindex;
	}//setTabindex
	
}//class SelectboxDokumentStatus
