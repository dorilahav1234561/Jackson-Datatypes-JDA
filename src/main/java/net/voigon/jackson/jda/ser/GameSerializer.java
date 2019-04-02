package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;

public class GameSerializer extends StdSerializer<Game> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -847659045883580607L;

	protected GameSerializer() {
		super(Game.class);
		
	}

	@Override
	public void serialize(Game value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		
		gen.writeStringField("name", value.getName());
		
		if (value.getType() != GameType.DEFAULT)
			gen.writeNumberField("type", value.getType().getKey());
		
		if (value.getUrl() != null)
			gen.writeStringField("url", value.getUrl());
		
		gen.writeEndObject();
	}

}
