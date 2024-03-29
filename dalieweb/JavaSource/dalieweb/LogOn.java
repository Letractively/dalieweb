package dalieweb;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lebenslauf.Event;
import lebenslauf.Navigation;

import selinas.SelinasUser;

import database.Database;
import database.dateien.Message;
import database.getDatabase.DataSetMessage;
import database.getDatabase.DataSetStatus;
import database.getDatabase.DataSetUser;

import help.LoggerHelper;

public class LogOn extends HttpServlet implements Servlet {
    
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
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    HttpSession session = request.getSession();
	    Message error;      

        try {
           	session.setAttribute("Database",dbConn);
            session.setAttribute("Speech", "DE");
            navigation = new Navigation("B");
            navigation.allEvents.put("K",new Event("Persönliches","Berufslaufbahn","/lebenslauf/personendaten.jsp"));
            navigation.allEvents.put("B",new Event("Personendaten","Bildungsweg","/lebenslauf/beruf.jsp"));
            navigation.allEvents.put("A",new Event("Berufslaufbahn","Projekte","/lebenslauf/bildung.jsp"));
            navigation.allEvents.put("P",new Event("Bildungsweg","Lehrgänge","/lebenslauf/projekt.jsp"));
            navigation.allEvents.put("L",new Event("Projekte","Persönliches","/lebenslauf/lehrgang.jsp"));
            navigation.allEvents.put("S",new Event("Lehrgänge","Personendaten","/lebenslauf/persoenliches.jsp"));
           	session.setAttribute("Navigation",navigation);
           	session.setAttribute("Event",navigation.getStartEvent());
           	dbConn.getConnection();//DatabaseConnection open
           	SelinasUser user = new SelinasUser(DataSetUser.chain(dbConn,request.getParameter("userId")));
           	if ((user != null) && (user.checkPassword(request.getParameter("password"))) && (user.checkStatus(DataSetStatus.chain(dbConn,"A","DE")))){
           	    session.setAttribute("User", user);
           	    session.setAttribute("PermitId",(new Integer(user.user.getPermitId())).toString());   	            	
           	    performForward("/lebenslauf/lebenslauf002.jsp",request,response);//JSP- show all Dokuments
           	} else {
           	    error = DataSetMessage.chain(dbConn, "Login",(String) session.getAttribute("Speech"));
                request.setAttribute("Message", error.getErrorMsg());
           	    performForward("/lebenslauf/lebenslauf001.jsp",request,response);//JSP- User Login
           	}//endif user!=null
        } catch (Exception e) {
            LoggerHelper.log(this.getClass().getName(), "Exception 1 of perForm LoginServlet", e);      
            try {
                error = DataSetMessage.chain(dbConn, "Login001",(String) session.getAttribute("Speech"));
                request.setAttribute("Message", error.getErrorMsg());
            } catch (Exception e1) {
                LoggerHelper.log(this.getClass().getName(), "Exception 2 of perForm LoginServlet", e1);
            }//catch
                performForward("/lebenslauf/lebenslauf001.jsp",request,response);//JSP- User Login
      	}//catch 
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

	public LogOn() {
		super();
	}//LoginServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "check User-Login on dalieweb";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy LoginServlet", e);
	    }//catch
	}//destroy

}//class LogOn