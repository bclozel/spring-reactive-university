package com.example.integration.github;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Brian Clozel
 */
@JsonDeserialize(using = GithubUserDeserializer.class)
public class GithubUser {

	private long id;

	private String login;

	private String avatarUrl;

	private String url;

	public GithubUser(long id, String login, String avatarUrl, String url) {
		this.id = id;
		this.login = login;
		this.avatarUrl = avatarUrl;
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
