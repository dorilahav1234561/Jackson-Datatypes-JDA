package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.entities.MessageEmbed.Footer;

public class FooterDeserializer extends StdDeserializer<Footer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected FooterDeserializer() {
		super(Footer.class);

	}

	@Override
	public Footer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.readValueAsTree(),
				proxyIconUrl = node.get("proxyIconUrl");
		return new Footer(node.get("text").asText(), node.get("iconUrl").asText(), proxyIconUrl == null ? null : proxyIconUrl.asText());
	}

}
