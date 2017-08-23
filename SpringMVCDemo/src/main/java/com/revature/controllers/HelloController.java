package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome() {
		return "/pages/index.html";
	}

}
