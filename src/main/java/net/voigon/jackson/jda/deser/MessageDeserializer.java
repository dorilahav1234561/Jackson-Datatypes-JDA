package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.voigon.jackson.jda.empty.EmptyMessage;

public class MessageDeserializer extends StdDeserializer<Message> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8611029621720313664L;

	protected MessageDeserializer() {
		super(Message.class);
		
	}

	@Override
	public Message deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = jp.readValueAsTree();
		
		Message message = null;
		try {
			message = ((ObjectMapper) jp.getCodec()).convertValue(node.get("channel"), TextChannel.class).getMessageById(node.get("id").asText()).complete();
			
			if (message == null)
				message = new EmptyMessage();
			
		} catch (IllegalArgumentException e) {
			message = new EmptyMessage();
		}
		
		return message;
	}

	@Override
	public Message getNullValue() {
		return new EmptyMessage();
	}
}
