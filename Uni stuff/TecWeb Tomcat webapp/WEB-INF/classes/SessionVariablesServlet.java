import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionVariablesServlet extends HttpServlet{
	private final Map personale = new HashMap();

	public void init(){
	personale.put( "Leonardo", "001");
	personale.put( "Monica Roccaforte", "002");
	personale.put( "big Floppa", "003");
	personale.put( "Mammeta", "004");
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		response setContentType("text/html");
		PrintWriter out = response.getWriter();
		//se la sessione esiste a estrae altrimenti ne crea una nuova
		HttpSession session= request.getSession( true );
		
		out.print("<html>");
		out.print("<body>");
	
		out.print("</body>");
		out.print("</html>");
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		response setContentType("text/html");
		PrintWriter out = response.getWriter();
		//se la sessione esiste a estrae altrimenti ne crea una nuova
		HttpSession session= request.getSession( false );
		
		out.print("<html>");
		out.print("<body>");
	
		out.print("</body>");
		out.print("</html>");
	}
	

} 