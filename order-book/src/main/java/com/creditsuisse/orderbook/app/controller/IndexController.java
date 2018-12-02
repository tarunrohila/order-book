package com.creditsuisse.orderbook.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.creditsuisse.orderbook.app.constant.PageURLConstants;

/**
 * This is controller class that handles mapping to redirect it to index page
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Controller
public class IndexController extends AbstractController implements PageURLConstants {
	
	/**
	 * Method to load index page.
	 * 
	 * @return index page of order book application
	 */
	@RequestMapping(value =INDEX_URL, method = RequestMethod.GET)
	public String loadIndexPage() {
		LOGGER.info("Index page is loaded");
		return INDEX_PAGE;
	}

}
