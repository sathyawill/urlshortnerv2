package com.codewithwilliam.shortner.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import com.codewithwilliam.shortner.service.impl.UrlShortenServiceImpl;

@RunWith(Parameterized.class)
public class UrlShortenServiceImplTest {

	private String url;
	private String expected;
	
    
    private UrlShortenServiceImpl urlShortenService = new UrlShortenServiceImpl();;
    
    @Parameters(name="{index}: Test with url={0}, result: {1}")
    public static Iterable<Object[]> data() {
    	return Arrays.asList(new Object[][] {
    		{"www.apple.com","O3vL9mj"},
    		{"www.apple.com/iphone","ZKrpYn9"},
    		{"www.google.com","gnoAeQ"},	
    		{"www.kohls.com","vKFfHni"}	
    		
    	});
    }
    
    public UrlShortenServiceImplTest(String url, String expected) {
    	this.url = url;
    	this.expected = expected;
    }
    
    @Test
    public void testUrlServiceResults() {
    	assertEquals(expected,urlShortenService.createShortenedUrl(url));
    }
    
//    @Test
//    public void testCreateShortenedUrl() throws Exception {
//        Mockito.when(urlShortenService.createShortenedUrl("www.apple.com")).thenReturn("O3vL9mj");
//        String actual = urlShortenService.createShortenedUrl("www.apple.com");
//        assertEquals("O3vL9mj", actual);
//    }
//    
//    @Test
//    public void testNegativeCreateShortenedUrl() throws Exception {
//        Mockito.when(urlShortenService.createShortenedUrl("www.apple.com")).thenReturn("O3vL9mj");
//        String actual = urlShortenService.createShortenedUrl("www.apple.com");
//        assertNotEquals("00O3vL9mj", actual);
//    }
//
//    @Test
//    public void testGetShortenedUrl() throws Exception {
//        Mockito.when(urlShortenService.getShortenedUrl("O3vL9mj")).thenReturn("www.apple.com");
//        String actual = urlShortenService.getShortenedUrl("O3vL9mj");
//        assertEquals("www.apple.com", actual);
//
//
//    }
    
}
