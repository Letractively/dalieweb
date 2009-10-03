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

import database.Database;
import database.dateien.Message;
import database.getDatabase.DataSetMessage;

public class LogOffSelina extends HttpServlet implements Servlet {
    	
        Database dbConn;
        
        /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
    	protected void perForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	    HttpSession session = request.getSession();
    	    dbConn = (Database) session.getAttribute("Database");
    	    try {
    			dbConn.getConnection();//DatabaseConnection open
    			Message error = DataSetMessage.chain(dbConn,"Logout",(String)session.getAttribute("Speech"));//getMessage from Database
    			request.setAttribute("Message", error.getErrorMsg());//Message to RequestAttribute
    		} catch (Exception e) {
    			//put of ErrorMessage
    			LoggerHelper.log(this.getClass().getName(), "Exception of perForm LogOff", e);
    		}//catch
    	    session.invalidate();
    	    performForward("/selinas/selinas001.jsp", request, response);//go back to User-Login
    	}//perForm
    	
    	/** handle the HTTP <code>GET</code> method */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	    perForm(request,response);
    	}//doGet
    	/** handle the HTTP <code>POST</code> method */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	     perForm(request, response);
    	}//doPost
    	/** handle the next step */
    	protected void performForward(String destination,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {	
    		ServletContext context = getServletContext();
    		RequestDispatcher dispatcher = context.getRequestDispatcher(destination);
    		dispatcher.forward(request, response);		
    	}//performForward
    	
    	public LogOffSelina() {
    		super();
    	}//LogoutServlet
    	/**@return a short description of this Servlet */
    	public String getServletInfo() {
    	    return "User-Logout on Selina";
    	}//getServletInfo
    	
    	/** finally method */
    	public void destroy(){
    	    try {
    	        dbConn.close();//DatabaseConnection close
    	    } catch (Exception e) {
    	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy LogoutServlet", e);
    	    }//catch
    	}//destroy
}//class LogOff