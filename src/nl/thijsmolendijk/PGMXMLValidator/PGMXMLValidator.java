package nl.thijsmolendijk.PGMXMLValidator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import nl.thijsmolendijk.PGMXMLValidator.validatorstorage.AttributeTextValidators;
import nl.thijsmolendijk.PGMXMLValidator.validatorstorage.ParentChildValidators;
import nl.thijsmolendijk.PGMXMLValidator.validatorstorage.RequiredAttributes;
import nl.thijsmolendijk.PGMXMLValidator.validatorstorage.TextValidators;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXParseException;

public class PGMXMLValidator {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainView.createAndShowGUI(new PGMXMLValidator());
			}
		});
	}

	public static void validateElement(Element e) throws Exception {
		RequiredAttributes.validate(e);
		AttributeTextValidators.validate(e);
		ParentChildValidators.validate(e);
		if (e.getFirstChild() != null && e.getFirstChild().getNodeType() == Node.TEXT_NODE)
			TextValidators.validate(e.getNodeName(), e.getTextContent());
	}

	public static List<String> validateXML(String xml) {
		List<String> results = new ArrayList<String>();
		try {
			InputStream is = new ByteArrayInputStream(xml.getBytes());
	        Document doc = PositionalXMLReader.readXML(is);
			NodeList nodeList = doc.getElementsByTagName("*");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					try {
						validateElement((Element) node);
					} catch (Exception e) {
						results.add("Line "+node.getUserData("lineNumber")+": "+e.getMessage());
					}
				}
			}
		} catch (SAXParseException e) {
			results.add("(PARSE ERROR) Line "+e.getLineNumber()+", column "+e.getColumnNumber()+": "+e.getLocalizedMessage());
		} catch (Exception ex) {
			results.add("There was a error validating: "+ex.getLocalizedMessage());
		}
		if (results.size() < 1)
			results.add("XML Validated. No errors found.");
		else
			results.add("XML Validated. "+results.size()+" errors found.");
		return results;
	}
}
