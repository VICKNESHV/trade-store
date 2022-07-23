package com.db.trade.tradestore.service;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.db.trade.tradestore.TradestoreApplication;
import com.db.trade.tradestore.entity.Trade;
import com.db.trade.tradestore.entity.TradeId;

@SpringJUnitConfig(TradestoreApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(args = "--spring.application.run.mode=DEV")
@TestMethodOrder(OrderAnnotation.class)
class TradeStoreServiceImplTest {

	@SpyBean
	private TradeService tradeStoreService;

	@Test
	@Order(1)
	void testisVersionValid() {
		List<Trade> tradeList = new ArrayList<>();
		Trade trade = new Trade(new TradeId("T1", 1), "CP-1", "B1", Date.valueOf(LocalDate.of(2022, 5, 20)),
				Date.valueOf(LocalDate.now()), false);
		tradeList.add(trade);
		Boolean isValid = this.tradeStoreService.isVersionValid(0, tradeList);
		assertSame(isValid, false);
	}

	@Test
	@Order(2)
	void testMaturityDateValid() {
		boolean isValid = this.tradeStoreService.isMaturityDateValid(LocalDate.now().plusDays(1));

		assertSame(isValid, true);
	}

}