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

import dalieweb.beehive.bean.Address;

/**
 * Servlet implementation class GoToServlet001
 */
public class GoToServlet001 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String BEAN_FOR_ADDRESS = "Address";
	
	 /** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
    protected void perForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession session = request.getSession(false);
         if (session == null){
             return;
         }
         
         Address address = (Address)request.getAttribute(BEAN_FOR_ADDRESS);
         if (address == null) {
        	 address = new Address();
         }
         
         
         //System.out.println(address.toString());
         Map<String, String> mParameter = new HashMap<String, String>();
         Enumeration<?> names = request.getParameterNames();
         while (names.hasMoreElements()) {
           String name = (String) names.nextElement();
           mParameter.put(name, request.getParameter(name));
         }
         if (mParameter.containsKey(Address.ADDRESS_FIRST_NAME)) {
        	 address.setFirstName(mParameter.get(Address.ADDRESS_FIRST_NAME));
         }
         if (mParameter.containsKey(Address.ADDRESS_LAST_NAME)) {
        	 address.setLastName(mParameter.get(Address.ADDRESS_LAST_NAME));
         }
         if (mParameter.containsKey(Address.ADDRESS_STREET_1)) {
        	 address.setStreet1(mParameter.get(Address.ADDRESS_STREET_1));
         }
         if (mParameter.containsKey(Address.ADDRESS_STREET_2)) {
        	 address.setStreet2(mParameter.get(Address.ADDRESS_STREET_2));
         }
         if (mParameter.containsKey(Address.ADDRESS_CITY)) {
        	 address.setCity(mParameter.get(Address.ADDRESS_CITY));
         }
         if (mParameter.containsKey(Address.ADDRESS_POSTAL_CODE)) {
        	 address.setPostalCode(mParameter.get(Address.ADDRESS_POSTAL_CODE));
         }
         if (mParameter.containsKey(Address.ADDRESS_COUNTRY)) {
        	 address.setCountry(mParameter.get(Address.ADDRESS_COUNTRY));
         }
         
         if (mParameter.containsKey(Address.ADDRESS_SUBMITTED)) {
        	 address.isValidate();
         }
         
         request.setAttribute(BEAN_FOR_ADDRESS, address);
         
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
