/*
 * ButtonOption.java 
 * @author Administrator on 03.04.2009 um 09:48:43 
 */
package tagLibrary;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * <b>Class</b>ButtonOption:<br>Erzeuge ein HTML-Button nach Berechtiung<br>
 * <b>Attribute</b> <li>name<li>userPermitId<li>permitId<li>accesskey<li>tabindex<br>
 * 
 * @version 1.00 on 03.04.2009 um 09:48:43
 * @author dv0101
 */
public class ButtonOption extends TagSupport{
	/* Erzeute ein HTML-Button nach Berechtiung*/
	
    /** separator " */
    final String FB = "\"";//wird als " interpretiert
    /** HTML-Attribute: name */
    private String name="name";
    /** userPermitId: SessionAttribute -> UserBerechtiungsId */
    private String userPermitId = "0";
    /** permitId: Berechtigungsstufe */
    private String permitId="0";//deaktiviert
    /** HTML-Attribute: accesskey*/
    private String accesskey="n";
    /** HTML-Attribute: tabindex*/
    private String tabindex="1";
    
    
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            HttpSession session = pageContext.getSession();
            if(session.getAttribute("PermitId") != null)    
                userPermitId = (String)session.getAttribute("PermitId");
            
            out.println("<button type=" + FB + "submit" + FB + " name=" + FB + name + FB
                    + " accesskey=" + FB + accesskey + FB 
                    + " tabindex=" + FB + tabindex + FB + getPermitAttribut() + ">");
        
            return EVAL_BODY_INCLUDE;//Evaluate body into existing out stream
        
        } catch (Exception e) {
            throw new JspException(e.getMessage());
        }//catch
    }//doStartTag
    
    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();
            out.println("</button>");
            }catch(IOException iex) {
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
		name = null;
		userPermitId = null;
		permitId = null;
		accesskey = null;
		tabindex = null;
		super.release();
	}//release
	
	/** @param String accesskey for accesskey */
    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }//setAccesskey
    /** @param String name for name */
    public void setName(String name) {
        this.name = name;
        setId(name);
    }//setName
    /** @param String id for permitId  */
    public void setPermitId(String id){
    	this.permitId = id;
    }//setPermitId
    /** @param String tabindex for tabindex */
    public void setTabindex(String tabindex) {
        this.tabindex = tabindex;
    }//setTabindex

}//ButtonOption

