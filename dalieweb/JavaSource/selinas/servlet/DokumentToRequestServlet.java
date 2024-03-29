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

import database.Database;
import database.dateien.Selinas;
import selinas.SelinasUser;
import selinas.bean.SelinasSession;

public class DokumentToRequestServlet extends HttpServlet implements Servlet {
	/* DokumentToRequestServlet: - Verwendung in DokumentTypTag (JSP Custom Tag) Dokument wurde per Maus ausgewählt  */
	/*                           - sessionAttribute Dokument wird per Request Parameter geladen  */
	/*                           - Weiterleitung auf Site selinas003.jsp Präsentationsmodus  Dokumente  erfolgt  */
	
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
		    
		 try {
		     session.setAttribute("Dokument", show.getDokumentOfDatabase(dbConn,selinasuser.user,request));//SessionAttribut:DokumentOfDatabase
	         performForward("/selinas/selinas003.jsp", request, response);//JSP- Seite zum Verwalten
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
	
	public DokumentToRequestServlet() {
		super();
	}//DokumentServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "work with UserBean Selinas";
	}//getServletInfo

}//class DokumentToInitializeServlet