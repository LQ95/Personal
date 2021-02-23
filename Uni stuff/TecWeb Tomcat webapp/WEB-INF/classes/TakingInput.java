import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class TakingInput extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	//prende un parametro in entrata dalla richiesta
	String firstName= request.getParameter( "firstname" );
 	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	//manda XHTML
	out.println("<?xml version = \"1.0\"?>");
	out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD " + " " + " \">");
	out.println("");
	out.println("<html><head><title> elaborazione di una richiesta che comprende dati</title></head>");
	out.println("");
	out.println("<body><h4>Ciao, " + firstName +", benvenuto alle servlet</h4></body>");
	out.println("</html>");
	out.println("");
	out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	//prende un parametro in entrata dalla richiesta
	String firstName= request.getParameter( "firstname" );
 	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	//manda XHTML
	out.println("<?xml version = \"1.0\"?>");
	out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD " + " " + " \">");
	out.println("");
	out.println("<html><head><title> elaborazione di una richiesta che comprende dati</title></head>");
	out.println("");
	out.println("<body><h4>Ciao, " + firstName +", benvenuto alle servlet con metodo POST</h4></body>");
	out.println("</html>");
	out.println("");
	out.close();
	}

	
}