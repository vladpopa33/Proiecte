<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->
<%@ page import="examen.Users" %>
<% 
	String r="3;url=mada.html";
	String text="Autentificare esuata!";
	Users u =new Users();
	if(u.exists(request.getParameter("myusername"),request.getParameter("mypassword"))){
		r="3;url=meniu.jsp";
		text="Autentificare reusita!";
		request.getSession().setAttribute("logged",request.getParameter("myusername"));
	}
		
%>
<meta http-equiv="Refresh" content=<%=r%>>
<title>Mada</title>
</head>
<body>
<h4><%=text%></h4>
</body>
</html>