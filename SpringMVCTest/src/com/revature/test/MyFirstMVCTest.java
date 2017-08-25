package com.revature.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration
public class MyFirstMVCTest {

	@Autowired
	public WebApplicationContext wac;
	
	public MockMvc mockMvc;
	
	@Before
	public void setUp()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void LoginControllerTest() throws Exception
	{
		MockHttpServletRequestBuilder createMessage = post("/login")
				.param("username", "Bob")
				.param("password", "1234");
		this.mockMvc.perform(createMessage).andDo(print())
		.andExpect(status().is2xxSuccessful());
		
	}
}
