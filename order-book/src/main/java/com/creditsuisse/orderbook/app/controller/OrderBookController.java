package com.creditsuisse.orderbook.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.creditsuisse.orderbook.app.constant.PageURLConstants;
import com.creditsuisse.orderbook.app.dto.ExecutionParameter;
import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderBookObject;
import com.creditsuisse.orderbook.app.dto.OrderDetailObject;
import com.creditsuisse.orderbook.app.dto.Stats;
import com.creditsuisse.orderbook.app.service.OrderBookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This is controller class to manage all request mappings for order book.
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Api(value="Order book", description="Order Book API")
@RestController
public class OrderBookController extends AbstractController implements PageURLConstants {
	
	/*
	 * Autowired dependency to use OrderBookService object;
	 */
	@Autowired
	private OrderBookService orderBookService;
	
	/**
	 * This method is used to create new instrument
	 * 
	 * @return instrument which is created
	 */
	@ApiOperation(value="Add new financial instrument", response = String.class)
	@PostMapping(value=ADD_INSTRUMENT)
	public String addInstument(@RequestBody InstrumentObject orderBookObject) {
		getOrderBookService().addInstrument(orderBookObject);
		return "New Instrument "+orderBookObject.getInstrumentName()+" is created" ;
	}
	
	/**
	 * This method returns all instruments
	 */
	@ApiOperation(value="Provide list of all financial instruments", response = List.class)
	@GetMapping(INSTRUMENTS)
	public List<InstrumentObject> getAllInstruments() {
		List<InstrumentObject> instruments = getOrderBookService().retrieveInstruments();
		if (instruments.isEmpty()) {
			new ResponseEntity<List<InstrumentObject>>(instruments, HttpStatus.NO_CONTENT);
        }
		return instruments;
	}
	
	/**
	 * This method is used to delete instrument
	 * 
	 * @param instrumentName
	 */
	@ApiOperation(value="Delete an existing finacial instrument", response = String.class)
	@DeleteMapping(DELETE_INSTRUMENT_FOR_NAME)
	public String deleteInstrumentForName(@PathVariable("instrumentName") String instrumentName) {
		if (instrumentName != null) {
			getOrderBookService().deleteInstrumentForName(instrumentName);
			return "Instrument : "+instrumentName+" is deleted";
		}
		return "Please provide a valid instrument name";
	}
	
	/**
	 * This method is used to open order book
	 * 
	 * @param instrumentId
	 */
	@ApiOperation(value="Open an order book", response = String.class)
	@PostMapping(OPEN_ORDER_BOOK)
	public String openOrderBook(@PathVariable("instrumentName") String instrumentName) {
		OrderBookObject orderBookObject = new OrderBookObject();
		InstrumentObject instrumentObject = getOrderBookService().retrieveInstrumentByName(instrumentName);
		if(instrumentObject != null) {
			orderBookObject.setStatus("OPEN");
			orderBookObject.setInstrumentId(instrumentObject.getInstrumentId());
			getOrderBookService().openOrderBook(orderBookObject);
		} else {
			return "Order book for "+instrumentName+" can't be opned because there are no instrument present with this name";
		}
	
		return "Order book for "+instrumentName+" is open, you can add orders";
	}
	
	/**
	 * This method is used to close order book
	 * 
	 * @param instrumentId
	 * @param orderBookId
	 */
	@ApiOperation(value="Close an order book", response = String.class)
	@PutMapping(CLOSE_ORDER_BOOK)
	public String closeOrderBook(@PathVariable("instrumentName") String instrumentName, @PathVariable("orderBookId") Long orderBookId) {
		InstrumentObject instrumentObject = getOrderBookService().retrieveInstrumentByName(instrumentName);
		if(instrumentObject != null && instrumentObject.getOrderBooks() != null && !instrumentObject.getOrderBooks().isEmpty()) {
			for(OrderBookObject orderBookObject : instrumentObject.getOrderBooks()) {
				if(orderBookObject.getOrderId().equals(orderBookId)) {
					if("CLOSE".equals(orderBookObject.getStatus())) {
						return "Order book for "+instrumentName+" is already closed";
					} else if("EXECUTED".equals(orderBookObject.getStatus())) {
						return "Order book for "+instrumentName+" is already executed";
					} else {
						orderBookObject.setStatus("CLOSE");
						orderBookObject.setInstrumentId(instrumentObject.getInstrumentId());
						getOrderBookService().closeOrderBook(orderBookObject);
						break;
					}
					
				}
			}
		} else {
			return "Order book for "+instrumentName+" can't be closed because there are no instrument/order book present with provided details";
		}
	
		return "Order book for "+instrumentName+" is closed now, you can execute only orders";
	}
	
