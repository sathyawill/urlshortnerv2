package com.codewithwilliam.shortner.service.impl;

import java.security.MessageDigest;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithwilliam.shortner.encoding.impl.MD5EncodingServiceImpl;
import com.codewithwilliam.shortner.service.UrlShortenService;

@Service
public class UrlShortenServiceImpl implements UrlShortenService {

	
	
	private static final int DEFAULT_BYTES = 5;
	
	private static HashMap<String, String> urlMap = new HashMap<String, String>();
	
	@Override
	public String createShortenedUrl(String data) {
		
		
		String cleanhttp = data.replaceFirst("^(http[s]?://)","");
		
		Collection<String> encodingSet = urlMap.values();
        String encodedValue = StringUtils.EMPTY;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
           int bytes = DEFAULT_BYTES;
           encodedValue = MD5EncodingServiceImpl.getEncodedValue(m, cleanhttp, bytes);
           while(encodingSet.contains(encodedValue)) {
        	   bytes ++;
        	   encodedValue = MD5EncodingServiceImpl.getEncodedValue(m, cleanhttp, bytes);
           }
           //do not store again if the encoded value already exists.
           if(StringUtils.isEmpty(getShortenedUrl(encodedValue))) {
        	   urlMap.put(encodedValue,data);
           }
        } catch (Exception e) {
        }
        return encodedValue;
	}


	@Override
	public String getShortenedUrl(String data) {
		
		String shortenedUrlString = "";
		shortenedUrlString = urlMap.get(data);
		
		return shortenedUrlString;
	}


	@Override
	public void cleanMap() {
		 urlMap.clear();
	}
	
}
