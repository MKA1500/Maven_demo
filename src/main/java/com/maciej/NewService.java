package com.maciej;

import java.util.Optional;

public class NewService {
	static final String FALLBACK_NAME = "world";
	static final Lang FALLBACK_LANG = new Lang(1L, "Hello", "en");
	
	private LangRepo repository;
	
	NewService() {
		this(new LangRepo());
	}
	
	NewService(LangRepo repository) {
		this.repository = repository;
	}

	String prepareGreeting(String name) {
		return prepareGreeting(name, FALLBACK_LANG.getId());
	}
	
	String prepareGreeting(String name, Long longId) {
		var welcomeMsg = repository.findById(longId).orElse(FALLBACK_LANG).getWelcomeMsg();
		var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
		return welcomeMsg + " " + nameToWelcome + "!";
	}
}
