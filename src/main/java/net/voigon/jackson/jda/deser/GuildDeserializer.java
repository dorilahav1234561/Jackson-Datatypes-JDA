package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.voigon.jackson.jda.empty.EmptyGuild;

public class GuildDeserializer extends StdDeserializer<Guild> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6659737559189291958L;
	
	private JDA
		bot;

	protected GuildDeserializer(JDA bot) {
		super(Guild.class);
		
		this.bot = bot;
	}

	@Override
	public Guild deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
		JsonNode node = jp.readValueAsTree();
		
		Guild guild = null;
		try {
			guild = bot.getGuildById(node.asText());
			
			if (guild == null)
				guild = new EmptyGuild();
			
		} catch (IllegalArgumentException e) {
			guild = new EmptyGuild();
		}
		
		return guild;
	}

}
