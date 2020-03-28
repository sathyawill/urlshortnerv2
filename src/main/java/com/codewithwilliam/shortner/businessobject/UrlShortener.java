package com.codewithwilliam.shortner.businessobject;



public class UrlShortener {
	public String url;
	public String shortened = "";
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getShortened() {
		return shortened;
	}
	public void setShortened(String shortened) {
		this.shortened = shortened;
	}
	@Override
	public String toString() {
		return "UrlShortener [url=" + url + ", shortened=" + shortened + "]";
	}

	
}
