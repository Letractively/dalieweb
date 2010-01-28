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

public class GoToSelinas004Servlet extends HttpServlet implements Servlet {
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
		HttpSession session = request.getSession();
		SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas"));
	    SelinasUser selinasuser = (SelinasUser) session.getAttribute("User");
	    Dokument dokumentOfSession = (Dokument)session.getAttribute("Dokument");
	    Database dbConn = (Database) session.getAttribute("Database");
	    String lastDokumentOrderByTyp = (String)session.getAttribute("DokumentOrderByTyp");
	    String currentDokumentOrderByTyp = request.getParameter("dokumentOrderByTyp");
	    String lastLinkOrderByTyp = (String)session.getAttribute("LinkOrderByTyp");
		String currentLinkOrderByTyp = request.getParameter("linkOrderByTyp");
		String nextPage = "/selinas/selinas001.jsp";
		
 		try {
 	        RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
      		displogin.include(request, response);  		
 		}catch (ServletException se) {
 		   performForward(nextPage,request,response);//Login 
     	}//catch ServletException
		
	 	try{
	 		session.setAttribute("Dokument", show.getDokumentOfDatabase(dbConn,selinasuser.user,dokumentOfSession));//SessionAttribut:DokumentOfDatabase
	 		
	 		if(request.getParameter("upLoadOn")!= null){//Button: Download zeigen
 				if((session.getAttribute("UpLoadOn").toString()).equalsIgnoreCase("1")){
 					session.setAttribute("UpLoadOn","0");//SessionAttribut:UploadTable don't show
 				}else{
 					session.setAttribute("UpLoadOn","1");//SessionAttribut:UploadTable show
 					}//endif
 			}//endif
	 		
	 		if(request.getParameter("dokumentOrderByTyp") != null){//Table-Link:sort by Dokument
	 			if(lastDokumentOrderByTyp.equalsIgnoreCase(currentDokumentOrderByTyp)){
	 				lastDokumentOrderByTyp = lastDokumentOrderByTyp + "D";
	 				session.setAttribute("DokumentOrderByTyp",lastDokumentOrderByTyp);//SessionAttribut:sort by Dokument
	 			}else{
	 				session.setAttribute("DokumentOrderByTyp",request.getParameter("dokumentOrderByTyp"));//SessionAttribut:sort by Dokument
	 			}//endif
	 		}//endif
	 		
	 		if(request.getParameter("linkOrderByTyp") != null){//Table-Link:sort by Dokument
	 			if(lastLinkOrderByTyp.equalsIgnoreCase(currentLinkOrderByTyp)){
	 				lastLinkOrderByTyp = lastLinkOrderByTyp + "D";
	 				session.setAttribute("LinkOrderByTyp",lastLinkOrderByTyp);//SessionAttribut:sort by Link
	 			}else{
	 				session.setAttribute("LinkOrderByTyp",currentLinkOrderByTyp);//SessionAttribut:sort by Link
	 			}//endif
	 		}//endif
	 		
	 		if(request.getParameter("memo") != null){//Table-Link:sort by Dokument
	 			show.getDokumentLinkOfUpdate(dbConn,selinasuser.user,dokumentOfSession,request);
	 		}//endif
	 		session.setAttribute("MemoLoad","memoLoadOFF");//SessionAttribut:MemoTable don't show
	 		performForward("/selinas/selinas004.jsp",request,response);//show Page selinas003.jsp 			
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
	
	public GoToSelinas004Servlet() {
		super();
	}//GoToStartServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "navigation of Selinas";
	}//getServletInfo

}//class GoToSelinas003Servlet