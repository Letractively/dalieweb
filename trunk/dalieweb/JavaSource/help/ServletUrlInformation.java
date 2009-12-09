package help;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletUrlInformation extends HttpServlet implements Servlet {
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
		 /* Getting servlet request URL */
        String url = request.getRequestURL().toString();
        /* Getting servlet request query string. */
        String queryString = request.getQueryString();
        /* Getting request information without the hostname.*/
        String uri = request.getRequestURI();

        //
        // Below we extract information about the request object path
        // information. We extract the protocol user, server and and its 
        // assigned port number. We extract our application context path, 
        // servlet path, path info and the query string information. If we 
        // combaine all the information below we'll get someting equals to 
        // the request.getRequestURL().
        //
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int portNumber = request.getServerPort();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String query = request.getQueryString();

        System.out.println("1. url..:" + url);
        System.out.println("2. queryString..:" + queryString);
        System.out.println("3. uri..:" + uri);
        System.out.println("4. scheme..:" + scheme);
        System.out.println("5. serverName..:" + serverName);
        System.out.println("6. contextPath..:" + contextPath);
        System.out.println("7. servletPath..:" + servletPath);
        System.out.println("8. pathInfo..:" + pathInfo);
        System.out.println("9. query..:" + query);
        
        /*Get client's IP address */
        String clientIP = request.getRemoteAddr();
        /* Get client's host name */
        String clintHost = request.getRemoteHost();
        System.out.println("10. clientIP..:" + clientIP);
        System.out.println("11. clientHost..:" + clintHost);
        
        
        /* Get an instance of ServletContext */
    	ServletContext context = getServletContext();
    	String logPath = context.getInitParameter("LOG.PATH");
    	System.out.println("12. logPath..:" + logPath);
    	
    	performForward("/toTrail1.jsp", request, response);//go Site
	}//perForm
	
	/** handle the next step */
	protected void performForward(String destination,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {	
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(destination);
		dispatcher.forward(request, response);
	}//performForward
	
	
	/** handle the HTTP <code>GET</code> method */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    perForm(request,response);
	}//doGet
	/** handle the HTTP <code>POST</code> method */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    perForm(request,response);
	}//doPost
	
	public ServletUrlInformation() {
		super();
	}//UploadServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "get Info of UrlInformation";
	}//getServletInfo
	
	/** finally method */
	public void destroy(){
	    
	}//destroy

}//class ServletUrlInformation