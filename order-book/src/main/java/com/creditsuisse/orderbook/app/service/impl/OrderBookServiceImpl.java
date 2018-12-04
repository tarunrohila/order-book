package com.creditsuisse.orderbook.app.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditsuisse.orderbook.app.dto.ExecutionParameter;
import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderBookObject;
import com.creditsuisse.orderbook.app.dto.OrderDetailObject;
import com.creditsuisse.orderbook.app.dto.Stats;
import com.creditsuisse.orderbook.app.mapper.InstrumentMapper;
import com.creditsuisse.orderbook.app.mapper.OrderBookMapper;
import com.creditsuisse.orderbook.app.mapper.OrderDetailMapper;
import com.creditsuisse.orderbook.app.repository.InstrumentRepository;
import com.creditsuisse.orderbook.app.repository.OrderBookRepository;
import com.creditsuisse.orderbook.app.repository.OrderDetailRepository;
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
	 * Autowired dependency to use OrderBookMapper object;
	 */
	@Autowired
	private OrderBookMapper orderBookMapper;
	
	
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
	
	/*
	 * Autowired dependency to use OrderBookRepository object;
	 */
	@Autowired
	private OrderBookRepository orderBookRepository;
	
	/**
	 * This method is used to retrieve all Instruments
	 * 
	 * @return order books
	 */
	@Override
	public List<InstrumentObject> retrieveInstruments() {
		return getInstrumentMapper().mapInstrumentEntitytoObjectList(getInstrumentRepository().findAll());
	}
	
	
	/**
	 * This method is used to add Instrument
	 * 
	 * @param orderBookObject
	 */
	@Override
	public void addInstrument(InstrumentObject instrumentObject) {
		getInstrumentRepository().save(getInstrumentMapper().mapInstrumentObjectToEntity(instrumentObject));
		
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
	 * This method is used to delete financial instrument.
	 */
	@Override
	public void deleteInstrumentForName(String instrumentName) {
		getInstrumentRepository().deleteInstrumentForName(instrumentName);
	}


	/**
	 * This method is used to retrieve instrument for name
	 * 
	 * @param instrumentName
	 * @return instrument
	 */
	@Override
	public InstrumentObject retrieveInstrumentByName(String instrumentName) {
		return getInstrumentMapper().mapInstrumentEntitytoObject(getInstrumentRepository().findInstrumentByName(instrumentName));
	}


	/**
	 * This method is used to open a new order book for an instrument.
	 * 
	 * @param orderBookObject
	 */
	@Override
	public void openOrderBook(OrderBookObject orderBookObject) {
		getOrderBookRepository().save(getOrderBookMapper().mapOrderBookObjectToEntity(orderBookObject));
	}


	/**
	 * Method to get the value of orderBookMapper
	 *
	 * @return the orderBookMapper
	 */
	public OrderBookMapper getOrderBookMapper() {
		return orderBookMapper;
	}


	/**
	 * Method to set the value for orderBookMapper
	 *
	 * @param orderBookMapper the orderBookMapper to set
	 */
	public void setOrderBookMapper(OrderBookMapper orderBookMapper) {
		this.orderBookMapper = orderBookMapper;
	}


	/**
	 * Method to get the value of orderBookRepository
	 *
	 * @return the orderBookRepository
	 */
	public OrderBookRepository getOrderBookRepository() {
		return orderBookRepository;
	}


	/**
	 * Method to set the value for orderBookRepository
	 *
	 * @param orderBookRepository the orderBookRepository to set
	 */
	public void setOrderBookRepository(OrderBookRepository orderBookRepository) {
		this.orderBookRepository = orderBookRepository;
	}


	/**
	 * This method is used to close  order book for an instrument.
	 * 
	 * @param orderBookObject
	 */
	@Override
	public void closeOrderBook(OrderBookObject orderBookObject) {
		getOrderBookRepository().closeOrderBook(orderBookObject.getStatus(), orderBookObject.getOrderId());
	}


	/**
	 * This method is used to add a new order.
	 */
	@Override
	public void addOrder(OrderDetailObject orderDetailObject) {
		getOrderDetailRepository().save(getOrderDetailMapper().mapOrderDetailObjectToEntity(orderDetailObject));
		
	}


	/**
	 * This method is used to execute order
	 * 
	 * @param orderBookObject
	 */
	@Override
	public String executeOrderBook(OrderBookObject orderBookObject, ExecutionParameter executionParameter) {
		List<OrderDetailObject> validOrders = new ArrayList<>();
		Long demand = new Long(0);
		for(OrderDetailObject detailObject: orderBookObject.getOrders()) {
			if("limit".equalsIgnoreCase(detailObject.getOrderType()) && detailObject.getPrice()!=null && executionParameter.getExecutionPrice() >= detailObject.getPrice()) {
				detailObject.setStatus("valid");
				getOrderDetailRepository().setOrderStatus(detailObject.getStatus(), detailObject.getOrderId());
			} else if("market".equalsIgnoreCase(detailObject.getOrderType())) {
				detailObject.setStatus("valid");
				getOrderDetailRepository().setOrderStatus(detailObject.getStatus(), detailObject.getOrderId());
			} else {
				detailObject.setStatus("invalid");
				getOrderDetailRepository().setOrderStatusAndQty(detailObject.getStatus(), detailObject.getOrderId(),  0);
			}
			
			validOrders = orderBookObject.getOrders().stream().filter(orderDetail -> "valid".equalsIgnoreCase(orderDetail.getStatus())).collect(Collectors.toList());
			demand = validOrders.stream().mapToLong(order -> order.getPrice()).sum();
			if(executionParameter.getExecutionQuantity() < demand) {
				return "Demand is higher than execution quantity";
			} else {
				for(OrderDetailObject validOrder : validOrders) {
					if("market".equalsIgnoreCase(validOrder.getOrderType())) {
						getOrderDetailRepository().setOrderStatusAndPrice(validOrder.getStatus(), validOrder.getOrderId(), executionParameter.getExecutionPrice());
					} else {
						getOrderDetailRepository().setOrderStatusAndQty(validOrder.getStatus(), validOrder.getOrderId(), validOrder.getQuantity());
					}
				}
			}
		}
		getOrderBookRepository().executeOrderBook(orderBookObject.getStatus(), orderBookObject.getOrderId());
		return "Order execution id done";
		
	}


	@Override
	public Stats getStats(Long instrumentId, Long orderBookId) {
		Stats stats = new Stats();
		List<OrderDetail> orders = getOrderDetailRepository().getAllOrdersForInstrument(instrumentId, orderBookId);
		List<OrderDetail> validOrders = orders.stream().filter(orderDetail -> "valid".equalsIgnoreCase(orderDetail.getStatus())).collect(Collectors.toList());
		List<OrderDetail> invalidOrders = orders.stream().filter(orderDetail -> "invalid".equalsIgnoreCase(orderDetail.getStatus())).collect(Collectors.toList());
		int totalOrders = orders.size();
		int totalValidOrder = validOrders.stream().mapToInt(order -> order.getQuantity()).sum();
		int totalInvalidOrder = invalidOrders.stream().mapToInt(order -> order.getQuantity()).sum();
		int biggestOrder =  orders.stream()
		        .mapToInt(OrderDetail::getQuantity)
		        .summaryStatistics().getMax();
		int smallestOrder = orders.stream()
		        .mapToInt(OrderDetail::getQuantity)
		        .summaryStatistics().getMin();
		stats.setTotalOrders(totalOrders);
		stats.setTotalValidOrders(totalValidOrder);
		stats.setTotalInvalidorders(totalInvalidOrder);
		stats.setBiggestOrder(biggestOrder);
		stats.setSmallestOrder(smallestOrder);
		return stats;
	}


	@Override
	public OrderDetailObject retrieveOrderDetails(Long orderId) {
		return getOrderDetailMapper().mapOrderDetailEntitytoObject(getOrderDetailRepository().getOne(orderId));
	}

}
