<%@ page contentType="text/html; charset:UTF-8"%>


<html>
<body>
<jsp:useBean id="test" class="tecwebjsp.SaySomething" scope="session">
<% test.setMessage("Dio sghangherato"); %>
<%= test.getMessage()%>
</jsp:useBean>
</body>
</html>