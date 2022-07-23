package com.db.trade.tradestore.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.db.trade.tradestore.TradestoreApplication;
import com.db.trade.tradestore.exception.TradeInvalidException;
import com.db.trade.tradestore.model.StatusMessageResponse;
import com.db.trade.tradestore.model.TradeRequest;
import com.db.trade.tradestore.service.TradeService;

@SpringJUnitConfig(TradestoreApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(args = "--spring.application.run.mode=DEV")
@TestMethodOrder(OrderAnnotation.class)
class TradeStoreControllerTest {

	@SpyBean
	private TradeController controller;

	@SpyBean
	private TradeService tradeStoreService;

	@Test
	@Order(1)
	void testStoreTrade() {
		TradeRequest tradeRequest = new TradeRequest();
		tradeRequest.setTradeId("T10");
		tradeRequest.setVersion(2);
		tradeRequest.setCounterPartyId("CP-1");
		tradeRequest.setBookId("B1");
		tradeRequest.setMaturityDate(LocalDate.of(2022, 10, 20));
		tradeRequest.setIsTradeExpired(false);
		ResponseEntity<StatusMessageResponse> statusResponseEntity = this.controller.addUpdateTrade(tradeRequest);

		assertSame(HttpStatus.OK, statusResponseEntity.getStatusCode());
	}

	@Test
	@Order(2)
	void testStoreTradeExpectedInvalidTradeExceptionForVersion() {
		TradeRequest tradeRequest = new TradeRequest();
		tradeRequest.setTradeId("T10");
		tradeRequest.setVersion(1);
		tradeRequest.setCounterPartyId("CP-1");
		tradeRequest.setBookId("B1");
		tradeRequest.setMaturityDate(LocalDate.of(2022, 10, 20));
		tradeRequest.setIsTradeExpired(false);
		assertThrows(TradeInvalidException.class, () -> this.controller.addUpdateTrade(tradeRequest));
	}

	@Test
	@Order(3)
	void testStoreTradeExpectedInvalidTradeExceptionForMaturityDate() {
		TradeRequest tradeRequest = new TradeRequest();
		tradeRequest.setTradeId("T10");
		tradeRequest.setVersion(2);
		tradeRequest.setCounterPartyId("CP-1");
		tradeRequest.setBookId("B1");
		tradeRequest.setMaturityDate(LocalDate.of(2021, 10, 20));
		tradeRequest.setIsTradeExpired(false);
		assertThrows(TradeInvalidException.class, () -> this.controller.addUpdateTrade(tradeRequest));
	}

	@Test
	@Order(4)
	void testFindAllTrades() {
		assertTrue(this.controller.getTradeList(0, 1).getBody().size() > 0);
	}

	@Test
	@Order(5)
	void testOverrideTradeWithSameVersion() {
		TradeRequest tradeRequest = new TradeRequest();
		tradeRequest.setTradeId("T10");
		tradeRequest.setVersion(2);
		tradeRequest.setCounterPartyId("CP-1");
		tradeRequest.setBookId("B1");
		tradeRequest.setMaturityDate(LocalDate.of(2022, 11, 20));
		tradeRequest.setIsTradeExpired(false);
		assertSame("Trade is successfully updated into the database",
				this.controller.addUpdateTrade(tradeRequest).getBody().getStatusMessages().get(0).getMessage());
	}

}
