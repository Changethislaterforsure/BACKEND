package com.example.flights.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flights.domain.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
