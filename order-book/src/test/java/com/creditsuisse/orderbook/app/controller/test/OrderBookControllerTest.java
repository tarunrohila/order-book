package com.creditsuisse.orderbook.app.controller.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.creditsuisse.orderbook.app.controller.OrderBookController;
import com.creditsuisse.orderbook.app.dto.ExecutionParameter;
import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderBookObject;
import com.creditsuisse.orderbook.app.dto.StatusEnum;
import com.creditsuisse.orderbook.app.service.OrderBookService;
import com.creditsuisse.orderbook.app.service.impl.OrderBookServiceImpl;

/**
 * @author Tarun Rohila
 * @since Dec 4, 2018
 */

@RunWith(MockitoJUnitRunner.class)
public class OrderBookControllerTest {
	
	private static OrderBookController orderBookController ;
	
	@Mock
    OrderBookService orderBookService;
	
	@InjectMocks
	OrderBookServiceImpl orderBookServiceImpl;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderBookController = new  OrderBookController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		orderBookController = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddInstument() {
		InstrumentObject orderBookObject = new InstrumentObject();
		orderBookObject.setInstrumentId(new Long(101));
		orderBookObject.setInstrumentName("TCS");
		orderBookController.setOrderBookService(orderBookService);
		Mockito.doNothing().when(orderBookService).addInstrument(orderBookObject);
		System.out.println(orderBookController.addInstument(orderBookObject));
		assertNotNull(orderBookController.addInstument(orderBookObject));
	}
	
	@Test
	public void testGetAllInstrumentsEmptyList() {
		InstrumentObject orderBookObject = new InstrumentObject();
		orderBookObject.setInstrumentId(new Long(101));
		orderBookObject.setInstrumentName("TCS");
		orderBookController.setOrderBookService(orderBookService);
		List<InstrumentObject> instruments = new ArrayList<>();
		Mockito.when((orderBookService).retrieveInstruments()).thenReturn(instruments);
		System.out.println(orderBookController.getAllInstruments());
		assertNotNull(orderBookController.getAllInstruments());
	}
	@Test
	public void testGetAllInstruments() {
		InstrumentObject orderBookObject = new InstrumentObject();
		orderBookObject.setInstrumentId(new Long(101));
		orderBookObject.setInstrumentName("TCS");
		orderBookController.setOrderBookService(orderBookService);
		List<InstrumentObject> instruments = new ArrayList<>();
		InstrumentObject instrumentObject = new InstrumentObject();
		instrumentObject.setInstrumentId(new Long(101));
		instrumentObject.setInstrumentName("TCS");
		instruments.add(instrumentObject);
		Mockito.when((orderBookService).retrieveInstruments()).thenReturn(instruments);
		System.out.println(orderBookController.getAllInstruments());
		assertNotNull(orderBookController.getAllInstruments());
	}
	@Test
	public void testDeleteInstrumentForName() {
		orderBookController.setOrderBookService(orderBookService);
		Mockito.doNothing().when(orderBookService).deleteInstrumentForName("TCS");
		System.out.println(orderBookController.deleteInstrumentForName("TCS"));
		assertNotNull(orderBookController.deleteInstrumentForName("TCS"));
	}
	
	@Test
	public void testDeleteInstrumentForNameNull() {
		orderBookController.setOrderBookService(orderBookService);
		//Mockito.doNothing().when(orderBookService).deleteInstrumentForName("TCS");
		System.out.println(orderBookController.deleteInstrumentForName(null));
		assertNotNull(orderBookController.deleteInstrumentForName(null));
	}
	
	
	@Test
	public void testOpenOrderBook() {
		orderBookController.setOrderBookService(orderBookService);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(new InstrumentObject());
		Mockito.doNothing().when(orderBookService).openOrderBook(Mockito.any(OrderBookObject.class));
		System.out.println(orderBookController.openOrderBook("TCS"));
		assertNotNull(orderBookController.openOrderBook("TCS"));
	}
	
	@Test
	public void testOpenOrderBookNullInstrument() {
		orderBookController.setOrderBookService(orderBookService);
		//Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(new InstrumentObject());
		//Mockito.doNothing().when(orderBookService).openOrderBook(Mockito.any(OrderBookObject.class));
		System.out.println(orderBookController.openOrderBook(null));
		assertNotNull(orderBookController.openOrderBook(null));
	}
	
