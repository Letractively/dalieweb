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

public class AdressToProcessServlet extends HttpServlet implements Servlet {
	 /* Aufruf der Adressverarbeitung */
	
	Database dbConn;
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    String nextPage = "/selinas/selinas001.jsp";
	    SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas"));
	    SelinasUser selinasuser = (SelinasUser) session.getAttribute("User"); 
	    Adresse adressOfSession = (Adresse)session.getAttribute("Adresse");
	    dbConn = (Database) session.getAttribute("Database");
	     
		try{
		    RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
	    	displogin.include(request, response);
		}catch (ServletException se) {
		    performForward(nextPage,request,response);//Login 
	     }//catch ServletException
		 
		 try{
		 	RequestDispatcher errorServlet =  request.getRequestDispatcher("ErrorServlet");
		 	errorServlet.include(request, response);
		 }catch (ServletException se) {
		 	performForward(nextPage,request,response);//Login 
		 }//catch ServletException
	     
	 	 String error = (String) session.getAttribute("Error");
	 	 if(request.getParameter("beenden") == null){//Button: Verarbeitung starten
	 	 	try{
	 	 		if(error.equalsIgnoreCase("yes")) { 
	 	 			session.setAttribute("Adresse", show.getAdressOfRequest(adressOfSession,request));//SessionAttribut:AdressOfRequest
	 	 			performForward("/selinas/selinas020.jsp",request,response);
	 	 		}else{
	 	 			session.setAttribute("Adresse", show.getAdressOfUpdate(dbConn,selinasuser.user,adressOfSession,request));//SessionAttribut:AdressOfUpdate
	 	 			performForward("/selinas/selinas020.jsp",request,response);
	 	 		}//endif error.equals
	 	 	}catch (Exception e) {
	 	 		LoggerHelper.log(this.getClass().getName(), "Exception of perForm..: Button -> AdressVerwaltung verarbeiten ", e);
	 	 		performForward(nextPage,request,response);//Login 
	 	 	}//catch ServletException
	 	 }else{//button beendet
 	 		try {
		 		 if(error.equalsIgnoreCase("yes")) {//Fehler: found 
		 			session.setAttribute("Adresse", show.getAdressOfRequest(adressOfSession,request));//SessionAttribut:AdressOfRequest
		 			performForward("/selinas/selinas020.jsp",request,response);
		 		}else{//Fehler: not found
		 			performForward("/selinas/selinas002.jsp",request,response);
		 			}//endif
			} catch (Exception e) {
				LoggerHelper.log(this.getClass().getName(), "Exception of perForm..: Button -> AdressVerwaltung beenden ", e);
				performForward(nextPage,request,response);//Login 
			}//
	 	 }//endif
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
	
	public AdressToProcessServlet() {
		super();
	}//AdressServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return this.getClass().getName() +"Adresse: update/insert/delete ";
	}//getServletInfo

}//class AdressToProcessServlet