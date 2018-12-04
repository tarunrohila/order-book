package com.creditsuisse.orderbook.app.mapper;

import org.springframework.stereotype.Component;

import com.creditsuisse.orderbook.app.dto.OrderBookObject;
import com.creditsuisse.orderbook.app.repository.domain.OrderBook;

/**
 * This is mapper class to map order book object to entity and vice versa.
 * 
 * @author Tarun Rohila
 * @since Dec 3, 2018
 */
@Component
public class OrderBookMapper {

	public OrderBook mapOrderBookObjectToEntity(OrderBookObject orderBookObject) {
		OrderBook orderBook = new OrderBook();
		orderBook.setStatus(orderBookObject.getStatus());
		orderBook.setInstrumentId(orderBookObject.getInstrumentId());
		orderBook.setOid(orderBookObject.getOrderId());
		return orderBook;
	}

}
