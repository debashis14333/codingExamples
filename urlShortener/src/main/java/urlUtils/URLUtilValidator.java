package urlUtils;

public class URLUtilValidator {
	
	public static boolean validateClientId(String clientId) {
		return true;
	}

	public static boolean validateLongURL(String url) {
		if(url==null || url.isEmpty()) {
			return false;
		}
		return true;
	}

	public static boolean validateShortURL(String url, String domain) {
		if(url==null || url.isEmpty())
		{
			return false;
		}
		if (url.substring(0, domain.length()).equals(domain))
		{
			return true;
		}
		return false;
	}
	
	
	public static String sanitizeLongURL(String url) {
		if (url.substring(0, 7).equals("http://"))
			url = url.substring(7);

		if (url.substring(0, 8).equals("https://"))
			url = url.substring(8);

		if (url.substring(0, 4).equals("www."))
			url = url.substring(4);

		if (url.charAt(url.length() - 1) == '/')
			url = url.substring(0, url.length() - 1);
		return url;
	}

	public static String sanitizeShortURL(String url, String domain) {
		if (url.substring(0, domain.length()).equals(domain))
			url = url.substring(domain.length());
		
		return url;
	}
	
	public static String encodeToken(long token) {
		// Map to store 62 chars
		char charMap[] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

		StringBuffer encodedToken = new StringBuffer();

		// Convert given token to a base 62 number
		while (token > 0) {
			int position = (int) (token % 62);
			encodedToken.insert(0, charMap[position]);
			token = token / 62;
		}
		return encodedToken.toString();
	}

    public static long decodeToken(String shortURL)  
    {  
        long token = 0;
        int length = shortURL.length();
        for (int i = 1; i <= length; i++)  
        {  
            if ('0' <= shortURL.charAt(length-i) &&  
                       shortURL.charAt(length-i) <= '9')  
            {
            	token = token * 62 + shortURL.charAt(length-i) - '0';;  
                	
            }
            if ('a' <= shortURL.charAt(length-i) &&  
                       shortURL.charAt(length-i) <= 'z')  
            {
            	token = token * 62 + shortURL.charAt(length-i) - 'a' + 10;  
            	
            }
            if ('A' <= shortURL.charAt(length-i) &&  
                       shortURL.charAt(length-i) <= 'Z') 
            {
            	token = token * 62 + shortURL.charAt(length-i) - 'A' + 36; 	
            } 
        }  
        return token;  
    } 

}
