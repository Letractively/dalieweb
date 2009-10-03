/*
 * Created of DV0101 on 24.08.2009 14:24:22
 *
 * Filename	  Backward.java
 */
package dalieweb;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lebenslauf.Navigation;

/**
 * Class description goes here.
 *
 * @version 	1.00 24.08.2009 um 14:24:22
 * @author 		DV0101
 * <br><br>
 * private   = "false" nur sichtbar innerhalb der Klasse<br>
 * ohne      = 	       sichtbar innerhalb Package<br>
 * protected = "false" sichtbar innerhalb Package und abgeleiteten Klassen<br>
 * public    = "false" sichtbar ausserhalb<br>
 */
public class Backward extends HttpServlet implements Servlet {

    /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        try {
            RequestDispatcher displogin = request.getRequestDispatcher("LogOnCheck");
            displogin.include(request, response);
        } catch (ServletException se) {
            performForward("/lebenslauf/lebenslauf001.jsp", request, response);//Login
        }//catch ServletException
        
        try {
            Navigation navigation = (Navigation) session.getAttribute("Navigation");
            session.setAttribute("Event",navigation.getBackEvent());			                  
        } catch (Exception e) {
            performForward("/lebenslauf/lebenslauf001.jsp", request, response);//Login
        }//catch
        
        performForward("lebenslauf/lebenslauf002.jsp", request, response);//JSP- show all Dokuments
    
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
	
	public Backward() {
		super();
	}//BackwarServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "Handling of Navigation on Lebenslauf";
	}//getServletInfo
    
}//class Backward
