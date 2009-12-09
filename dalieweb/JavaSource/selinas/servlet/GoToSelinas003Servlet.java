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
import database.dateien.Dokument;
import database.dateien.Selinas;

public class GoToSelinas003Servlet extends HttpServlet implements Servlet {
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
		SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas"));
	    SelinasUser selinasuser = (SelinasUser) session.getAttribute("User");
	    Dokument dokumentOfSession = (Dokument)session.getAttribute("Dokument");
	    Database dbConn = (Database) session.getAttribute("Database");
		String nextPage = "/selinas/selinas001.jsp";
		
 		try {
 	        RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
      		displogin.include(request, response);  		
 		}catch (ServletException se) {
 		   performForward(nextPage,request,response);//Login 
     	}//catch ServletException
		
 		
	 	try{
	 		session.setAttribute("Dokument", show.getDokumentOfDatabase(dbConn,selinasuser.user,dokumentOfSession));//SessionAttribut:DokumentOfDatabase
	 		if(request.getParameter("linkOrderByTyp") != null)//
	 			session.setAttribute("LinkOrderByTyp",request.getParameter("linkOrderByTyp"));//SessionAttribut:DokumentOfInitialization
 			if(request.getParameter("upLoadOn")!= null){
 				if((session.getAttribute("UpLoadOn").toString()).equalsIgnoreCase("1")){
 					session.setAttribute("UpLoadOn","0");//SessionAttribut:UplaodTabelle nicht anzeigen
 				}else{
 					session.setAttribute("UpLoadOn","1");//SessionAttribut:UplaodTabelle anzeigen
 					}//endif
 			}//endif
	 		if(request.getParameter("dokumentOrderByTyp") != null)//
	 			session.setAttribute("DokumentOrderByTyp",request.getParameter("dokumentOrderByTyp"));//SessionAttribut:DokumentOfInitialization
	 			
	 		performForward("/selinas/selinas003.jsp",request,response); 			
	 		}catch (Exception e) {
	 			performForward(nextPage,request,response);//Login 
	 		}//catch ServletException
	 	
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
	
	public GoToSelinas003Servlet() {
		super();
	}//GoToStartServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "navigation of Selinas";
	}//getServletInfo

}//class GoToSelinas003Servlet