package com.db.trade.tradestore.exception;

import constants.TradeMessageCode;

public class NoDataFoundException extends RuntimeException{

	private static final long serialVersionUID = -2543315756756890974L;
	
	private final TradeMessageCode tradeMessageCode;

	public TradeMessageCode getStockMessageCode() {
		return tradeMessageCode;
	}

	public NoDataFoundException(String message, TradeMessageCode tradeMessageCode) {
		super(message);
		this.tradeMessageCode = tradeMessageCode;
	}
}
