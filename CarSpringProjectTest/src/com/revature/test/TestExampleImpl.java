package com.revature.test;

import org.springframework.stereotype.Component;

@Component("testImpl")
public class TestExampleImpl implements TestExample {

	@Override
	public boolean isValid() {
		//some business logic
		return true;
	}

}
