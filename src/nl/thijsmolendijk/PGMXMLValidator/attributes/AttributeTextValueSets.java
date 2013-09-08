package nl.thijsmolendijk.PGMXMLValidator.attributes;

import java.util.ArrayList;
import java.util.List;

import nl.thijsmolendijk.PGMXMLValidator.textcontents.InvalidTextContentException;
import nl.thijsmolendijk.PGMXMLValidator.textcontents.TextContentValidator;

import org.w3c.dom.Element;

public class AttributeTextValueSets {
	private List<AttributeTextValueSet> attributeTextValueSets = new ArrayList<AttributeTextValueSet>();

	public AttributeTextValueSets(Object... data) {
		for (int i = 0; i < data.length; i++) {
			String key = (String) data[i];
			i++;
			TextContentValidator val = (TextContentValidator) data[i];
			this.attributeTextValueSets.add(new AttributeTextValueSet(key, val));
		}
	}

	public void validate(Element e) throws InvalidTextContentException {
		for (AttributeTextValueSet set : this.attributeTextValueSets) {
			if (e.hasAttribute(set.getAttribute()))
				if (!set.getValidator().validate(e.getAttribute(set.getAttribute())))
					throw new InvalidTextContentException("Attribute "+set.getAttribute()+" of "+e.getTagName()+" "+set.getValidator().toString());
		}
	}
}	
