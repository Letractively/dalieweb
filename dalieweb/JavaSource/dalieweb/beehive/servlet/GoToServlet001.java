package dalieweb.beehive.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dalieweb.beehive.bean.BeanForServlet001;

/**
 * Servlet implementation class GoToServlet001
 */
public class GoToServlet001 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BEAN_FOR_SERVLET_001 = "BeanForServlet001";
    
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
    protected void perForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession session = request.getSession(false);
         if (session == null){
             return;
         }
         
         BeanForServlet001 beanFS001 = (BeanForServlet001)request.getAttribute(BEAN_FOR_SERVLET_001);
         if (beanFS001 == null) {
        	 beanFS001 = new BeanForServlet001();			
         }
         
         Map<String, String> mParameter = new HashMap<String, String>();
         Enumeration<?> names = request.getParameterNames();
         while (names.hasMoreElements()) {
           String name = (String) names.nextElement();
           mParameter.put(name, request.getParameter(name));
         }
         if (mParameter.containsKey("NameOFWebForm_Name")) {
        	 if (mParameter.get("NameOFWebForm_Name").length() == 0) {
        		 beanFS001.addMessage("Name is failed");
        	 }
			beanFS001.setName(mParameter.get("NameOFWebForm_Name"));
         }
         if (mParameter.containsKey("NameOFWebForm_FirstName")) {
        	 if (mParameter.get("NameOFWebForm_FirstName").length() == 0) {
        		 beanFS001.addMessage("First Name is failed");
        	 }
        	beanFS001.setFirstName(mParameter.get("NameOFWebForm_FirstName"));
         }
         
         request.setAttribute(BEAN_FOR_SERVLET_001, beanFS001);
         String nextPage = "/17_servlets/Servlets001.jsp";
         performForward(nextPage,request,response);//JSP- User Login
    }//perForm
    
	   /** handle the next step */
    protected void performForward(String destination,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {    
         ServletContext context = getServletContext();
         RequestDispatcher dispatcher = context.getRequestDispatcher(destination);
         dispatcher.forward(request, response);
    }//performForward
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, 
	 * HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		 perForm(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, 
	 * HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		 perForm(request,response);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoToServlet001() {
		super();
	}
	
}
