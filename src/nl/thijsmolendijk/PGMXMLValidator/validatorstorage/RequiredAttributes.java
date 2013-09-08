package nl.thijsmolendijk.PGMXMLValidator.validatorstorage;

import java.util.HashMap;

import nl.thijsmolendijk.PGMXMLValidator.attributes.MissingAttributeException;
import nl.thijsmolendijk.PGMXMLValidator.attributes.RequiredAttribute;

import org.w3c.dom.Element;

public class RequiredAttributes {
	public static HashMap<String, RequiredAttribute> requiredAttributes = new HashMap<String, RequiredAttribute>();
	static {
		requiredAttributes.put("wool", new RequiredAttribute("team", "color"));
		
		
		//Regions
		requiredAttributes.put("cuboid", new RequiredAttribute("min", "max"));
		requiredAttributes.put("rectangle", new RequiredAttribute("min", "max"));
		requiredAttributes.put("circle", new RequiredAttribute("center", "radius"));
		requiredAttributes.put("cylinder", new RequiredAttribute("base", "radius", "height"));
		requiredAttributes.put("sphere", new RequiredAttribute("origin", "radius"));
		requiredAttributes.put("region", new RequiredAttribute("name"));
				
		//Kits
		requiredAttributes.put("kit", new RequiredAttribute("name"));
		
		requiredAttributes.put("lane", new RequiredAttribute("team"));
		
		requiredAttributes.put("box", new RequiredAttribute("value"));

	}
	
	public static void validate(Element e) throws MissingAttributeException {
		if (!requiredAttributes.containsKey(e.getTagName()))
			return;
		RequiredAttribute validator = requiredAttributes.get(e.getTagName());
		validator.validate(e);
	}
}
