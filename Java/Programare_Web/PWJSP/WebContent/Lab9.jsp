<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
<style>
table,th,td,tr{
	border: 1px solid black;
	border-collapse:collapse;
	}
</style>
<script>
function functie(){
	document.getElementById('save').removeAttribute('style');
	}
</script>
</head>
<body>
<%@ page import="pdpj.Masini"%>
<%@ page import="pdpj.Masina"%>
<%int i=1;%>
<%Masini m=new Masini();%>

<%int nr=m.length();%>
<%
if(request.getParameter("id")!=null)
	i=Integer.parseInt(request.getParameter("id"));
%>
<%
Masina car=m.get_car(i-1);
if(request.getParameter("marca")!=null){
	car.marca=request.getParameter("marca");
}
if(request.getParameter("culoare")!=null){
	car.culoare=request.getParameter("culoare");
	
}
if(request.getParameter("pret")!=null){
	car.pret=request.getParameter("pret");
}
m.edit_car(i-1, car); %>

<h5>Programare Web - Laboratorul 8: Servlet - Problema 8</h5>
<form method='POST' action='Lab9.jsp'>
	<table>
		<tr>
			<th>Nr.crt</th>
			<th>Marca</th>
			<th>Culoare</th>
			<th>Pret(Euro)</th>
		</tr>
		<tr>
			<td>#<%=i%></td>
			<td><input type='text' onfocus='functie()' name='marca' value=<%=car.marca%>></td>
			<td><input type='text' onfocus='functie()' name='culoare' value=<%=car.culoare%>></td>
			<td><input type='text' onfocus='functie()' name='pret' value=<%=car.pret%>></td>
		</tr>
	</table>
	<input type='hidden' name='id' value=<%=i%>>
	<input id='save' type='submit' style='visibility:hidden' value='Save'>
</form>
	<%
	if(i>1)
    	out.println("<form method='POST' action='Lab9.jsp'><input type='hidden' name='id' value='"+(i-1)+"'><input type='submit' value='Previous'></form>");
    if(i<nr)
    	out.println("<form method='POST' action='Lab9.jsp'><input type='hidden' name='id' value='"+(i+1)+"'><input type='submit' value='Next'></form>");
     %>

</body>
</html>