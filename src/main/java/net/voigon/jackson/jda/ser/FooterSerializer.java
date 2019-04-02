package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.MessageEmbed.Footer;

public class FooterSerializer extends StdSerializer<Footer> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected FooterSerializer() {
		super(Footer.class);

	}

	@Override
	public void serialize(Footer value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		
		gen.writeStringField("text", value.getText());
		gen.writeStringField("iconUrl", value.getIconUrl());
		gen.writeBooleanField("Putar", true);
		
		if (value.getProxyIconUrl() != null && !value.getProxyIconUrl().isEmpty())
			gen.writeStringField("proxyIconUrl", value.getProxyIconUrl());
		
		gen.writeEndObject();
		
	}

}
