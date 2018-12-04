package com.creditsuisse.orderbook.app.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderBookObject;
import com.creditsuisse.orderbook.app.dto.OrderDetailObject;
import com.creditsuisse.orderbook.app.repository.domain.Instrument;
import com.creditsuisse.orderbook.app.repository.domain.OrderBook;
import com.creditsuisse.orderbook.app.repository.domain.OrderDetail;

/**
 * This class is used to map Object to Entity and visa verca
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Component
public class InstrumentMapper {

	/**
	 * Method to map entity list of entity of Instrument to list of object of
	 * InstrumentObject
	 * 
	 * @param instruments
	 * @return list of objects of InstrumentObject
	 */
	public List<InstrumentObject> mapInstrumentEntitytoObjectList(List<Instrument> instruments) {
		List<InstrumentObject> instrumentObjectList = new ArrayList<>();
		for (Instrument instrument : instruments) {
			InstrumentObject instrumentObject = new InstrumentObject();
			instrumentObject.setInstrumentId(instrument.getOid());
			instrumentObject.setInstrumentName(instrument.getName());
			instrumentObjectList.add(instrumentObject);
		}
		return instrumentObjectList;
	}

	/**
	 * Method to map Instrument object to entity
	 * 
	 * @param instrumentObject
	 * @return entity of instrument
	 */
	public Instrument mapInstrumentObjectToEntity(InstrumentObject instrumentObject) {
		Instrument instrument = new Instrument();
		instrument.setName(instrumentObject.getInstrumentName());
		instrument.setOid(instrumentObject.getInstrumentId());
		if (instrumentObject.getOrderBooks() != null && !instrumentObject.getOrderBooks().isEmpty()) {
			Set<OrderBook> books = new HashSet<>();
			for (OrderBookObject bookObject : instrumentObject.getOrderBooks()) {
				OrderBook book = new OrderBook();
				book.setInstrumentId(instrument.getOid());
				book.setOid(bookObject.getOrderId());
				book.setStatus(bookObject.getStatus());
				books.add(book);
			}
			instrument.setOrderBook(books);
		}

		return instrument;
	}

	/**
	 * This method map instrument entity to instrument object
	 * 
	 * @param findInstrumentByName
	 * @return
	 */
	public InstrumentObject mapInstrumentEntitytoObject(Instrument instrument) {
		InstrumentObject instrumentObject = null;
		if (instrument != null) {
			instrumentObject = new InstrumentObject();
			instrumentObject.setInstrumentName(instrument.getName());
			instrumentObject.setInstrumentId(instrument.getOid());
			if (instrument.getOrderBook() != null && !instrument.getOrderBook().isEmpty()) {
				Set<OrderBookObject> orderBookObjects = new HashSet<>();
				for (OrderBook orderBook : instrument.getOrderBook()) {
					OrderBookObject orderBookObject = new OrderBookObject();
					orderBookObject.setOrderId(orderBook.getOid());
					orderBookObject.setStatus(orderBook.getStatus());
					Set<OrderDetailObject> orders = new HashSet<>();
					for(OrderDetail orderDetail : orderBook.getOrder()) {
						OrderDetailObject orderDetailObject = new OrderDetailObject();
						orderDetailObject.setEntryDate(orderDetail.getOrderCreationDate());
						orderDetailObject.setInstrumentId(orderDetail.getInstrumentId());
						orderDetailObject.setOrderBookId(orderDetail.getOrderBookId());
						orderDetailObject.setOrderId(orderDetail.getOid());
						orderDetailObject.setOrderType(orderDetail.getOrderType());
						orderDetailObject.setPrice(orderDetail.getPrice());
						orderDetailObject.setQuantity(orderDetail.getQuantity());
						orderDetailObject.setStatus(orderDetail.getStatus());
						orders.add(orderDetailObject);
					}
					orderBookObject.setOrders(orders);
					orderBookObjects.add(orderBookObject);
				}
				instrumentObject.setOrderBooks(orderBookObjects);
			}
		}
		return instrumentObject;
	}

}
