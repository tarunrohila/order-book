package com.creditsuisse.orderbook.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.creditsuisse.orderbook.app.repository.domain.OrderDetail;

/**
 * @author Tarun Rohila
 * @since Nov 30, 2018
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	/**
	 * Method to find userdetails by email.
	 * 
	 * @param email - email
	 * @return list of userdetails.
	 */
	@Query("SELECT o FROM OrderDetail o WHERE o.instrumentId = :instrumentId")
	List<OrderDetail> findOrderDetailsByInstrumentId(@Param("instrumentId") final Long instrumentId);

}
