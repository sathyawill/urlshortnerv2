package com.codewithwilliam.shortner.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.codewithwilliam.shortner.UrlShortenerBaseTests;
import com.codewithwilliam.shortner.service.impl.UrlShortenServiceImpl;

public class UrlShortenServiceImplTest extends UrlShortenerBaseTests{


    @Mock
    private UrlShortenServiceImpl urlShortenService;
    
    @Test
    public void testCreateShortenedUrl() throws Exception {
        Mockito.when(urlShortenService.createShortenedUrl("www.apple.com")).thenReturn("O3vL9mj");
        String actual = urlShortenService.createShortenedUrl("www.apple.com");
        assertEquals("O3vL9mj", actual);
    }
    
    @Test
    public void testNegativeCreateShortenedUrl() throws Exception {
        Mockito.when(urlShortenService.createShortenedUrl("www.apple.com")).thenReturn("O3vL9mj");
        String actual = urlShortenService.createShortenedUrl("www.apple.com");
        assertNotEquals("00O3vL9mj", actual);
    }

    @Test
    public void testGetShortenedUrl() throws Exception {
        Mockito.when(urlShortenService.getShortenedUrl("O3vL9mj")).thenReturn("www.apple.com");
        String actual = urlShortenService.getShortenedUrl("O3vL9mj");
        assertEquals("www.apple.com", actual);


    }
    
}
