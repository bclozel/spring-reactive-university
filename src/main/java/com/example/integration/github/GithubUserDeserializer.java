package com.example.integration.github;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.boot.jackson.JsonObjectDeserializer;

/**
 * @author Brian Clozel
 */
public class GithubUserDeserializer extends JsonObjectDeserializer<GithubUser> {

	@Override
	protected GithubUser deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext,
			ObjectCodec objectCodec, JsonNode jsonNode) throws IOException {

		Long id = nullSafeValue(jsonNode.get("id"), Long.class);
		String login = nullSafeValue(jsonNode.get("login"), String.class);
		String avatarUrl = nullSafeValue(jsonNode.get("avatar_url"), String.class);
		String url = nullSafeValue(jsonNode.get("url"), String.class);
		return new GithubUser(id, login, avatarUrl, url);
	}
}
