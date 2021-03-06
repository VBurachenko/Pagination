package by.epam.tc.parser;

public enum ItemField {
	
	PLANES("items"),
	ID("id"),
	AMOUNT("amount"),
	COLOR("color"),
	RADAR("radar"),
	PLANE("plane"),
	ENGINES("engines"),
	
	PARAMETERS("parameters"),
	MANUFACTURER("manufacturer"),
	MODEL("model"),
	ORIGIN("origin"),
	TYPE("type"),
	CREW("crew"),
	PASSENGER_CAPACITY("passenger-capacity"),
	CARGO_CAPACITY("cargo-capacity"),
	PRICE("price"),
	ENG_MODEL("model"),
	ENG_TYPE("type"),
	HEIGHT("height"),
	LENGTH("length"),
	WINGSPAN("wingspan"),
	GROSS_WEIGHT("gross-weight");
	
	
	private String value;
	
	ItemField(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
