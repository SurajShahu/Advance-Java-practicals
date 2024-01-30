package in.co.rays.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("FirstServlet doGet");
		// resp.sendRedirect("SecondServlet");
		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
		rd.forward(req, resp);
		/*
		 * System.out.println("in get method...!!!");
		 * System.out.println("request method getMethod ==>" + req.getMethod());
		 * System.out.println("request method getRequestURI==>" + req.getRequestURI());
		 * System.out.println("request method getProtocol==>" + req.getProtocol());
		 * System.out.println("request method getRemoteAddr==>" + req.getRemoteAddr());
		 * System.out.println("request method getAuthType==>" + req.getAuthType());
		 * 
		 * Enumeration e=req.getHeaderNames(); while(e.hasMoreElements()) { String
		 * name=(String) e.nextElement(); String value=req.getHeader(name);
		 * System.out.println(name+"="+value); }
		 */

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in dopost method...!!!");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(login);
		System.out.println(pass);
		System.out.println(dob);
		System.out.println(address);

		/*
		 * System.out.println("FirstServlet doPost");
		 * resp.sendRedirect("SecondServlet");
		 */
		System.out.println("FirstServlet doPost");
		
		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
		rd.forward(req, resp);
		
	}
}
