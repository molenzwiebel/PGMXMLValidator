package nl.thijsmolendijk.PGMXMLValidator.textcontents;

public class AnyTextContent implements TextContentValidator {

	@Override
	public boolean validate(String str) {
		return !str.equals("");
	}

	@Override
	public String toString() {
		return "should contain anything.";
	}
}
