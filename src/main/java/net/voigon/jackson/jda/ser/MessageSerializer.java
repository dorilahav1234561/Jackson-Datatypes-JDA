package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.Message;

public class MessageSerializer extends StdSerializer<Message> {

	protected MessageSerializer() {
		super(Message.class);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4000217108154416202L;

	@Override
	public void serialize(Message value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeObjectField("channel", value.getChannel());
		gen.writeStringField("id", value.getId());
		gen.writeEndObject();
	}

}
