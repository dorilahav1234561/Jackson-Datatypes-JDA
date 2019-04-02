package net.voigon.jackson.jda;

import com.fasterxml.jackson.databind.module.SimpleModule;

import lombok.Getter;
import net.dv8tion.jda.core.JDA;
import net.voigon.jackson.jda.deser.JDADeserializers;
import net.voigon.jackson.jda.ser.JDASerializers;

public class JDAModule extends SimpleModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1804182873632148990L;
	
	@Getter
	private final JDA
			bot;
	
	public JDAModule(JDA jda) {
		this.bot = jda;
		
		setSerializers(new JDASerializers());
		setDeserializers(new JDADeserializers(bot));
	}
		
}
