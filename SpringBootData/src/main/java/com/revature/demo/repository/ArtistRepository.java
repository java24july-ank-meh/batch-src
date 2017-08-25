package com.revature.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.demo.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{
	
}
