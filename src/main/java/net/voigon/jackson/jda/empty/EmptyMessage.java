package net.voigon.jackson.jda.empty;

import java.time.OffsetDateTime;
import java.util.Formatter;
import java.util.List;

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.IMentionable;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.MessageReaction;
import net.dv8tion.jda.core.entities.MessageType;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

public class EmptyMessage implements Empty, Message {

	@Override
	public long getIdLong() {
		return 0;
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
	}

	@Override
	public List<User> getMentionedUsers() {
		return null;
	}

	@Override
	public List<TextChannel> getMentionedChannels() {
		return null;
	}

	@Override
	public List<Role> getMentionedRoles() {
		return null;
	}

	@Override
	public List<Member> getMentionedMembers(Guild guild) {
		return null;
	}

	@Override
	public List<Member> getMentionedMembers() {
		return null;
	}

	@Override
	public List<IMentionable> getMentions(MentionType... types) {
		return null;
	}

	@Override
	public boolean isMentioned(IMentionable mentionable, MentionType... types) {
		return false;
	}

	@Override
	public boolean mentionsEveryone() {
		return false;
	}

	@Override
	public boolean isEdited() {
		return false;
	}

	@Override
	public OffsetDateTime getEditedTime() {
		return null;
	}

	@Override
	public User getAuthor() {
		return null;
	}

	@Override
	public Member getMember() {
		return null;
	}

	@Override
	public String getJumpUrl() {
		return null;
	}

	@Override
	public String getContentDisplay() {
		return null;
	}

	@Override
	public String getContentRaw() {
		return null;
	}

	@Override
	public String getContentStripped() {
		return null;
	}

	@Override
	public List<String> getInvites() {
		return null;
	}

	@Override
	public String getNonce() {
		return null;
	}

	@Override
	public boolean isFromType(ChannelType type) {
		return false;
	}

	@Override
	public ChannelType getChannelType() {
		return null;
	}

	@Override
	public boolean isWebhookMessage() {
		return false;
	}

	@Override
	public MessageChannel getChannel() {
		return null;
	}

	@Override
	public PrivateChannel getPrivateChannel() {
		return null;
	}

	@Override
	public Group getGroup() {
		return null;
	}

	@Override
	public TextChannel getTextChannel() {
		return null;
	}

	@Override
	public Category getCategory() {
		return null;
	}

	@Override
	public Guild getGuild() {
		return null;
	}

	@Override
	public List<Attachment> getAttachments() {
		return null;
	}

	@Override
	public List<MessageEmbed> getEmbeds() {
		return null;
	}

	@Override
	public List<Emote> getEmotes() {
		return null;
	}

	@Override
	public List<MessageReaction> getReactions() {
		return null;
	}

	@Override
	public boolean isTTS() {
		return false;
	}

	@Override
	public MessageAction editMessage(CharSequence newContent) {
		return null;
	}

	@Override
	public MessageAction editMessage(MessageEmbed newContent) {
		return null;
	}

	@Override
	public MessageAction editMessageFormat(String format, Object... args) {
		return null;
	}

	@Override
	public MessageAction editMessage(Message newContent) {
		return null;
	}

	@Override
	public AuditableRestAction<Void> delete() {
		return null;
	}

	@Override
	public JDA getJDA() {
		return null;
	}

	@Override
	public boolean isPinned() {
		return false;
	}

	@Override
	public RestAction<Void> pin() {
		return null;
	}

	@Override
	public RestAction<Void> unpin() {
		return null;
	}

	@Override
	public RestAction<Void> addReaction(Emote emote) {
		return null;
	}

	@Override
	public RestAction<Void> addReaction(String unicode) {
		return null;
	}

	@Override
	public RestAction<Void> clearReactions() {
		return null;
	}

	@Override
	public MessageType getType() {
		return null;
	}

}