package selinas.http.immo;

import help.LoggerHelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import selinas.SelinasUser;

import database.Database;
import database.getDatabase.DataSetStaLanImo;

public class LogOnImmobilienToInitialize extends HttpServlet{
	
	Database dbConn;
	
	/** perform servlet initialization */
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    String dbType = config.getInitParameter("dbType");
	    String dbHost = config.getInitParameter("dbHost");
	    String dbSchema = config.getInitParameter("dbSchema");
	    String user = config.getInitParameter("user");
	    String password = config.getInitParameter("password");
	    dbConn = new Database(dbType,dbHost,dbSchema,user,password);    
	}//init
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		
		/* Obtain reference to session 
		Create a new if session is not initialized */
	    HttpSession session = request.getSession(true);
	    
	    try{
			session.setAttribute("Database",dbConn);
			session.setAttribute("ImmobilienOrderByTyp","K");
			SelinasUser user = (SelinasUser) session.getAttribute("User");
			String language = (String)session.getAttribute("Speech");
			dbConn.getConnection();
			session.setAttribute("StaLanImo",DataSetStaLanImo.chain(dbConn,user.user.getSelinasId(),user.user.getSelinasStandortId(),language));
		}catch (Exception e) {
	 		LoggerHelper.log(this.getClass().getName(),"Exception no User of Database:", e);
		}//catch
		
 		try {
 	        RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
      		displogin.include(request, response);  		
 		}catch (ServletException se) {
 		   performForward("/selinas/selinas001.jsp",request,response);//Login 
     	}//catch ServletException	
		
 		performForward("/selinas/immo/immo001.jsp",request,response);
    }//perform
	
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
	
	public LogOnImmobilienToInitialize() {
		super();
	}//LogOnImmobilienToInitialize
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "check User is ready to work on selina ";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(),"Exception of destroy: ", e);
	    }//catch
	}//destroy
}//class LogOnImmobilienToInitialize