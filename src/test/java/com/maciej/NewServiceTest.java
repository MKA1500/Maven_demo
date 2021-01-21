package com.maciej;

import static org.junit.Assert.assertEquals;
 
import java.util.Optional;

import org.junit.Test;

public class NewServiceTest {
	private final static String WELCOME = "Hello";
	private final static String FALLBACK_ID_WELCOME = "Salut";
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
		var mockRepo = fallbackLangIdRepo();
		var SUT = new NewService();
		
		// when 
		var result = SUT.prepareGreeting(null, null);
		
		// then
		assertEquals(FALLBACK_ID_WELCOME + " " + NewService.FALLBACK_NAME + "!", result);
    }
	
	public void test_prepareGreeting_textLang_returnsGreetingWithFallbackIdLang() {
		// given
		var mockRepo = fallbackLangIdRepo();
		var SUT = new NewService();
		
		// when 
		var result = SUT.prepareGreeting(null, "abc");
		
		// then
		assertEquals(FALLBACK_ID_WELCOME + " " + NewService.FALLBACK_NAME + "!", result);
    }
	
	private LangRepo fallbackLangIdRepo() {
		return new LangRepo() {

			@Override
			Optional<Lang> findById(Long id) {
				if (id.equals(NewService.FALLBACK_LANG.getId())) {
					Lang newLang = new Lang(null, FALLBACK_ID_WELCOME, null);
					return Optional.of(newLang);
				}
				return Optional.empty();
			}
			
		};
	}
	
	private LangRepo alwaysReturnHelloRepo() {
		return new LangRepo() {
			@Override
			Optional<Lang> findById(Long id) {
				Lang newLang = new Lang(null, WELCOME,  null);
				return Optional.of(newLang);
			}
		};
	}
}
