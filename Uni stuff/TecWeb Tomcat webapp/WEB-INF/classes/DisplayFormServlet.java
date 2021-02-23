import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DisplayFormServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		Enumeration campi=req.getParameterNames();
		if(!campi.hasMoreElements()){
				out.print("<form method=\"POST\" action=\"DisplayForm\">");
				out.print("<label for =\"nome\">Come ti chiami?</label>");
				out.print("<input type=\"text\" name=\"nome\"></input>");
				out.print("<label for =\"girl\">Ragazza? </label>");
				out.print("<input type=\"radio\" id=\"girl\" value=\"girl\" name=\"giender\"></input>");
				out.print("<label for =\"boy\">Uomo?</label>");
				out.print("<input type=\"radio\" id=\"boy\" value=\"boy\" name=\"giender\"></input>");
				out.print("<label for =\"borl\">Uazza?</label>");
				out.print("<input type=\"radio\" id=\"borl\" value=\"borl\" name=\"giender\"></input>");
				out.print("<label for =\"rettangolare\">Sei rettangolare?</label>");
				out.print("<input type=\"checkbox\" name=\"rettangolare\" value=\"AFFERMATIVO\"></input>");
				out.print("<input type=\"submit\" value=\"Manda i campi a questa Servlet\"></input>");
				out.print("</form>");
		}else{
			while(campi.hasMoreElements())
				{
					String campo = (String)campi.nextElement();
					String valore = req.getParameter(campo);
					out.print("<br/>");
					out.print(campo +" = " + valore);
		
			}
		}
	out.close();}
	
}