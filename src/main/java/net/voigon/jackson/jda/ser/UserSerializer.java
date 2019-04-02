package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.User;

public class UserSerializer extends StdSerializer<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3125595552164938388L;

	protected UserSerializer() {
		super(User.class);

	}

	@Override
	public void serialize(User value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.getId());
		
	}

}
