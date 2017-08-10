package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.beans.Reimbursement;

public class BeanServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws 
				ServletException, IOException {
		List<Reimbursement> rlist = new ArrayList<>();
		
		Reimbursement r1 = new Reimbursement(1, "Bob", "Smith", "travel", "denied");
		Reimbursement r2 = new Reimbursement(2, "John", "Roberts", "family", "approved");
		Reimbursement r3 = new Reimbursement(3, "Mary", "Jane", "business", "pending");
		
		rlist.add(r1);
		rlist.add(r2);
		rlist.add(r3);
		
		//Create GSON object, convert arraylist to JSON
		Gson gson = new Gson();
		String rJSON = gson.toJson(rlist);
		
		//Set up response body for json
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//send response in json format
		PrintWriter out = response.getWriter();
		out.write(rJSON);
		
	}

}
