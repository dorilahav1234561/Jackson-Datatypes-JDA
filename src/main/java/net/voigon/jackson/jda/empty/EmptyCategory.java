package net.voigon.jackson.jda.empty;

import java.util.List;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.PermissionOverride;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.managers.ChannelManager;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.core.requests.restaction.ChannelAction;
import net.dv8tion.jda.core.requests.restaction.InviteAction;
import net.dv8tion.jda.core.requests.restaction.PermissionOverrideAction;
import net.dv8tion.jda.core.requests.restaction.order.CategoryOrderAction;

public class EmptyCategory implements Empty, Category {
	
	

	@Override
	public ChannelType getType() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Guild getGuild() {
		return null;
	}

	@Override
	public Category getParent() {
		return null;
	}

	@Override
	public List<Member> getMembers() {
		return null;
	}

	@Override
	public int getPosition() {
		return 0;
	}

	@Override
	public int getPositionRaw() {
		return 0;
	}

	@Override
	public JDA getJDA() {
		return null;
	}

	@Override
	public PermissionOverride getPermissionOverride(Member member) {
		return null;
	}

	@Override
	public PermissionOverride getPermissionOverride(Role role) {
		return null;
	}

	@Override
	public List<PermissionOverride> getPermissionOverrides() {
		return null;
	}

	@Override
	public List<PermissionOverride> getMemberPermissionOverrides() {
		return null;
	}

	@Override
	public List<PermissionOverride> getRolePermissionOverrides() {
		return null;
	}

	@Override
	public ChannelAction createCopy(Guild guild) {
		return null;
	}

	@Override
	public ChannelManager getManager() {
		return null;
	}

	@Override
	public AuditableRestAction<Void> delete() {
		return null;
	}

	@Override
	public PermissionOverrideAction createPermissionOverride(Member member) {
		return null;
	}

	@Override
	public PermissionOverrideAction createPermissionOverride(Role role) {
		return null;
	}

	@Override
	public PermissionOverrideAction putPermissionOverride(Member member) {
		return null;
	}

	@Override
	public PermissionOverrideAction putPermissionOverride(Role role) {
		return null;
	}

	@Override
	public InviteAction createInvite() {
		return null;
	}

	@Override
	public RestAction<List<Invite>> getInvites() {
		return null;
	}

	@Override
	public long getIdLong() {
		return 0;
	}

	@Override
	public int compareTo(Category o) {
		return 0;
	}

	@Override
	public List<Channel> getChannels() {
		return null;
	}

	@Override
	public List<TextChannel> getTextChannels() {
		return null;
	}

	@Override
	public List<VoiceChannel> getVoiceChannels() {
		return null;
	}

	@Override
	public ChannelAction createTextChannel(String name) {
		return null;
	}

	@Override
	public ChannelAction createVoiceChannel(String name) {
		return null;
	}

	@Override
	public CategoryOrderAction<TextChannel> modifyTextChannelPositions() {
		return null;
	}

	@Override
	public CategoryOrderAction<VoiceChannel> modifyVoiceChannelPositions() {
		return null;
	}

}