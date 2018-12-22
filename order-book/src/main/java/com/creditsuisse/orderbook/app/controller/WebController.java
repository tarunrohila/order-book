package com.creditsuisse.orderbook.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.creditsuisse.orderbook.app.constant.PageURLConstants;
import com.creditsuisse.orderbook.app.dto.InstrumentObject;

/**
 * This is controller class that handles mapping to redirect it to index page and other web pages
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Controller
public class WebController extends AbstractController implements PageURLConstants {
	
	/**
	 * Method to load index page.
	 * 
	 * @return index page of order book application
	 */
	@RequestMapping(value =INDEX_URL, method = RequestMethod.GET)
	public String loadIndexPage() {
		return INDEX_PAGE;
	}
	
	@RequestMapping(value =ADD_INSTRUMENT_URL, method = RequestMethod.GET)
	public String addInstrumentPage(ModelMap model) {
		model.addAttribute("instrumentObject",new InstrumentObject());
		return ADD_INSTRUMENT_PAGE;
	}
	
	@RequestMapping(value =ORDER_BOOKS_URL, method = RequestMethod.GET)
	public String orderBooksPage(ModelMap model) {
		return ORDER_BOOKS_PAGE;
	}

}
