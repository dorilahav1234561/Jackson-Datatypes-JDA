package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.TextChannel;
import net.voigon.jackson.jda.empty.EmptyTextChannel;

public class TextChannelDeserializer extends StdDeserializer<TextChannel> {

	final JDA
			bot;
	
	protected TextChannelDeserializer(JDA bot) {
		super(TextChannel.class);

		this.bot = bot;
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
			textChannel = bot.getTextChannelById(node.asText());
			
			if (textChannel == null)
				textChannel = new EmptyTextChannel();
			
		} catch (IllegalArgumentException e) {
			textChannel = new EmptyTextChannel();
		}
		
		return textChannel;
	}

}
