package selinas.servlet;

import help.LoggerHelper;

import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Database;
import selinas.InputCheck;

public class ErrorServlet extends HttpServlet implements Servlet {
	
    Database dbConn;
    
    /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();
        dbConn = (Database) session.getAttribute("Database");
        try {
            dbConn.getConnection();//DataBaseConnection open
            session.setAttribute("Error","no");
            Enumeration eParameters = request.getParameterNames();
            while (eParameters.hasMoreElements()) {
                	String param = eParameters.nextElement().toString();
                	System.out.println("Parameter..: " + param + " = " + "ParameterValue..: "+ request.getParameter(param));
                	InputCheck test = new InputCheck(dbConn, param, request.getParameter(param),(String) session.getAttribute("Speech"));
                	if (test.CheckInput()){
                	    request.setAttribute("Message", test.error.getErrorMsg());
                	    session.setAttribute("Error","yes");
                	    break;
                	}//endif test.CheckInput
            }//while
        } catch (Exception e) {
            LoggerHelper.log(this.getClass().getName(), "Exception of perForm ErrorServlet", e);
            throw new ServletException("Error");
        }//catch
    }//perform
	/** handle the HTTP <code>GET</code> method */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		perForm(request,response);
	}//doPost
	/** handle the HTTP <code>POST</code> method */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		perForm(request,response);
	}//doPost
	
	public ErrorServlet(){
		super();
	}//ErrorSevlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "check InputParameter is valid or not";
	}//getServletInfo
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy ErrorServlet", e);
	    }//catch
	}//destroy
	
}//class ErrorServlet