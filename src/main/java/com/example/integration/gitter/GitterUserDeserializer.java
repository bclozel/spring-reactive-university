package com.example.integration.gitter;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.boot.jackson.JsonObjectDeserializer;

/**
 * @author Brian Clozel
 */
public class GitterUserDeserializer extends JsonObjectDeserializer<GitterUser> {

	@Override
	protected GitterUser deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext,
			ObjectCodec objectCodec, JsonNode jsonNode) throws IOException {
		String userId = nullSafeValue(jsonNode.get("id"), String.class);
		String userUrl = nullSafeValue(jsonNode.get("url"), String.class);
		String userName = nullSafeValue(jsonNode.get("username"), String.class);
		String userDisplayName = nullSafeValue(jsonNode.get("displayName"), String.class);
		String userAvatar = nullSafeValue(jsonNode.get("avatarUrl"), String.class);
		String userAvatarMed = nullSafeValue(jsonNode.get("avatarUrlMedium"), String.class);
		String userAvatarSm = nullSafeValue(jsonNode.get("avatarUrlSmall"), String.class);
		return new GitterUser(userId, userUrl, userName, userDisplayName,
				userAvatar, userAvatarMed, userAvatarSm);
	}
}
