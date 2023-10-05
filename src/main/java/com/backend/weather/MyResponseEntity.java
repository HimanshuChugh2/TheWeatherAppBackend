package com.backend.weather;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * Author: Himanshu Chugh
 * Email: himanshuchugh2@gmail.com
 * Date: 2023-10-02
 */
public class MyResponseEntity<T> extends ResponseEntity<T> {

	private String customMessage;

	public MyResponseEntity(T body, HttpStatus status) {
		super(body, status);
	}

	public MyResponseEntity(T body, HttpHeaders headers, HttpStatus status) {
		super(body, headers, status);
	}

	// Add more constructors if needed

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
}