package com.db.trade.tradestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.trade.tradestore.exception.TradeInvalidException;
import com.db.trade.tradestore.model.StatusMessageResponse;
import com.db.trade.tradestore.model.TradeRequest;
import com.db.trade.tradestore.model.TradeResponse;
import com.db.trade.tradestore.service.TradeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TradeController {

	@Autowired
	private TradeService tradeService;

	@ApiOperation(value = "Add/Update a trade to the store", nickname = "addUpdateStore", notes = "Add/Update a trade to the store", response = TradeResponse.class, tags={ "trade store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = TradeResponse.class),
        @ApiResponse(code = 400, message = "The request could not be parsed.", response = StatusMessageResponse.class),
        @ApiResponse(code = 500, message = "The service encountered an internal server error.", response = StatusMessageResponse.class) })
    @PostMapping("/trade")
	public ResponseEntity<StatusMessageResponse> addUpdateStore(@RequestBody TradeRequest tradeRequest) throws TradeInvalidException {
		return new ResponseEntity<StatusMessageResponse>(tradeService.addUpdatetrade(tradeRequest), HttpStatus.OK);
	}

	@ApiOperation(value = "Returns all the trades from the store", nickname = "listTrades", notes = "Returns the list of trades executed", response = TradeResponse.class, responseContainer = "List", tags={ "trade store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The service request was processed successfully.", response = TradeResponse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "The request could not be parsed.", response = StatusMessageResponse.class),
        @ApiResponse(code = 500, message = "The service encountered an internal server error.", response = StatusMessageResponse.class) })
	@GetMapping("/trade")
	public ResponseEntity<List<TradeResponse>> getTradeList(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "1") int size) {
		return new ResponseEntity<List<TradeResponse>>(tradeService.getTradeList(page, size), HttpStatus.OK);
	}
}

