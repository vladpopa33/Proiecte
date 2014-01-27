<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificare</title>
</head>
<body>
<%@ page import="examen.Programs"%>
<% 
if(session.getAttribute("logged")!=null){
	Programs q=new Programs();
	out.println("<form action='modificare.jsp' method='POST'>");
	int i=0;
	if(request.getParameter("data0")!=null) {
		while(request.getParameter("data"+i)!=null){
			q.edit(i, session.getAttribute("logged").toString(),request.getParameter("data"+i),request.getParameter("ora"+i),request.getParameter("durata"+i),request.getParameter("descriere"+i));
			i++;
		}
	}
	out.println(q.get(session.getAttribute("logged").toString()));
	out.println("<input type='submit' value='Modifica'></form>");
	if(i!=0)
			out.println("<br>Editat cu succes");

}
else
	out.println("Nu ai voie!");
%>
</body>
</html>