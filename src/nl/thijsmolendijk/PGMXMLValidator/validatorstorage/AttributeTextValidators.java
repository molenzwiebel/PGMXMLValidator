package nl.thijsmolendijk.PGMXMLValidator.validatorstorage;

import java.util.HashMap;

import nl.thijsmolendijk.PGMXMLValidator.attributes.AttributeTextValueSets;
import nl.thijsmolendijk.PGMXMLValidator.bukkit.OtherEnums.DyeColor;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.AnyTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.EnumTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.IntegerTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.InvalidTextContentException;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.Vector2DTextContent;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.VectorTextContent;

import org.w3c.dom.Element;

public class AttributeTextValidators {
	public static HashMap<String, AttributeTextValueSets> requiredAttributeContents = new HashMap<String, AttributeTextValueSets>();
	static {
		requiredAttributeContents.put("wool", new AttributeTextValueSets("team", new AnyTextContent(), "color", new EnumTextContent(DyeColor.class)));
		
		requiredAttributeContents.put("cuboid", new AttributeTextValueSets("min", new VectorTextContent(), "max", new VectorTextContent()));
		requiredAttributeContents.put("rectangle", new AttributeTextValueSets("min", new Vector2DTextContent(), "max", new Vector2DTextContent()));
		requiredAttributeContents.put("circle", new AttributeTextValueSets("center", new Vector2DTextContent(), "radius", new IntegerTextContent()));
		requiredAttributeContents.put("cylinder", new AttributeTextValueSets("base", new VectorTextContent(), "radius", new IntegerTextContent(), "height", new IntegerTextContent()));
		requiredAttributeContents.put("sphere", new AttributeTextValueSets("origin", new VectorTextContent(), "radius", new IntegerTextContent()));
				
		requiredAttributeContents.put("spawn", new AttributeTextValueSets("yaw", new IntegerTextContent()));

	}
	
	public static void validate(Element e) throws InvalidTextContentException {
		if (!requiredAttributeContents.containsKey(e.getTagName()))
			return;
		AttributeTextValueSets validator = requiredAttributeContents.get(e.getTagName());
		validator.validate(e);
	}
}
