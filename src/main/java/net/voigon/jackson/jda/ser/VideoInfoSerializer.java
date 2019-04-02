package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.MessageEmbed.VideoInfo;

public class VideoInfoSerializer extends StdSerializer<VideoInfo> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected VideoInfoSerializer() {
		super(VideoInfo.class);

	}

	@Override
	public void serialize(VideoInfo value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		
		gen.writeStringField("url", value.getUrl());
		gen.writeNumberField("width", value.getWidth());
		gen.writeNumberField("height", value.getHeight());
		
		gen.writeEndObject();
	}

}
