package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
		//User u1 = new User((String) req.getParameter("username"),(String) req.getParameter("password"));
		User u = new User(username, password);
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
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<Object> getUser() {
		User a = new User("admin1", "admin1");
		return ResponseEntity.ok(a);
	}
	
	@RequestMapping(value="/hidden", method=RequestMethod.GET)
	public String goSecret() {
		return "secret";
	}
	
	@RequestMapping(value="/{fname}/{lname}", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> fullname(@PathVariable("fname") String fname, @PathVariable("lname") String lname) {
		String output = fname + " " + lname;
		return ResponseEntity.ok(output);
	}

}




