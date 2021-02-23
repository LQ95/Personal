/*
	La mia prima servlet
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Utente
 */
public class FirstServlet extends HttpServlet{

	 
    protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException{
		response.setContentType( "text/html");
		PrintWriter out = response.getWriter();
		//invia HTML
		out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");
		out.println("<body>");
		out.println("");
		out.println("<title>servlet test 1</title></head>");
		out.println("");
		out.println("<p>Welcome to Servlets, biatch!</p>");
		out.println("");
		out.println("</body>");
        out.println("</html>");
		out.close();
    }
}
