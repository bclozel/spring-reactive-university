package com.example.dashboard;

/**
 * @author Brian Clozel
 */
public class ReactorPersonNotFoundException extends RuntimeException {

	public ReactorPersonNotFoundException(String id) {
		super("ReactorPerson not found with id=" + id);
	}
}
