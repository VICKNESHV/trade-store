package com.db.trade.tradestore.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.db.trade.tradestore.entity.Trade;
import com.db.trade.tradestore.entity.TradeId;
import com.db.trade.tradestore.exception.NoDataFoundException;
import com.db.trade.tradestore.exception.TradeInvalidException;
import com.db.trade.tradestore.model.StatusMessage;
import com.db.trade.tradestore.model.StatusMessage.TypeEnum;
import com.db.trade.tradestore.model.StatusMessageResponse;
import com.db.trade.tradestore.model.TradeRequest;
import com.db.trade.tradestore.model.TradeResponse;
import com.db.trade.tradestore.repository.TradeRepository;

import constants.TradeMessageCode;

@Service
public class TradeService {

	@Autowired
	private TradeRepository tradeRepository;

	public StatusMessageResponse addUpdatetrade(TradeRequest tradeRequest) throws TradeInvalidException {
		StatusMessageResponse statusMessageResponse = new StatusMessageResponse();
		List<StatusMessage> statusMessages = new ArrayList<>();
		StatusMessage statusMessage = new StatusMessage();
		statusMessageResponse.setStatusMessages(statusMessages);
		List<Trade> tradeList = tradeRepository.findByTradeIdTradeId(tradeRequest.getTradeId());
		if (!CollectionUtils.isEmpty(tradeList)) {
			Integer version = tradeRequest.getVersion();
			if (isVersionValid(version, tradeList)) {
				if (!isMaturityDateValid(tradeRequest.getMaturityDate())) {
					throw new TradeInvalidException("Maturity Date of the trade version is invalid",
							TradeMessageCode.SYSTEM_ERROR);
				}
				Trade trade = getTradeByTradeVersionId(version, tradeList);
				if (trade != null) {
					statusMessage.setMessage("Trade is successfully updated into the database");
					if (trade.isExpired()) {
						throw new TradeInvalidException("Trade version is expired already",
								TradeMessageCode.SYSTEM_ERROR);
					}
				} else {
					TradeId tradeId = new TradeId(tradeRequest.getTradeId(), tradeRequest.getVersion());
					tradeId.setTradeId(tradeRequest.getTradeId());
					tradeId.setVersion(tradeRequest.getVersion());
					trade = new Trade(tradeId, tradeRequest.getCounterPartyId(), tradeRequest.getBookId(), Date.valueOf(tradeRequest.getMaturityDate()),Date.valueOf(LocalDate.now()),false);  
					statusMessage.setMessage("Trade is successfully inserted into the database");
				}
				trade.setBookId(tradeRequest.getBookId());
				trade.setCounterPartyId(tradeRequest.getCounterPartyId());
				trade.setCreatedDate(Date.valueOf(LocalDate.now()));
				trade.setExpired(tradeRequest.isIsTradeExpired());
				trade.setMaturityDate(Date.valueOf(tradeRequest.getMaturityDate()));
				trade.setExpired(false);
				statusMessage.setType(TypeEnum.SUCCESS);
				statusMessages.add(statusMessage);
				tradeRepository.save(trade);
			} else {
				throw new TradeInvalidException("Trade version is invalid", TradeMessageCode.SYSTEM_ERROR);
			}
		} else {
			TradeId tradeId = new TradeId(tradeRequest.getTradeId(), tradeRequest.getVersion());
			Trade trade = new Trade(tradeId, tradeRequest.getCounterPartyId(), tradeRequest.getBookId(),
					Date.valueOf(tradeRequest.getMaturityDate()), Date.valueOf(LocalDate.now()), false);
			statusMessage.setType(TypeEnum.SUCCESS);
			statusMessage.setMessage("Trade is successfully inserted into the database");
			statusMessages.add(statusMessage);
			tradeRepository.save(trade);
		}
		return statusMessageResponse;
	}

	public List<TradeResponse> getTradeList(int page, int size) {
		List<TradeResponse> tradeResponseList = new ArrayList<>();
		List<Trade> tradeList = tradeRepository.findAll(PageRequest.of(page, size)).getContent();
		if (CollectionUtils.isEmpty(tradeList)) {
			throw new NoDataFoundException("No data found", TradeMessageCode.NO_DATA_FOUND);
		}
		tradeList.stream().forEach(t -> {
			TradeResponse tradeResponse = new TradeResponse();
			tradeResponse.setTradeId(t.getTradeId().getTradeId());
			tradeResponse.setVersion(t.getTradeId().getVersion());
			tradeResponse.setBookId(t.getBookId());
			tradeResponse.setCounterPartyId(t.getCounterPartyId());
			tradeResponse.setMaturityDate(t.getMaturityDate().toLocalDate());
			tradeResponse.setTradeCreatedDate(t.getCreatedDate().toLocalDate());
			tradeResponse.setIsTradeExpired(t.isExpired());
			tradeResponseList.add(tradeResponse);
		});
		return tradeResponseList;
	}

	public void updateTradeExpiryFlag() {
		tradeRepository.findAll().stream().forEach(t -> {
			if (!isMaturityDateValid(t.getMaturityDate().toLocalDate())) {
				t.setExpired(true);
				tradeRepository.save(t);
			}
		});
	}
	
	public boolean isVersionValid(Integer version, List<Trade> tradeModelList) {
		if (tradeModelList.stream().anyMatch(t -> version < t.getTradeId().getVersion())) {
			return false;
		}
		return true;
	}

	public Trade getTradeByTradeVersionId(Integer version, List<Trade> tradeModelList) {
		Optional<Trade> trade = tradeModelList.stream().filter(t -> t.getTradeId().getVersion().equals(version))
				.findAny();
		return trade.isPresent() ? trade.get() : null;
	}

	public boolean isTradeVersionExpired(TradeRequest tradeRequest, List<Trade> tradeModelList) {
		Optional<Trade> trade = tradeModelList.stream()
				.filter(t -> t.getTradeId().getVersion().equals(tradeRequest.getVersion())).findAny();
		if (trade.isPresent() && trade.get().isExpired()) {
			return true;
		}
		return false;
	}

	public boolean isMaturityDateValid(LocalDate maturityDate) {
		return Date.valueOf(maturityDate).after(new Date(System.currentTimeMillis()));

	}

}
