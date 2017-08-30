package com.revature.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {
	
	@GET
	@Path("/{name: [a-zA-Z][a-zA-Z]*}")
	@Produces("text/plain")
	public String helloName(@PathParam("name") String name) {
		return "Hello, " + name;
	}
	
	@GET
	@Path("/html")
	@Produces("text/html")
	public String getHtml() {
		return "<html><body><h1>Hello, World!</h1></body></html>";
	}
	
	@POST
	@Consumes("text/plain")
	public void postText(String message) {
		// Store the message
	}
	
	@GET
	@Path("/{name}/{lname}")
	@Produces("text/plain")
	public Response getFname(@PathParam("name") String fname, @PathParam("lname") String lname) {
		String output = "Hello, " + fname + " " + lname;
		return Response.status(200).entity(output).build();
	}
}
