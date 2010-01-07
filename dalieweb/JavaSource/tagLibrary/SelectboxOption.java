package tagLibrary;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import database.Database;
import database.dateien.Selectbox;
import database.dateien.SelectboxOptionen;
import database.getDatabase.DataSetSelectbox;
import selinas.SelinasUser;

/**
 * @author dv0101 am 09.01.2009 um 21:08:04
 *
 * SelectboxOption.java
 * 
 */

public class SelectboxOption extends TagSupport{
    
   protected String optionen = "";
   private Database dbConn;
   private SelinasUser selinasuser;
    
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
                    
                	 if(session.getAttribute("PermitId") != null)    
                	 	userPermitId = (String)session.getAttribute("PermitId");
            
                    try {
                        dbConn.getConnection();
                        optionen = "";
                        Selectbox selectbox = DataSetSelectbox.chain(dbConn, selinasuser.user.getSelinasId(),selinasuser.user.getSelinasStandortId(),name, argument);
                        for (int i = 0; i < selectbox.optionen.size(); i++) {
                            SelectboxOptionen sbo = (SelectboxOptionen) selectbox.optionen.elementAt(i);
                            optionen = optionen + "<option value='"+ sbo.getOptionValue() + 
                                    "'class='"+ ccsStyle + "'>"
                                    + sbo.getOptionDescription() + "</option>";
                        }//for
                        dbConn.close();
                    } catch (Exception e) {
                        throw new JspException("Selectbox object "
                                + " has not the valid type");
                    }//Selectbox.chain
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
                    + FB + getPermitAttribut() + " tabindex=" + FB + tabindex + FB
                    + ">" + optionen);
        } catch (IOException iex) {
            throw new JspException(iex.getMessage());
        }//catch
        return EVAL_BODY_INCLUDE;
    }//doStartTag
    
   public int doEndTag() {
       try {
           JspWriter out = pageContext.getOut();
           out.println("</select>");
           }catch(IOException iex) {
               System.out.println(iex.getMessage());
           }//catch
       return EVAL_PAGE;
   }//doEndTag
   
   private String getPermitAttribut(){
	if(Integer.parseInt(userPermitId) >= Integer.parseInt(permitId)){
	    return "";
	}else{
	    return " disabled='disabled'";
	}//endif
}//getPermitAttribut
   
   /** To find the internal state */
   public void release() {
      /* Der JSP-Container ruft die Methode release() auf, um den  */
      /* internen Zustand der Aktionsklasse zurückzusetzen. */
    dbConn = null;
    selinasuser = null;
    optionen = null;
    name = null;
    ccsStyle = null;
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
   public void setArgument(String argument){
       this.argument = argument;
   }//setKey
   /** @param String id for permitId  */
   public void setPermitId(String id){
   	this.permitId = id;
   }//setPermitId
   /** @param String tabindex for tabindex */
   public void setTabindex(String tabindex) {
       this.tabindex = tabindex;
   }//setTabindex
}//class SelectboxOption

