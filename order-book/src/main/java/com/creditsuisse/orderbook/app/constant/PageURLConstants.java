package com.creditsuisse.orderbook.app.constant;

/**
 * This interface contains all constants for urls of pages.
 * 
 * @author Tarun Rohila
 *
 */
public interface PageURLConstants {

	
	/**
	 * Constant for instruments.
	 */
	String INSTRUMENTS = "/instruments";
	
	
	/**
	 * Constant for instrument form.
	 */
	String ADD_INSTRUMENT = "/add-instrument";
	
	/**
	 * Constant for delete instrument
	 */
	String DELETE_INSTRUMENT_FOR_NAME = "/{instrumentName}/delete-instrument";
	
	/**
	 * Constant for opening order book
	 */
	String OPEN_ORDER_BOOK = "/{instrumentName}/open";
	
	/**
	 * Constant for closing order book
	 */
	String CLOSE_ORDER_BOOK = "/{instrumentName}/{orderBookId}/close";
	
	/**
	 * Constant for executing order book
	 */
	String EXECUTE_ORDER_BOOK = "/{instrumentName}/{orderBookId}/execute";
	
	/**
	 * Constant for adding order in an order book
	 */
	String ADD_ORDER = "/{instrumentName}/{orderBookId}/add-order";
	
	/**
	 * Constant for order history
	 */
	String SHOW_ORDERS = "order-book/order-history";
	

}
