package com.creditsuisse.orderbook.app.service;

import java.util.List;

import com.creditsuisse.orderbook.app.dto.ExecutionParameter;
import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderBookObject;
import com.creditsuisse.orderbook.app.dto.OrderDetailObject;
import com.creditsuisse.orderbook.app.dto.Stats;

/**
 * This interface provides operation required for order book.
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
public interface OrderBookService {

	/**
	 * This method is used to retrieve all Instruments
	 * 
	 * @return order books
	 */
	List<InstrumentObject> retrieveInstruments();

	/**
	 * This method is used to add Instrument
	 * 
	 * @param orderBookObject
	 */
	void addInstrument(InstrumentObject orderBookObject);

	/**
	 * This method is used to delete financial instrument.
	 * 
	 * @param instrumentId
	 */
	void deleteInstrument(Long instrumentId);

	
	/**
	 * This method is used to delete financial instrument.
	 * 
	 * @param instrumentName
	 */
	void deleteInstrumentForName(String instrumentName);

	/**
	 * This method is used to retrieve instrument for name
	 * 
	 * @param instrumentName
	 * @return instrument
	 */
	InstrumentObject retrieveInstrumentByName(String instrumentName);

	/**
	 * This method is used to open a new order book for an instrument.
	 * 
	 * @param orderBookObject
	 */
	void openOrderBook(OrderBookObject orderBookObject);

	/**
	 * This method is used to close  order book for an instrument.
	 * 
	 * @param orderBookObject
	 */
	void closeOrderBook(OrderBookObject orderBookObject);

	/**
	 * This method is used to add new order
	 * 
	 * @param orderDetailObject
	 */
	void addOrder(OrderDetailObject orderDetailObject);

	/**
	 * This method is used to execute order
	 * 
	 * @param orderBookObject
	 * @param executionParameter 
	 */
	String executeOrderBook(OrderBookObject orderBookObject, ExecutionParameter executionParameter);

	/**
	 * THis method is used to provided order stats for instrumnt
	 * @param orderBookId 
	 * @param instrumentName
	 * @return
	 */
	Stats getStats(Long instrumentId, Long orderBookId);

	/**
	 * Method to get order details
	 * @param orderId
	 * @return
	 */
	OrderDetailObject retrieveOrderDetails(Long orderId);

}
