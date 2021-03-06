package com.analyzer.data.inner;

public class HyperMediaLink {
	private String link;
	private String message;
	private boolean available;
	private boolean isExternal;

	public HyperMediaLink(String link) {
		this.link = link;
	}

	public String getLink() { return link; }
	public void setLink(String link) { this.link = link; }
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	public boolean isAvailable() { return available; }
	public void setAvailable(boolean available) { this.available = available; }
	public boolean isExternal() { return isExternal; }
	public void setExternal(boolean external) { isExternal = external; }
}
