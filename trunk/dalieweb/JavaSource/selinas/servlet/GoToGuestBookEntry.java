package selinas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import selinas.bean.GuestBook002LB;

/**
 * Servlet implementation class GoGuestBook
 */
public class GoToGuestBookEntry extends HttpServlet implements Servlet {
	   
	private static final String GUEST_BOOK_002_LB = "GuestBook002LB";
	
    /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null){
		    return;
		}
		
		ServletContext context = getServletContext();  
		// Get bean from servlet context (same as application scope)  
		GuestBook002LB guestBook002LB = (GuestBook002LB)context.getAttribute(GUEST_BOOK_002_LB);
		    if (guestBook002LB == null) {
				guestBook002LB = new GuestBook002LB();
			}
		String nextPage = "/gaestebuch/guestbook002LB.jsp";
		context.setAttribute(GUEST_BOOK_002_LB, guestBook002LB);
		performForward(nextPage,request,response);//JSP- User Login
	}//perForm
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		perForm(request,response);
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		perForm(request,response);
	}//doPost

	/** handle the next step */
	protected void performForward(String destination,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {	
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(destination);
		dispatcher.forward(request, response);
	}//performForward
	
	/** finally method */
	public void destroy(){
	}//destroy
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoToGuestBookEntry() {
		super();
	}//GoToGuestBookEntry
	
}//class GoToGuestBookEntry
