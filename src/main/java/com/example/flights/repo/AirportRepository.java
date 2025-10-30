package com.example.flights.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flights.domain.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    // used for: GET /cities/{id}/airports
    List<Airport> findByCityId(Long cityId);
}
