package com.creditsuisse.orderbook.app.service;

import java.util.List;

import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderDetailObject;

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
	 * This method is toggles the status of instrument as open or close
	 * 
	 * @param instrumentId
	 */
	void toggleStatus(Integer instrumentId);

	/**
	 * This method is used to delete financial instrument.
	 * 
	 * @param instrumentId
	 */
	void deleteInstrument(Long instrumentId);

	/**
	 * Method to buy order 
	 * 
	 * @param orderDetailObject
	 */
	void buyOrder(OrderDetailObject orderDetailObject);

	/**
	 * Method to sell order
	 * 
	 * @param orderDetailObject
	 */
	void sellOrder(OrderDetailObject orderDetailObject);

	/**
	 * Method to retrieve orders
	 * 
	 * @return list of orders
	 */
	List<OrderDetailObject> retrieveOrders();

}
