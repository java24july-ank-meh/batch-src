package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		switch (request.getRequestURI()) {
		case "/FrontControllerDemo/index":
			return "index.html";
		default:
			return "404.html";
		}
	}
}
