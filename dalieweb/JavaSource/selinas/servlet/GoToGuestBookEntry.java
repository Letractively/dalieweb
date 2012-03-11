package selinas.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dalieweb.beehive.bean.Address;
import dalieweb.beehive.bean.GuestBookEntry;

import selinas.bean.GuestBook002LB;

/**
 * Servlet implementation class GoGuestBook
 */
public class GoToGuestBookEntry extends HttpServlet implements Servlet {
	   
	private static final String GUEST_BOOK_ENTRY = "GuestBookEntry";
	
    /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}

		GuestBookEntry guestBookEntry = (GuestBookEntry) request
				.getAttribute(GUEST_BOOK_ENTRY);
		
		if (guestBookEntry == null) {
			guestBookEntry = new GuestBookEntry();
		}

		Map<String, String> mParameter = new HashMap<String, String>();
		Enumeration<?> names = request.getParameterNames();
		Map<String, String[]> values = request.getParameterMap();
		for( Map.Entry<String, String[]> entry : values.entrySet() ) {
			
			String key = entry.getKey();
			String[] value = entry.getValue();
	
			System.out.println("key" + key);
			for (int i = 0; i < value.length; i++) {
				System.out.println("value"+value[i].trim().toString());
				
			}
			
		} /* for entry */
		
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println(name +";"+ request.getParameter(name.trim()));
			mParameter.put(name, request.getParameter(name.trim()));
		}

		if (mParameter.containsKey(GuestBookEntry.GUESTBOOK_ENTRY_NAME)) {
       	 guestBookEntry.setEntryName(
       			 mParameter.get(GuestBookEntry.GUESTBOOK_ENTRY_NAME));
        }
		if (mParameter.containsKey(GuestBookEntry.GUESTBOOK_ENTRY_EADDRESS)) {
	       	 guestBookEntry.setEntryEMail(
	       			 mParameter.get(GuestBookEntry.GUESTBOOK_ENTRY_EADDRESS));
	        }
		if (mParameter.containsKey(GuestBookEntry.GUESTBOOK_ENTRY_TEXTENTRY)) {
	       	 guestBookEntry.setEntryText(
	       			 mParameter.get(GuestBookEntry.GUESTBOOK_ENTRY_TEXTENTRY));
	        }
		
		if (mParameter.containsKey(GuestBookEntry.GUESTBOOK_SUBMITTED)) {
       	 guestBookEntry.isValidate();
        }
		System.out.println(guestBookEntry.toString());
		String nextPage = "/gaestebuch/guestbook002LB.jsp";
		request.setAttribute(GUEST_BOOK_ENTRY, guestBookEntry);
		performForward(nextPage, request, response);// JSP- User Login
	}// perForm
	
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
