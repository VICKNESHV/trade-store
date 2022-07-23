package com.db.trade.tradestore.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.db.trade.tradestore.TradestoreApplication;
import com.db.trade.tradestore.entity.Trade;
import com.db.trade.tradestore.entity.TradeId;

@SpringJUnitConfig(TradestoreApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(args = "--spring.application.run.mode=DEV")
@TestMethodOrder(OrderAnnotation.class)
class TradeStoreRepositoryTest {

	@Autowired
	private TradeRepository repository;

	private static final List<Trade> trades = new ArrayList<>(4);

	@BeforeAll
	public static void setup() {
		trades.add(new Trade(new TradeId("T1", 1), "CP-1", "B1", Date.valueOf(LocalDate.of(2022, 10, 20)), Date.valueOf(LocalDate.now()), false));
		trades.add(new Trade(new TradeId("T2", 2), "CP-2", "B1", Date.valueOf(LocalDate.of(2022, 11, 20)), Date.valueOf(LocalDate.now()), false));
		trades.add(new Trade(new TradeId("T2", 1), "CP-1", "B1", Date.valueOf(LocalDate.of(2022, 11, 20)), Date.valueOf(LocalDate.now()), false));
		trades.add(new Trade(new TradeId("T3", 3), "CP-3", "B2", Date.valueOf(LocalDate.of(2022, 12, 20)), Date.valueOf(LocalDate.now()), false));
	}

	@Test
	@Order(1)
	void testSave() {
		trades.forEach(t -> repository.save(t));
		List<Trade> trade = this.repository.findByTradeIdTradeId("T1");
		assertEquals(trade.get(0).getTradeId().getTradeId(), "T1");;
	}

	@Test
	@Order(2)
	void testFindAll() {
		List<Trade> trades = repository.findAll();
		assertEquals(trades.size() > 0, true);
	}

}
