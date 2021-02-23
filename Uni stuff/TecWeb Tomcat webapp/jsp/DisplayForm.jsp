<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>

<h1>Mostrami una form oppure i suoi dati</h1>

<% 
Enumeration campi= request.getParameterNames();
if(!campi.hasMoreElements()){
	//la form viene mostrata se non ci sono dati ricevuti%>
<form method="POST" action="DisplayForm.jsp">
<label for ="">Come ti chiami?</label>
<input type="text" name="nome"></input>
<label for ="">Ragazza? </label>
<input type="radio" id="girl" value="girl" name="giender"></input>
<label for ="">Uomo?</label>
<input type="radio" id="boy" value="boy" name="giender"></input>
<label for ="">Uazza?</label>
<input type="radio" id="borl" value="borl" name="giender"></input>
<label for ="rettangolare">Sei rettangolare?</label>
<input type="checkbox" name="rettangolare" value="AFFERMATIVO"></input>
<input type="submit" value="Manda i campi a questa JSP"></input>
</form>

<% 	
}else{
	while(campi.hasMoreElements()){
		String campo = (String)campi.nextElement();
		String valore = request.getParameter(campo);
		%>
		<br/>
		<%= campo %> = <%= valore%>
		<%
	}
}
%>