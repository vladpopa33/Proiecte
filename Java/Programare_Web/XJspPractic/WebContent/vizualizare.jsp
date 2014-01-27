<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vizualizeaza</title>
</head>
<%@ page import="examen.Programs"%>
<body>
<%
if(session.getAttribute("logged")!=null){
	Programs q=new Programs();
	out.println(q.get(session.getAttribute("logged").toString()));
}
else 
	out.println("Nu ai voie!");
%>
</body>
</html>