package pdpj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Lab6
 */
@WebServlet(description = "PDPJ - Lab 6 -  Servlet", urlPatterns = { "/Lab6" })
public class Lab5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Oferte of;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lab5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
        of=new Oferte();

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

	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h5>Programare Distribuita - Platforme Java - Laboratorul 5: Servlet</h5>");
	    if(request.getSession().getAttribute("login")==null){
		    int i=1;
		    if(request.getParameter("id")!=null)
		    	i=Integer.parseInt(request.getParameter("id"));
		    Oferta o=of.get_oferta(i-1);
		    int nr=of.length();
		    out.println("<form method='POST' action=''><table><tr><th>Nr.crt</th><th>Destinatie</th><th>Pret</th><th>Transport</th></tr>");
		    
		    out.print("<tr><td>#"+i+"</td><td>"+o.destinatie+"</td><td>"+o.pret+"</td><td>"+o.transport+"</td></tr>");
		    out.println("</table><input type='hidden' name='id' value='"+i+"'><input id='save' type='submit' style='visibility:hidden' value='Save'></form>");
	    	out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+1+"'><input type='submit' value='First'></form>");
		    if(i>1)
		    	out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+(i-1)+"'><input type='submit' value='Previous'></form>");
		    if(i<nr)
		    	out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+(i+1)+"'><input type='submit' value='Next'></form>");
	    	out.println("<form method='POST' action=''><input type='hidden' name='id' value='"+nr+"'><input type='submit' value='Last'></form>");
		    }
	    else
	    	out.println("Operator");
    	out.println("</body></html>");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
