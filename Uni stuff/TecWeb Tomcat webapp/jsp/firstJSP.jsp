<%@ page language="java"  contentType="text/html; charset=UTF-8"%>
<%@ page session="true" import="java.util.*"%>
<html>
<head>
<title>JSP Test 1</title>
</head>
<body>
<%!
long loadTime = System.currentTimeMillis();
Date loadDate = new Date();
int hitCount = 0; 
%>
<h1>JSP TEST!</h1>
<p>
Questa pagina è stata caricata il <%= loadDate %>
<br/>
Oggi è il <%=new Date() %>
<br/>
Questa pagina è stata su per <%=(System.currentTimeMillis()-loadTime)/1000 %> secondi, e ha avuto <%= ++hitCount %> accessi dal <%= loadDate%>

</p>
</body>
</html>