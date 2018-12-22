package com.creditsuisse.orderbook.app.repository.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.creditsuisse.orderbook.app.dto.StatusEnum;

import io.swagger.annotations.ApiModelProperty;

/**
 * This is an entity class for an order book for an instrument.
 * 
 * @author Tarun Rohila
 * @since Dec 3, 2018
 */
@Entity
@Table(name = "ORDER_BOOK")
@NamedQuery(name = "OrderBook.findAll", query = "SELECT o FROM OrderBook o")
public class OrderBook implements Serializable {
	
	/**
	 * Autogenerated serial number 
	 */
	private static final long serialVersionUID = 7992835851829675865L;

	
	/*
	 * Variable declaration for oid
	 */
	@Id
	@ApiModelProperty(notes = "The database generated  ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long oid;
	
	/*
	 * Variable declaration for status
	 */
	@ApiModelProperty(notes = "Order book status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	/*
	 * Variable declaration for instrumentId
	 */
	@ApiModelProperty(notes = "Instrument id")
	@Column(name="INSTRUMENT_ID")
	private Long instrumentId;
	
	
	/*
	 * Variable declaration for order
	 */
	@OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true)
	@JoinColumn(name = "ORDER_BOOK_ID", foreignKey = @ForeignKey(name = "none"))
	private Set<OrderDetail> order;

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
	 * Method to get the value of order
	 *
	 * @return the order
	 */
	public Set<OrderDetail> getOrder() {
		return order;
	}

	/**
	 * Method to set the value for order
	 *
	 * @param order the order to set
	 */
	public void setOrder(Set<OrderDetail> order) {
		this.order = order;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instrumentId == null) ? 0 : instrumentId.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderBook other = (OrderBook) obj;
		if (instrumentId == null) {
			if (other.instrumentId != null)
				return false;
		} else if (!instrumentId.equals(other.instrumentId))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	

}
