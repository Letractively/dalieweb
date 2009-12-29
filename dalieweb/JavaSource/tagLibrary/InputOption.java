package tagLibrary;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * @author dv0101 am 06.12.2008 um 19:04:17
 * <br>
 * <b> create HTML-Tag INPUT </b>
 * <br><b>public</b><br>
 * <br>
 * <b>InputOption</b> extends TagSupport<br><br>
 * String compelling name<br>
 * String non compelling id<br>
 * String non compelling value<br>
 * String non compelling permitId<br>
 * String compelling tabindex<br>
 * String non compelling size<br>
 * @return
 * <ul><li>
 * <INPUT type="text" name="name" id="name" onfocus ="if(this.value=='name') this.value=''" onblur ="if (this.value=='') this.value='name'" value="name" tabindex="6" readonly disabled style="width:10em;" maxlength="10">
 * </li></ul>
 * 
 */
public class InputOption extends TagSupport{
    
    /**
     * FB = Feldbegrenzer z.B "DV0101"
     */
    public String FB = "\"";//wird als " interpretiert
    
    private String type="text";
    public void setType(String type) {
        this.type = type;
    }//setType
    
    private String name="name";
    public void setName(String name) {
        this.name = name;
        setId(name);
    }//setName
    private String getName() {
        return this.name;
    }//getName
        
    private String id=""; 
    public void setId(String id) {
        this.id = id;
    }//setId
    
    private String value = "";
    public void setValue(String value){
        this.value = value;
    }//setValue
    public String getValue() {
        return value;
    }//getValue
    private String permitId="0";//deaktiviert
    private String permitAttribut = " readonly='readonly' disabled='disabled'";
    public void setPermitId(String id){
        	if(Integer.parseInt(permitId)== 9) {
        	    this.permitAttribut = " readonly='readonly' disabled='disabled'";
        	}else {
        		this.permitId = id;
        	if(Integer.parseInt(id) >= 3) {
        	    this.permitAttribut = "";
        	} else if(Integer.parseInt(id) == 2) {
        	    this.permitAttribut = "";
        	    this.permitAttribut = " readonly='readonly'";
        	} else if(Integer.parseInt(id) == 9) {
        	    this.permitAttribut = "";
        	    this.permitAttribut = " readonly='readonly' disabled='disabled'";
        	}//endif
        	}//endif
    }//setPermitId
    
    private String tabindex="1";
    public void setTabindex(String tabindex) {
        this.tabindex = tabindex;
    }//setTabindex
    
    private String size="";
    public void setSize(String size) {
        this.size = size;
    }//setSize
    public String getSize() {
        if(size.equals("")) {
            return "";
        }else {
            return " style="+FB+"width:"+size+"em;"+FB +" maxlength="+FB+size+FB;
        }//endif
    }//getSize
    /**
     * <b> create HTML-Tag INPUT </b>
     * <br><b>public</b><br>
     * @param
     * <ul>	<li>String compelling name</li>
     * 		<li>String non compelling id</li>
     * 		<li>String non compelling value</li>
     * 		<li>String non compelling permitId</li>
     * 		<li>String compelling tabindex</li>
     * 		<li>String non compelling size</li>
     * </ul>
     * @return
     * <ul><li>
     * <INPUT type="text" name="name" id="name" onfocus ="if(this.value=='name') this.value=''" onblur ="if (this.value=='') this.value='name'" value="name" tabindex="6" readonly disabled style="width:10em;" maxlength="10">
     * </li></ul>
     */
    public int doStartTag() {
        try {
            JspWriter out = pageContext.getOut();
            HttpSession session = pageContext.getSession();
            if(session.getAttribute("PermitId") != null)    
                //Daten vom SessionOpjekt als Input holen
                setPermitId((String)session.getAttribute("PermitId"));
            out.println("<input type="+FB+type+FB+" name="+FB+name+FB+" id="+FB+id+FB+" onfocus ="+FB+"if(this.value=='"+getName()+"') this.value=''"+FB+" onblur ="+FB+"if (this.value=='') this.value='"+getName()+"'"+FB+" value="+FB+getValue()+FB+" tabindex="+FB+tabindex+FB+ this.permitAttribut + getSize()+ " class="+FB+"OHNE"+FB+"");
            }catch(IOException iex) {
            }//catch
        return EVAL_BODY_INCLUDE;
    }//doStartTag
    
    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();
            out.println("/>");
            }catch(IOException iex) {
            }//catch
        return EVAL_PAGE;
    }//doEndTag    
    
}//class InputOption

