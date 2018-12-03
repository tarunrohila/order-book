package com.creditsuisse.orderbook.app.controller;

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
import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderBookObject;
import com.creditsuisse.orderbook.app.service.OrderBookService;

/**
 * This is controller class to manage all request mappings for order book.
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
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
	@PostMapping(value=ADD_INSTRUMENT)
	public String addInstument(@RequestBody InstrumentObject orderBookObject) {
		getOrderBookService().addInstrument(orderBookObject);
		return "New Instrument "+orderBookObject.getInstrumentName()+" is created" ;
	}
	
	/**
	 * This method returns all instruments
	 */
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
	@DeleteMapping(DELETE_INSTRUMENT_FOR_NAME)
	public String deleteInstrumentForName(@PathVariable("instrumentName") String instrumentName) {
		if (instrumentName != null) {
			getOrderBookService().deleteInstrumentForName(instrumentName);
		}
		return "Instrument : "+instrumentName+" is deleted";
	}
	
	/**
	 * This method is used to open order book
	 * 
	 * @param instrumentId
	 */
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
	 */
	@PutMapping(CLOSE_ORDER_BOOK)
	public String closeOrderBook(@PathVariable("instrumentName") String instrumentName, @PathVariable("orderBookId") Long orderBookId) {
		InstrumentObject instrumentObject = getOrderBookService().retrieveInstrumentByName(instrumentName);
		if(instrumentObject != null && instrumentObject.getOrderBooks() != null && !instrumentObject.getOrderBooks().isEmpty()) {
			for(OrderBookObject orderBookObject : instrumentObject.getOrderBooks()) {
				if(orderBookObject.getOrderId().equals(orderBookId)) {
					orderBookObject.setStatus("CLOSE");
					orderBookObject.setInstrumentId(instrumentObject.getInstrumentId());
					//getOrderBookService().closeOrderBook(orderBookObject);
					getOrderBookService().addInstrument(instrumentObject);
				}
			}
		} else {
			return "Order book for "+instrumentName+" can't be closed because there are no instrument/order book present with provided details";
		}
	
		return "Order book for "+instrumentName+" is closed now, you can execute orders";
	}
	
	/**
	 * This method is used to buy order
	 * 
	 * @param sellOrderType
	 * @param limitSellPrice
	 * @param sellQty
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value = SELL_ORDER, method = RequestMethod.POST)
	public String sellOrder(@RequestParam("instrumentId") String instrumentId, @RequestParam("sellOrderType") String sellOrderType, @RequestParam("limitSellPrice") Long limitSellPrice, @RequestParam("sellQty") Integer sellQty, ModelMap model) {
		OrderDetailObject orderDetailObject = new OrderDetailObject();
		orderDetailObject.setInstrumentId(Long.valueOf(instrumentId));
		orderDetailObject.setOrderType(sellOrderType);
		orderDetailObject.setQuantity(sellQty);
		if(limitSellPrice != null && limitSellPrice.intValue() != 0) {
			orderDetailObject.setPrice(limitSellPrice);
		}
		getOrderBookService().sellOrder(orderDetailObject);
		return ORDERS_REDIRECT;
	}*/

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

}
