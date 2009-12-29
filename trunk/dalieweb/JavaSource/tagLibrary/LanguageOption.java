package tagLibrary;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
/**
 * @author dv0101 am 03.12.2008 um 20:27:13
 * <br>
 * <b> create HTML-Tag selectBox </b>
 * <br><b>public</b><br>
 * <br>
 * <b>LanguageOption</b> extends TagSupport<br><br>
 * private String name<br>
 * private String id<br>
 * private String permitId<br>
 * private String tabindex<br>
 * private String option<br>
 * @return
 * <ul><li><SELECT name="speech" id="speech" disabled tabindex="3"><BR>
 * <option value="DE">deutsch</option><option value="EN">englisch</option></SELECT>
 * </li></ul>
 *
 */
public class LanguageOption extends TagSupport {
    
    /**
     * FB = Feldbegrenzer z.B "DV0101"
     */
    public String FB = "\"";//wird als " interpretiert
    /**
     * select of option on Speech german
     */
    final String optionDE="<option value="+FB+"DE"+FB+">deutsch</option><option value="+FB+"EN"+FB+">englisch</option>";
    /**
     * select of option on Speech englisch
     */
    final String optionEN="<option value="+FB+"EN"+FB+">englisch</option><option value="+FB+"DE"+FB+">deutsch</option>";
    
    private String name="speech";
    public void setName(String name) {
        this.name = name;
        setId(name);
    }//setName
    
    private String id="";
    public void setId(String id) {
        this.id = id;
    }//setId
     
    private String permitId="0";//deaktiviert
    private String permitAttribut = " disabled='disabled'";
    public void setPermitId(String id){
        if(Integer.parseInt(permitId)== 9) {
    	    this.permitAttribut = " disabled='disabled'";
    	}else {
    	    this.permitId = id;
        	if(Integer.parseInt(id) >= 2)
        	    this.permitAttribut = "";
        	if(Integer.parseInt(id) == 9)
        	    this.permitAttribut = " disabled='disabled'";
        	}//endif
    }//setPermitId
    
    private String tabindex="1";
    public void setTabindex(String tabindex) {
        this.tabindex = tabindex;
    }//setTabindex
    
    private String option="DE";
    public void setOption(String option) {
        this.option = option;
    }//setOption
    private String getOption() {
        if(option.equals("DE")){
            return optionDE;
        }else {
            return optionEN;
        }//endif
    }//getOption
    /**
     * <b> create HTML-Tag selectBox </b>
     * <br><b>public</b><br>
     * @param
     * <ul>	<li>String compelling name</li>
     * 		<li>String non compelling id</li>
     * 		<li>String non compelling permitId</li>
     * 		<li>String compelling tabindex</li>
     * 		<li>String non compelling option DE=deutsch/EN=englisch</li>
     * </ul>
     * @return
     * <ul><li><SELECT name="speech" id="speech" disabled tabindex="3"><BR>
     * <option value="DE">deutsch</option><option value="EN">englisch</option></SELECT>
     * </li></ul>
     */
    public int doStartTag() {
        try {
            JspWriter out = pageContext.getOut();
            HttpSession session = pageContext.getSession();
            if(session.getAttribute("Speech") != null)    
                //Daten vom SessionOpjekt als Input holen
                setOption((String)session.getAttribute("Speech"));
            if(session.getAttribute("PermitId") != null)    
                //Daten vom SessionOpjekt als Input holen
                setPermitId((String)session.getAttribute("PermitId"));
    	    
            out.println("<SELECT name="+FB+name+FB+" id="+FB+id+FB+permitAttribut+" tabindex="+FB+tabindex+FB+">"+getOption());
            }catch(IOException iex) {
            }//catch
        return EVAL_BODY_INCLUDE;
    }//doStartTag
    
    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();
            out.println("</SELECT>");
            }catch(IOException iex) {
            }//catch
        return EVAL_PAGE;
    }//doEndTag
    
    
}//class LanuageOption
