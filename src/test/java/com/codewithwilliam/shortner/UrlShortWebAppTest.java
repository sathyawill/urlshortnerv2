package com.codewithwilliam.shortner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.codewithwilliam.shortner.businessobject.UrlShortener;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UrlShortWebAppTest extends UrlShortenerBaseTests{
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void testWebApp() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().is3xxRedirection());
	}
	
	//@Test
	public void testUrlShorteningWebApp() throws Exception {
		UrlShortener urlShortener = new UrlShortener();
		urlShortener.setUrl("www.apple.com/iphone");
		mockMvc.perform((post("/url/shortner")
						.content(asJsonString(urlShortener))
						.contentType(MediaType.APPLICATION_JSON)));
						
					
	}
	
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
