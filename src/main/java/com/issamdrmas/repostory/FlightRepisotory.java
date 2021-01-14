package com.issamdrmas.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.issamdrmas.model.Flight;

@Repository
public interface FlightRepisotory extends JpaRepository<Flight, Long> {
    @Query("SELECT p FROM Flight p WHERE p.pilotCode LIKE :c")
	public List<Flight> getPiloteCode(@Param("c")String code);
}

