package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.entities.MessageEmbed.AuthorInfo;

public class AuthorInfoDeserializer extends StdDeserializer<AuthorInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected AuthorInfoDeserializer() {
		super(AuthorInfo.class);

	}

	@Override
	public AuthorInfo deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		JsonNode node = p.readValueAsTree();
		JsonNode proxyIconUrl = node.get("proxyIconUrl");
		
		return new AuthorInfo(node.get("name").asText(), node.get("url").asText(), node.get("iconUrl").asText(), proxyIconUrl != null ? proxyIconUrl.asText() : null);
	}

}
