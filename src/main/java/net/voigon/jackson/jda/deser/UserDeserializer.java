package net.voigon.jackson.jda.deser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.voigon.jackson.jda.JDAModule;
import net.voigon.jackson.jda.empty.EmptyUser;

public class UserDeserializer extends StdDeserializer<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2138259969155786181L;

	JDAModule
			module;
	
	protected UserDeserializer(JDAModule module) {
		super(User.class);
		
		this.module = module;
		
	}

	@Override
	public User deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		JsonNode node = jp.readValueAsTree();
		
		User user = null;
		try {
			user = module.getBot().getUserById(node.asText());
			
			if (user == null)
				user = trySerializeWithName(jp, ctxt, node);
			
		} catch (IllegalArgumentException e) {
			user = trySerializeWithName(jp, ctxt, node);
		}
		
		return user;
	}

	@Override
	public User getNullValue() {
		return new EmptyUser();
	}

	protected User trySerializeWithName(JsonParser jp, DeserializationContext ctxt, JsonNode node) throws JsonProcessingException {
		if (!module.deserializeWithNames()) return getNullValue(ctxt);

		List<User> list = module.getBot().getUsersByName(node.asText(), module.isNameIgnoreCase(this));
		return list == null || list.isEmpty() ? getNullValue(ctxt) : list.get(0);
	}

}
