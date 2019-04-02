package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.entities.MessageEmbed.ImageInfo;

public class ImageInfoDeserializer extends StdDeserializer<ImageInfo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ImageInfoDeserializer() {
		super(ImageInfo.class);

	}

	@Override
	public ImageInfo deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		JsonNode node = p.readValueAsTree();
		JsonNode proxyIconUrl = node.get("proxyIconUrl");
		
		return new ImageInfo(node.get("url").asText(), proxyIconUrl != null ? proxyIconUrl.asText() : null, node.get("width").asInt(), node.get("height").asInt());
	}

}
