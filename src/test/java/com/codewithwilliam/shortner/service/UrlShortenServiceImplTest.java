package com.codewithwilliam.shortner.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;

import com.codewithwilliam.shortner.UrlShortenerBaseTests;
import com.codewithwilliam.shortner.service.impl.UrlShortenServiceImpl;

public class UrlShortenServiceImplTest extends UrlShortenerBaseTests{


    @Mock
    private UrlShortenServiceImpl urlShortenService;
    
    @Test
    public void testCreateShortenedUrl() throws Exception {
        Mockito.when(urlShortenService.createShortenedUrl("www.apple.com")).thenReturn("O3vL9mj");
       
    }

    @Test
    public void testGetShortenedUrl() throws Exception {
        Mockito.when(urlShortenService.getShortenedUrl("O3vL9mj")).thenReturn("O3vL9mj");
       
    }
    
}
