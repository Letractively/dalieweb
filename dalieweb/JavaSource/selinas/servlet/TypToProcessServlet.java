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

import selinas.InputCheck;
import selinas.SelinasUser;
import selinas.bean.SelinasSession;
import database.Database;
import database.dateien.Selinas;
import database.dateien.Typ;
import database.getDatabase.DataSetSelectOptionen;
import database.getDatabase.DataSetTyp;

public class TypToProcessServlet extends HttpServlet implements Servlet {
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    String nextPage = "/selinas/selinas001.jsp";
	    SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas"));
	    SelinasUser selinasuser = (SelinasUser) session.getAttribute("User"); 
	    Typ typOfSession = (Typ)session.getAttribute("Typ");
	    Database dbConn = (Database) session.getAttribute("Database");
	    String language = (String)session.getAttribute("Speech");
	    
	    try{
		    RequestDispatcher displogin =  request.getRequestDispatcher("LogOnCheck");
	    	displogin.include(request, response);
		}catch (ServletException se) {
		    performForward(nextPage,request,response);//Login 
	    }//catch ServletException
		 
		try{
			RequestDispatcher errorServlet =  request.getRequestDispatcher("ErrorServlet");
		 	errorServlet.include(request, response);
		}catch (ServletException se) {
			performForward(nextPage,request,response);//Login 
		}//catch ServletException
	     
	 	String error = (String) session.getAttribute("Error");
	 	if(request.getParameter("new") != null){//Button: Dokumenttypen neu
 	 		try{	
 	 			/* gültigen Dokumenttyp ermitteln */
 	 			session.setAttribute("Typ", show.getTypOfInitialize(dbConn,selinasuser.user,language));//SessionAttribut:DokumentTypOfInitialize
	 	 		performForward("/selinas/selinas025.jsp",request,response);
		    } catch (Exception e) {
		       	LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
		       	performForward(nextPage,request,response);//Login 
		    }//catch
		}else{//endif button
			if(request.getParameter("delete") != null){//Button: Dokumenttypen löschen
				try{
					session.setAttribute("Error","no");
					InputCheck test = new InputCheck(dbConn,"DeleteDokumentTyp",DataSetTyp.getCounter(dbConn,selinasuser.user,typOfSession.getTyp()),language);
					if (test.checkCount()){
						request.setAttribute("Message", test.error.getErrorMsg());
						session.setAttribute("Error","yes");
					}else{
						DataSetTyp.delete(dbConn,selinasuser.user.getKundenId(),selinasuser.user.getStandortId(),typOfSession.getTyp());
						DataSetSelectOptionen.delete(dbConn,"DokumentTyp",language,"KA",typOfSession.getTyp());
						/* ersten gültigen Dokumenttyp ermitteln */
						session.setAttribute("Typ",show.getTypOfDatabase(dbConn,selinasuser.user));//SessionAttribut:DokumentTypOfDatabase
					}//endif test.CheckCount
					performForward("/selinas/selinas025.jsp",request,response);
				} catch (Exception e) {
					LoggerHelper.log(this.getClass().getName(),"Exception of perForm..:", e);
					performForward(nextPage,request,response);//Login 
		        }//catch
		}else{//endif button
		 	if(request.getParameter("beenden") == null){//Button: Verarbeitung starten
		 		try{
		 			if(error.equalsIgnoreCase("yes")) {//Fehler: gefunden 
		 				session.setAttribute("Typ", show.getTypOfRequest(typOfSession,request));//SessionAttribut:AdressOfUpdate
		 				performForward("/selinas/selinas025.jsp",request,response);
		 			}else{//Fehler: not found
		 				session.setAttribute("Typ", show.getTypOfUpdate(dbConn,selinasuser.user,typOfSession,request,language));//SessionAttribut:AdressOfUpdate
		 				performForward("/selinas/selinas025.jsp",request,response);
		 			}//endif error.equals
		 		}catch (Exception e) {
		 			LoggerHelper.log(this.getClass().getName(), "Exception of perForm Verarbeitung", e);
		 			performForward(nextPage,request,response);//Login 
		 		}//catch ServletException
			}else{//Button: beenden
		 		try {
		 			if(error.equalsIgnoreCase("yes")) {//Fehler: found 
		 				session.setAttribute("Typ", show.getTypOfRequest(typOfSession,request));//SessionAttribut:AdressOfUpdate
		 				performForward("/selinas/selinas025.jsp",request,response);
		 			}else{//Fehler: not found
		 				//session.setAttribute("Typ", show.getTypOfUpdate(dbConn,selinasuser.user,typOfSession,request));//SessionAttribut:AdressOfUpdate
		 				performForward("/selinas/selinas002.jsp",request,response);
		 			}//endif
		 		} catch (Exception e) {
		 			LoggerHelper.log(this.getClass().getName(), "Exception of perForm Beenden", e);
		 			performForward(nextPage,request,response);//Login 
		 		}//catch
		 	}//endif beenden
		}//endif löschen
		}//endif neu
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
	
	public TypToProcessServlet() {
		super();
	}//TypToProcessServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "Manipulation on Database: DataTable Dokumenttyp ";
	}//getServletInfo


}//class AdressToProcessServlet