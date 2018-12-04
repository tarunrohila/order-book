package com.creditsuisse.orderbook.app.dto;

/**
 * This is pojo class to provide statistics
 * 
 * @author Tarun Rohila
 * @since Dec 4, 2018
 */

public class Stats {
	
	/*
	 * variable declartion for totalOrders
	 */
	private int totalOrders;
	
	/*
	 * variable declartion for totalValidOrders
	 */
	private int totalValidOrders;
	
	/*
	 * variable declartion for totalInvalidorders
	 */
	private int totalInvalidorders;
	
	/*
	 * variable declartion for biggestOrder
	 */
	private int biggestOrder;
	
	/*
	 * variable declartion for smallestOrder
	 */
	private int smallestOrder;

	/**
	 * Method to get the value of totalOrders
	 *
	 * @return the totalOrders
	 */
	public int getTotalOrders() {
		return totalOrders;
	}

	/**
	 * Method to set the value for totalOrders
	 *
	 * @param totalOrders the totalOrders to set
	 */
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}

	/**
	 * Method to get the value of totalValidOrders
	 *
	 * @return the totalValidOrders
	 */
	public int getTotalValidOrders() {
		return totalValidOrders;
	}

	/**
	 * Method to set the value for totalValidOrders
	 *
	 * @param totalValidOrders the totalValidOrders to set
	 */
	public void setTotalValidOrders(int totalValidOrders) {
		this.totalValidOrders = totalValidOrders;
	}

	/**
	 * Method to get the value of totalInvalidorders
	 *
	 * @return the totalInvalidorders
	 */
	public int getTotalInvalidorders() {
		return totalInvalidorders;
	}

	/**
	 * Method to set the value for totalInvalidorders
	 *
	 * @param totalInvalidorders the totalInvalidorders to set
	 */
	public void setTotalInvalidorders(int totalInvalidorders) {
		this.totalInvalidorders = totalInvalidorders;
	}

	/**
	 * Method to get the value of biggestOrder
	 *
	 * @return the biggestOrder
	 */
	public int getBiggestOrder() {
		return biggestOrder;
	}

	/**
	 * Method to set the value for biggestOrder
	 *
	 * @param biggestOrder the biggestOrder to set
	 */
	public void setBiggestOrder(int biggestOrder) {
		this.biggestOrder = biggestOrder;
	}

	/**
	 * Method to get the value of smallestOrder
	 *
	 * @return the smallestOrder
	 */
	public int getSmallestOrder() {
		return smallestOrder;
	}

	/**
	 * Method to set the value for smallestOrder
	 *
	 * @param smallestOrder the smallestOrder to set
	 */
	public void setSmallestOrder(int smallestOrder) {
		this.smallestOrder = smallestOrder;
	}
	
	
	

}
