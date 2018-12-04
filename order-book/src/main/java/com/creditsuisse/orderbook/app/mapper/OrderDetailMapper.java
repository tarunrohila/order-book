package com.creditsuisse.orderbook.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.creditsuisse.orderbook.app.dto.OrderDetailObject;
import com.creditsuisse.orderbook.app.repository.domain.OrderDetail;

/**
 * This class is created to map object to entity and vica versa.
 * 
 * @author Tarun Rohila
 * @since Nov 30, 2018
 */
@Component
public class OrderDetailMapper {

	public List<OrderDetailObject> mapOrderDetailEntitytoObject(List<OrderDetail> orderDetails) {
		List<OrderDetailObject> orders = new ArrayList<>();
		for(OrderDetail orderDetail : orderDetails) {
			OrderDetailObject orderDetailObject = new OrderDetailObject();
			/*orderDetailObject.setExecutionPrice(orderDetail.getExecutionPrice());
			orderDetailObject.setExecutionQuantity(orderDetail.getExecutionQuantity());*/
			//orderDetailObject.setInstrumentId(orderDetail.getInstrumentId());
			//orderDetailObject.setOrderCreationDate(orderDetail.getOrderCreationDate());
			orderDetailObject.setOrderId(orderDetail.getOid());
			orderDetailObject.setOrderType(orderDetail.getOrderType());
			orderDetailObject.setStatus(orderDetail.getStatus());
			//orderDetailObject.setTransactionType(orderDetail.getTransactionType());
			//orderDetailObject.setInstrument(orderDetail.getInstrument());
			orders.add(orderDetailObject);
		}
		return orders;
	}

	public OrderDetail mapOrderDetailObjectToEntity(OrderDetailObject orderDetailObject) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderCreationDate(orderDetailObject.getEntryDate());
		orderDetail.setOrderType(orderDetailObject.getOrderType());
		if("market".equalsIgnoreCase(orderDetailObject.getOrderType())) {
			orderDetail.setPrice(new Long(0));
		} else {
			orderDetail.setPrice(orderDetailObject.getPrice());
		}
		orderDetail.setQuantity(orderDetailObject.getQuantity());
		orderDetail.setStatus(orderDetailObject.getStatus());
		orderDetail.setOrderBookId(orderDetailObject.getOrderBookId());
		orderDetail.setInstrumentId(orderDetailObject.getInstrumentId());
		return orderDetail;
	}

}
