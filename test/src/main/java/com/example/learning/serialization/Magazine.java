package com.example.learning.serialization;

import java.io.Serializable;

public class Magazine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7617705073675686804L;
	
	public static int magazineId = 2002;
	
	private String publisherName;
	private String issueName;
	private int totalPages;
	
	public Magazine() {
		super();
	}

	public Magazine(String publisherName, String issueName, int totalPages) {
		super();
		this.publisherName = publisherName;
		this.issueName = issueName;
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "Magazine [publisherName=" + publisherName + ", issueName=" + issueName + ", totalPages=" + totalPages
				+ "]";
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	
	
}
