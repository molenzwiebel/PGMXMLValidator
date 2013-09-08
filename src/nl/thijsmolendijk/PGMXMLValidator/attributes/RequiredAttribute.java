package nl.thijsmolendijk.PGMXMLValidator.attributes;

import org.w3c.dom.Element;

public class RequiredAttribute {
	private String[] attributes;
	
	public RequiredAttribute(String... args) {
		this.attributes = args;
	}
	
	public void validate(Element e) throws MissingAttributeException {
		if (e.getTagName().equals("team"))
			System.out.println(e.getAttribute("color"));
		for (String attr : this.attributes)
			if (!e.hasAttribute(attr))
				throw new MissingAttributeException(attr, e);
	}
}
