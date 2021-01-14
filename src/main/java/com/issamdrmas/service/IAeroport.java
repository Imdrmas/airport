package com.issamdrmas.service;

import org.springframework.data.domain.Page;

import com.issamdrmas.model.Flight;

public interface IAeroport {
public Page<Flight> getAllVols(String mc, int page, int size);
public Page<Flight> getAllAvions(String mc, int page, int size);
public Page<Flight> getAllPilotes(String mc, int page, int size);
}
