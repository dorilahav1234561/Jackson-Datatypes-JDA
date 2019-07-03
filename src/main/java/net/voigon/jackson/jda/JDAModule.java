package net.voigon.jackson.jda;

import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.dv8tion.jda.core.JDA;
import net.voigon.jackson.jda.deser.JDADeserializers;
import net.voigon.jackson.jda.ser.JDASerializers;

@Accessors(chain = true, fluent = true)
public class JDAModule extends SimpleModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1804182873632148990L;

	private final JDA
			bot;

	@Getter @Setter
	private boolean
			deserializeWithNames = true,
			nameIgnoreCase = true;

	public JDAModule(JDA jda) {
		this.bot = jda;

		setSerializers(new JDASerializers());
		setDeserializers(new JDADeserializers(bot));
	}

	public JDA getBot() {return this.bot;}

	public <T> boolean isNameIgnoreCase(StdDeserializer<T> deserializer) {
		return nameIgnoreCase;
	}

}
