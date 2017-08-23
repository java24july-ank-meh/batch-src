package com.revature.spring.hib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("appContext.xml");
		DataService service = 
				(DataService)ctx.getBean("service");
		
		//Persist teacher object
		Teacher teacher = new Teacher(3L,"Joanna","Robinson",567L);
		
		//call business logic
		service.insertTeacher(teacher);
		System.out.println("done");
	}

}
