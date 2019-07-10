package net.voigon.jackson.jda.deser;

import java.io.IOException;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import lombok.Getter;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.EntityBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

public class MessageEmbedDeserializer extends StdDeserializer<MessageEmbed> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7971646051109716360L;
	
	@Getter
	final JDA
			bot;

	protected MessageEmbedDeserializer(JDA bot) {
		super(MessageEmbed.class);

		this.bot = bot;
		
	}
	
	@Override
	public MessageEmbed deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		if (getBot() == null) return null;

		return new EntityBuilder(getBot()).createMessageEmbed(
				new JSONObject(p.getCodec().<Map<?, ?>>readValue(p, new TypeReference<Map<?, ?>>() {})));
	}

}
