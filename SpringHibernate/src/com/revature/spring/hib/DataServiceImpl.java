package com.revature.spring.hib;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	SessionFactory sf;
	
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional
	public void insertTeacher(Teacher teacher) {
		Session session = sf.getCurrentSession();
		session.save(teacher);
	}

}
