package pdpj;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;

import java.sql.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filtru implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String user = (String) request.getParameter("user");
		String password = (String) request.getParameter("password");

		ServletContext application = request.getSession().getServletContext();

		if (user != null && password != null && user.equals("operator")
				&& password.equals("parola")) {
			System.out.println("asd");
			request.getSession().setAttribute("login", "true");
		}
		chain.doFilter(req, res);

		// chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {

		// Get init parameter
		String testParam = config.getInitParameter("test-param");

		// Print the init parameter
		System.out.println("Test Pa        ram: " + testParam);
	}

	public void destroy() {

	}
}
