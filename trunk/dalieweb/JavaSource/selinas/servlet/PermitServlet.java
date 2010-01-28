package selinas.servlet;

import help.LoggerHelper;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import selinas.SelinasUser;

import database.Database;
import database.getDatabase.DataSetUser;
import database.dateien.Dokument;
import database.dateien.User;

public class PermitServlet extends HttpServlet implements Servlet {
	
	private Database dbConn;
	private Dokument dokument;
	private SelinasUser selinasuser;
	private String sRet = "";
	private String permitInfo = "0";
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response){             	
		HttpSession session = request.getSession();
        dbConn = (Database) session.getAttribute("Database");
        dokument = (Dokument) session.getAttribute("Dokument");
        selinasuser = (SelinasUser) session.getAttribute("User");
        try{
        	if((String)session.getAttribute("PermitInfo") != null)
        		permitInfo = (String)session.getAttribute("PermitInfo");
        
        	if(permitInfo == null || permitInfo.equalsIgnoreCase("0")){
        		if(dokument.getStatus().equalsIgnoreCase("p")){
        			request.setAttribute("permitInfo",getResult(selinasuser.user,request,response));
        		}else{
        			request.setAttribute("permitInfo",getResult(DataSetUser.reade(dbConn,dokument),request,response));
        		}//endif
        		session.setAttribute("PermitInfo","1");//SessionAttribut:show
        	}else{
        		request.setAttribute("permitInfo","");
        		session.setAttribute("PermitInfo","0");//SessionAttribut:show
        	}//endif
        
        } catch (Exception e) {
        	LoggerHelper.log(this.getClass().getName(), " perForm..:", e);
        }//catch
        
	}//perForm
	 
	protected String getResult(User user,HttpServletRequest request, HttpServletResponse response) {
	    sRet = "<table style=\" background-color: lightyellow; border:1px solid black; \"><caption style=\"font-weight: bold; font-size: 10px; font-family: Helvetica,sans-serif; margin-left: 3px; text-align: left; \">Info zum Status</caption>";
    	sRet += "<tr><td>&nbsp;Name&nbsp;</td>";
    	sRet += "<td>"+ user.getUserId() +"&nbsp;"+user.getName() +","+ user.getVorname() +"&nbsp;&nbsp;</td></tr>";
		sRet += "</tr></table></ br>";	
		return sRet;
	    }//getResult
	protected String getResult(Vector allUser,HttpServletRequest request, HttpServletResponse response) {
	    sRet = "<table style=\" background-color: lightyellow; border:1px solid black; \"><caption style=\"font-weight: bold; font-size: 10px; font-family: Helvetica,sans-serif; margin-left: 3px; text-align: left; \">Info zum Status</caption>";
    	sRet += "<tr><td rowspan=\""+allUser.size()+1 +"\" valign=\"top\">&nbsp;Name&nbsp;</td></tr>";
    	 for (int i = 0; i < allUser.size(); i++){         
			User user  = ((User)allUser.elementAt(i));
    	sRet += "<tr><td>"+ user.getUserId() +"&nbsp;"+user.getName() +","+ user.getVorname() +"&nbsp;&nbsp;</td></tr>";
    	 }//for
    	sRet += "</table></ br>";	
		return sRet;
	    }//getResult
	/** handle the HTTP <code>GET</code> method 
	 * @throws 
	 * @throws Exception*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
	    perForm(request,response);
	}//doGet
	/** handle the HTTP <code>POST</code> method */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
	    perForm(request,response);
	}//doPost
	
	/** handle the next step */
	protected void performForward(String destination,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {	
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(destination);
		dispatcher.forward(request, response);		
	}//performForward
	
	public PermitServlet() {
		super();
	}//PermitServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "create the permit-info about current dokument on session";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    try {
	        dbConn.close();//DatabaseConnection close
	    } catch (Exception e) {
	        LoggerHelper.log(this.getClass().getName(), "Exception of destroy..: ", e);
	    }//catch
	}//destroy

}//class PermitServlet