import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AuthorizationTestServlet extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getRemoteUser();
		out.print("<html>");
		out.print("<body>");
		if(name == null)
		{
			out.print("Non autorizzato");
		}
		else{
			out.print("Autorizzato. Vatti a guardare I PORNI!");
		}
		out.print("</body>");
		out.print("</html>");
	}
	

} 