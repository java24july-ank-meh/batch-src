package com.revature.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestConsumerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String url = "http://localhost:8181/artist/12";
			Artist artist = restTemplate.getForObject(url, Artist.class);
			String json = restTemplate.getForObject(url, String.class);
			ResponseEntity<String> rs = restTemplate.getForEntity(url, String.class);
			System.out.println(json);
			System.out.println(rs);
			System.out.println(artist);			

			url = "http://localhost:8181/artist/hello";
			json = restTemplate.getForObject(url, String.class);
			System.out.println(json);
		};
	}
}