	@Test
	public void testCloseOrderBook() {
		orderBookController.setOrderBookService(orderBookService);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(null);
		System.out.println(orderBookController.closeOrderBook("TCS"));
		assertNotNull(orderBookController.closeOrderBook("TCS"));
	}
	@Test
	public void testCloseOrderBookOrderBookNull() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		instrumentObject.setOrderBooks(null);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		System.out.println(orderBookController.closeOrderBook("TCS"));
		assertNotNull(orderBookController.closeOrderBook("TCS"));
	}
	
	@Test
	public void testCloseOrderBookOrderBookEmpty() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		instrumentObject.setOrderBooks(new HashSet<>());
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		System.out.println(orderBookController.closeOrderBook("TCS"));
		assertNotNull(orderBookController.closeOrderBook("TCS"));
	}
	
	@Test
	public void testCloseOrderBookOrderBookAlreadyClosed() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		Set<OrderBookObject> orderBooks = new HashSet<>();
		OrderBookObject book = new OrderBookObject();
		book.setOrderId(new Long(101));
		book.setStatus(StatusEnum.CLOSE);
		orderBooks.add(book);
		instrumentObject.setOrderBooks(orderBooks);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		System.out.println(orderBookController.closeOrderBook("TCS"));
		assertNotNull(orderBookController.closeOrderBook("TCS"));
	}
	
	@Test
	public void testCloseOrderBookOrderBookNotClosed() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		Set<OrderBookObject> orderBooks = new HashSet<>();
		OrderBookObject book = new OrderBookObject();
		book.setOrderId(new Long(101));
		book.setStatus(StatusEnum.OPEN);
		orderBooks.add(book);
		instrumentObject.setOrderBooks(orderBooks);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		System.out.println(orderBookController.closeOrderBook("TCS"));
		assertNotNull(orderBookController.closeOrderBook("TCS"));
	}
	
	@Test
	public void testCloseOrderBookOrderBookAlredyExecuted() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		Set<OrderBookObject> orderBooks = new HashSet<>();
		OrderBookObject book = new OrderBookObject();
		book.setOrderId(new Long(101));
		book.setStatus(StatusEnum.EXECUTED);
		orderBooks.add(book);
		instrumentObject.setOrderBooks(orderBooks);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		System.out.println(orderBookController.closeOrderBook("TCS"));
		assertNotNull(orderBookController.closeOrderBook("TCS"));
	}
	
	@Test
	public void testExecuteOrderBook() {
		orderBookController.setOrderBookService(orderBookService);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(null);
		System.out.println(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
		assertNotNull(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
	}
	@Test
	public void testExecuteOrderBookOrderBookNull() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		instrumentObject.setOrderBooks(null);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		System.out.println(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
		assertNotNull(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
	}
	
	@Test
	public void testExecuteOrderBookOrderBookEmpty() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		instrumentObject.setOrderBooks(new HashSet<>());
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		System.out.println(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
		assertNotNull(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
	}
	
	@Test
	public void testExecuteOrderBookOrderBookAlreadyClosed() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		Set<OrderBookObject> orderBooks = new HashSet<>();
		OrderBookObject book = new OrderBookObject();
		book.setOrderId(new Long(101));
		book.setStatus(StatusEnum.CLOSE);
		orderBooks.add(book);
		instrumentObject.setOrderBooks(orderBooks);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		//Mockito.when(orderBookService.executeOrderBook(book, executionParameter)).thenReturn("Order Book is executed");
		System.out.println(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
		assertNotNull(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
	}
	
	@Test
	public void testExecuteOrderBookOrderBookEXECUTED() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		Set<OrderBookObject> orderBooks = new HashSet<>();
		OrderBookObject book = new OrderBookObject();
		book.setOrderId(new Long(101));
		book.setStatus(StatusEnum.EXECUTED);
		orderBooks.add(book);
		instrumentObject.setOrderBooks(orderBooks);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		System.out.println(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
		assertNotNull(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
	}
	
	@Test
	public void testExecuteOrderBookOrderBookOpen() {
		orderBookController.setOrderBookService(orderBookService);
		InstrumentObject instrumentObject = new InstrumentObject();
		Set<OrderBookObject> orderBooks = new HashSet<>();
		OrderBookObject book = new OrderBookObject();
		book.setOrderId(new Long(101));
		book.setStatus(StatusEnum.OPEN);
		orderBooks.add(book);
		instrumentObject.setOrderBooks(orderBooks);
		Mockito.when(orderBookService.retrieveInstrumentByName("TCS")).thenReturn(instrumentObject);
		System.out.println(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
		assertNotNull(orderBookController.executeOrderBook(Mockito.any(ExecutionParameter.class),"TCS"));
	}
	
	@Test
	public void testGetOrderBookService() {
		orderBookController.setOrderBookService(orderBookService);
		System.out.println(orderBookController.getOrderBookService());
		assertNotNull(orderBookController.getOrderBookService());
	}
	
	@Test
	public void testSetOrderBookService() {
		orderBookController.setOrderBookService(orderBookService);
	}




}
