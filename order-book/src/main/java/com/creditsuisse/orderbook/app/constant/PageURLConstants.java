package com.creditsuisse.orderbook.app.constant;

/**
 * This interface contains all constants for urls of pages.
 * 
 * @author Tarun Rohila
 *
 */
public interface PageURLConstants {

	/**
	 * Constant for index url.
	 */
	String INDEX_URL = "/";
	
	/**
	 * Constant for index page.
	 */
	String INDEX_PAGE = "index";
	
	/**
	 * Constant for instrument url.
	 */
	String INSTRUMENTS_URL = "/instruments";
	
	/**
	 * Constant for instrument page.
	 */
	String INSTRUMENTS_PAGE = "order-book/instrument-home";
	
	/**
	 * Constant for Add instrument url.
	 */
	String ADD_INSTRUMENT_URL = "/add-instrument";
	
	/**
	 * Constant for add instrument page.
	 */
	String ADD_INSTRUMENT_PAGE = "order-book/add-instrument";
	
	/**
	 * Constant for instrument form.
	 */
	String ADD_INSTRUMENT = "/add-instrument-form";
	
	/**
	 * Constant for redirecting to  Order Books page.
	 */
	String INSTRUMENTS_REDIRECT= "redirect:/instruments";
	
	/**
	 * Constant for redirecting to  orders page.
	 */
	String ORDERS_REDIRECT= "redirect:/orders";
	
	/**
	 * Constant for toggle status for instrument.
	 */
	String TOGGLE_STATUS = "/toggle-status";
	
	/**
	 * Constant for delete instrument
	 */
	String DELETE_INSTRUMENT_FOR_ID = "/delete-instrument/{instrumentId}";
	
	/**
	 * Constant for orders
	 */
	String ORDERS_URL = "/orders";
	
	/**
	 * Constant for orders page
	 */
	String ORDERS_PAGE = "order-book/order-home";
	
	/**
	 * Constant for buy orders
	 */
	String BUY_ORDER = "/buy-order";
	
	/**
	 * Constant for sell orders
	 */
	String SELL_ORDER = "/sell-order";
	
	/**
	 * Constant for order history
	 */
	String ORDER_HISTORY_DETAILS = "order-book/order-history";
	

}
