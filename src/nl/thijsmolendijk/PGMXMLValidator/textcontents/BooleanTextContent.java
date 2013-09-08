package nl.thijsmolendijk.PGMXMLValidator.textcontents;

public class BooleanTextContent implements TextContentValidator {

	@SuppressWarnings("unused")
	@Override
	public boolean validate(String str) {
		try {
			boolean bool = Boolean.getBoolean(str);
			return true;
		} catch (Exception e) {
				return false;
		}
	}
	
	@Override
	public String toString() {
		return "should contain an boolean (true or false)";
	}

}
