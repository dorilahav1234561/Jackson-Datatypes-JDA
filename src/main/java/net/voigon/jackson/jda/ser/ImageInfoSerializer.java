package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.MessageEmbed.ImageInfo;

public class ImageInfoSerializer extends StdSerializer<ImageInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ImageInfoSerializer() {
		super(ImageInfo.class);
		
	}

	@Override
	public void serialize(ImageInfo value, JsonGenerator gen, SerializerProvider provider) throws IOException {		
		gen.writeStartObject();
		gen.writeStringField("url", value.getUrl());
		gen.writeNumberField("width", value.getWidth());
		gen.writeNumberField("height", value.getHeight());
		if (value.getProxyUrl() != null && !value.getProxyUrl().isEmpty())
			gen.writeStringField("proxyUrl", value.getProxyUrl());
		
		gen.writeEndObject();
		
	}

}
