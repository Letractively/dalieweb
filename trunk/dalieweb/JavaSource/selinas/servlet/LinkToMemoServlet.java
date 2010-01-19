package selinas.servlet;

import help.LoggerHelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import database.dateien.Dokument;
import database.dateien.Link;
import database.getDatabase.DataSetLink;

public class LinkToMemoServlet extends HttpServlet{
	
	/** Database */
	Database dbConn;
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
		String nextPage = "/selinas/selinas001.jsp";
		HttpSession session = request.getSession();
		Dokument dokumentOfLink = (Dokument)session.getAttribute("Dokument");
		dbConn = (Database) session.getAttribute("Database");
	    Link linkOfDokument = null;
		
 		try {
 	        RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
      		displogin.include(request, response);  		
 		}catch (ServletException se) {
 		   performForward(nextPage,request,response);//Login 
     	}//catch ServletException
 		
 		try{
	    	dbConn.getConnection();/* open Databaseconnection */
	    	linkOfDokument = DataSetLink.chain(dbConn,dokumentOfLink,Integer.parseInt(request.getParameter("ApplicationsId")));
 		} catch(Exception e) {
 	    	LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
 	    	performForward(nextPage,request,response);//Login 
	    }
 		session.setAttribute("LinkOfDokument",linkOfDokument);
 		session.setAttribute("MemoLoad","memoLoadOn");//SessionAttribut:MemoLoad Table show
 		performForward("/selinas/selinas004.jsp", request, response);//go Site
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
	
	public LinkToMemoServlet() {
		super();
	}//LinkToMemoServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "delete a select File OfDokuments on WebServer";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy..:", e);
	    }//catch
	}//destroy
	
}//class LinkToMemoServlet