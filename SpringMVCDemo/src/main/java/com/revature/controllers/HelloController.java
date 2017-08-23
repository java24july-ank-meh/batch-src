package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.User;

@Controller
public class HelloController {
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome() {
		return "/pages/index.html";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goLogin() {
		return "/pages/login.html";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String username, String password, HttpServletRequest req) {
		User u = new User((String) req.getParameter("username"),(String) req.getParameter("password"));
		
		if (u.getUsername().equals("admin") && u.getPassword().equals("admin")) {
			return "redirect:home";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping(value="/home/{user}", method=RequestMethod.GET)
	public ResponseEntity<Object> goHomeUser(@PathVariable("user") String name) {
		List<String> names = new ArrayList<>();
		names.add(name);
		names.add("Kelvin");
		names.add("Eleazar");
		return ResponseEntity.ok(names);
	}

}




