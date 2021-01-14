package com.issamdrmas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.issamdrmas.model.Flight;
import com.issamdrmas.repostory.PlaneRepisotory;
import com.issamdrmas.repostory.PilotRepisotory;
import com.issamdrmas.repostory.FlightRepisotory;

public class AeroprtImpl implements IAeroport {
	
	
	@Autowired
    PlaneRepisotory avionRepisotory;
	@Autowired
	FlightRepisotory volRepisotory;
	@Autowired
	PilotRepisotory piloteRepisotory;

	@Override
	public Page<Flight> getAllVols(String mc, int page, int size) {
		return null;		
	}

	@Override
	public Page<Flight> getAllAvions(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Flight> getAllPilotes(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
