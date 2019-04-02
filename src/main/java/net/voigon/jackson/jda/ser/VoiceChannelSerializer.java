package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.VoiceChannel;

public class VoiceChannelSerializer extends StdSerializer<VoiceChannel> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1901211609388437491L;
	
	protected VoiceChannelSerializer() {
		super(VoiceChannel.class);

	}
	
	@Override
	public void serialize(VoiceChannel value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.getId());
		
	}

}
