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
public class GithubIssueDeserializer extends JsonObjectDeserializer<GithubIssue> {

	@Override
	protected GithubIssue deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext,
			ObjectCodec objectCodec, JsonNode jsonNode) throws IOException {
		Long id = nullSafeValue(jsonNode.get("id"), Long.class);
		String url = nullSafeValue(jsonNode.get("url"), String.class);
		Integer number = nullSafeValue(jsonNode.get("number"), Integer.class);
		String title = nullSafeValue(jsonNode.get("title"), String.class);
		JsonNode userNode = jsonNode.get("user");
		GithubUser user = objectCodec.readValue(userNode.traverse(objectCodec), GithubUser.class);
		return new GithubIssue(id, url, number, title, user);
	}
}
