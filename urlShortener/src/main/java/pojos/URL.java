package pojos;

import java.sql.Timestamp;

public class URL {
	private String shortURL;
	private String longURL;
	private String userId;
	private int hitCount;
	private Timestamp creationDate;
	
	
	public URL(String shortURL, String longURL, String userId) {
		this.shortURL = shortURL;
		this.longURL = longURL;
		this.userId = userId;
		this.hitCount = 0;
		this.creationDate = new Timestamp(System.currentTimeMillis());
	}
	//auto-generated getter-setters.
	public String getShortURL() {
		return shortURL;
	}
	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	public String getLongURL() {
		return longURL;
	}
	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void increaseHitCount() {
		hitCount++;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	
}
