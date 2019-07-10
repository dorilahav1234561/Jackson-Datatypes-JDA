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
import net.dv8tion.jda.core.entities.Role;
import net.voigon.jackson.jda.JDAModule;
import net.voigon.jackson.jda.empty.EmptyRole;

public class RoleDeserializer extends StdDeserializer<Role> {

	private static final long serialVersionUID = 6084546409058036415L;
	
	final JDAModule
			module;

	protected RoleDeserializer(JDAModule module) {
		super(Role.class);
		
		this.module = module;

	}

	@Override
	public Role deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		if (module.getBot() == null) return getNullValue();

		JsonNode node = jp.readValueAsTree();
		
		Role role = null;
		try {
			role = module.getBot().getRoleById(node.asText());
			
			if (role == null)
				role = trySerializeWithName(jp, ctxt, node);
			
		} catch (IllegalArgumentException e) {
			role = trySerializeWithName(jp, ctxt, node);
		}
		
		return role;
	}

	@Override
	public Role getNullValue() {
		return new EmptyRole();
	}

	protected Role trySerializeWithName(JsonParser jp, DeserializationContext ctxt, JsonNode node) throws JsonProcessingException {
		if (!module.deserializeWithNames()) return getNullValue(ctxt);

		List<Role> list = module.getBot().getRolesByName(node.asText(), module.isNameIgnoreCase(this));
		return list == null || list.isEmpty() ? getNullValue(ctxt) : list.get(0);
	}

}
