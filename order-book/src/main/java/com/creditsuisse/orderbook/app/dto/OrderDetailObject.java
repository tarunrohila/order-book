package com.creditsuisse.orderbook.app.dto;

import com.creditsuisse.orderbook.app.repository.domain.Instrument;

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
	 * Variable declaration for orderType
	 */
	private String transactionType;
	
	/*
	 * Variable declaration for orderType
	 */
	private String orderType;
	
	/*
	 * Variable declaration for status
	 */
	private String status;
	
	/*
	 * Variable declaration for quantity
	 */
	private int quantity;
	
	/*
	 * Variable declaration for executionQuantity
	 */
	private int executionQuantity;
	
	/*
	 * Variable declaration for price
	 */
	private Long price;
	
	/*
	 * Variable declaration for executionPrice
	 */
	private Long executionPrice;
	
	/*
	 * Variable declaration for orderCreationDate
	 */
	private String orderCreationDate;;
	
	/*
	 * Variable declaration for instrumentId
	 */
	private Long instrumentId;
	
	private Instrument instrument;

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
	 * Method to get the value of transactionType
	 *
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * Method to set the value for transactionType
	 *
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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
	 * Method to get the value of status
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Method to set the value for status
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
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
	 * Method to get the value of executionQuantity
	 *
	 * @return the executionQuantity
	 */
	public int getExecutionQuantity() {
		return executionQuantity;
	}

	/**
	 * Method to set the value for executionQuantity
	 *
	 * @param executionQuantity the executionQuantity to set
	 */
	public void setExecutionQuantity(int executionQuantity) {
		this.executionQuantity = executionQuantity;
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
	 * Method to get the value of executionPrice
	 *
	 * @return the executionPrice
	 */
	public Long getExecutionPrice() {
		return executionPrice;
	}

	/**
	 * Method to set the value for executionPrice
	 *
	 * @param executionPrice the executionPrice to set
	 */
	public void setExecutionPrice(Long executionPrice) {
		this.executionPrice = executionPrice;
	}

	/**
	 * Method to get the value of orderCreationDate
	 *
	 * @return the orderCreationDate
	 */
	public String getOrderCreationDate() {
		return orderCreationDate;
	}

	/**
	 * Method to set the value for orderCreationDate
	 *
	 * @param orderCreationDate the orderCreationDate to set
	 */
	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
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
	 * Method to get the value of instrument
	 *
	 * @return the instrument
	 */
	public Instrument getInstrument() {
		return instrument;
	}

	/**
	 * Method to set the value for instrument
	 *
	 * @param instrument the instrument to set
	 */
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	

}
