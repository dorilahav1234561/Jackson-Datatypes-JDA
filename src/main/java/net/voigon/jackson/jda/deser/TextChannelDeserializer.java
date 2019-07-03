package net.voigon.jackson.jda.deser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.voigon.jackson.jda.JDAModule;
import net.voigon.jackson.jda.empty.EmptyTextChannel;

public class TextChannelDeserializer extends StdDeserializer<TextChannel> {

	final JDAModule
			module;
	
	protected TextChannelDeserializer(JDAModule module) {
		super(TextChannel.class);

		this.module = module;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3474620147837266781L;

	@Override
	public TextChannel deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		JsonNode node = jp.readValueAsTree();
		
		TextChannel textChannel = null;
		try {
			textChannel = module.getBot().getTextChannelById(node.asText());
			
			if (textChannel == null)
				textChannel = trySerializeWithName(jp, ctxt, node);
			
		} catch (IllegalArgumentException e) {
			textChannel = trySerializeWithName(jp, ctxt, node);
		}
		
		return textChannel;
	}

	@Override
	public TextChannel getNullValue() {
		return new EmptyTextChannel();
	}

	protected TextChannel trySerializeWithName(JsonParser jp, DeserializationContext ctxt, JsonNode node) throws JsonProcessingException {
		if (!module.deserializeWithNames()) return getNullValue(ctxt);

		List<TextChannel> list = module.getBot().getTextChannelsByName(node.asText(), module.isNameIgnoreCase(this));
		return list == null || list.isEmpty() ? getNullValue(ctxt) : list.get(0);
	}

}
