<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
<style>table,th,td,tr{border: 1px solid black; border-collapse:collapse;}</style>
</head>
<body>
<%@ page import="pdpj.Oferta"%>
<%@ page import="pdpj.Oferte"%>
<%
Oferte of=new Oferte();
if(request.getSession().getAttribute("login")==null||!request.getSession().getAttribute("login").equals("true")){
    int i=1;
    if(request.getParameter("id")!=null){
    	i=Integer.parseInt(request.getParameter("id"));
    }
    Oferta o=of.get_oferta(i-1);
    int nr=of.length();
    out.println("<form method='POST' action=''><table><tr><th>Nr.crt</th><th>Destinatie</th><th>Pret</th><th>Transport</th></tr>");
    out.print("<tr><td>#"+i+"</td><td>"+o.destinatie+"</td><td>"+o.pret+"</td><td>"+o.transport+"</td></tr>");
    out.println("</table><input type='hidden' name='id' value='"+i+"'><input id='save' type='submit' style='visibility:hidden' value='Save'></form>");
	out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+1+"'><input type='submit' value='First'></form>");
    if(i>1){
    	out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+(i-1)+"'><input type='submit' value='Previous'></form>");
    }
    if(i<nr){
    	out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+(i+1)+"'><input type='submit' value='Next'></form>");
    }
    out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+nr+"'><input type='submit' value='Last'></form>");
    }
else{
	out.println("<h1>Operator</h1>");
	out.println("<h4>Adauga oferta</h4>");
	out.println(request.getSession().getAttribute("login"));
	String destinatie="";
	String pret="";
	String transport="";
	if(request.getParameter("destinatie")!=null){
    	destinatie=request.getParameter("destinatie");
    	if(request.getParameter("pret")!=null)
    		pret=request.getParameter("pret");
    	if(request.getParameter("transport")!=null)
    		transport=request.getParameter("transport");
    	Oferta o=new Oferta(destinatie,pret,transport);
    	of.add_oferta(o);
	}
	out.println("<form method='POST' action=''>Destinatie:<input type='text' name='destinatie'><br>Pret:<input type='text' name='pret'><br>Transport:<input type='text' name='transport'><br><input type='submit' value='Add'>");
}
%>
</body>
</html>