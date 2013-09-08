package nl.thijsmolendijk.PGMXMLValidator.textcontents;

public class VectorTextContent implements TextContentValidator {

	@Override
	public boolean validate(String str) {
		try {
			String[] data = str.split(",");
			if (data.length < 3 || data.length > 3)
				return false;
			if (!data[0].equals("oo") || !data[0].equals("-oo"))
				Double.parseDouble(data[0]);
			if (!data[1].equals("oo") || !data[1].equals("-oo"))
				Double.parseDouble(data[0]);
			if (!data[2].equals("oo") || !data[2].equals("-oo"))
				Double.parseDouble(data[0]);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "should contain a vector (eg: 1,2,3)";
	}

}
