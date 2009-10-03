/*
 * Created of DV0101 on 11.06.2009 11:51:10
 *
 * Filename	  HinweisOption.java
 */
package tagLibrary;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Class description goes here.
 *
 * @version 	1.00 11.06.2009 um 11:51:10
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class HinweisOption extends TagSupport {

    private String message = "";
    public void setMessage(String message) {
        this.message = message;
    }//setMessage
    private String typ = "";
    public void setTyp(String typ) {
    	this.typ = typ;
    }//setTyp
   public int doStartTag() throws JspException {
       try {
           JspWriter out = pageContext.getOut();
           if (message.equals("")) {
               	return Tag.SKIP_BODY; // Ignore body of the tag 
           } else {
               if(typ.equalsIgnoreCase("F")) {
                   out.println("<fieldset><legend>Hinweis</legend>" + message + "</fieldset>");
               }else {
                   out.println(message);
               }//endif
               return EVAL_BODY_INCLUDE;//Evaluate body into existing out stream
           }//endif message != null
       } catch (Exception e) {
           throw new JspException(e.getMessage());
       }//catch
   }//doStartTag

}//class HinweisOption
