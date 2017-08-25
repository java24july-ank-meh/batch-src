package com.revature.beans;

import javax.persistence.*;

@Entity
public class Artist {
	@Id
	private int artistid;
	private String name;

	public Artist(int artistid, String name) {
		super();
		this.artistid = artistid;
		this.name = name;
	}

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getArtistid() {
		return artistid;
	}

	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artist [artistid=" + artistid + ", name=" + name + "]";
	}

}
