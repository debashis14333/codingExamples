package serviceapi;

public interface UrlShortenerService {
	
	String getShortenedURL(String longURL, String clientId);
	String getOriginalURL(String shortURL);
	int getHitCount(String shortURL);

}
