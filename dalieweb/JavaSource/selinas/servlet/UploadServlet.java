package selinas.servlet;

import help.LoggerHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import selinas.SelinasUser;
import selinas.UploadApplication;

import database.Database;
import database.dateien.Dokument;
import database.dateien.Link;
import database.dateien.Message;
import database.getDatabase.DataSetLink;

public class UploadServlet extends HttpServlet implements Servlet {
	
	Database dbConn;
	Dokument dokument;
	Message error;
	final 	String sUploadDir = "/upload/";
    String sRet = "";
    String feldName = "";
    String fileName = "";
    String contenType = "";
    long sizeInBytes = 0;
    

    /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
        dbConn = (Database) session.getAttribute("Database");
        dokument = (Dokument) session.getAttribute("Dokument");
        SelinasUser selinasuser = (SelinasUser) session.getAttribute("User");
        Link dokumentlink = new Link();
        try {
             ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
             try {
                    List files = upload.parseRequest(request);
                    byte[] buffer = new byte[8192];
                    for (Iterator iter = files.iterator(); iter.hasNext();) {
                     FileItem element = (FileItem) iter.next();
                        if (!element.isFormField()) {
                            UploadApplication uploadApplication = new UploadApplication(element);
                            if (uploadApplication.checkUplaodApplikation()) {
                                contenType = element.getContentType();
                                feldName = element.getFieldName();
                                sizeInBytes = element.getSize();

                                fileName = element.getName();
                                fileName = fileName.replace('\\', '/');
                                fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
                                InputStream is = element.getInputStream();

                                String 	ksdni = (new Integer(dokument.getKundenId())).toString();
        						ksdni += (new Integer(dokument.getStandortId())).toString();
        						ksdni += (new Integer(dokument.getNummer())).toString();
        					   	ksdni += (new Integer(dokument.getId())).toString();
        					   	try{
        					   		ksdni += (DataSetLink.read(dbConn,dokument).size());
        					   	}catch(Exception e){
        					   		ksdni += (0);
        					   		}
        					   	ksdni += dokument.getDokumentTyp().toString() + uploadApplication.getApplication();
        						
                                FileOutputStream fos = new FileOutputStream(
                                        new File(getServletContext()
                                                .getRealPath(sUploadDir), ksdni));
                                int len = 0;
                                while ((len = is.read(buffer)) > 0) {
                                    fos.write(buffer, 0, len);
                                }//while
                                fos.flush();
                                fos.close();
                                is.close();
                                dbConn.getConnection();
                                dokumentlink.setPfadOfLink(request.getContextPath() + sUploadDir + ksdni);
                                dokumentlink.setNameOfLink(fileName);
                                dokumentlink.setContentType(contenType);
                                dokumentlink.setSizeInBytes(sizeInBytes);
                                DataSetLink.insert(dbConn,dokument,dokumentlink,selinasuser.user);
                                request.setAttribute("upload",getResult(ksdni,request,response));
                                
                            } else {//keine gültige PC Anwendung
                                System.out.println(element.getName());
                                if(element.getSize() != 0 ) {
                                    request.setAttribute("upload", "Keine zulässige "
                                        + element.getContentType().toString()
                                        + " für Database\n" );//Message to RequestAttribute
                                }else {
                                	request.setAttribute("upload","");
                                }//endif
                            }//checkUplaodApplikation()
                        }//element isFormField
                    }// Iterator
                } catch (FileUploadException e) {
                    LoggerHelper.log(this.getClass().getName(), "FileUploadException", e);
                    throw new ServletException("FileUploadException");
                }//try
                
        } catch (Exception e) {
          LoggerHelper.log(this.getClass().getName(), "e.getMessage()", e);
        }//catch
    }//doPerForm

	protected String getResult(String ksdni,HttpServletRequest request, HttpServletResponse response) {
	    sRet = "<table><tr>";
    	sRet += "<td>&nbsp;contenType&nbsp;</td>";
    	sRet += "<td>"+ contenType + "</td></tr>";
    	sRet += "<tr><td>&nbsp;sizeInBytes&nbsp;</td>";
    	sRet += "<td>"+ sizeInBytes + "</td></tr>";
    	sRet += "<tr><td>&nbsp;Ihr Dokument&nbsp;</td>";
    	sRet += "<td>"+ fileName + "</td></tr>";
    	sRet += "<tr><td>&nbsp;Server Dokument&nbsp;</td>";
    	sRet += "<td>"+ ksdni + "</td></tr>";
		sRet += "<tr><td>&nbsp;starten&nbsp;</td>";
		sRet += "<td><a href='"+ request.getContextPath()+ sUploadDir.toString()+ksdni.toString()+"'";
		sRet +=	"target='_blank'>"+ksdni+"</a></td></tr></table></ br>";	
    	
		//sRet += "<HR><TABLE><TR>";
		//sRet += "<TD><A HREF='"+response.encodeURL(request.getContextPath()+"/DokumentServlet?dokumentTyp="+dokument.getDokumentenTypTyp()+"&amp;dokumentNr="+dokument.getDokumentNr()+"&amp;dokumentId="+dokument.getDokumentId())+"' target='_parent'>Fertig</A>";
		//sRet += "</TD></TR></TABLE>";
		return sRet;
	    }//getResult
	
	/** handle the HTTP <code>GET</code> method */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    perForm(request,response);
	}//doGet
	/** handle the HTTP <code>POST</code> method */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    perForm(request,response);
	}//doPost
	
	/** handle the next step */
	protected void performForward(String destination,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {	
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(destination);
		dispatcher.forward(request, response);		
	}//performForward
	
	public UploadServlet() {
		super();
	}//UploadServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "Upload of Selinas";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy UploadServlet", e);
	    }//catch
	}//destroy

}//class UploadServlet