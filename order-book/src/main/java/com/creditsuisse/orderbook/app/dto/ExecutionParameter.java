package com.creditsuisse.orderbook.app.dto;

/**
 * This is pojo class to keep execution parameter to execute order book
 * 
 * @author Tarun Rohila
 * @since Dec 4, 2018
 */
public class ExecutionParameter {
	
	/*
	 * Variable declaration for executionQuantity
	 */
	private Long executionQuantity;
	/*
	 * Variable declaration for executionPrice
	 */
	private Long executionPrice;

	/**
	 * Method to get the value of executionQuantity
	 *
	 * @return the executionQuantity
	 */
	public Long getExecutionQuantity() {
		return executionQuantity;
	}

	/**
	 * Method to set the value for executionQuantity
	 *
	 * @param executionQuantity the executionQuantity to set
	 */
	public void setExecutionQuantity(Long executionQuantity) {
		this.executionQuantity = executionQuantity;
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
	
	

}
