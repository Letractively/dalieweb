package selinas.servlet;

import help.LoggerHelper;

import java.io.File;
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import selinas.SelinasUser;

import database.Database;
import database.dateien.Dokument;
import database.dateien.Link;
import database.getDatabase.DataSetLink;

public class DeleteLink extends HttpServlet implements Servlet {
	/** separator " */
    final String FB = "/";//wird als " interpretiert
	final 	String sUploadDir = "upload";
	
	Database dbConn;
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
		SelinasUser selinasuser = (SelinasUser) session.getAttribute("User");
	    Dokument dokumentOfLink = (Dokument)session.getAttribute("Dokument");
	    Link link = null;
	    dbConn = (Database) session.getAttribute("Database");
		
	    try{
	    	dbConn.getConnection();/* open Databaseconnection */
	    	link = DataSetLink.chain(dbConn,dokumentOfLink,Integer.parseInt(request.getParameter("ApplicationsId")));
	    } catch(Exception e) {
 	    	LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
            throw new ServletException("Error");
	    }
 		try{//first -> delete File's 
 			System.out.println(request.getSession().getServletContext().getRealPath("/")+ FB + sUploadDir + FB +link.getPfadOfLink().substring(17,link.getPfadOfLink().length()));
      		File file = new File(request.getSession().getServletContext().getRealPath("/")+ FB + sUploadDir + FB +link.getPfadOfLink().substring(17,link.getPfadOfLink().length()));
      		FileUtils.forceDelete(file);
 		}catch(Exception e){
 			LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
 		}//try

 		try{//second -> delete database
      		DataSetLink.delete(dbConn,dokumentOfLink,Integer.parseInt(request.getParameter("ApplicationsId")));//delete all Records on Database Table of DokumentLink
        } catch (Exception e) {
        	LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
            throw new ServletException("Error");
        }//try
	
	}//perForm
	
	/** handle the HTTP <code>GET</code> method */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    perForm(request,response);
	}//doGet
	/** handle the HTTP <code>POST</code> method */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    perForm(request,response);
	}//doPost
	
	public DeleteLink() {
		super();
	}//UploadServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "Delete Files of Selinas";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy DeleteServlet", e);
	    }//catch
	}//destroy
	

	
}//class DeleteServlet