package com.revature.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.demo.model.Artist;
import com.revature.demo.repository.ArtistRepository;

@Service
@Transactional
public class ArtistService {
	@Autowired
	ArtistRepository ar;
	
	public List<Artist> findAll() {
		return ar.findAll();
	}
	
	public Artist findOne(long id) {
		return ar.findOne(id);
	}

}
