package com.revature.main;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;
import com.revature.model.Artist;

public class SpringRestClient {

	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(getBaseURI());
        
        String jsonResponse = target.path("artist").path("12")
        		.request().accept(MediaType.APPLICATION_JSON).get(String.class);

        Artist artist = new Gson().fromJson(jsonResponse, Artist.class);
        
        System.out.println(artist.getName());
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8181").build();
    }

}
