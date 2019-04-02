package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.entities.MessageEmbed.Field;

public class FieldDeserializer extends StdDeserializer<Field> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected FieldDeserializer() {
		super(Field.class);

	}

	@Override
	public Field deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.readValueAsTree();
		return new Field(node.get("name").asText(), node.get("value").asText(), node.get("inline").asBoolean());
	}

}
