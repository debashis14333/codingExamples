package service;

import java.util.HashMap;
import java.util.Map;

import pojos.URL;
import serviceapi.TokenService;
import serviceapi.UrlShortenerService;
import static urlUtils.URLUtilValidator.*;

public class UrlShortenerServiceImpl implements UrlShortenerService {

	private static final int SERVER_ID = 1;
	private static final int SHORT_URL_LENGTH = 8;
	private static final String SHORT_URL_DOMAIN = "http://tinyUrl.in/";

	private static long currentToken;
	private TokenService tokenService;
	private Map<String, URL> shortUrlToURLMap;
	private Map<String, String> clientIdLongUrlToShortUrlMap;

	public UrlShortenerServiceImpl() {
		shortUrlToURLMap = new HashMap();
		clientIdLongUrlToShortUrlMap = new HashMap();
		tokenService = new TokenServiceImpl();
		currentToken = tokenService.getTokenRange(SERVER_ID);
	}

	@Override
	public String getShortenedURL(String longURL, String clientId) {
		String shortURL = "";
		if (validateLongURL(longURL) && validateClientId(clientId)) {
			longURL = sanitizeLongURL(longURL);
			String queryId = clientId + longURL;
			if (clientIdLongUrlToShortUrlMap.containsKey(queryId)) {
				shortURL = clientIdLongUrlToShortUrlMap.get(queryId);
			} else {
				long token = getNextToken();
				shortURL = encodeToken(token);
				URL url = new URL(shortURL, longURL, clientId);
				shortUrlToURLMap.put(shortURL, url);
				clientIdLongUrlToShortUrlMap.put(queryId, shortURL);
			}
		}
		else
		{
			return null;
		}
		return SHORT_URL_DOMAIN + shortURL;
	}


	private long getNextToken() {
		if (currentToken % 10 == 0) {
			currentToken = tokenService.getTokenRange(SERVER_ID);
		}
		return currentToken++;
	}

	@Override
	public String getOriginalURL(String shortURL) {
		// TODO Auto-generated method stub
		if(validateShortURL(shortURL, SHORT_URL_DOMAIN))
		{
			String url = sanitizeShortURL(shortURL, SHORT_URL_DOMAIN);
			if(shortUrlToURLMap.containsKey(url))
			{
				URL urlObject = shortUrlToURLMap.get(url);
				urlObject.increaseHitCount();
				return urlObject.getLongURL();
			}
		}
		return null;
	}

	@Override
	public int getHitCount(String shortURL) {
		// TODO Auto-generated method stub
		if(validateShortURL(shortURL, SHORT_URL_DOMAIN))
		{
			String url = sanitizeShortURL(shortURL, SHORT_URL_DOMAIN);
			if(shortUrlToURLMap.containsKey(url))
			{
				return shortUrlToURLMap.get(url).getHitCount();
			}
		}
		return 0;
	}

}
