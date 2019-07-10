package net.voigon.jackson.jda.deser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Guild;
import net.voigon.jackson.jda.JDAModule;
import net.voigon.jackson.jda.empty.EmptyGuild;

public class GuildDeserializer extends StdDeserializer<Guild> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6659737559189291958L;
	
	private JDAModule
		module;

	protected GuildDeserializer(JDAModule module) {
		super(Guild.class);
		
		this.module = module;

	}

	@Override
	public Guild deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
		if (module.getBot() == null) return getNullValue();

		JsonNode node = jp.readValueAsTree();

		Guild guild = null;
		try {
			guild = module.getBot().getGuildById(node.asText());
			
			if (guild == null)
				guild = trySerializeWithName(jp, dc, node);
			
		} catch (IllegalArgumentException e) {
			guild = trySerializeWithName(jp, dc, node);
		}
		
		return guild;
	}

	@Override
	public Guild getNullValue() {
		return new EmptyGuild();
	}

	protected Guild trySerializeWithName(JsonParser jp, DeserializationContext ctxt, JsonNode node) throws JsonProcessingException {
		if (!module.deserializeWithNames()) return getNullValue(ctxt);

		List<Guild> list = module.getBot().getGuildsByName(node.asText(), module.isNameIgnoreCase(this));
		return list == null || list.isEmpty() ? getNullValue(ctxt) : list.get(0);
	}

}
