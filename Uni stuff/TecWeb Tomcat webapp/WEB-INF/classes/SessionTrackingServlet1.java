import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionTrackingServlet1 extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie cookie,cookie2;
		Cookie cookies[];
		out.print("<html>");
		out.print("<body>");
		String sessionID = request.getPathInfo();
		if(sessionID == null){
			sessionID = generateSessionID();
			
		}
		cookies=request.getCookies();
		if(cookies[1] == null){
				cookie = new Cookie("segreto","666");
				response.addCookie(cookie);
				out.print("<a href=\"SessionTracking1/" + sessionID + "\">test</a> <br/>");
			}
		else{
			out.print("l'utente con sessionID:"+sessionID+" ha questi cookies<br/>");
			for(int i=0; i<cookies.length; i++){
				out.print(cookies[i].getName());
				out.print("<br/>");
				out.print(cookies[i].getValue());
				out.print("<br/>");
			}
		out.print("</body>");
		out.print("</html>");
		
		}
	}
	
	private static String generateSessionID(){
		String uid= new java.rmi.server.UID().toString();
		return java.net.URLEncoder.encode(uid);
	}
} 