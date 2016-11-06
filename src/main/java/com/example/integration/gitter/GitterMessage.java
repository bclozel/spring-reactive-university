package com.example.integration.gitter;

import java.time.Instant;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Brian Clozel
 */
@JsonDeserialize(using = GitterMessageDeserializer.class)
public class GitterMessage {

	private String id;

	private String text;

	private String html;

	private GitterUser fromUser;

	private Instant sent;

	public GitterMessage(String id, String text, String html, GitterUser fromUser, Instant sent) {
		this.id = id;
		this.text = text;
		this.html = html;
		this.fromUser = fromUser;
		this.sent = sent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Instant getSent() {
		return sent;
	}

	public void setSent(Instant sent) {
		this.sent = sent;
	}

	public GitterUser getFromUser() {
		return fromUser;
	}

	public void setFromUser(GitterUser fromUser) {
		this.fromUser = fromUser;
	}

}
