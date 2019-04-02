package net.voigon.jackson.jda.empty;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import net.dv8tion.jda.client.requests.restaction.pagination.MentionPaginationAction;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Region;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.GuildVoiceState;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.entities.ListedEmote;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.entities.Webhook;
import net.dv8tion.jda.core.managers.AudioManager;
import net.dv8tion.jda.core.managers.GuildController;
import net.dv8tion.jda.core.managers.GuildManager;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.restaction.MemberAction;
import net.dv8tion.jda.core.requests.restaction.pagination.AuditLogPaginationAction;
import net.dv8tion.jda.core.utils.cache.MemberCacheView;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;

public class EmptyGuild implements Empty, Guild {

	@Override
	public long getIdLong() {
		return 0;
	}

	@Override
	public RestAction<EnumSet<Region>> retrieveRegions(boolean includeDeprecated) {
		return null;
	}

	@Override
	public MemberAction addMember(String accessToken, String userId) {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getIconId() {
		return null;
	}

	@Override
	public String getIconUrl() {
		return null;
	}

	@Override
	public Set<String> getFeatures() {
		return null;
	}

	@Override
	public String getSplashId() {
		return null;
	}

	@Override
	public String getSplashUrl() {
		return null;
	}

	@Override
	public RestAction<String> getVanityUrl() {
		return null;
	}

	@Override
	public VoiceChannel getAfkChannel() {
		return null;
	}

	@Override
	public TextChannel getSystemChannel() {
		return null;
	}

	@Override
	public Member getOwner() {
		return null;
	}

	@Override
	public long getOwnerIdLong() {
		return 0;
	}

	@Override
	public Timeout getAfkTimeout() {
		return null;
	}

	@Override
	public String getRegionRaw() {
		return null;
	}

	@Override
	public boolean isMember(User user) {
		return false;
	}

	@Override
	public Member getSelfMember() {
		return null;
	}

	@Override
	public Member getMember(User user) {
		return null;
	}

	@Override
	public MemberCacheView getMemberCache() {
		return null;
	}

	@Override
	public SnowflakeCacheView<Category> getCategoryCache() {
		return null;
	}

	@Override
	public SnowflakeCacheView<TextChannel> getTextChannelCache() {
		return null;
	}

	@Override
	public SnowflakeCacheView<VoiceChannel> getVoiceChannelCache() {
		return null;
	}

	@Override
	public List<Channel> getChannels(boolean includeHidden) {
		return null;
	}

	@Override
	public SnowflakeCacheView<Role> getRoleCache() {
		return null;
	}

	@Override
	public SnowflakeCacheView<Emote> getEmoteCache() {
		return null;
	}

	@Override
	public RestAction<List<ListedEmote>> retrieveEmotes() {
		return null;
	}

	@Override
	public RestAction<ListedEmote> retrieveEmoteById(String id) {
		return null;
	}

	@Override
	public RestAction<List<Ban>> getBanList() {
		return null;
	}

	@Override
	public RestAction<Ban> getBanById(String userId) {
		return null;
	}

	@Override
	public RestAction<Integer> getPrunableMemberCount(int days) {
		return null;
	}

	@Override
	public Role getPublicRole() {
		return null;
	}

	@Override
	public TextChannel getDefaultChannel() {
		return null;
	}

	@Override
	public GuildManager getManager() {
		return null;
	}

	@Override
	public GuildController getController() {
		return null;
	}

	@Override
	public MentionPaginationAction getRecentMentions() {
		return null;
	}

	@Override
	public AuditLogPaginationAction getAuditLogs() {
		return null;
	}

	@Override
	public RestAction<Void> leave() {
		return null;
	}

	@Override
	public RestAction<Void> delete() {
		return null;
	}

	@Override
	public RestAction<Void> delete(String mfaCode) {
		return null;
	}

	@Override
	public AudioManager getAudioManager() {
		return null;
	}

	@Override
	public JDA getJDA() {
		return null;
	}

	@Override
	public RestAction<List<Invite>> getInvites() {
		return null;
	}

	@Override
	public RestAction<List<Webhook>> getWebhooks() {
		return null;
	}

	@Override
	public List<GuildVoiceState> getVoiceStates() {
		return null;
	}

	@Override
	public VerificationLevel getVerificationLevel() {
		return null;
	}

	@Override
	public NotificationLevel getDefaultNotificationLevel() {
		return null;
	}

	@Override
	public MFALevel getRequiredMFALevel() {
		return null;
	}

	@Override
	public ExplicitContentLevel getExplicitContentLevel() {
		return null;
	}

	@Override
	public boolean checkVerification() {
		return false;
	}

	@Override
	public boolean isAvailable() {
		return false;
	}

}