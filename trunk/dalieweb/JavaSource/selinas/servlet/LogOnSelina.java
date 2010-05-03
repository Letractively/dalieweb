package selinas.servlet;

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

import lebenslauf.Navigation;

import selinas.SelinasModul;
import selinas.SelinasUser;

import database.Database;
import database.dateien.Message;
import database.getDatabase.DataSetMessage;
import database.getDatabase.DataSetStatus;
import database.getDatabase.DataSetUser;
import database.getDatabase.DataSetSelinas;
import database.getDatabase.DataSetTypen;

import help.LoggerHelper;

public class LogOnSelina extends HttpServlet implements Servlet {
    
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
    			if ((user != null) && (user.checkPassword(request.getParameter("password"))) && (user.checkStatus(DataSetStatus.chain(dbConn,"A","DE")))){
    				session.setAttribute("User", user);
    				session.setAttribute("PermitId",(new Integer(user.user.getPermitId())).toString());
    				session.setAttribute("Selinas",DataSetSelinas.chain(dbConn,user.user.getSelinasId(),user.user.getSelinasStandortId(),request.getParameter("speech")));
    				session.setAttribute("SelectTyp","UB");////SessionAttribut:CCS <LI>.Element current is on
    				session.setAttribute("UpLoadOn","0");////SessionAttribut:UploadTable don't show
    				session.setAttribute("DokumentOrderByTyp","TNI");//SessionAttribut:sort by Dokument
    				session.setAttribute("LinkOrderByTyp","D");//SessionAttribut:sort by Link
    				session.setAttribute("TypOrderByTyp","B");//SessionAttribut:sort by DokumentTyp
    				session.setAttribute("UserOrderByTyp","U");//SessionAttribut:sort by UserId
    				session.setAttribute("AdressOrderByTyp","U");//SessionAttribut:sort by Adresse
    				session.setAttribute("MemoLoad","memoLoadOFF");//SessionAttribut:MemoLoad(Funktion:laden Tooltip möglich ja/nein)Table show
    				session.setAttribute("SelinasModul",new SelinasModul(DataSetTypen.chainDatenTypSelinasModel(dbConn,"D",request.getParameter("speech").toString())));
    				
    				try {
    		 	        RequestDispatcher displogin =  request.getRequestDispatcher("LogOnSelinaInializeServlet");
    		      		displogin.include(request, response);  		
    		 		}catch (ServletException se) {
    		 		   performForward(nextPage,request,response);//Login 
    		     	}//catch ServletException
    				
    				performForward("/selinas/selinas002.jsp",request,response);//JSP- show all Dokuments
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

	public LogOnSelina() {
		super();
	}//LogOnSelinaServlet
	
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

}//class LogOnSelina