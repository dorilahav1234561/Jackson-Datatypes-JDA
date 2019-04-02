package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.MessageEmbed;

public class MessageEmbedSerializer extends StdSerializer<MessageEmbed> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7426152257037317186L;

	protected MessageEmbedSerializer() {
		super(MessageEmbed.class);
		
	}

	@Override
	public void serialize(MessageEmbed value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeObject(value.toJSONObject().toMap());
		
	}

	
}
