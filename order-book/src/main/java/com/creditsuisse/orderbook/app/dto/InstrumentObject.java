package com.creditsuisse.orderbook.app.dto;

import java.util.Set;

/**
 * This is Pojo class to for Order Book
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
public class InstrumentObject {
	
	/*
	 * Variable declaration for instrument_id
	 */
	private Long instrumentId;
	
	/*
	 * Variable declaration for instrument_name
	 */
	private String instrumentName;
	
	public InstrumentObject() {
		super();
	}

	/*
	 * Variable declaration for orderBooks
	 */
	private Set<OrderBookObject> orderBooks;
	

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
	 * Method to get the value of instrumentName
	 *
	 * @return the instrumentName
	 */
	public String getInstrumentName() {
		return instrumentName;
	}

	/**
	 * Method to set the value for instrumentName
	 *
	 * @param instrumentName the instrumentName to set
	 */
	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	/**
	 * Method to get the value of orderBooks
	 *
	 * @return the orderBooks
	 */
	public Set<OrderBookObject> getOrderBooks() {
		return orderBooks;
	}

	/**
	 * Method to set the value for orderBooks
	 *
	 * @param orderBooks the orderBooks to set
	 */
	public void setOrderBooks(Set<OrderBookObject> orderBooks) {
		this.orderBooks = orderBooks;
	}

}
