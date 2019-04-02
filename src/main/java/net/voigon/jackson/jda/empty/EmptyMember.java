package net.voigon.jackson.jda.empty;

import java.awt.Color;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.GuildVoiceState;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

public class EmptyMember implements Empty, Member {

	@Override
	public String getAsMention() {
		return null;
	}

	@Override
	public List<Permission> getPermissions() {
		return null;
	}

	@Override
	public boolean hasPermission(Permission... permissions) {
		return false;
	}

	@Override
	public boolean hasPermission(Collection<Permission> permissions) {
		return false;
	}

	@Override
	public boolean hasPermission(Channel channel, Permission... permissions) {
		return false;
	}

	@Override
	public boolean hasPermission(Channel channel, Collection<Permission> permissions) {
		return false;
	}

	@Override
	public User getUser() {
		return null;
	}

	@Override
	public Guild getGuild() {
		return null;
	}

	@Override
	public JDA getJDA() {
		return null;
	}

	@Override
	public OffsetDateTime getJoinDate() {
		return null;
	}

	@Override
	public GuildVoiceState getVoiceState() {
		return null;
	}

	@Override
	public Game getGame() {
		return null;
	}

	@Override
	public OnlineStatus getOnlineStatus() {
		return null;
	}

	@Override
	public String getNickname() {
		return null;
	}

	@Override
	public String getEffectiveName() {
		return null;
	}

	@Override
	public List<Role> getRoles() {
		return null;
	}

	@Override
	public Color getColor() {
		return null;
	}

	@Override
	public int getColorRaw() {
		return 0;
	}

	@Override
	public List<Permission> getPermissions(Channel channel) {
		return null;
	}

	@Override
	public boolean canInteract(Member member) {
		return false;
	}

	@Override
	public boolean canInteract(Role role) {
		return false;
	}

	@Override
	public boolean canInteract(Emote emote) {
		return false;
	}

	@Override
	public boolean isOwner() {
		return false;
	}

	@Override
	public TextChannel getDefaultChannel() {
		return null;
	}

}