package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.Guild;

public class GuildSerializer extends StdSerializer<Guild> {

	private static final long serialVersionUID = -7628726635930111231L;

	protected GuildSerializer() {
		super(Guild.class);
	}

	@Override
	public void serialize(Guild value, JsonGenerator jg, SerializerProvider sp) throws IOException {
		jg.writeString(value.getId());
	}

}
