package service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import serviceapi.UrlShortenerService;

@RunWith(JUnit4.class)
class UrlShortenerServiceTest {

	private static UrlShortenerService urlService;

	@BeforeAll
	public static void setup() {
		urlService = new UrlShortenerServiceImpl();
	}

	@Test
	void testGetShortenedURL() {
		String shortUrl1 = urlService.getShortenedURL("http://www.youtube.com/someVideo/", "1");
		String shortUrl2 = urlService.getShortenedURL("http://youtube.com/someVideo", "1");
		String shortUrl3 = urlService.getShortenedURL("http://google.com/someSearch", "1");
		String shortUrl4 = urlService.getShortenedURL("http://youtube.com/someVideo", "2");

		assertEquals(shortUrl1, shortUrl2, "Same Short URL is NOT returned for Same Long URL for Same client.");
		assertNotEquals(shortUrl1, shortUrl3,
				"Different Short URL is NOT returned for different Long URL for Same client.");
		assertNotEquals(shortUrl1, shortUrl4,
				"Different Short URL is NOT returned for Same Long URL for Different client.");
	}

	@Test
	void testGetShortenedURLForInvalidInput() {
		String shortUrl1 = urlService.getShortenedURL("", "1");
		String shortUrl2 = urlService.getShortenedURL(null, "2");

		assertNull("For Empty URL, it should return null", shortUrl1);
		assertNull("For null URL, it should return null", shortUrl2);

	}

	@Test
	void testGetOriginalURL() {
		String shortUrl1 = urlService.getShortenedURL("http://www.youtube.com/someVideo/", "1");
		String shortUrl2 = urlService.getShortenedURL("http://www.youtube.com/someVideo/", "2");
		String longUrl1 = urlService.getOriginalURL(shortUrl1);
		String longUrl2 = urlService.getOriginalURL(shortUrl1);
		String longUrl3 = urlService.getOriginalURL(shortUrl2);

		assertEquals(longUrl1, longUrl2, "Same Long URL is NOT returned for the Same Short URL.");
		assertEquals(longUrl1, longUrl3, "Same Long URL is NOT returned for Same Short URL for Different client.");
	}

	@Test
	void testGetOriginalURLForInvalidInput() {
		String shortUrl1 = urlService.getShortenedURL("http://www.facebook.com/user1/", "1");
		String longUrl1 = urlService.getOriginalURL("");
		String longUrl2 = urlService.getOriginalURL(null);
		String longUrl3 = urlService.getOriginalURL("SomeRandomInputText");

		assertNotNull(shortUrl1, "It should return Not-null shortUrl for a valid Long URL");
		assertNull("For Empty Short URL, it should return null", longUrl1);
		assertNull("For null Short URL, it should return null", longUrl2);
		assertNull("For an Invalid Short URL, it should return null", longUrl3);

	}

	@Test
	void testGetHitCount() {
		String shortUrl1 = urlService.getShortenedURL("http://www.youtube.com/someVideo/", "1");
		urlService.getOriginalURL(shortUrl1);
		assertEquals(urlService.getHitCount(shortUrl1), 3, "HitCount is NOT matched for the Short URL : " + shortUrl1);
	}
	
	@Test
	void testGetHitCountForInvalidInput() {
		String shortUrl1 = urlService.getShortenedURL("http://www.youtube.com/someVideo1/", "1");
		urlService.getOriginalURL(shortUrl1);
		assertEquals(urlService.getHitCount(""), 0, "HitCount is NOT matched for the Short URL : " + shortUrl1);
		assertEquals(urlService.getHitCount(null), 0, "HitCount is NOT matched for the Short URL : " + shortUrl1);
		assertEquals(urlService.getHitCount("SomeRandomInputText"), 0, "HitCount is NOT matched for the Short URL : " + shortUrl1);

	}

}
