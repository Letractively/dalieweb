
package selinas.servlet;

import help.HelpDate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import selinas.bean.GuestBook002LB;

import java.util.*;
import java.io.*;

/**
 * Servlet implementation class GoToGuestBookCapturer
 */
@WebServlet(description = "Determine GuestBook Captuer", urlPatterns = { "/GoToGuestBookCapturer" })
public class GoToGuestBookCapture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String GUEST_BOOK_002_LB = "GuestBook002LB";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoToGuestBookCapture() {
		super();
	}//GoToGuestBookCapturer
	
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
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		GuestBook002LB entry = null;
		String nextPage = "/gaestebuch/gaestebuch001.jsp";
		System.out.println("Hier");
		if (session == null) {
			
			return;
		}
		
	    ServletContext context = getServletContext();  
	    // Get bean from servlet context (same as application scope)  
	    entry = (GuestBook002LB)context.getAttribute(GUEST_BOOK_002_LB);
	    
	    System.out.println(entry);
	    if (entry == null) {
			entry = new GuestBook002LB();
		}
	    System.out.println(entry);
	    
		HelpDate helpDate = new HelpDate();
		String line = "", content = "", newContent = "";
		String fileName = "/gaestebuch/gaestebuch001F.jsp";
		String path = getServletContext().getRealPath("/");
		//String sep2 = ".";
		//String sep3 = ":";
		String lsep = System.getProperty("line.separator");
		
		Enumeration<String> eParameters = request.getParameterNames();
		Map<String, String[]> mParameters = request.getParameterMap();
		
	     while (eParameters.hasMoreElements()) {
	          String  param =  eParameters.nextElement().toString();
	          System.out.println("Parameter..: " + param + " = " + "ParameterValue..: "+ request.getParameter(param));
	     }

		if (mParameters.containsKey("Name")) {
	    	String name = request.getParameter("Name").toString();
		
	    		if (name != null ) 
	    			entry.setName(name);
			
	    } else {
	    		//entry.setMessage("Following correct");
	    	entry.addEntryToErrorList("Name is Missing");
	    }
	    		
		
		if (mParameters.containsKey("eMail")) {
			String eMail = request.getParameter("eMail").toString();
		
			if (eMail != null) 	
				entry.setEmail(eMail);
			
		} else {
			//entry.setMessage("Following correct");
			entry.addEntryToErrorList("eMail is Missing");
			
		}
		
		if (mParameters.containsKey("eMail")) {
			String commentary = request.getParameter("Commentary");
		
			if (commentary != null) 
				entry.setContent(commentary);
		
		} else {
			//entry.setMessage("Following correct");
			entry.addEntryToErrorList("Commentary is missing");
			
		}
		

		if (entry.isError()) {
			entry.setMessage("following correct");
			nextPage = "/gaestebuch/guestbook002LB.jsp";
			
			// Put bean back into context (same as application scope)  
			context.setAttribute(GUEST_BOOK_002_LB, entry);  
		} else {
		
		String data =  
			"<td width='25%' rowspan='2'>" + helpDate.getDDD_MM_JJJJ() + " <br />um " + helpDate.getHH_MM_SS() + "</td>" +
			"<table style='border-bottom: 1px dotted #222222;' border='0' width='80%' cellpadding='0' cellspacing='0'>" +
			"<tr>" +
			"<td><a href='mailto:P.biene@freenet.de'><b>Bienchen</b></a>&nbsp;<span>schrieb:</span></td>" +
			"</tr>" +
			"<tr>" +
			"<td style='font-size: 14px; padding: 5px 3px'>Ich bin echt stolz auf dich und bleib am Ball.:-))</td>" +
			"</tr>" +
			"</table>" + lsep;
		
		File fileLoad = new File(path + fileName);
		
		boolean ex = fileLoad.exists();
		boolean re = fileLoad.canRead();
		
		if (ex && re) {
			try {
				FileReader fileInput = new FileReader(fileLoad);
				BufferedReader input = new BufferedReader(fileInput);
				while((line = input.readLine()) != null ) {
					content = content + line + lsep;
				}
				input.close();
				int pos = content.indexOf("<!--Entry-->");
				String firstPart = content.substring(0,pos);
				
				String secondPart = content.substring(pos,content.length());
				newContent = firstPart + "<!--Entry-->" + lsep + data + secondPart;
				
			} catch (IOException ioex) {
				System.out.println("FileLoad-Exception: " + ioex.getMessage());
			}
		} else {
			System.out.println("File does not exist: " + path + fileName);
		}
		
		boolean rw = fileLoad.canWrite();
		if (rw) {
			try {
				FileWriter fileOut = new FileWriter(fileLoad);
				BufferedWriter output = new BufferedWriter(fileOut);
				output.write(newContent);
				output.close();
			} catch (IOException ioex) {
				System.out.println("FileWrite-Exception" + ioex);
			}
		} else {
			System.out.println("File Write it isn't possible");
		}
		
		}
		//System.out.println(nextPage);
		performForward("/gaestebuch/guestbook002LB.jsp",request,response);//JSP- User Login
	}//perForm
	
	/** handle the next step */
	protected void performForward (String destination, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(destination);
		dispatcher.forward(request, response);
	}//performForward
	
	/** finally method. */
	public void destroy() {
	} /* destroy */
	
}//class GoToGuestBookCapturer