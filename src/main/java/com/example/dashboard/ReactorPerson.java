package com.example.dashboard;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Brian Clozel
 */
@Document
public class ReactorPerson {

	private String id;

	private String name;

	public ReactorPerson() {
	}

	public ReactorPerson(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
