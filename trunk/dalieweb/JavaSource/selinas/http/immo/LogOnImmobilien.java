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

import lebenslauf.Navigation;
import database.Database;
import database.dateien.Message;
import database.getDatabase.DataSetMessage;
import database.getDatabase.DataSetSelinas;
import database.getDatabase.DataSetStatus;
import database.getDatabase.DataSetUser;

public class LogOnImmobilien extends HttpServlet {
	
	Database dbConn;
	Navigation navigation;
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
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  
	 * @throws ServletException
	 * @throws IOException*/
	protected void perForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    HttpSession session = request.getSession();
	    Message error;      
	    String nextPage = "/selinas/selinas001.jsp";
	    
	    if(request.getParameter("userId").toString().equalsIgnoreCase("") ){
    		request.setAttribute("Message","");
	    	performForward(nextPage,request,response);//JSP- User Login
	    }else{
    		try {
    			session.setAttribute("Database",dbConn);
    			session.setAttribute("Speech", request.getParameter("speech"));
    			dbConn.getConnection();//DatabaseConnection open
    			SelinasUser user = new SelinasUser(DataSetUser.chain(dbConn,request.getParameter("userId")));
    			if ((user != null) && 
    					(user.checkPassword(request.getParameter("password"))) && 
							(user.checkStatus(DataSetStatus.chain(dbConn,"A","DE")))){
    					
    				session.setAttribute("User", user);
    				session.setAttribute("PermitId",(new Integer(user.user.getPermitId())).toString());
    				session.setAttribute("Selinas",DataSetSelinas.chain(dbConn,user.user.getSelinasId(),user.user.getSelinasStandortId(),request.getParameter("speech")));
    				
    				performForward("/selinas/immo/immo001.jsp",request,response);//JSP- show all Dokuments
    			} else {
    				error = DataSetMessage.chain(dbConn, "Login",(String) session.getAttribute("Speech"));
    				request.setAttribute("Message", error.getErrorMsg());
    				performForward(nextPage,request,response);//JSP- User Login
    			}//endif user!=null
    		} catch (Exception e) {
    			LoggerHelper.log(this.getClass().getName(), "Exception 1 of perForm:", e);      
    			try {
    				error = DataSetMessage.chain(dbConn, "Login001",(String) session.getAttribute("Speech"));
    				request.setAttribute("Message", error.getErrorMsg());
            	} catch (Exception e1) {
            		LoggerHelper.log(this.getClass().getName(), "Exception 2 of perForm:", e1);
            	}//catch
                performForward(nextPage,request,response);//JSP- User Login
    		}//catch 
	    }//endif
	}//perForm  	
	
	/** handle the HTTP <code>GET</code> method */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	public LogOnImmobilien() {
		super();
	}//LogOnImmobilien
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "check User-Login on selina";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy LogOnSelina", e);
	    }//catch
	}//destroy

}//class LogOnImmobilien