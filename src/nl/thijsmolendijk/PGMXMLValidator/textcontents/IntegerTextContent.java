package nl.thijsmolendijk.PGMXMLValidator.textcontents;

public class IntegerTextContent implements TextContentValidator {

	@SuppressWarnings("unused")
	@Override
	public boolean validate(String str) {
		try {
			int i = Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			try {
				double i = Double.parseDouble(str);
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
	}
	
	@Override
	public String toString() {
		return "should contain an integer";
	}

}
