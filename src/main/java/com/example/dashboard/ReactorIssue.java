package com.example.dashboard;

import com.example.integration.github.GithubIssue;

/**
 * @author Brian Clozel
 */
public class ReactorIssue {

	private long number;

	private String url;

	private String title;

	private String userLogin;

	private String userAvatarUrl;

	private boolean userOnline;

	public ReactorIssue(GithubIssue issue, boolean userOnline) {
		this.number = issue.getNumber();
		this.url = issue.getUrl();
		this.title = issue.getTitle();
		this.userLogin = issue.getUser().getLogin();
		this.userAvatarUrl = issue.getUser().getAvatarUrl();
		this.userOnline = userOnline;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserAvatarUrl() {
		return userAvatarUrl;
	}

	public void setUserAvatarUrl(String userAvatarUrl) {
		this.userAvatarUrl = userAvatarUrl;
	}

	public boolean isUserOnline() {
		return userOnline;
	}

	public void setUserOnline(boolean userOnline) {
		this.userOnline = userOnline;
	}
}
