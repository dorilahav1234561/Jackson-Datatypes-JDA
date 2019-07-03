package net.voigon.jackson.jda.deser;

import com.fasterxml.jackson.databind.module.SimpleDeserializers;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.MessageEmbed.AuthorInfo;
import net.dv8tion.jda.core.entities.MessageEmbed.Field;
import net.dv8tion.jda.core.entities.MessageEmbed.Footer;
import net.dv8tion.jda.core.entities.MessageEmbed.ImageInfo;
import net.dv8tion.jda.core.entities.MessageEmbed.VideoInfo;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.voigon.jackson.jda.JDAModule;

public class JDADeserializers extends SimpleDeserializers {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2131720185837427613L;

	public JDADeserializers(JDAModule module) {
		addDeserializer(Guild.class, new GuildDeserializer(module));
		addDeserializer(Member.class, new MemberDeserializer(module));
		addDeserializer(Message.class, new MessageDeserializer());
		addDeserializer(TextChannel.class, new TextChannelDeserializer(module));
		addDeserializer(User.class, new UserDeserializer(module));
		addDeserializer(VoiceChannel.class, new VoiceChannelDeserializer(module));
		addDeserializer(AuthorInfo.class, new AuthorInfoDeserializer());
		addDeserializer(VideoInfo.class, new VideoInfoDeserializer());
		addDeserializer(ImageInfo.class, new ImageInfoDeserializer());
		addDeserializer(Field.class, new FieldDeserializer());
		addDeserializer(Footer.class, new FooterDeserializer());
		addDeserializer(Role.class, new RoleDeserializer(module));
		addDeserializer(MessageEmbed.class, new MessageEmbedDeserializer(module.getBot()));
		addDeserializer(Game.class, new GameDeserializer());
		addDeserializer(Category.class, new CategoryDeserializer(module));
	}
	
}
