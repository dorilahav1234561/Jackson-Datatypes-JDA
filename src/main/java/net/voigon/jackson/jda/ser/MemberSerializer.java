package net.voigon.jackson.jda.ser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import net.dv8tion.jda.core.entities.Member;

public class MemberSerializer extends StdSerializer<Member> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5630422306743264548L;
	
	protected MemberSerializer() {
		super(Member.class);
		
	}

	@Override
	public void serialize(Member value, JsonGenerator jg, SerializerProvider sp) throws IOException {
		
		if (value != null) {
			
			jg.writeStartObject();
			jg.writeStringField("id", value.getUser().getId());
			jg.writeStringField("guild_id", value.getGuild().getId());
			jg.writeEndObject();
			
		}
		
	}

}
