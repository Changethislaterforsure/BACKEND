package com.example.flights.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flights.domain.Airport;
import com.example.flights.repo.AirportRepository;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    public Airport findById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found: " + id));
    }

    public List<Airport> findByCity(Long cityId) {
        return airportRepository.findByCityId(cityId);
    }

    public Airport create(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport update(Long id, Airport updated) {
        Airport existing = findById(id);
        existing.setName(updated.getName());
        existing.setCode(updated.getCode());
        existing.setCity(updated.getCity());
        return airportRepository.save(existing);
    }

    public void delete(Long id) {
        airportRepository.deleteById(id);
    }
}
