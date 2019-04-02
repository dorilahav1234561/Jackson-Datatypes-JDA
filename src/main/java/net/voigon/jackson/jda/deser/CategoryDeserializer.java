package net.voigon.jackson.jda.deser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Category;
import net.voigon.jackson.jda.empty.EmptyCategory;

public class CategoryDeserializer extends StdDeserializer<Category> {

	private static final long serialVersionUID = -2324576152368178346L;
	
	private JDA
			bot;
	
	protected CategoryDeserializer(JDA bot) {
		super(Category.class);
		this.bot = bot;
	}

	@Override
	public Category deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		JsonNode node = jp.readValueAsTree();
		
		Category category = null;
		try {
			category = bot.getCategoryById(node.asText());
			
			if (category == null)
				category = new EmptyCategory();
			
		} catch (IllegalArgumentException e) {
			category = new EmptyCategory();
		}
		
		return category;
	}
}
