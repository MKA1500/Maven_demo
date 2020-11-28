package com.maciej;

import java.util.Optional;

public class NewService {
	static final String FALLBACK_NAME = "world";

	String prepareGreeting(String name) {
		return "Hello " + Optional.ofNullable(name).orElse(FALLBACK_NAME) + "!";

	}
}
