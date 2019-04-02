package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.entities.MessageEmbed.VideoInfo;

public class VideoInfoDeserializer extends StdDeserializer<VideoInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected VideoInfoDeserializer() {
		super(VideoInfo.class);

	}

	@Override
	public VideoInfo deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = p.readValueAsTree();
		return new VideoInfo(node.get("url").asText(), node.get("width").asInt(), node.get("height").asInt());
	}

}
