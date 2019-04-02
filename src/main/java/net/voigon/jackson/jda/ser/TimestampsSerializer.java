package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.RichPresence.Timestamps;

public class TimestampsSerializer extends StdSerializer<Timestamps> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3329474326780859811L;

	protected TimestampsSerializer() {
		super(Timestamps.class);
		
	}

	@Override
	public void serialize(Timestamps value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		
		if (value.getStart() != 0)
			gen.writeNumberField("start", value.getStart());
		
		if (value.getEnd() != 0)
			gen.writeNumberField("end", value.getEnd());
		
		gen.writeEndObject();
		
	}

}
