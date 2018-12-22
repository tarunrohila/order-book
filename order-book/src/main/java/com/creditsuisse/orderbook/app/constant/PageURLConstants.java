package com.creditsuisse.orderbook.app.constant;

/**
 * This interface contains all constants for urls of pages.
 * 
 * @author Tarun Rohila
 *
 */
public interface PageURLConstants {

	
	/**
	 * Constant for index
	 * 
	 */
	String INDEX_URL = "/";
	
	/**
	 * Constant for index page
	 * 
	 */
	String INDEX_PAGE = "index";
	
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
	String CLOSE_ORDER_BOOK = "/{instrumentName}/close";
	
	/**
	 * Constant for executing order book
	 */
	String EXECUTE_ORDER_BOOK = "/{instrumentName}/execute";
	
	/**
	 * Constant for adding order in an order book
	 */
	String ADD_ORDER = "/{instrumentName}/add-order";
	
	/**
	 * Constant for order history
	 */
	String SHOW_ORDERS = "order-book/order-history";
	
	/**
	 * Constant for stats.
	 */
	String STATS = "/{instrumentName}/{orderBookId}/stats";
	
	/**
	 * Constant for orderDetail
	 */
	String ORDER_DETAIL = "/{orderId}";
	
	String ADD_INSTRUMENT_URL = "add-instrument-url";
	String ADD_INSTRUMENT_PAGE = "add-instrument-page";
	
	String ORDER_BOOKS_URL = "order-books-url";
	
	String ORDER_BOOKS_PAGE = "orderbooks";
	

}
