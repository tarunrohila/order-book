package com.creditsuisse.orderbook.app.dto;

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
	
	/*
	 * Variable declaration for status
	 */
	private boolean status;
	
	/*
	 * Variable declaration for quantity
	 */
	private int quantity;
	
	

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
	 * Method to get the value of status
	 *
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Method to set the value for status
	 *
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
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
	

	

}
