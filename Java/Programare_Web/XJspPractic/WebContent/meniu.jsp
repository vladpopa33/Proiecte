<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meniu</title>
</head>
<body>
<%
if(session.getAttribute("logged")!=null)
	out.println("<a href='programare.jsp'>Programare</a><br><a href='vizualizare.jsp'>Vizualizeaza</a><br><a href='modificare.jsp'>Modifica</a><br><a href='stergere.jsp'>Sterge</a><br>");
else
	out.println("Nu ai voie!");

%>
</body>
</html>