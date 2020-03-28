package com.codewithwilliam.shortner.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codewithwilliam.shortner.businessobject.UrlShortener;
import com.codewithwilliam.shortner.service.UrlShortenService;

@Controller
public class UrlShortController {
	
	@Autowired
	UrlShortenService urlShortenService;

	
	@GetMapping("/{shortened}")
	public void doRedirect(HttpServletResponse response, @PathVariable String shortened) {
		System.out.println(shortened);
		String origUrl = urlShortenService.getShortenedUrl(shortened);
		if(StringUtils.isNotEmpty(origUrl)) {
			try {
				response.sendRedirect("http://"+origUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		  
		}else {
			try {
				response.getWriter().println("No shortened URL exists for this:"+shortened);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@GetMapping("/")
	public String viewHome() {
	      return "redirect:url/shortner";
	} 
	
	@GetMapping("/url/shortner")
	public String getUrlShort() {
		System.out.println("Hello");
		return "index";
		
    }
	@PostMapping("/url/shortner")
	public String postUrl(UrlShortener urlToShorten, Model model) {
		if(urlToShorten != null) {
			urlToShorten.setShortened(urlShortenService.createShortenedUrl(urlToShorten.getUrl()));
		}
		model.addAttribute("urlShortener", urlToShorten);
		
		return "index";
		
	}
	
	@GetMapping("/url/shortner/cleanData")
	public void cleanData(HttpServletResponse response) {
		urlShortenService.cleanMap();
    }
	

}
