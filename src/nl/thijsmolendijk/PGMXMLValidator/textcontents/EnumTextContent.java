package nl.thijsmolendijk.PGMXMLValidator.textcontents;

@SuppressWarnings("rawtypes")
public class EnumTextContent implements TextContentValidator {
	private Class<? extends Enum> enumClass;

	public EnumTextContent(Class<? extends Enum> clazz) {
		this.enumClass = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validate(String str) {
		return stringToEnum(str, enumClass) != null;
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
	
	@Override
	public String toString() {
		return "should contain a value defined in enum class "+this.enumClass.getSimpleName();
	}
}