	/**
	 * This method is used to execute order book
	 * 
	 * @param instrumentId
	 * @param orderBookId
	 */
	@ApiOperation(value="execute an order book", response = String.class)
	@PutMapping(EXECUTE_ORDER_BOOK)
	public String executeOrderBook(@RequestBody ExecutionParameter executionParameter, @PathVariable("instrumentName") String instrumentName, @PathVariable("orderBookId") Long orderBookId) {
		InstrumentObject instrumentObject = getOrderBookService().retrieveInstrumentByName(instrumentName);
		if(instrumentObject != null && instrumentObject.getOrderBooks() != null && !instrumentObject.getOrderBooks().isEmpty()) {
			for(OrderBookObject orderBookObject : instrumentObject.getOrderBooks()) {
				if(orderBookObject.getOrderId().equals(orderBookId)) {
					if("OPEN".equals(orderBookObject.getStatus())) {
						return "Order book for "+instrumentName+" is open, only closed order book can be executed";
					} else if("EXECUTED".equals(orderBookObject.getStatus())) {
						return "Order book for "+instrumentName+" is already executed";
					} else {
						orderBookObject.setStatus("EXECUTED");
						orderBookObject.setInstrumentId(instrumentObject.getInstrumentId());
						return getOrderBookService().executeOrderBook(orderBookObject, executionParameter);
					}
					
				}
			}
		} else {
			return "Order book for "+instrumentName+" can't be closed because there are no instrument/order book present with provided details";
		}
	
		return "Order book for "+instrumentName+" is Executed now";
	}
	
	/**
	 * Method to add new order.
	 * @param orderDetailObject
	 * @param instrumentName
	 * @param orderBookId
	 * @return
	 */
	@ApiOperation(value="Add new order", response = String.class)
	@PostMapping(ADD_ORDER)
	public String addOrder(@RequestBody OrderDetailObject orderDetailObject, @PathVariable("instrumentName") String instrumentName, @PathVariable("orderBookId") Long orderBookId) {
		InstrumentObject instrumentObject = getOrderBookService().retrieveInstrumentByName(instrumentName);
		if(instrumentObject != null && instrumentObject.getOrderBooks() != null && !instrumentObject.getOrderBooks().isEmpty()) {
			for(OrderBookObject orderBookObject : instrumentObject.getOrderBooks()) {
				if(orderBookObject.getOrderId().equals(orderBookId) && "CLOSE".equalsIgnoreCase(orderBookObject.getStatus())) {
					return "Order Book is already close so you can't add any orders";
				} else {
					orderDetailObject.setInstrumentId(instrumentObject.getInstrumentId());
					orderDetailObject.setOrderBookId(orderBookId);
					orderDetailObject.setStatus("invalid");
					orderDetailObject.setEntryDate(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
					getOrderBookService().addOrder(orderDetailObject);
					return "New order for "+instrumentName+" is added";
				}
			}
		} 
		return "Order book for "+instrumentName+" is not present so no orders can be added";
	}
	

	/**
	 * Method to get the value of orderBookService
	 *
	 * @return the orderBookService
	 */
	public OrderBookService getOrderBookService() {
		return orderBookService;
	}

	/**
	 * Method to set the value for orderBookService
	 *
	 * @param orderBookService the orderBookService to set
	 */
	public void setOrderBookService(final OrderBookService orderBookService) {
		this.orderBookService = orderBookService;
	}
	
	/**
	 * This method is used to provide stats
	 * 
	 * @param instrumentName
	 * @param orderBookId
	 * @return
	 */
	@ApiOperation(value="Method to get statistic for an instrument", response = Stats.class)
	@GetMapping(STATS)
	public Stats getStats(@PathVariable("instrumentName") String instrumentName, @PathVariable("orderBookId") Long orderBookId) {
		Stats stats = null;
		InstrumentObject instrumentObject = getOrderBookService().retrieveInstrumentByName(instrumentName);
		if(instrumentObject != null) {
			stats = getOrderBookService().getStats(instrumentObject.getInstrumentId(),orderBookId);
		}
		return stats;
	}
	
	/**
	 * Method to get order details
	 * 
	 * @param orderId
	 * @return
	 */
	@ApiOperation(value="Method to get detail for an order", response = OrderDetailObject.class)
	@GetMapping(ORDER_DETAIL)
	public OrderDetailObject getOrderDetail(@PathVariable("orderId") Long orderId) {
		OrderDetailObject  orderDetailObject= getOrderBookService().retrieveOrderDetails(orderId);
		return orderDetailObject;
	}

}
