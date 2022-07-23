package com.db.trade.tradestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.trade.tradestore.entity.Trade;
import com.db.trade.tradestore.entity.TradeId;

public interface TradeRepository extends JpaRepository<Trade, TradeId>{

	List<Trade> findByTradeIdTradeId(String tradeId);

}
