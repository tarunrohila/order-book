package com.creditsuisse.orderbook.app.dto;

/**
 * This is dto class order order details.
 * 
 * @author Tarun Rohila
 * @since Nov 30, 2018
 */
public class OrderDetailObject {
	
	/*
	 * Variable declaration for oid
	 */
	private Long orderId;
	
	
	/*
	 * Variable declaration for status
	 */
	private OrderStatus status;
	
	/*
	 * Variable declaration for quantity
	 */
	private int quantity;
	
	/*
	 * Variable declaration for price
	 */
	private Long price;
	
	/*
	 * Variable declaration for entryDate
	 */
	private String entryDate;
	
	/*
	 * Variable declaration for instrumentId
	 */
	private Long instrumentId;
	
	/*
	 * Variable declaration for orderType
	 */
	private String orderType;
	
	/*
	 * Variable declaration for instrument
	 */
	private Long orderBookId;

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
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * Method to set the value for status
	 *
	 * @param status the status to set
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	/**
	 * Method to get the value of quantity
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Method to set the value for quantity
	 *
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Method to get the value of price
	 *
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * Method to set the value for price
	 *
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * Method to get the value of entryDate
	 *
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * Method to set the value for entryDate
	 *
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * Method to get the value of instrumentId
	 *
	 * @return the instrumentId
	 */
	public Long getInstrumentId() {
		return instrumentId;
	}

	/**
	 * Method to set the value for instrumentId
	 *
	 * @param instrumentId the instrumentId to set
	 */
	public void setInstrumentId(Long instrumentId) {
		this.instrumentId = instrumentId;
	}

	/**
	 * Method to get the value of orderType
	 *
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * Method to set the value for orderType
	 *
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * Method to get the value of orderBookId
	 *
	 * @return the orderBookId
	 */
	public Long getOrderBookId() {
		return orderBookId;
	}

	/**
	 * Method to set the value for orderBookId
	 *
	 * @param orderBookId the orderBookId to set
	 */
	public void setOrderBookId(Long orderBookId) {
		this.orderBookId = orderBookId;
	}

	
	

}
