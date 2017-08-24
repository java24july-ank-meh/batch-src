package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Artist;

public interface ArtistDao extends JpaRepository<Artist, Integer>{
	List<Artist> findByName(String name);
}
