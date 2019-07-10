package net.voigon.jackson.jda.deser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Category;
import net.voigon.jackson.jda.JDAModule;
import net.voigon.jackson.jda.empty.Empty;
import net.voigon.jackson.jda.empty.EmptyCategory;

public class CategoryDeserializer extends StdDeserializer<Category> {

	private static final long serialVersionUID = -2324576152368178346L;
	
	private JDAModule
			module;

	protected CategoryDeserializer(JDAModule module) {
		super(Category.class);

		this.module = module;

	}

	@Override
	public Category deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		if (module.getBot() == null) return getNullValue();

		JsonNode node = jp.readValueAsTree();
		
		Category category = null;
		try {
			category = module.getBot().getCategoryById(node.asText());
			
			if (category == null)
				category = trySerializeWithName(jp, ctxt, node);
			
		} catch (IllegalArgumentException e) {
			category = trySerializeWithName(jp, ctxt, node);
		}
		
		return category;
	}

	@Override
	public Category getNullValue() {
		return new EmptyCategory();
	}

	protected Category trySerializeWithName(JsonParser jp, DeserializationContext ctxt, JsonNode node) throws JsonProcessingException {
		if (!module.deserializeWithNames()) return getNullValue(ctxt);

		List<Category> list = module.getBot().getCategoriesByName(node.asText(), module.isNameIgnoreCase(this));
		return list == null || list.isEmpty() ? getNullValue(ctxt) : list.get(0);
	}

}
