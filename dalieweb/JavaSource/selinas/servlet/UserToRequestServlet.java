package selinas.servlet;

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

public class UserToRequestServlet extends HttpServlet implements Servlet {
	/* UserToRequestServlet: - Verwendung in selinas030FUTag (JSP Custom Tag) User wurde per Maus ausgewählt  */
	/*                           - sessionAttribute User wird per Request Parameter geladen  */
	/*                           - Weiterleitung auf Site selinas030.jsp Verwaltungsmodus  User  erfolgt  */
		
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
		    session.setAttribute("ShowUser", show.getUserOfDatabase(dbConn,request));//SessionAttribut:UserOfDatabase
		    Adresse adressOfSession = show.getAdressOfDatabase(dbConn,selinasuser.user);
		    session.setAttribute("Adresse", show.getAdressOfDatabase(dbConn,selinasuser.user,show.getUserOfDatabase(dbConn,request)) );
		    session.setAttribute("AdressUser", show.getUserOfDatabase(dbConn,adressOfSession.getUserId()));
	        performForward("/selinas/selinas030.jsp", request, response);//JSP- Seite zum Verwalten
		 } catch (Exception e) {
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
	
	public UserToRequestServlet() {
		super();
	}//UserServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return this.getClass().getName() + "get a User of Database and Load to SessionAttribute";
	}//getServletInfo
	
}//class UserToRequestServlet