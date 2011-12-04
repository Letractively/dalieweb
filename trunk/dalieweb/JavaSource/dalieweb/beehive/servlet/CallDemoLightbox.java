package dalieweb.beehive.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CallDemoLightbox.
 */
public class CallDemoLightbox extends HttpServlet {

	
	/**
     * perform for both HTTP <code>GET</code>
     * and <code>POST</code> methods.
     *
     * @param request The servlet container creates an HttpServletRequest object
     * @param response The servlet container creates an HttpServletResponse
     *
     * @throws ServletException Defines a general exception
     * @throws IOException Signals that an I/O exception
     * **/
    private void perForm(final HttpServletRequest request,
                final HttpServletResponse response)
                		throws ServletException , IOException {

         String nextPage = "/18_demoLightbox/Lightbox001.jsp";
         performForward(nextPage, request, response); /* forward to next */
    } /* perForm */

	/**
	 * handle the next step.
	 * 
	 * @param destination
	 *            next Task
	 * @param request
	 *            The servlet container creates an HttpServletRequest object
	 * @param response
	 *            The servlet container creates an HttpServletResponse
	 * 
	 * @throws ServletException
	 *            Defines a general exception
	 * @throws IOException
	 *             Signals that an I/O exception.
	 **/
	private void performForward(final String destination,
			final HttpServletRequest request, 
			final HttpServletResponse response)
					throws ServletException, IOException {

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context
				.getRequestDispatcher(destination);

		dispatcher.forward(request, response);
	} /* performForward */

	/**
	 * 
	 * @param request
	 *            The servlet container creates an HttpServletRequest object
	 * @param response
	 *            The servlet container creates an HttpServletResponse
	 * 
	 * @throws ServletException
	 *             Defines a general exception
	 * @throws IOException
	 *             Signals that an I/O exception
	 * **/
	protected final void doGet(final HttpServletRequest request,
			final HttpServletResponse response) 
					throws ServletException, IOException {
		perForm(request, response);
	} /* doGet */

	/**
	 * @param request
	 *            The servlet container creates an HttpServletRequest object
	 * @param response
	 *            The servlet container creates an HttpServletResponse
	 * 
	 * @throws ServletException
	 *             Defines a general exception
	 * @throws IOException
	 *             Signals that an I/O exception
	 * **/
	protected final void doPost(final HttpServletRequest request,
			final HttpServletResponse response) 
					throws ServletException, IOException {
		perForm(request, response);
	} /* doPost */

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CallDemoLightbox() {
		super();
	} /* CallDemoLightbox */
	
}
