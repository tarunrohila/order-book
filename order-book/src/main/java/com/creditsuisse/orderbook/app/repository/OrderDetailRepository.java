package com.creditsuisse.orderbook.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditsuisse.orderbook.app.repository.domain.OrderDetail;

/**
 * @author Tarun Rohila
 * @since Nov 30, 2018
 */
@Transactional
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	/**
	 * Method to find userdetails by email.
	 * 
	 * @param email - email
	 * @return list of userdetails.
	 */
	/*@Query("SELECT o FROM Order o WHERE o.instrumentId = :instrumentId")
	List<Order> findOrderDetailsByInstrumentId(@Param("instrumentId") final Long instrumentId);*/

}
