/*
 * UploadApplication.java
 * @author dv0101 on 23.03.2009 um 17:22:15
 *
 */
package selinas;

import org.apache.commons.fileupload.FileItem;
/**
 * <b>Class</b>UploadApplication:<br>check the UploadApplication<br>
 * 
 * @version 1.00 on 23.03.2009 um 08:22:15
 * @author dv0101
 * <br><br>
 */
public class UploadApplication {
    /* check the selected upload */
    
    /** 
     * <B>name=</B>C:\Dokumente und Einstellungen\DV0101\Eigene Dateien\Eigene eBooks\hms020719mu.pdf,<BR> 
     * <B>StoreLocation=</B>C:\Pfad\temp\Upload.tmp, <BR>
     * <B>size=</B>201177bytes, <BR>
     * <B>isFormField=</B>false, <br>
     * <B>FieldName=</B>myFile <br>
     * */
    FileItem element;
    private String applicationsKz;
    
    /** Typ of Element<BR>Datei ist .pdf or .doc or .xls  */
    private String application = "";//Typ of Element
    
    public UploadApplication(){}
    public UploadApplication(FileItem element){
        this.element = element;
    }//UploadApplication
    
    /** <B>vaild is:</B><BR>msword<BR>ms-excel<BR>pdf */
    public boolean checkUplaodApplikation() {
        if(element.getContentType().equalsIgnoreCase("application/msword")){
      		this.application = ".doc";
      		return true;
        }else if (element.getContentType().equalsIgnoreCase("application/vnd.ms-excel")) {
          	this.application = ".xls";
          	return true;   
        }else if (element.getContentType().equalsIgnoreCase("application/pdf")) {
          	this.application = ".pdf";
          	return true;
        }else if (element.getContentType().equalsIgnoreCase("application/download")) {
          	this.application = ".pdf";
          	return true;
        }else if (element.getContentType().equalsIgnoreCase("text/plain")) {
          	this.application = ".txt";
          	return true;
        }//endif
        return false;
    }//checkUploadApplikation
    
    /** <B>vaild is:</B><BR>jpeg<BR>png<BR>gif */
    public boolean checkUplaodImage() {
        if(element.getContentType().equalsIgnoreCase("image/jpeg")){
      		this.application = ".jpg";
      		return true;
        }else if (element.getContentType().equalsIgnoreCase("image/jpg")) {
          	this.application = ".jpg";
          	return true;
        }else if (element.getContentType().equalsIgnoreCase("image/png")) {
          	this.application = ".png";
          	return true;   
        }else if (element.getContentType().equalsIgnoreCase("image/gif")) {
          	this.application = ".gif";
          	return true;
        }//endif
        return false;
    }//checkUploadApplikation
    
    public static String getApplicationsKz(String kz){
    	if(kz.equalsIgnoreCase("application/msword"))
      		return ".doc";
    	if(kz.equalsIgnoreCase("application/vnd.ms-excel"))
      		return ".xls";
    	if(kz.equalsIgnoreCase("application/pdf"))
      		return ".pdf";
    	if(kz.equalsIgnoreCase("application/download"))
      		return ".pdf";
    	if(kz.equalsIgnoreCase("text/plain"))
      		return ".txt";
    	return "";
    }//getApplicationsKz
    /**
     * @return Returns the String of application.
     * <br> ".pdf or .xls or .doc
     */
    public String getApplication() {
        return application;//Typ of Element
    }//getApplication
}//class UploadApplication
