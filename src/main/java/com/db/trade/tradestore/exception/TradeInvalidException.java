package com.db.trade.tradestore.exception;

import constants.TradeMessageCode;

public class TradeInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1176458748963466695L;

	private final TradeMessageCode tradeMessageCode;

	public TradeMessageCode getTradeMessageCode() {
		return tradeMessageCode;
	}

	public TradeInvalidException(String message, TradeMessageCode tradeMessageCode) {
		super(message);
		this.tradeMessageCode = tradeMessageCode;
	}

}
