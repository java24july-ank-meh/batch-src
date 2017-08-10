package com.revature.util;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import junit.framework.Assert;

public class ConnectionUtilTest {
	@InjectMocks private ConnectionUtil connectionUtil;
	@Mock private Connection mockConnection;
	@Mock private Statement mockStatement;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMockConnectionUtil() throws Exception {
		Mockito.when(mockConnection.createStatement())
			.thenReturn(mockStatement);
		Mockito.when(mockConnection.createStatement()
				.executeUpdate((String) Mockito.any()))
				.thenReturn(1);
		
		int value = connectionUtil.executeQuery("");
		
		Assert.assertEquals(value, 1);
		Mockito.verify(mockConnection.createStatement(),
				Mockito.times(1));
	}
}
