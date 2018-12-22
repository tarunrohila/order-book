package com.creditsuisse.orderbook.app.service.impl.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.creditsuisse.orderbook.app.dto.ExecutionParameter;
import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.dto.OrderBookObject;
import com.creditsuisse.orderbook.app.dto.OrderDetailObject;
import com.creditsuisse.orderbook.app.dto.StatusEnum;
import com.creditsuisse.orderbook.app.mapper.InstrumentMapper;
import com.creditsuisse.orderbook.app.mapper.OrderBookMapper;
import com.creditsuisse.orderbook.app.mapper.OrderDetailMapper;
import com.creditsuisse.orderbook.app.repository.InstrumentRepository;
import com.creditsuisse.orderbook.app.repository.OrderBookRepository;
import com.creditsuisse.orderbook.app.repository.OrderDetailRepository;
import com.creditsuisse.orderbook.app.repository.domain.Instrument;
import com.creditsuisse.orderbook.app.service.impl.OrderBookServiceImpl;

/**
 * @author Tarun Rohila
 * @since Dec 4, 2018
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderBookServiceImplTest {

	private static OrderBookServiceImpl orderBookServiceImpl;

	@Mock
	private InstrumentMapper instrumentMapper;

	@Mock
	private OrderDetailMapper orderDetailMapper;

	@Mock
	private OrderBookMapper orderBookMapper;

	@Mock
	private InstrumentRepository instrumentRepository;

	@Mock
	private OrderDetailRepository orderDetailRepository;

	@Mock
	private OrderBookRepository orderBookRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderBookServiceImpl = new OrderBookServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		orderBookServiceImpl = null;
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
	public void testRetrieveInstruments() {
		List<InstrumentObject> instrumentObjects = new ArrayList<>();
		InstrumentObject instrumentObject = new InstrumentObject();
		instrumentObject.setInstrumentId(new Long(0));
		instrumentObject.setInstrumentName("TCS");
		instrumentObjects.add(instrumentObject);
		List<Instrument> instruments = new ArrayList<>();
		Instrument instrument = new Instrument();
		instrument.setOid(new Long(101));
		instrument.setName("TCS");
		orderBookServiceImpl.setInstrumentMapper(instrumentMapper);
		orderBookServiceImpl.setInstrumentRepository(instrumentRepository);
		// Mockito.when(instrumentMapper.mapInstrumentEntitytoObjectList(new
		// ArrayList<>())).thenReturn(instrumentObjects);
		Mockito.when(instrumentRepository.findAll()).thenReturn(instruments);
		Assert.assertNotNull(orderBookServiceImpl.retrieveInstruments());
	}

	@Test
	public void testAddInstrument() {
		orderBookServiceImpl.setInstrumentMapper(instrumentMapper);
		orderBookServiceImpl.setInstrumentRepository(instrumentRepository);
		Assert.assertNotNull(orderBookServiceImpl.retrieveInstruments());
	}

	@Test
	public void testDeleteInstrument() {
		orderBookServiceImpl.setInstrumentRepository(instrumentRepository);
	}

	@Test
	public void testDeleteInstrumentForName() {
		orderBookServiceImpl.setInstrumentRepository(instrumentRepository);
	}
	
	@Test
	public void testRetrieveInstrumentByName() {
		Instrument instrument = new Instrument();
		instrument.setOid(new Long(101));
		instrument.setName("TCS");
		orderBookServiceImpl.setInstrumentMapper(instrumentMapper);
		orderBookServiceImpl.setInstrumentRepository(instrumentRepository);
		Assert.assertNotNull(orderBookServiceImpl.retrieveInstruments());
	}
	
	@Test
	public void testOpenOrderBook() {
		Instrument instrument = new Instrument();
		instrument.setOid(new Long(101));
		instrument.setName("TCS");
		orderBookServiceImpl.setOrderBookMapper(orderBookMapper);
		orderBookServiceImpl.setOrderBookRepository(orderBookRepository);
	}
	
	@Test
	public void testCloseOrderBook() {
		Instrument instrument = new Instrument();
		instrument.setOid(new Long(101));
		instrument.setName("TCS");
		orderBookServiceImpl.setOrderBookRepository(orderBookRepository);
	}
	
	@Test
	public void testAddOrder() {
		Instrument instrument = new Instrument();
		instrument.setOid(new Long(101));
		instrument.setName("TCS");
		orderBookServiceImpl.setOrderDetailMapper(orderDetailMapper);
		orderBookServiceImpl.setOrderDetailRepository(orderDetailRepository);
	}
	@Test
	public void testExecuteOrderBook() {
		OrderBookObject orderBookObject = new OrderBookObject();
		orderBookObject.setInstrumentId(new Long(101));
		orderBookObject.setOrderId(new Long(101));
		orderBookObject.setStatus(StatusEnum.OPEN);
		ExecutionParameter executionParameter = new ExecutionParameter();
		executionParameter.setExecutionPrice(new Long(101));
		executionParameter.setExecutionQuantity(new Long(100));
		Set<OrderDetailObject> orders = new HashSet<>();
		OrderDetailObject orderDetail = new OrderDetailObject();
		orderDetail.setInstrumentId(new Long(101));
		orderDetail.setOrderBookId(new Long(101));
		orderDetail.setOrderType("limit");
		orderDetail.setPrice(new Long(101));
		orderDetail.setQuantity(10);
		orderDetail.setStatus("valid");
		orders.add(orderDetail);
		orderBookObject.setOrders(orders);
		orderBookServiceImpl.setOrderDetailMapper(orderDetailMapper);
		orderBookServiceImpl.setOrderDetailRepository(orderDetailRepository);
	}

}
