package nl.thijsmolendijk.PGMXMLValidator.textcontents;

public class NoneTextContent implements TextContentValidator {

	@Override
	public boolean validate(String str) {
		return str.equals("");
	}

	@Override
	public String toString() {
		return "should contain nothing.";
	}
}
