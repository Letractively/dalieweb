package selinas.servlet;

import help.HelpString;
import help.LoggerHelper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.fop.apps.Driver;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.InputHandler;
import org.apache.fop.apps.XSLTInputHandler;

import selinas.SelinasUser;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import database.Database;
import database.dateien.Dokument;
import database.getDatabase.DataSetAdresse;
import database.getDatabase.DataSetTyp;

public class DokumentToReportServlet extends HttpServlet implements Servlet {
	
	Database dbConn;
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
		String nextPage = "/selinas/selinas001.jsp";
		/** name of XML-File */
		String nameOfXmlPfad = "";
		
		SelinasUser selinasuser = (SelinasUser) session.getAttribute("User");
	    Dokument dokumentOfPrint = (Dokument)session.getAttribute("Dokument");
	    dbConn = (Database) session.getAttribute("Database");
	    String language = (String)session.getAttribute("Speech");
		
 		try {
 	        RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
      		displogin.include(request, response);  		
 		}catch (ServletException se) {
 		   performForward(nextPage,request,response);//Login 
     	}//catch ServletException
 		
 		
        XStream xs = new XStream(new DomDriver());/*Serialize the object*/
        nameOfXmlPfad = (new Integer(dokumentOfPrint.getKundenId())).toString();
        nameOfXmlPfad += (new Integer(dokumentOfPrint.getStandortId())).toString();
        nameOfXmlPfad += (new Integer(dokumentOfPrint.getNummer())).toString();
        nameOfXmlPfad += (new Integer(dokumentOfPrint.getId())).toString();
        nameOfXmlPfad += dokumentOfPrint.getTyp().toString();
        
        dokumentOfPrint.setContent(HelpString.collapseHtml(dokumentOfPrint.getContent()));
        try{
      		//Write to a file in the file system      	
      		FileOutputStream fos = new FileOutputStream (getServletContext().getRealPath("/xml/"+nameOfXmlPfad+".xml"));
      		PrintWriter writer = new PrintWriter (new OutputStreamWriter (fos, "ISO-8859-1"), true);
      		writer.println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
      		ObjectOutputStream out = xs.createObjectOutputStream(writer);
      		out.writeObject(dokumentOfPrint);/* write Dokument to XML-Output */
      		dbConn.getConnection();/* open Databaseconnection */
      	//	out.writeObject(DataSetStatus.chain(dbConn,dokumentOfPrint.getStatus(),language));/* get a Status form Database -> write to XML-Output */ 
      		out.writeObject(DataSetTyp.chain(dbConn,dokumentOfPrint));/* get a Typ form Database -> write to XML-Output */
      		out.writeObject(selinasuser);/* write User to XML-Output */
      		out.writeObject(DataSetAdresse.chain(dbConn,dokumentOfPrint.getKundenId(),"U", dokumentOfPrint.getChangeUser()));/* get a (U)ser Adress form Database -> write to XML-Output */
      		out.flush();/* important */
      		out.close();/* important */ 
        } catch (Exception e) {
        	LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
        }//try
        
		try {
			InputHandler input = new XSLTInputHandler(new File(getServletContext().getRealPath("/xml/"+nameOfXmlPfad+".xml")),new File(getServletContext().getRealPath("/xsl/report001.xsl")));
			renderXML(input, response);
		} catch (FOPException e1) {
			LoggerHelper.log(this.getClass().getName(),"FOPException of perForm..:", e1);
		}//
        
 		//performForward("/selinas/selinas002.jsp", request, response);
	}//perForm
    
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
	
	public DokumentToReportServlet() {
		super();
	}//DokumentToReportServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "create a Report of Dokument";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy LoginServlet", e);
	    }//catch
	}//destroy
	
	
	public void renderXML(InputHandler input,HttpServletResponse response) throws ServletException {
		   try {
			   ByteArrayOutputStream out = new ByteArrayOutputStream();

			   response.setContentType("application/pdf");

			   Driver driver = new Driver();
			   //driver.setLogger(log);
			   driver.setRenderer(Driver.RENDER_PDF);
			   driver.setOutputStream(out);
			   driver.render(input.getParser(), input.getInputSource());

			   byte[] content = out.toByteArray();
			   response.setContentLength(content.length);
			   response.getOutputStream().write(content);
			   response.getOutputStream().flush();
		   } catch (Exception ex) {
			   throw new ServletException(ex);
		   }//try
	   }//renderXML
}//class GoToStartServlet