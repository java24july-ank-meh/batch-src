package com.revature.main;

import com.revature.dao.*;
import com.revature.domain.Cave;

public class Main {

	public static void main(String[] args) {
		CaveDAO dao = new CaveDAOImpl();
		Cave c = new Cave();
		c.setName("Underwater Fortress");
		c.setMaxBears(38);
		
		//dao.readCave(1);
		//dao.createCave(c);
		//System.out.println(dao.readAllCaves());
		dao.feedBear(1, 100);
	}

}
