package net.voigon.jackson.jda.deser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.voigon.jackson.jda.JDAModule;
import net.voigon.jackson.jda.empty.EmptyVoiceChannel;

public class VoiceChannelDeserializer extends StdDeserializer<VoiceChannel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1889416326944723324L;

	JDAModule
			module;
	
	protected VoiceChannelDeserializer(JDAModule module) {
		super(VoiceChannel.class);
		
		this.module = module;
	}

	@Override
	public VoiceChannel deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		JsonNode node = jp.readValueAsTree();
		
		VoiceChannel voiceChannel = null;
		try {
			voiceChannel = module.getBot().getVoiceChannelById(node.asText());
			
			if (voiceChannel == null)
				voiceChannel = trySerializeWithName(jp, ctxt, node);
			
		} catch (IllegalArgumentException e) {
			voiceChannel = trySerializeWithName(jp, ctxt, node);
		}
		
		return voiceChannel;
	}

	@Override
	public VoiceChannel getNullValue() {
		return new EmptyVoiceChannel();
	}

	protected VoiceChannel trySerializeWithName(JsonParser jp, DeserializationContext ctxt, JsonNode node) throws JsonProcessingException {
		if (!module.deserializeWithNames()) return getNullValue(ctxt);

		List<VoiceChannel> list = module.getBot().getVoiceChannelByName(node.asText(), module.isNameIgnoreCase(this));
		return list == null || list.isEmpty() ? getNullValue(ctxt) : list.get(0);
	}

}
