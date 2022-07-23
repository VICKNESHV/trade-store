package com.db.trade.tradestore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TradeId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4667559050124004984L;

	@Column(name = "TRADE_ID")
	private String tradeId;
	
	@Column(name = "VERSION")
	private Integer version;

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}
