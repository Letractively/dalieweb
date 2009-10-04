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
    
    private String name="Speech";
    public void setName(String name) {
        this.name = name;
        setId(name);
    }//setName
    
    private String id="";
    public void setId(String id) {
        this.id = id;
    }//setId
     
    private String permitId="0";//deaktiviert
    private String permitAttribut = " disabled";
    public void setPermitId(String id){
        if(Integer.parseInt(permitId)== 9) {
    	    this.permitAttribut = " disabled";
    	}else {
    	    this.permitId = id;
        	if(Integer.parseInt(id) >= 2)
        	    this.permitAttribut = "";
        	if(Integer.parseInt(id) == 9)
        	    this.permitAttribut = " disabled";
        	}//endif
    }//setPermitId
    
    private String tabindex="1";
    public void setTabindex(String tabindex) {
        this.tabindex = tabindex;
    }//setTabindex
    
    private String argument = "KA";
    public void setArgument(String argument){
        this.argument = argument;
    }//setKey
    
    private String ccsStyle="";
    public void setCcsStyle(String ccsStyle) {
        this.ccsStyle = ccsStyle;
    }//setCcsStyle
    
    
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
            if (session.getAttribute("PermitId") != null)
                setPermitId((String) session.getAttribute("PermitId"));
            if (session.getAttribute("Argument") != null)
                setArgument((String) session.getAttribute("Argument"));

            if (session.getAttribute("Database") != null) {
                dbConn = (Database) session.getAttribute("Database");
                if (session.getAttribute("User") != null) {
                	 selinasuser = (SelinasUser) session.getAttribute("User");
                    
                    try {
                        dbConn.getConnection();
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
                    + FB + permitAttribut + " tabindex=" + FB + tabindex + FB
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
    
    
}//class SelectboxOption

