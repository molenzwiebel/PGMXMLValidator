package nl.thijsmolendijk.PGMXMLValidator.textcontents;

import nl.thijsmolendijk.PGMXMLValidator.bukkit.Material;

public class ItemTextContent implements TextContentValidator {

	@Override
	public boolean validate(String str) {
		if (stringToEnum(str, Material.class) == null)
			return new IntegerTextContent().validate(str);
		else
			return true;
	}


	public static <T extends Enum<T>> T stringToEnum(String value, Class<T> enuma) {
		try {
			if (value == null || enuma == null)
				return null;
			T valueFound = Enum.valueOf(enuma, value.replace(" ", "_").toUpperCase());
			if (valueFound != null)
				return valueFound;
		} catch (Exception e) {
			return null;
		}
		return null;
	}
}
