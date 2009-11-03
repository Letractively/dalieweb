package dalieweb;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.fop.apps.Driver;
import org.apache.fop.apps.InputHandler;
import org.apache.fop.apps.XSLTInputHandler;

public class LebenslaufGetReport extends HttpServlet implements Servlet {
	
	public static final String XML_REQUEST_PARAM = "xml";
	public static final String XSL_REQUEST_PARAM = "xsl";
	
	
	/** perform for both HTTP <code>GET</code> and <code>POST</code> methods  */
	protected void perForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		try {
            RequestDispatcher displogin = request.getRequestDispatcher("LogOnCheck");
            displogin.include(request, response);
        } catch (ServletException se) {
            performForward("/lebenslauf/lebenslauf001.jsp", request, response);//Login
        }//catch ServletException
        
        try{
			String xmlParam = request.getParameter(XML_REQUEST_PARAM);
			String xslParam = request.getParameter(XSL_REQUEST_PARAM);

			
				if ((xmlParam != null) && (xslParam != null)) {
					InputHandler input = new XSLTInputHandler(new File(getServletContext().getRealPath(xmlParam)),new File(getServletContext().getRealPath(xslParam)));
					renderXML(input, response);
					} else {
						PrintWriter out = response.getWriter();
						out.println("<html><head><title>Error</title></head>\n"+
								   "<body><h1>FopServlet Error</h1><h3>No"+
								   " request param given.</body></html>");
					}//endif
				}catch(ServletException ex) {
				   throw ex;
				}catch(Exception ex) {
				   throw new ServletException(ex);
				}//try
        
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
	
	public LebenslaufGetReport() {
		super();
	}//DokumentServlet
	
	/**@return a short description of this Servlet */
	public String getServletInfo() {
	    return "Create a Lebenslauf on PDF";
	}//getServletInfo
	

		public void renderXML(InputHandler input,HttpServletResponse response) throws ServletException {
			   try {
				   ByteArrayOutputStream out = new ByteArrayOutputStream();

				   response.setContentType("application/pdf");

				   Driver driver = new Driver();
				   //driver.setLogger(log);
				   driver.setRenderer(Driver.RENDER_PDF);
				   driver.setOutputStream(out);
				   driver.render(input.getParser(), input.getInputSource());

				   byte[] content = out.toByteArray();
				   response.setContentLength(content.length);
				   response.getOutputStream().write(content);
				   response.getOutputStream().flush();
			   } catch (Exception ex) {
				   throw new ServletException(ex);
			   }//try
		   }//renderXML
}//class LebenslaufGetReport