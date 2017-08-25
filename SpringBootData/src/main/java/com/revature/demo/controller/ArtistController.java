package com.revature.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.demo.model.Artist;
import com.revature.demo.service.ArtistService;

@RestController
@RequestMapping("artist")
public class ArtistController {
	@Autowired
	ArtistService as;
	
	@GetMapping
	public List<Artist> findAll() {
		return as.findAll();
	}
	
	@GetMapping("{id}")
	public Artist findOne(@PathVariable("id") long id) {
		return as.findOne(id);
	}
}
