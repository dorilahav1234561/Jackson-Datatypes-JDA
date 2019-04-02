package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;

public class GameDeserializer extends StdDeserializer<Game> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3828509447620077662L;
	
	protected GameDeserializer() {
		super(Game.class);
		
	}


	@Override
	public Game deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		JsonNode node = p.readValueAsTree();
		ObjectMapper mapper = (ObjectMapper) p.getCodec();
		
		return Game.of(mapper.treeToValue(node.get("type"), GameType.class), node.get("name").asText(), node.get("url").asText());
	}

}
