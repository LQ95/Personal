package esame;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ServletTifosi extends HttpServlet{
	private HashMap<String,LinkedList<String>> squadre= new HashMap<String,LinkedList<String> >(); //key:squadra value: lista di tifosi			
	private Date loadDate = new Date(); 
	private static String NumeriOrdinali[]= new String[]{"primo","secondo","terzo","quarto","quinto","sesto","settimo","ottavo","nono","decimo"};	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException{
		response.setContentType("text/html");
		HttpSession session= request.getSession( true );
		PrintWriter out = response.getWriter();
		LinkedList<String> tifosi;
		String message="Non hai inserito nessuna squadra!";
		String sessionID=session.getId();
		
		int NumeroTifosi;
		String squadraTemp=request.getParameter("squadra");
		String squadra;
		//il singolo tifoso è identificato dal suo sessionID. Se è non presente nella lista dei tifosi della squadra inserita viene aggiunto,altrimenti no
		if(!squadraTemp.isEmpty()){
			squadra=squadraTemp.substring(0,1).toUpperCase() + squadraTemp.substring(1); //Rendo la prima lettera sempre maiuscola per fare una superficiale prevenzione dei duplicati
			if (squadre.containsKey(squadra))
			{
				tifosi=squadre.get(squadra);
				if(!tifosi.contains(sessionID))
				{
					NumeroTifosi=tifosi.size()+1;
					tifosi.add(sessionID);
					squadre.replace(squadra, tifosi);
				}
				else{
					NumeroTifosi=tifosi.size();
				}
				if(NumeroTifosi<11) //invece di dire 1-esimo,2-esimo,-3esimo,ecc ecc, per i primi 10 userà i numeri ordinali corretti
				{
					message="Forza "+squadra+": sei il "+NumeriOrdinali[NumeroTifosi-1]+" tifoso del "+squadra+" da "+loadDate+".";
				}
				else message="Forza "+squadra+": sei l'"+NumeroTifosi+"-esimo tifoso del "+squadra+" da "+loadDate+".";
				
			}
			else{
					squadre.put(squadra,new LinkedList<String>());
					message="Forza "+squadra+": sei il primo tifoso del "+squadra+" da "+loadDate+".";
				}
		}
		out.print("<html>");
		out.print("<body>");
		out.print(message);
		out.print("</body>");
		out.print("</html>");
	}
	

} 