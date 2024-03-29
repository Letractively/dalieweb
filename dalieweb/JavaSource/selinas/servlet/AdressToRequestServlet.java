package selinas.servlet;

import help.LoggerHelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import selinas.SelinasUser;
import selinas.bean.SelinasSession;
import database.Database;
import database.dateien.Adresse;
import database.dateien.Selinas;

public class AdressToRequestServlet extends HttpServlet implements Servlet {
	/* Aufruf der Adressverwaltung */
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	        
	     HttpSession session = request.getSession();
	     String nextPage = "/selinas/selinas001.jsp";
	     SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas")); 
	     SelinasUser selinasuser = (SelinasUser) session.getAttribute("User");
	     Database dbConn = (Database) session.getAttribute("Database");
		 try {
		     RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
	     	 displogin.include(request, response);
		 }catch (ServletException se) {
		    performForward(nextPage,request,response);//Login 
	     }//catch ServletException
		    
		 try{ 
		 	Adresse adressOfSession = show.getAdressOfDatabase(dbConn,request);
		 	session.setAttribute("Adresse", adressOfSession);//SessionAttribut:AdressOfDatabase
		 	session.setAttribute("AdressUser", show.getUserOfDatabase(dbConn,adressOfSession.getUserId()));
	        performForward("/selinas/selinas020.jsp", request, response);//JSP- Seite zum Verwalten
		 } catch (Exception e) {
		 	LoggerHelper.log(this.getClass().getName(), "Exception of perForm getAdressOfDatabase", e);
		 	performForward(nextPage, request, response);
        }//catch  
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
	
	public AdressToRequestServlet() {
		super();
	}//AdressToRequestServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return  this.getClass().getName() + "get Adress from Database and Load to SessionAttribute";
	}//getServletInfo
	
}//class AdressToRequestServlet