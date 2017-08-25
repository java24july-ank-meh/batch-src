package com.revature.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	private final String SUCCESS = "success";
	private final String FAILURE = "index";
	
	//method to call
	@RequestMapping(method = RequestMethod.POST)
	public String loginUser(ModelMap map, HttpServletRequest request) {
		// fetch params
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " + password);
		// check to see if username passwords match
		if (username.equals("Bob") && password.equals("1234")) {
			// add attribute to modelmap object to use in inbox.jsp
			//map.addAttribute("user", username);
			return SUCCESS;
		} else
			return FAILURE;
	}
}
