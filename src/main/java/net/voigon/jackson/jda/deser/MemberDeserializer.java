package net.voigon.jackson.jda.deser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.voigon.jackson.jda.JDAModule;
import net.voigon.jackson.jda.empty.EmptyMember;

public class MemberDeserializer extends StdDeserializer<Member> {

	private static final long serialVersionUID = -4517803555826355356L;
	
	private JDAModule
			module;

	protected MemberDeserializer(JDAModule module) {
		super(Member.class);
		
		this.module = module;
	}

	@Override
	public Member deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
		if (module.getBot() == null) return getNullValue();

		JsonNode node = jp.readValueAsTree();
		
		Member member = null;
		try {
			member = module.getBot().getGuildById(node.get("guild_id").asText()).getMemberById(node.get("id").asText());
			
			if (member == null)
				member = new EmptyMember();
			
		} catch (IllegalArgumentException e) {
			member = new EmptyMember();
		}
		
		return member;
	}

	@Override
	public Member getNullValue() {
		return new EmptyMember();
	}

}
