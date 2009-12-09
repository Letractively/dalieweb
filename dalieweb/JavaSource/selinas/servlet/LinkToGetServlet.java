package selinas.servlet;

import help.LoggerHelper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import database.dateien.Dokument;
import database.dateien.Link;
import database.getDatabase.DataSetLink;

public class LinkToGetServlet extends HttpServlet implements Servlet {
	
	/** Database */
	Database dbConn;
	/** ipOrDamain -> localhost or 216.10.*/
	String ipOrDomain;
	
	/** perform servlet initialization */
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    ipOrDomain = config.getInitParameter("IpOrDomain");  
	}//init
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Dokument dokumentOfLink = (Dokument)session.getAttribute("Dokument");
	    dbConn = (Database) session.getAttribute("Database");
	    Link link = null;
 	    BufferedInputStream  bis = null; 
 	    BufferedOutputStream bos = null;

 	    try{
	    	dbConn.getConnection();/* open Databaseconnection */
	    	link = DataSetLink.chain(dbConn,dokumentOfLink,Integer.parseInt(getApplicationsId(request.getParameter("ApplicationsId"))));
	    } catch(Exception e) {
 	    	LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
            throw new ServletException("Error");
	    }
 	    ServletOutputStream  out  = response.getOutputStream();
 	    /* Set the output data's mime type */
 		response.setContentType(link.getContentType());  // MIME type for pdf doc 	    
 	    response.setHeader("Content-disposition","attachment;filename=" + link.getNameOfLink());
 	    try {
 	    	/*create an input stream from fileURL */
 	        URL url = new URL("http",ipOrDomain,request.getServerPort(),link.getPfadOfLink());
 	        /* Use Buffered Stream for reading/writing. */
 	        bis = new BufferedInputStream(url.openStream());
 	        bos = new BufferedOutputStream(out);
 	        byte[] buff = new byte[2048];
 	        int bytesRead;
 	        // Simple read/write loop.
 	        while(-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
 	            bos.write(buff, 0, bytesRead);
 	        }//
 	    } catch(final MalformedURLException e) {
 	    	LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
            throw new ServletException("Error");
 	    } catch(final IOException e) {
 	    	LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
            throw new ServletException("Error");
 	    } finally {
 	        if (bis != null)
 	            bis.close();
 	        if (bos != null)
 	            bos.close();
 	    }//finally
 	   
	}//perForm
	/** handle the HTTP <code>GET</code> method */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    perForm(request,response);
	}//doGet
	/** handle the HTTP <code>POST</code> method */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    perForm(request,response);
	}//doPost
	
	public LinkToGetServlet() {
		super();
	}//DokumentToReportServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "get the contont of Link";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy..:", e);
	    }//catch
	}//destroy
	
	/**
	 * /**
     * <b>example dateiname.pdf return dateiname</b>
     * <br>
     * <br><b>private</b><br>
	 * @param String nameOfLink
	 * @return String sting */
	public String getApplicationsId(String applicationsId) {
		StringBuffer temp = new StringBuffer(applicationsId);
		temp.delete(applicationsId.lastIndexOf("."), applicationsId.length());
		return temp.toString();
	}//getNameOfLink
}//class LinkToGetServlet