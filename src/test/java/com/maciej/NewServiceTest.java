package com.maciej;

import static org.junit.Assert.assertEquals;
 
import java.util.Optional;

import org.junit.Test;

public class NewServiceTest {
	private final static String WELCOME = "Hello";
	@Test
    public void test_prepareGreeting_nullName_returnsWithFallbackName() {
		// given
		var mockRepo = alwaysReturnHelloRepo();
		var SUT = new NewService(mockRepo);
		
		// when 
		var result = SUT.prepareGreeting(null, "-1");
		
		// then
		// (expected, result)
		assertEquals(WELCOME + " " + NewService.FALLBACK_NAME + "!", result);
    }
	
	public void test_prepareGreeting_name_returnsGreetingWithName() {
		// given
		var SUT = new NewService();
		String name = "test";
		
		// when 
		var result = SUT.prepareGreeting(name, "-1");
		
		// then
		assertEquals(WELCOME + " " + name + "!", result);
    }
	
	public void test_prepareGreeting_nullLang_returnsGreetingWithFallbackIdLang() {
		// given
		var fallbackIdWelcome = "Hola";
		var mockRepo = new LangRepo() {

			@Override
			Optional<Lang> findById(Long id) {
				if (id.equals(NewService.FALLBACK_LANG.getId())) {
					return Optional.of(new Lang(null, fallbackIdWelcome, null));
				}
				return Optional.empty();
			}
			
		};
		var SUT = new NewService();
		
		// when 
		var result = SUT.prepareGreeting(null, null);
		
		// then
		assertEquals(WELCOME + " " + NewService.FALLBACK_NAME + "!", result);
    }
	
	private LangRepo alwaysReturnHelloRepo() {
		return new LangRepo() {
			@Override
			Optional<Lang> findById(Long id) {
				return Optional.of(new Lang(null, WELCOME,  null));
			}
		};
	}
}
