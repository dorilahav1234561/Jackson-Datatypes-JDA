package net.voigon.jackson.jda.empty;

import java.util.List;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.requests.RestAction;

public class EmptyUser implements Empty, User {

	@Override
	public long getIdLong() {
		return 0;
	}

	@Override
	public String getAsMention() {
		return null;
	}

	@Override
	public boolean isFake() {
		return false;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getDiscriminator() {
		return null;
	}

	@Override
	public String getAvatarId() {
		return null;
	}

	@Override
	public String getAvatarUrl() {
		return null;
	}

	@Override
	public String getDefaultAvatarId() {
		return null;
	}

	@Override
	public String getDefaultAvatarUrl() {
		return null;
	}

	@Override
	public String getEffectiveAvatarUrl() {
		return null;
	}

	@Override
	public boolean hasPrivateChannel() {
		return false;
	}

	@Override
	public RestAction<PrivateChannel> openPrivateChannel() {
		return null;
	}

	@Override
	public List<Guild> getMutualGuilds() {
		return null;
	}

	@Override
	public boolean isBot() {
		return false;
	}

	@Override
	public JDA getJDA() {
		return null;
	}

}