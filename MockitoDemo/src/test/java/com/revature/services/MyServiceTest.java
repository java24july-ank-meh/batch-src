package com.revature.services;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.beans.MyBean;
import com.revature.dao.MyDao;

import junit.framework.Assert;

public class MyServiceTest {
	@Mock private MyDao myDao;
	
	@Test
	public void testFindById() {
		MockitoAnnotations.initMocks(this);
		MyService myService = new MyService(myDao);
		myService.findById(1);
		Mockito.verify(myDao).findById(1);
	}
	
	@Test
	public void test() {
		MyService myService = new MyService(myDao);
		Mockito.when(myDao.findById(1)).thenReturn(createTestBean());
		MyBean actual = myService.findById(1);
		Assert.assertEquals("MyFirstName", actual.getFirstName());
		Assert.assertEquals("MyLastName", actual.getLastName());
		Mockito.verify(myDao).findById(1);
	}

	private MyBean createTestBean() {
		MyBean myBean = new MyBean();
		myBean.setFirstName("MyFirstName");
		myBean.setLastName("MyLastName");
		return myBean;
	}

}
