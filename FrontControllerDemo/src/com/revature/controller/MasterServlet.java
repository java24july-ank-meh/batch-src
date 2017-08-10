package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class MasterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws
				ServletException, IOException {
		String rh = new RequestHelper().process(request, response);
		request.getRequestDispatcher(rh).forward(request, response);
	}

}
