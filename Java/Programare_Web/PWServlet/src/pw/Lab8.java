package pw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lab8
 */
@WebServlet(description = "Programare Web Laborator 8 - Servlet Problema  8", urlPatterns = { "/Lab8" })
public class Lab8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Masini m=new Masini();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lab8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Servlet</title>");
	    out.println("<style>table,th,td,tr{border: 1px solid black; border-collapse:collapse;}</style>");
	    out.println("<script>function functie(){document.getElementById('save').removeAttribute('style');}</script>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h5>Programare Web - Laboratorul 8: Servlet - Problema 8</h5>");
	    int i=1;
	    if(request.getParameter("id")!=null)
	    	i=Integer.parseInt(request.getParameter("id"));
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
	    m.edit_car(i-1, car);
	    int nr=m.length();
	    out.println("<form method='POST' action=''><table><tr><th>Nr.crt</th><th>Marca</th><th>Culoare</th><th>Pret(Euro)</th></tr>");
	    
	    out.print("<tr><td>#"+i+"</td><td><input onfocus='functie()' type='text' name='marca' value='"+car.marca+"'></td><td><input type='text' onfocus='functie()' name='culoare' value='"+car.culoare+"'></td><td><input type='text' onfocus='functie()' name='pret' value='"+car.pret+"'></td></tr>");
	    out.println("</table><input type='hidden' name='id' value='"+i+"'><input id='save' type='submit' style='visibility:hidden' value='Save'></form>");
	    if(i>1)
	    	out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+(i-1)+"'><input type='submit' value='Previous'></form>");
	    if(i<nr)
	    	out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+(i+1)+"'><input type='submit' value='Next'></form>");
	    out.println("</head>");
	    out.println("</body>");
	    out.println("</head>");
	    out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
