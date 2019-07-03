package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;
import net.voigon.jackson.jda.empty.EmptyUser;

public class UserDeserializer extends StdDeserializer<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2138259969155786181L;

	JDA
			bot;
	
	protected UserDeserializer(JDA bot) {
		super(User.class);
		
		this.bot = bot;
		
	}

	@Override
	public User deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		JsonNode node = jp.readValueAsTree();
		
		User user = null;
		try {
			user = bot.getUserById(node.asText());
			
			if (user == null)
				user = new EmptyUser();
			
		} catch (IllegalArgumentException e) {
			user = new EmptyUser();
		}
		
		return user;
	}

	@Override
	public User getNullValue() {
		return new EmptyUser();
	}
}
