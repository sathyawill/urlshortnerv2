package com.codewithwilliam.shortner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithwilliam.shortner.controller.UrlShortController;

@SpringBootTest
public class UrlShortenerBaseTests {

	@Autowired
	private UrlShortController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
