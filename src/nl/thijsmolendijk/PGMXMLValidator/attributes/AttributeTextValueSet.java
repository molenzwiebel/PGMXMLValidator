package nl.thijsmolendijk.PGMXMLValidator.attributes;

import nl.thijsmolendijk.PGMXMLValidator.textcontents.TextContentValidator;

public class AttributeTextValueSet {
	private String attribute;
	private TextContentValidator validator;
	public AttributeTextValueSet(String attr, TextContentValidator val) {
		this.attribute = attr;
		this.validator = val;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
	public TextContentValidator getValidator() {
		return validator;
	}
	
}
