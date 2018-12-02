package com.creditsuisse.orderbook.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.creditsuisse.orderbook.app.constant.PageURLConstants;
import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderDetailObject;
import com.creditsuisse.orderbook.app.service.OrderBookService;

/**
 * This is controller class to manage all request mappings for order book.
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Controller
public class OrderBookController extends AbstractController implements PageURLConstants {
	
	/*
	 * Autowired dependency to use OrderBookService object;
	 */
	@Autowired
	private OrderBookService orderBookService;
	
	/**
	 * This method loads instruments page
	 * 
	 * @return instruments page
	 */
	@RequestMapping(value =INSTRUMENTS_URL, method = RequestMethod.GET)
	public String loadInstrumentPage(ModelMap model) {
		List<InstrumentObject> instruments = getOrderBookService().retrieveInstruments();
		model.addAttribute("instruments",instruments);
		LOGGER.info("Instrument page is loaded");
		return INSTRUMENTS_PAGE;
	}
	
	/**
	 * This method loads add instrument page
	 * 
	 * @return add instrument page
	 */
	@RequestMapping(value =ADD_INSTRUMENT_URL, method = RequestMethod.GET)
	public String loadAddOrderBookPage(ModelMap model) {
		LOGGER.info("Add instrument page is loaded");
		model.addAttribute("instrumentObject",new InstrumentObject());
		return ADD_INSTRUMENT_PAGE;
	}
	
	/**
	 * This method is toggles the status of instrument as open or close
	 * 
	 * @param instrumentId
	 * @param model
	 */
	@RequestMapping({ TOGGLE_STATUS })
	public void toggleStatus(@RequestParam("instrumentId") Integer instrumentId, ModelMap model) {
		if ((instrumentId != null) && (instrumentId.intValue() != 0)) {
			getOrderBookService().toggleStatus(instrumentId);
		}
	}
	
	/**
	 * This method add order book page
	 * 
	 * @return order book page
	 */
	@PostMapping(value=ADD_INSTRUMENT)
	public String addOrderBook(@ModelAttribute("orderBookObject") InstrumentObject orderBookObject, ModelMap model) {
		getOrderBookService().addInstrument(orderBookObject);
		return INSTRUMENTS_REDIRECT;
	}
	
	/**
	 * This method is used to delete order book
	 * 
	 * @param instrumentId
	 * @param model
	 */
	@RequestMapping(value = DELETE_INSTRUMENT_FOR_ID, method = RequestMethod.GET)
	public String deleteInstrument(@PathVariable("instrumentId") Long instrumentId, ModelMap model) {
		if ((instrumentId != null) && (instrumentId != 0)) {
			getOrderBookService().deleteInstrument(instrumentId);
		}
		return INSTRUMENTS_REDIRECT;
	}
	
	/**
	 * This method is used to delete order book
	 * 
	 * @param instrumentId
	 * @param model
	 */
	@RequestMapping(value = ORDERS_URL, method = RequestMethod.GET)
	public String loadOrdersPage(ModelMap model) {
		List<InstrumentObject> instruments = getOrderBookService().retrieveInstruments();
		List<OrderDetailObject> orders = getOrderBookService().retrieveOrders();
		model.addAttribute("instruments",instruments);
		model.addAttribute("orders",orders);
		return ORDERS_PAGE;
	}
	
	/**
	 * This method is used to buy order
	 * 
	 * @param buyOrderType
	 * @param limitBuyPrice
	 * @param buyQty
	 * @param model
	 * @return
	 */
	@RequestMapping(value = BUY_ORDER, method = RequestMethod.POST)
	public String buyOrder(@RequestParam("instrumentId") String instrumentId,  @RequestParam("buyOrderType") String buyOrderType, @RequestParam("limitBuyPrice") Long limitBuyPrice, @RequestParam("buyQty") Integer buyQty, ModelMap model) {
		OrderDetailObject orderDetailObject = new OrderDetailObject();
		orderDetailObject.setInstrumentId(Long.valueOf(instrumentId));
		orderDetailObject.setOrderType(buyOrderType);
		orderDetailObject.setQuantity(buyQty);
		if(limitBuyPrice != null && limitBuyPrice.intValue() != 0) {
			orderDetailObject.setPrice(limitBuyPrice);
		}
		getOrderBookService().buyOrder(orderDetailObject);
		return ORDERS_REDIRECT;
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
	@RequestMapping(value = SELL_ORDER, method = RequestMethod.POST)
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

}
