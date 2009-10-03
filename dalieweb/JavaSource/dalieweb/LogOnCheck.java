package dalieweb;

import help.LoggerHelper;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import selinas.SelinasUser;

import database.dateien.Message;
import database.getDatabase.DataSetMessage;
import database.getDatabase.DataSetStatus;


public class LogOnCheck extends HttpServlet implements Servlet {

    database.Database dbConn;	
    
    /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
    protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        dbConn = (database.Database) session.getAttribute("Database");
        SelinasUser user = (SelinasUser)session.getAttribute("User");
        Message error;
        try {
            dbConn.getConnection();//DatabaseConnection open
            if ((user != null) && (user.checkStatus(DataSetStatus.chain(dbConn,"A","DE")))){
            } else {
                //User isn't okay.
                error = DataSetMessage.chain(dbConn, "Loginfehler",(String) session.getAttribute("Speech"));
				request.setAttribute("Message", error.getErrorMsg());
                throw new ServletException("Error");
            }//endif user!=null
       } catch (Exception e) {
            LoggerHelper.log(this.getClass().getName(), "Exception of perForm LoginTestServlet", e);
            throw new ServletException("Error");
       }//catch
    }//perform
    
    /** handle the HTTP <code>GET</code> method */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		perForm(request,response);
	}//doPost
	/** handle the HTTP <code>POST</code> method */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		perForm(request,response);
	}//doPost
	
	public LogOnCheck() {
		super();
	}//LogOnCheck
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "check User-Login on Lebenslauf";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy LogOnCheck", e);
	    }//catch
	}//destroy

}//class LogOnCheck
