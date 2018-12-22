package com.creditsuisse.orderbook.app.dto;

import java.util.Set;

/**
 * This is dto class for OrderBook
 * @author Tarun Rohila
 * @since Dec 3, 2018
 */
public class OrderBookObject {
	
	/*
	 * Variable declaration for orderId
	 */
	private Long orderId;
	
	/*
	 * Variable declaration for status
	 */
	private StatusEnum status;
	
	/*
	 * Variable declaration for status
	 */
	private Long InstrumentId;
	
	/*
	 * Variable declaration for status
	 */
	private Set<OrderDetailObject> orders;
	
	
	

	/**
	 * Method to get the value of orderId
	 *
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * Method to set the value for orderId
	 *
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Method to get the value of status
	 *
	 * @return the status
	 */
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * Method to set the value for status
	 *
	 * @param status the status to set
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * Method to get the value of instrumentId
	 *
	 * @return the instrumentId
	 */
	public Long getInstrumentId() {
		return InstrumentId;
	}

	/**
	 * Method to set the value for instrumentId
	 *
	 * @param instrumentId the instrumentId to set
	 */
	public void setInstrumentId(Long instrumentId) {
		InstrumentId = instrumentId;
	}

	/**
	 * Method to get the value of orders
	 *
	 * @return the orders
	 */
	public Set<OrderDetailObject> getOrders() {
		return orders;
	}

	/**
	 * Method to set the value for orders
	 *
	 * @param orders the orders to set
	 */
	public void setOrders(Set<OrderDetailObject> orders) {
		this.orders = orders;
	}
	
	

}
