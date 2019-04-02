package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.TextChannel;

public class TextChannelSerializer extends StdSerializer<TextChannel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5039597109402465170L;
	
	protected TextChannelSerializer() {
		super(TextChannel.class);
	}

	@Override
	public void serialize(TextChannel value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.getId());
	}

}
