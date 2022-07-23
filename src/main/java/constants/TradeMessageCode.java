package constants;

public enum TradeMessageCode {
	
	SYSTEM_ERROR("TRADE9000", "System error occured during request processing"),
	INTERNAL_ERROR("TRADE9001", "Internal error occured during request processing"),
	INVALID("TRADE9002", "Invalid request, please check the request input"),
	NO_DATA_FOUND("TRADE9004", "TRADE not found"),
	SUCCESSFUL_ADDITION_UPDATION("TRADE9005", "TRADE is successfully added/updated into the database");
	
	private String value;
	
	private String description;
	
	private TradeMessageCode(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	

}
