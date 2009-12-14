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


public class GoToSelinas002Servlet extends HttpServlet implements Servlet {
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
	    String lastDokumentOrderByTyp = (String)session.getAttribute("DokumentOrderByTyp");
	    String currentDokumentOrderByTyp = request.getParameter("dokumentOrderByTyp");
		String nextPage = "/selinas/selinas001.jsp";
		
 		try {
 	        RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
      		displogin.include(request, response);  		
 		}catch (ServletException se) {
 		   performForward(nextPage,request,response);//Login 
     	}//catch ServletException
		
	 	try{
	 		if(request.getParameter("dokumentOrderByTyp") != null){//Sortierung nach Dokument
	 			if(lastDokumentOrderByTyp.equalsIgnoreCase(currentDokumentOrderByTyp)){
	 				lastDokumentOrderByTyp = lastDokumentOrderByTyp + "D";
	 				session.setAttribute("DokumentOrderByTyp",lastDokumentOrderByTyp);//SessionAttribut:sort by Dokument
	 			}else{
	 				session.setAttribute("DokumentOrderByTyp",currentDokumentOrderByTyp);//SessionAttribut:sort by Dokument
	 			}//endif
	 		}//endif	
 			performForward("/selinas/selinas002.jsp",request,response);//show page
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
	
	public GoToSelinas002Servlet() {
		super();
	}//GoToStartServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "navigation of Selinas";
	}//getServletInfo

}//class GoToSelinas002Servlet