package com.creditsuisse.orderbook.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.creditsuisse.orderbook.app.dto.InstrumentObject;
import com.creditsuisse.orderbook.app.repository.domain.Instrument;

/**
 * This class is used to map Object to Entity and visa verca
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@Component
public class InstrumentMapper {

	/**
	 * Method to map entity list of entity of Instrument to list of object of InstrumentObject
	 * 
	 * @param instruments
	 * @return list of objects of InstrumentObject
	 */
	public List<InstrumentObject> mapInstrumentEntitytoObject(List<Instrument> instruments) {
		List<InstrumentObject> instrumentObjectList = new ArrayList<>(); 
		for(Instrument instrument :instruments) {
			InstrumentObject instrumentObject = new InstrumentObject();
			instrumentObject.setInstrumentId(instrument.getOid());
			instrumentObject.setInstrumentName(instrument.getName());
			instrumentObject.setStatus(instrument.isStatus());
			instrumentObjectList.add(instrumentObject);
		}
		return instrumentObjectList;
	}

	/**
	 * Method to map Instrument object to entity
	 * 
	 * @param instrumentObject
	 * @return entity of instrumen
	 */
	public Instrument mapInstrumentObjectToEntity(InstrumentObject instrumentObject) {
		Instrument instrument = new Instrument();
		instrument.setName(instrumentObject.getInstrumentName());
		instrument.setStatus(instrumentObject.isStatus());
		return instrument;
	}

}
