package net.voigon.jackson.jda.empty;

import java.awt.Color;
import java.util.Collection;
import java.util.List;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.managers.RoleManager;
import net.dv8tion.jda.core.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.core.requests.restaction.RoleAction;

public class EmptyRole implements Empty, Role {

	@Override
	public long getIdLong() {
		return 0;
	}

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
	public int compareTo(Role o) {
		return 0;
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
	public String getName() {
		return null;
	}

	@Override
	public boolean isManaged() {
		return false;
	}

	@Override
	public boolean isHoisted() {
		return false;
	}

	@Override
	public boolean isMentionable() {
		return false;
	}

	@Override
	public long getPermissionsRaw() {
		return 0;
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
	public boolean isPublicRole() {
		return false;
	}

	@Override
	public boolean canInteract(Role role) {
		return false;
	}

	@Override
	public Guild getGuild() {
		return null;
	}

	@Override
	public RoleAction createCopy(Guild guild) {
		return null;
	}

	@Override
	public RoleManager getManager() {
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

}
