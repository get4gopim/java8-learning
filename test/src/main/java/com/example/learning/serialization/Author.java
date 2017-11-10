package com.example.learning.serialization;

import java.util.List;

public class Author extends Magazine  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String authorName;
	private List<String> history;
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public List<String> getHistory() {
		return history;
	}
	public void setHistory(List<String> history) {
		this.history = history;
	}
	
	@Override
	public String toString() {
		return super.toString() + "; Author [authorName=" + authorName + ", history=" + history + "]";
	}
	
}
