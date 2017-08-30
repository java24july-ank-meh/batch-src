package com.revature.main;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class RestServiceClient {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getRestServiceURI());
		
		String textResponse = target.path("hello").path("Mehrab")
				.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		
		String htmlResponse= target.path("hello").path("html")
				.request().accept(MediaType.TEXT_HTML).get(String.class);
		
		String textResponse2 = target.path("hello").path("Mehrab").path("Rahman")
				.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		
		System.out.println(textResponse);
		System.out.println(htmlResponse);
		System.out.println(textResponse2);
	}

	private static URI getRestServiceURI() {
		return UriBuilder.fromUri("http://localhost:8181/RestService/restapp").build();
	}

}
