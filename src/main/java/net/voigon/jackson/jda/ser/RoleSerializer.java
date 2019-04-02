package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.Role;

public class RoleSerializer extends StdSerializer<Role> {

	private static final long serialVersionUID = -1149617652133479436L;

	protected RoleSerializer() {
		super(Role.class);
	}

	@Override
	public void serialize(Role value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.getId());
	}

}
