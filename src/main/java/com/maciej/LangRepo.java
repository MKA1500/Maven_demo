package com.maciej;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LangRepo {
	private List<Lang> languages;
	
	LangRepo() {
		languages = new ArrayList<>();
		languages.add(new Lang(1L, "Hello", "en"));
		languages.add(new Lang(2L, "Salut", "fr"));
		languages.add(new Lang(3L, "Hallo", "nl"));
	}
	
	// Optional in case something will go wrong...
	Optional<Lang> findById(Long id) {
		return languages.stream()
				.filter(l -> l.getId().equals(id))
				.findFirst();
	}
}
