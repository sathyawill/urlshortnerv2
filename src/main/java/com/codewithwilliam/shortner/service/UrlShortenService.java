package com.codewithwilliam.shortner.service;

public interface UrlShortenService {
	
	public String getShortenedUrl(String data);

	public String createShortenedUrl(String data);
	
	public void cleanMap();
}
