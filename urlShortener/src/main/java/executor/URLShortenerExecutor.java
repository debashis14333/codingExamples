package executor;

import service.UrlShortenerServiceImpl;
import serviceapi.UrlShortenerService;

public class URLShortenerExecutor {
	
	public static void main(String[] args) {
		UrlShortenerService urlService =  new UrlShortenerServiceImpl();
		String shortUrl1 = urlService.getShortenedURL("http://www.youtube.com/someVideo/", "1");
		String shortUrl2 = urlService.getShortenedURL("http://youtube.com/someVideo", "1");
		if(shortUrl1.equals(shortUrl2))
			System.out.println("Correctly Returned");
		String longUrl1 = urlService.getOriginalURL(shortUrl1);
		String longUrl2 = urlService.getOriginalURL(shortUrl2);
		if(longUrl1.equals(longUrl2))
			System.out.println("Correctly Returned 2");
		System.out.println("Hit count : " + urlService.getHitCount(shortUrl1));
	}


}
