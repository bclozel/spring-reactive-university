package com.example.integration.github;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Brian Clozel
 */
@JsonDeserialize(using = GithubIssueDeserializer.class)
public class GithubIssue {

	private long id;

	private String url;

	private int number;

	private String title;

	private GithubUser user;

	public GithubIssue(long id, String url, int number, String title, GithubUser user) {
		this.id = id;
		this.url = url;
		this.number = number;
		this.title = title;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public GithubUser getUser() {
		return user;
	}

	public void setUser(GithubUser user) {
		this.user = user;
	}
}
