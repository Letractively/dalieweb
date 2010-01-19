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
import database.dateien.Selinas;

public class GoToSelinas030Servlet extends HttpServlet implements Servlet {
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
		SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas"));
	    SelinasUser selinasuser = (SelinasUser) session.getAttribute("User");
	    Database dbConn = (Database) session.getAttribute("Database");
	    String lastUserOrderByTyp = (String)session.getAttribute("UserOrderByTyp");
	    String currentUserOrderByTyp = request.getParameter("userOrderByTyp");
	   
		String nextPage = "/selinas/selinas001.jsp";
		
 		try {
 	        RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
      		displogin.include(request, response);  		
 		}catch (ServletException se) {
 		   performForward(nextPage,request,response);//Login 
     	}//catch ServletException
		
	 	try{
	 		/* Hier wird der angemeldete User ermittelt
	 		 * wird ein Satz gefunden, wird dieser dann gleich zur Verwaltung angezeigt.  */
	 		session.setAttribute("ShowUser",show.getUserOfDatabase(dbConn,selinasuser.user));//SessionAttribut:UserOfDatabase
	 		/* SessionAttribut: UserAdresse des aktiv angemeldeten User's  */
     		session.setAttribute("Adresse", show.getAdressOfDatabase(dbConn,selinasuser.user));//SessionAttribut:AdressOfDatabase
     		
	 		if(request.getParameter("userOrderByTyp")!= null){//Table-Typ:sort by Typ
	 			if(lastUserOrderByTyp.equalsIgnoreCase(currentUserOrderByTyp)){
	 				lastUserOrderByTyp = lastUserOrderByTyp + "D";
	 				session.setAttribute("UserOrderByTyp",lastUserOrderByTyp);//SessionAttribut:sort by Dokument
	 			}else{
	 				session.setAttribute("UserOrderByTyp",request.getParameter("userOrderByTyp"));//SessionAttribut:sort by Dokument
	 			}//endif
	 		}//endif
	 		
	 		performForward("/selinas/selinas030.jsp",request,response);//show Page selinas030.jsp Userverwaltung 			
	 	}catch (Exception e) {
	 		LoggerHelper.log(this.getClass().getName(), "Exception of perForm:", e);
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
	
	public GoToSelinas030Servlet() {
		super();
	}//GoToStartServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "Userverwaltung: show selinas030";
	}//getServletInfo

}//class GoToSelinas030Servlet