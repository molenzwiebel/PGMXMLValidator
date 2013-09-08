package nl.thijsmolendijk.PGMXMLValidator.attributes;

import org.w3c.dom.Element;

public class MissingAttributeException extends Exception {
	private static final long serialVersionUID = 890240360035697335L;
	private String attribute;
	private Element element;
	
	public MissingAttributeException(String attr, Element e) {
		this.attribute = attr;
		this.element = e;
	}

	public String getAttribute() {
		return attribute;
	}

	public Element getElement() {
		return element;
	}
	
	@Override
	public String getMessage() {
		return element.getTagName()+" is missing attribute "+this.attribute;
	}
	
}
