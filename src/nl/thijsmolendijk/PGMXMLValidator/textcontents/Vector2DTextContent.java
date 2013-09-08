package nl.thijsmolendijk.PGMXMLValidator.textcontents;

public class Vector2DTextContent implements TextContentValidator {

	@Override
	public boolean validate(String str) {
		try {
			String[] data = str.split(",");
			if (data.length < 2 || data.length > 2)
				return false;
			if (!data[0].equals("oo") || !data[0].equals("-oo"))
				Double.parseDouble(data[0]);
			if (!data[1].equals("oo") || !data[1].equals("-oo"))
				Double.parseDouble(data[1]);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "should contain a 2D vector. (eg: 1,3)";
	}

}
