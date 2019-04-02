package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.Category;

public class CategorySerializer extends StdSerializer<Category> {
	
	private static final long serialVersionUID = 4899139245232261396L;

	protected CategorySerializer() {
		super(Category.class);
	}

	@Override
	public void serialize(Category value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.getId());
	}

}
