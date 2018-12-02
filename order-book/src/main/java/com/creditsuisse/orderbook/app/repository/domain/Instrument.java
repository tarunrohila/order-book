package com.creditsuisse.orderbook.app.repository.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity Class for Order book to save this object in database.
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Entity
@Table(name = "INSTRUMENT")
@NamedQuery(name = "Instrument.findAll", query = "SELECT o FROM Instrument o")
public class Instrument implements Serializable {
	
	/**
	 * Autogenerated serial number 
	 */
	private static final long serialVersionUID = -1931306263137686364L;

	
	/*
	 * Variable declaration for oid
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long oid;
	
	/*
	 * Variable declaration for name
	 */
	private String name;
	
	/*
	 * Variable declaration for status
	 */
	private boolean status;
	
	/*
	 * Variable declaration for quantity
	 */
	private int quantity;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "INSTRUMENT_ID", foreignKey = @ForeignKey(name = "none"))
	private Set<OrderDetail> orderDetail;

	/**
	 * Method to get the value of name
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the value for name
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Method to get the value of oid
	 *
	 * @return the oid
	 */
	public Long getOid() {
		return oid;
	}

	/**
	 * Method to set the value for oid
	 *
	 * @param oid the oid to set
	 */
	public void setOid(Long oid) {
		this.oid = oid;
	}

	/**
	 * Method to get the value of order
	 *
	 * @return the order
	 */
	public Set<OrderDetail> getOrder() {
		return orderDetail;
	}

	/**
	 * Method to set the value for order
	 *
	 * @param order the order to set
	 */
	public void setOrder(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
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
	

}
