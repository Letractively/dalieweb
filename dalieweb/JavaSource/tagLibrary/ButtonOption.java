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
 * <b>Class</b>ButtonOption:<br>description<br>
 * <b>Attribute</b> <li>Variable<li>Variable<br>
 * 
 * @version 1.00 on 03.04.2009 um 09:48:43
 * @author dv0101
 */
public class ButtonOption extends TagSupport{
	/* Dieses Objekt wird wie wo verwendet?*/
	/* Und dient für ?*/
    
    /** separator " */
    final String FB = "\"";//wird als " interpretiert
    
    private String name="Speech";
    public void setName(String name) {
        this.name = name;
        setId(name);
    }//setName
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
    
    private String accesskey="n";
    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }//setAccesskey
    private String tabindex="1";
    public void setTabindex(String tabindex) {
        this.tabindex = tabindex;
    }//setTabindex
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            HttpSession session = pageContext.getSession();
            if(session.getAttribute("PermitId") != null)    
                setPermitId((String)session.getAttribute("PermitId"));
            
            out.println("<button type=" + FB + "submit" + FB + " name=" + FB + name + FB
                    + " accesskey=" + FB + accesskey + FB 
                    + " tabindex=" + FB + tabindex + FB + permitAttribut + ">");
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

}//ButtonOption

