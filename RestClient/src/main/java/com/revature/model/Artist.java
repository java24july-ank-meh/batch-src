package com.revature.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Artist {
	private Long artistid;
	private String name;

	public Long getArtistid() {
		return artistid;
	}

	public void setArtistid(Long artistid) {
		this.artistid = artistid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist(Long artistid, String name) {
		super();
		this.artistid = artistid;
		this.name = name;
	}

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Artist [artistid=" + artistid + ", name=" + name + "]";
	}

}
