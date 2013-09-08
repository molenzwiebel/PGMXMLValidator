package nl.thijsmolendijk.PGMXMLValidator.validatorstorage;

import java.util.HashMap;

import nl.thijsmolendijk.PGMXMLValidator.bukkit.EntityType;
import nl.thijsmolendijk.PGMXMLValidator.bukkit.OtherEnums.DamageCause;
import nl.thijsmolendijk.PGMXMLValidator.bukkit.OtherEnums.Environment;
import nl.thijsmolendijk.PGMXMLValidator.bukkit.PotionEffectType;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.AnyTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.BooleanTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.EnumTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.IntegerTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.InvalidTextContentException;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.ItemTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.NoneTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.TextContentValidator;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.VectorTextContent;

public class TextValidators {
	public static HashMap<String, TextContentValidator> textContentValidators = new HashMap<String, TextContentValidator>();
	static {
		//Generic map info
		textContentValidators.put("name", new AnyTextContent());
		textContentValidators.put("version", new AnyTextContent());
		textContentValidators.put("objective", new AnyTextContent());
		textContentValidators.put("author", new AnyTextContent());
		textContentValidators.put("contributor", new AnyTextContent());
		textContentValidators.put("rule", new AnyTextContent());
		
		//Regions
		textContentValidators.put("block", new VectorTextContent());
		textContentValidators.put("point", new AnyTextContent());
		textContentValidators.put("cuboid", new NoneTextContent());
		textContentValidators.put("rectangle", new NoneTextContent());
		textContentValidators.put("cylinder", new NoneTextContent());
		textContentValidators.put("circle", new NoneTextContent());
		textContentValidators.put("sphere", new NoneTextContent());

		//Gamemodes and Goals
		textContentValidators.put("time", new AnyTextContent());
		textContentValidators.put("lives", new IntegerTextContent());
		textContentValidators.put("broadcastLives", new BooleanTextContent());
		textContentValidators.put("title", new AnyTextContent());
		textContentValidators.put("limit", new IntegerTextContent());
		
		//Kits
		textContentValidators.put("item", new ItemTextContent());
		textContentValidators.put("helmet", new ItemTextContent());
		textContentValidators.put("head", new ItemTextContent());
		textContentValidators.put("chestplate", new ItemTextContent());
		textContentValidators.put("leggings", new ItemTextContent());
		textContentValidators.put("boots", new ItemTextContent());
		textContentValidators.put("potion", new EnumTextContent(PotionEffectType.class));
		
		//Other modules
		textContentValidators.put("tool", new ItemTextContent());
		textContentValidators.put("damage", new EnumTextContent(DamageCause.class));
		textContentValidators.put("projectile", new EnumTextContent(EntityType.class));
		textContentValidators.put("veloctityMod", new IntegerTextContent());
		textContentValidators.put("instantignite", new BooleanTextContent());
		textContentValidators.put("blockdamage", new BooleanTextContent());
		textContentValidators.put("yield", new IntegerTextContent());
		textContentValidators.put("mob", new EnumTextContent(EntityType.class));
		textContentValidators.put("timelock", new BooleanTextContent());
		textContentValidators.put("maxbuildheight", new IntegerTextContent());
		textContentValidators.put("friendlyfire", new BooleanTextContent());
		textContentValidators.put("friendlyfirerefund", new BooleanTextContent());
		textContentValidators.put("difficulty", new IntegerTextContent());
		textContentValidators.put("dimension", new EnumTextContent(Environment.class));
		textContentValidators.put("depletion", new BooleanTextContent());
		
		//Filters
		textContentValidators.put("block", new ItemTextContent());

	}
	
	public static void validate(String key, String val) throws InvalidTextContentException {
		if (!textContentValidators.containsKey(key))
			return;
		TextContentValidator validator = textContentValidators.get(key);
		if (!validator.validate(val))
			throw new InvalidTextContentException(key+" "+validator.toString());
	}
}
