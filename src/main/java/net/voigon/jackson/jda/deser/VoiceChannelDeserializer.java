package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.voigon.jackson.jda.empty.EmptyVoiceChannel;

public class VoiceChannelDeserializer extends StdDeserializer<VoiceChannel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1889416326944723324L;

	JDA
			bot;
	
	protected VoiceChannelDeserializer(JDA bot) {
		super(VoiceChannel.class);
		
		this.bot = bot;
	}

	@Override
	public VoiceChannel deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		JsonNode node = jp.readValueAsTree();
		
		VoiceChannel voiceChannel = null;
		try {
			voiceChannel = bot.getVoiceChannelById(node.asText());
			
			if (voiceChannel == null)
				voiceChannel = new EmptyVoiceChannel();
			
		} catch (IllegalArgumentException e) {
			voiceChannel = new EmptyVoiceChannel();
		}
		
		return voiceChannel;
	}

}
