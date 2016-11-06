package com.example.integration.gitter;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Brian Clozel
 */
@JsonDeserialize(using = GitterUserDeserializer.class)
public class GitterUser {

	private String id;

	private String url;

	private String username;

	private String displayName;

	private String avatarUrl;

	private String avatarUrlMedium;

	private String avatarUrlSmall;

	public GitterUser(String id, String url, String username, String displayName, String avatarUrl,
			String avatarUrlMedium, String avatarUrlSmall) {
		this.id = id;
		this.url = url;
		this.username = username;
		this.displayName = displayName;
		this.avatarUrl = avatarUrl;
		this.avatarUrlMedium = avatarUrlMedium;
		this.avatarUrlSmall = avatarUrlSmall;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrlMedium() {
		return avatarUrlMedium;
	}

	public void setAvatarUrlMedium(String avatarUrlMedium) {
		this.avatarUrlMedium = avatarUrlMedium;
	}

	public String getAvatarUrlSmall() {
		return avatarUrlSmall;
	}

	public void setAvatarUrlSmall(String avatarUrlSmall) {
		this.avatarUrlSmall = avatarUrlSmall;
	}


	/*

	   "avatarUrl": "https://avatars-04.gitter.im/gh/uv/3/bclozel",
            "avatarUrlMedium": "https://avatars2.githubusercontent.com/u/103264?v=3&s=128",
            "avatarUrlSmall": "https://avatars2.githubusercontent.com/u/103264?v=3&s=60",
            "displayName": "Brian Clozel",
            "gv": "3",
            "id": "568e464916b6c7089cc186de",
            "url": "/bclozel",
            "username": "bclozel",
            "v": 2
	    */
}
