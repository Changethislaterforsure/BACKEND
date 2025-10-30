package com.example.flights.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flights.domain.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
