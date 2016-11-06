package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Brian Clozel
 */
@ConfigurationProperties("dashboard")
public class DashboardProperties {

	private final Reactor reactor = new Reactor();

	private final Github github = new Github();

	private final Gitter gitter = new Gitter();

	public Reactor getReactor() {
		return reactor;
	}

	public Github getGithub() {
		return github;
	}

	public Gitter getGitter() {
		return gitter;
	}

	public static class Reactor {

		private String gitterRoomId = "5534f75e15522ed4b3df41a7";

		public String getGitterRoomId() {
			return gitterRoomId;
		}

		public void setGitterRoomId(String gitterRoomId) {
			this.gitterRoomId = gitterRoomId;
		}
	}

	public static class Github {

		private String username;

		private String token;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	}

	public static class Gitter {

		private String token;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	}

}
