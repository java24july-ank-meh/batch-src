package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		//System.out.println("We did get");
		PrintWriter out = resp.getWriter();
		out.println("<p>Did the Get</p>");
		out.println("<a href=\"index.html\">Go Back</a>");
		
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		
		int result = Integer.parseInt(n1) + Integer.parseInt(n2);
		out.println("<p>Sum of two numbers = " + result + "</p>");
	}

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		//System.out.println("We did post");
		PrintWriter out = resp.getWriter();
		out.println("<p>Did the Post</p>");
		out.println("<a href=\"index.html\">Go Back</a>");
		String n1 = req.getParameter("fName");
		String n2 = req.getParameter("lName");
		String fullname = n1 + " " + n2;
		out.println("<p>Full Name: " + fullname + "</p>");
	}
}
