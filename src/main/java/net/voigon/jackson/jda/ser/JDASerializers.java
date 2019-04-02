package net.voigon.jackson.jda.ser;

import com.fasterxml.jackson.databind.module.SimpleSerializers;

public class JDASerializers extends SimpleSerializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6589204872468440015L;

	public JDASerializers() {
		addSerializer(new GuildSerializer());
		addSerializer(new MemberSerializer());
		addSerializer(new TextChannelSerializer());
		addSerializer(new MessageSerializer());
		addSerializer(new VoiceChannelSerializer());
		addSerializer(new UserSerializer());
		addSerializer(new AuthorInfoSerializer());
		addSerializer(new VideoInfoSerializer());
		addSerializer(new ImageInfoSerializer());
		addSerializer(new FieldSerializer());
		addSerializer(new FooterSerializer());
		addSerializer(new RoleSerializer());
		addSerializer(new MessageEmbedSerializer());
		addSerializer(new TimestampsSerializer());
		addSerializer(new GameSerializer());
		addSerializer(new CategorySerializer());
	}
}
