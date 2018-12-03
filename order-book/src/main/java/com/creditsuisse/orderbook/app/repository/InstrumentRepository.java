package com.creditsuisse.orderbook.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.creditsuisse.orderbook.app.repository.domain.Instrument;

/**
 * This is repository class which connects to Instrument Table
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Repository
@Transactional
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

	@Modifying
	@Query("DELETE FROM Instrument WHERE name = :instrumentName")
	void deleteInstrumentForName(@Param("instrumentName") final String instrumentName);

	@Query("SELECT i  FROM Instrument i WHERE i.name = :instrumentName")
	Instrument findInstrumentByName(@Param("instrumentName") final String instrumentName);

}
