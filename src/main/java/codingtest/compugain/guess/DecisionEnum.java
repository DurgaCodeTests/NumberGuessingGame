package codingtest.compugain.guess;

public enum DecisionEnum {

	READY("ready"), HIGHER("higher"), LOWER("lower"), YES("yes"), END("end");

	private String typeValue;

	/**
	 * @param typeValue
	 */
	DecisionEnum(String typeValue) {
		this.typeValue = typeValue;
	}

	/**
	 * @return the typeValue
	 */
	public String getTypeValue() {
		return typeValue;
	}
}
