package com.db.trade.tradestore.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TRADE_STORE")
public class Trade {
	
	@EmbeddedId
	private TradeId tradeId;
	
	@Column(name = "COUNTER_PARTY_ID")
	private String counterPartyId;
	
	@Column(name = "BOOK_ID")
	private String bookId;
	
	@Column(name = "MATURITY_DATE", nullable = false)
	private Date maturityDate;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "IS_EXPIRED", nullable = false)
	private Boolean expired;

	public TradeId getTradeId() {
		return tradeId;
	}

	public void setTradeId(TradeId tradeId) {
		this.tradeId = tradeId;
	}

	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean isExpired() {
		return expired;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}

	public Trade(TradeId tradeId, String counterPartyId, String bookId, Date maturityDate, Date createdDate,
			Boolean expired) {
		super();
		this.tradeId = tradeId;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}

	public Trade() {
		super();
	}
	
	
	
}
