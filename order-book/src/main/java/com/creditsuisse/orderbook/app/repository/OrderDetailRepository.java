package com.creditsuisse.orderbook.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.creditsuisse.orderbook.app.repository.domain.OrderDetail;

/**
 * @author Tarun Rohila
 * @since Nov 30, 2018
 */
@Transactional
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

	@Modifying
	@Query("UPDATE OrderDetail SET status= :status WHERE oid= :orderId")
	void setOrderStatus(@Param("status") final String status, @Param("orderId") final Long orderId);

	@Modifying
	@Query("UPDATE OrderDetail SET status= :status, quantity= :qty  WHERE oid= :orderId")
	void setOrderStatusAndQty(@Param("status") final String status, @Param("orderId") final Long orderId, @Param("qty") final int qty);

	@Modifying
	@Query("UPDATE OrderDetail SET status= :status, price= :price  WHERE oid= :orderId")
	void setOrderStatusAndPrice(@Param("status") final String status, @Param("orderId") final Long orderId, @Param("price") final Long price);
	
}
