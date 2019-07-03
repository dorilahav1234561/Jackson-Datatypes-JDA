package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Role;
import net.voigon.jackson.jda.empty.EmptyRole;

public class RoleDeserializer extends StdDeserializer<Role> {

	private static final long serialVersionUID = 6084546409058036415L;
	
	final JDA
			bot;

	protected RoleDeserializer(JDA bot) {
		super(Role.class);
		
		this.bot = bot;
	}

	@Override
	public Role deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		JsonNode node = jp.readValueAsTree();
		
		Role role = null;
		try {
			role = bot.getRoleById(node.asText());
			
			if (role == null)
				role = new EmptyRole();
			
		} catch (IllegalArgumentException e) {
			role = new EmptyRole();
		}
		
		return role;
	}

	@Override
	public Role getNullValue() {
		return new EmptyRole();
	}
}
