package com.example.flights.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flights.domain.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
