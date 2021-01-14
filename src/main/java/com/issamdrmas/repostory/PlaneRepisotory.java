package com.issamdrmas.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.issamdrmas.model.Plane;

public interface PlaneRepisotory extends JpaRepository<Plane, Long> {
	@Query("SELECT u.id FROM Plane u WHERE u.id LIKE CONCAT('%',:id,'%')")
	String findUsersWithPartOfName(String id);

}

