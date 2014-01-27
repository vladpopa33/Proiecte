<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stergere</title>
<script>
	function functie(i){
		document.getElementById("ind").setAttribute("value",i);
	}
</script>
</head>
<body>
<%@ page import="examen.Programs"%>
<% 
if(session.getAttribute("logged")!=null){
	Programs q=new Programs();
	if(request.getParameter("ind")!=null){
		q.delete(Integer.parseInt(request.getParameter("ind")), session.getAttribute("logged").toString());
		out.println(q.get(session.getAttribute("logged").toString()));
		out.println("<form action='stergere.jsp' method='POST'><input id='ind' type='hidden' name='ind'><input type='submit' value='Sterge'></form>");
		out.println("Sters cu succes!");
	}
	else{
		out.println(q.get(session.getAttribute("logged").toString()));
		out.println("<form action='stergere.jsp' method='POST'><input id='ind' type='hidden' name='ind'><input type='submit' value='Sterge'></form>");
	}
}
else 
	out.println("Nu ai voie!");
%>
</body>
</html>