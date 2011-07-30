package selinas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GoGuestBook
 */
@WebServlet(name = "GoToGuestBookEntry", description = "get Response of GuestBook", urlPatterns = { "/GoToGuestBookEntry" })
public class GoToGuestBookEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null){
		    return;
		}
		String nextPage = "/gaestebuch/guestbook002LB.jsp";
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
	
}//class GoGuestBook
