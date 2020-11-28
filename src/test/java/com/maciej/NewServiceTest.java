package com.maciej;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NewServiceTest {
	/*
	 * system under service...
	 */
	private NewService SUT = new NewService();
	@Test
    public void test_prepareGreeting_null_returnsWithFallback() {
		// given
		String name = null;
		
		// when 
		String result = SUT.prepareGreeting(name);
		
		// then
		// (expected, result)
		assertEquals("Hello " + NewService.FALLBACK_NAME + "!", result);
    }
	
	public void test_prepareGreeting_name_returnsWithName() {
		// given
		String name = "test";
		
		// when 
		String result = SUT.prepareGreeting(name);
		
		// then
		assertEquals("Hello " + name + "!", result);
    }
}
