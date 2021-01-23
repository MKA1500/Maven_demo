package com.maciej;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewService {
	static final String FALLBACK_NAME = "world";
	static final Lang FALLBACK_LANG = new Lang(1L, "Hello", "en");
	private final Logger logger = LoggerFactory.getLogger(NewService.class);
	
	private LangRepo repository;
	
	NewService() {
		this(new LangRepo());
	}
	
	NewService(LangRepo repository) {
		this.repository = repository;
	}
	
	String prepareGreeting(String name, String lang) {
		Long langId;
		try {
			langId = Optional.ofNullable(lang).map(Long::valueOf).orElse(FALLBACK_LANG.getId());
		} catch (NumberFormatException e) {
			logger.warn("Non numeric language id used: " + lang);
			langId = FALLBACK_LANG.getId();
		}
		var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
		var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
		return welcomeMsg + " " + nameToWelcome + "!";
	}
}
