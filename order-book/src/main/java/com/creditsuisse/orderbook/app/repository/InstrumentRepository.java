package com.creditsuisse.orderbook.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.creditsuisse.orderbook.app.repository.domain.Instrument;

/**
 * This is repository class which connects to Instrument Table
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Component
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
