package com.creditsuisse.orderbook.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderDetailObject;
import com.creditsuisse.orderbook.app.mapper.InstrumentMapper;
import com.creditsuisse.orderbook.app.mapper.OrderDetailMapper;
import com.creditsuisse.orderbook.app.repository.InstrumentRepository;
import com.creditsuisse.orderbook.app.repository.OrderDetailRepository;
import com.creditsuisse.orderbook.app.repository.domain.Instrument;
import com.creditsuisse.orderbook.app.repository.domain.OrderDetail;
import com.creditsuisse.orderbook.app.service.OrderBookService;

/**
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Service("orderBookService")
public class OrderBookServiceImpl implements OrderBookService {
	
	/*
	 * Autowired dependency to use InstrumentMapper object;
	 */
	@Autowired
	private InstrumentMapper InstrumentMapper;
	
	/*
	 * Autowired dependency to use OrderDetailMapper object;
	 */
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	
	/*
	 * Autowired dependency to use InstrumentRepository object;
	 */
	@Autowired
	private InstrumentRepository instrumentRepository;
	
	/*
	 * Autowired dependency to use OrderDetailRepository object;
	 */
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	/**
	 * This method is used to retrieve all Instruments
	 * 
	 * @return order books
	 */
	@Override
	public List<InstrumentObject> retrieveInstruments() {
		return getInstrumentMapper().mapInstrumentEntitytoObject(getInstrumentRepository().findAll());
	}
	
	
	/**
	 * This method is used to add Instrument
	 * 
	 * @param orderBookObject
	 */
	@Override
	public void addInstrument(InstrumentObject orderBookObject) {
		getInstrumentRepository().save(getInstrumentMapper().mapInstrumentObjectToEntity(orderBookObject));
		
	}
	
	/**
	 * This method is toggles the status of instrument as open or close
	 * 
	 * @param instrumentId
	 */
	@Override
	public void toggleStatus(Integer instrumentId) {
		Instrument orderBook = getInstrumentRepository().getOne(Long.valueOf(instrumentId));
		orderBook.setStatus(!orderBook.isStatus());
		getInstrumentRepository().save(orderBook);
		
		
	}

	/**
	 * This method is used to delete financial instrument.
	 * 
	 * @param instrumentId
	 */
	@Override
	public void deleteInstrument(Long instrumentId) {
		getInstrumentRepository().deleteById(instrumentId);
	}


	/**
	 * Method to get the value of instrumentMapper
	 *
	 * @return the instrumentMapper
	 */
	public InstrumentMapper getInstrumentMapper() {
		return InstrumentMapper;
	}

	/**
	 * Method to set the value for instrumentMapper
	 *
	 * @param instrumentMapper the instrumentMapper to set
	 */
	public void setInstrumentMapper(InstrumentMapper instrumentMapper) {
		InstrumentMapper = instrumentMapper;
	}

	/**
	 * Method to get the value of instrumentRepository
	 *
	 * @return the instrumentRepository
	 */
	public InstrumentRepository getInstrumentRepository() {
		return instrumentRepository;
	}

	/**
	 * Method to set the value for instrumentRepository
	 *
	 * @param instrumentRepository the instrumentRepository to set
	 */
	public void setInstrumentRepository(InstrumentRepository instrumentRepository) {
		this.instrumentRepository = instrumentRepository;
	}


	/**
	 * Method to buy order 
	 * 
	 * @param orderDetailObject
	 */
	@Override
	public void buyOrder(OrderDetailObject orderDetailObject) {
		OrderDetail orderDetailEntity = new OrderDetail();
		orderDetailEntity.setOrderCreationDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		orderDetailEntity.setTransactionType("buy");
		orderDetailEntity.setOrderType(orderDetailObject.getOrderType());
		if("limit".equalsIgnoreCase(orderDetailObject.getOrderType())) {
			orderDetailEntity.setPrice(orderDetailObject.getPrice());
		}
		orderDetailEntity.setInstrumentId(orderDetailObject.getInstrumentId());
		orderDetailEntity.setQuantity(orderDetailObject.getQuantity());
		List<OrderDetail> orderDetails = getOrderDetailRepository().findOrderDetailsByInstrumentId(orderDetailObject.getInstrumentId()).stream().filter(orderDetail -> "sell".equals(orderDetail.getTransactionType())).collect(Collectors.toList());
		Comparator<OrderDetail> compareByPrice = (OrderDetail o1, OrderDetail o2) ->
        o1.getPrice().compareTo( o2.getPrice());
        Collections.sort(orderDetails,compareByPrice);
		for(OrderDetail orderDetail : orderDetails) {
			if((orderDetailObject.getQuantity() > orderDetail.getQuantity()) || (orderDetail.getPrice().longValue() > orderDetailObject.getPrice().longValue())) {
				orderDetailEntity.setExecutionPrice(new Long(0));
				orderDetailEntity.setStatus("invalid");
			} else {
				orderDetailEntity.setExecutionPrice(orderDetail.getPrice());
				orderDetailEntity.setExecutionQuantity(orderDetailObject.getQuantity());
				orderDetailEntity.setStatus("valid");
			}
		}
		getOrderDetailRepository().save(orderDetailEntity);
	}


	/**
	 * Method to sell order
	 * 
	 * @param orderDetailObject
	 */
	@Override
	public void sellOrder(OrderDetailObject orderDetailObject) {
		OrderDetail orderDetailEntity = new OrderDetail();
		orderDetailEntity.setOrderCreationDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		orderDetailEntity.setTransactionType("sell");
		orderDetailEntity.setOrderType(orderDetailObject.getOrderType());
		if("limit".equalsIgnoreCase(orderDetailObject.getOrderType())) {
			orderDetailEntity.setPrice(orderDetailObject.getPrice());
		}
		orderDetailEntity.setInstrumentId(orderDetailObject.getInstrumentId());
		orderDetailEntity.setQuantity(orderDetailObject.getQuantity());
		orderDetailEntity.setStatus("invalid");
		orderDetailEntity.setExecutionPrice(new Long(0));
		List<OrderDetail> orderDetails = getOrderDetailRepository().findOrderDetailsByInstrumentId(orderDetailObject.getInstrumentId()).stream().filter(orderDetail -> "buy".equals(orderDetail.getTransactionType())).collect(Collectors.toList());
		Comparator<OrderDetail> compareByPrice = (OrderDetail o1, OrderDetail o2) ->
        o1.getPrice().compareTo( o2.getPrice());
        Collections.sort(orderDetails,compareByPrice);
		for(OrderDetail orderDetail : orderDetails) {
			if((orderDetailObject.getQuantity() > orderDetail.getQuantity()) || (orderDetail.getPrice().longValue() > orderDetailObject.getPrice().longValue())) {
				orderDetailEntity.setExecutionPrice(new Long(0));
				orderDetailEntity.setStatus("invalid");
			} else {
				orderDetailEntity.setExecutionPrice(orderDetail.getPrice());
				orderDetailEntity.setExecutionQuantity(orderDetailObject.getQuantity());
				orderDetailEntity.setStatus("valid");
			}
		}
		getOrderDetailRepository().save(orderDetailEntity);
	}


	/**
	 * Method to get the value of orderDetailMapper
	 *
	 * @return the orderDetailMapper
	 */
	public OrderDetailMapper getOrderDetailMapper() {
		return orderDetailMapper;
	}


	/**
	 * Method to set the value for orderDetailMapper
	 *
	 * @param orderDetailMapper the orderDetailMapper to set
	 */
	public void setOrderDetailMapper(OrderDetailMapper orderDetailMapper) {
		this.orderDetailMapper = orderDetailMapper;
	}


	/**
	 * Method to get the value of orderDetailRepository
	 *
	 * @return the orderDetailRepository
	 */
	public OrderDetailRepository getOrderDetailRepository() {
		return orderDetailRepository;
	}


	/**
	 * Method to set the value for orderDetailRepository
	 *
	 * @param orderDetailRepository the orderDetailRepository to set
	 */
	public void setOrderDetailRepository(OrderDetailRepository orderDetailRepository) {
		this.orderDetailRepository = orderDetailRepository;
	}


	/**
	 * Method to retrieve orders
	 * 
	 * @return list of orders
	 */
	@Override
	public List<OrderDetailObject> retrieveOrders() {
		List<OrderDetail> orderDetails = getOrderDetailRepository().findAll().stream().filter(orderDetail -> "buy".equals(orderDetail.getTransactionType())).collect(Collectors.toList());
		return getOrderDetailMapper().mapOrderDetailEntitytoObject(orderDetails);
	}

}
