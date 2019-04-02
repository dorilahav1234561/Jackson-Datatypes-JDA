package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.MessageEmbed.Field;

public class FieldSerializer extends StdSerializer<Field> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected FieldSerializer() {
		super(Field.class);

	}

	@Override
	public void serialize(Field value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		
		gen.writeStringField("name", value.getName());
		gen.writeStringField("value", value.getValue());
		gen.writeBooleanField("inline", value.isInline());
		
		gen.writeEndObject();
	}

}
