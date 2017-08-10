package com.revature.services;

import com.revature.beans.MyBean;
import com.revature.dao.MyDao;

public class MyService {
	private MyDao myDao;
	
	public MyService(MyDao myDao) {
		this.myDao = myDao;
	}
	
	public MyBean findById(int id) {
		return myDao.findById(id);
	}

}
