package com.db.trade.tradestore.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.db.trade.tradestore.service.TradeService;

@Component
public class TradeSchedulingTask {

	@Autowired
	TradeService tradeService;

	@Scheduled(cron = "0/30 * * * * ?")
	public void updateExpiryFlagTask() {
		tradeService.updateTradeExpiryFlag();
	}
}
