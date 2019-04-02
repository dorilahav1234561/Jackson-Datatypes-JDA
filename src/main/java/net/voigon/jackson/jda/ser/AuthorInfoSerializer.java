package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.MessageEmbed.AuthorInfo;

public class AuthorInfoSerializer extends StdSerializer<AuthorInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected AuthorInfoSerializer() {
		super(AuthorInfo.class);

	}

	@Override
	public void serialize(AuthorInfo value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("name", value.getName());
		gen.writeStringField("url", value.getUrl());
		gen.writeStringField("iconUrl", value.getIconUrl());
		
		if (value.getProxyIconUrl() != null || !value.getProxyIconUrl().isEmpty())
			gen.writeStringField("proxyIconUrl", value.getProxyIconUrl());
		
		gen.writeEndObject();
		
	}

}
