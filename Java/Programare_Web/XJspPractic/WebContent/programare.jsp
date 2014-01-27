<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Programeaza</title>
</head>
<body>
<%@ page import="examen.Programs"%>
<% 
if(session.getAttribute("logged")!=null){
	out.println("<form action='programare.jsp' method='POST'>Data: <input type='text' name='data'><br>Ora: <input type='text' name='ora'><br>Durata: <input type='text' name='durata' size='3'>h<br>Descriere: <input type='text' name='descriere' size='5'><br><input type='submit' value='Save'></form>");
	if(request.getParameter("data")!=null) {
		Programs q=new Programs();
		q.add(session.getAttribute("logged").toString(),request.getParameter("data"),request.getParameter("ora"),request.getParameter("durata"),request.getParameter("descriere"));
		out.println("<br><div>Adaugat cu succes!</div>");
	}
}
else
	out.println("Nu ai voie!");
%>
</body>
</html>