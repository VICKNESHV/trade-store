package com.db.trade.tradestore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.db.trade.tradestore.model.StatusMessage;
import com.db.trade.tradestore.model.StatusMessage.TypeEnum;
import com.db.trade.tradestore.model.StatusMessageResponse;

import constants.TradeMessageCode;

@RestControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<StatusMessageResponse> handleAllException(RuntimeException ex, WebRequest request) {
		StatusMessageResponse response = new StatusMessageResponse();
		StatusMessage statusMessage = new StatusMessage();
		statusMessage.setType(TypeEnum.ERROR);
		statusMessage.setMessage(TradeMessageCode.INTERNAL_ERROR.getDescription());
		statusMessage.setCode(TradeMessageCode.INTERNAL_ERROR.getValue());
		response.getStatusMessages().add(statusMessage);
		return new ResponseEntity<StatusMessageResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TradeInvalidException.class)
	public final ResponseEntity<StatusMessageResponse> handleStockException(RuntimeException ex, WebRequest request) {
		StatusMessageResponse response = new StatusMessageResponse();
		StatusMessage statusMessage = new StatusMessage();
		statusMessage.setType(TypeEnum.ERROR);
		statusMessage.setMessage(ex.getMessage());
		statusMessage.setCode(TradeMessageCode.INVALID.getValue());
		response.getStatusMessages().add(statusMessage);
		return new ResponseEntity<StatusMessageResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public final ResponseEntity<StatusMessageResponse> handleNoDataFoundException(RuntimeException ex, WebRequest request) {
		StatusMessageResponse response = new StatusMessageResponse();
		StatusMessage statusMessage = new StatusMessage();
		statusMessage.setType(TypeEnum.ERROR);
		statusMessage.setMessage(TradeMessageCode.NO_DATA_FOUND.getDescription());
		statusMessage.setCode(TradeMessageCode.NO_DATA_FOUND.getValue());
		response.getStatusMessages().add(statusMessage);
		return new ResponseEntity<StatusMessageResponse>(response, HttpStatus.NOT_FOUND);
	}

}
