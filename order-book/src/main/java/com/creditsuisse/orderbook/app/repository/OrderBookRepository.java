package com.creditsuisse.orderbook.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.creditsuisse.orderbook.app.repository.domain.OrderBook;

/**
 * @author Tarun Rohila
 * @since Dec 3, 2018
 */
@Repository
@Transactional
public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {

	@Modifying
	@Query("UPDATE OrderBook SET status= :status WHERE oid= :oid")
	void closeOrderBook(@Param("status") String status, @Param("oid") Long oid);

	@Modifying
	@Query("UPDATE OrderBook SET status= :status WHERE oid= :oid")
	void executeOrderBook(String status, Long orderId);

}
