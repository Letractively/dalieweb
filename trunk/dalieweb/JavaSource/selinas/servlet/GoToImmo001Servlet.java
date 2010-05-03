package selinas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GoToImmo001Servlet extends HttpServlet {
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
	    String lastImmobilienOrderByTyp = (String)session.getAttribute("ImmobilienOrderByTyp");
	    String currentImmobilienOrderByTyp = request.getParameter("immobilienOrderByTyp");
		String nextPage = "/selinas/selinas001.jsp";
		
 		try {
 	        RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
      		displogin.include(request, response);  		
 		}catch (ServletException se) {
 		   performForward(nextPage,request,response);//Login 
     	}//catch ServletException
		
	 	try{
	 		if(request.getParameter("immobilienOrderByTyp") != null){//Sortierung nach Dokument
	 			if(lastImmobilienOrderByTyp.equalsIgnoreCase(currentImmobilienOrderByTyp)){
	 				lastImmobilienOrderByTyp = lastImmobilienOrderByTyp + "D";
	 				session.setAttribute("ImmobilienOrderByTyp",lastImmobilienOrderByTyp);//SessionAttribut:sort by Dokument
	 			}else{
	 				session.setAttribute("ImmobilienOrderByTyp",currentImmobilienOrderByTyp);//SessionAttribut:sort by Dokument
	 			}//endif
	 		}//endif	
 			performForward("/selinas/immo/immo001.jsp",request,response);//show page
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
	
	public GoToImmo001Servlet() {
		super();
	}//GoToImmo001Servlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "navigation of Selinas";
	}//getServletInfo

}//class GoToImmo001Servlet