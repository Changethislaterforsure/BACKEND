package com.example.flights.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flights.domain.Aircraft;
import com.example.flights.repo.AircraftRepository;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    public Aircraft findById(Long id) {
        return aircraftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aircraft not found: " + id));
    }

    public Aircraft create(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Aircraft update(Long id, Aircraft updated) {
        Aircraft existing = findById(id);
        existing.setType(updated.getType());
        existing.setAirlineName(updated.getAirlineName());
        existing.setNumberOfPassengers(updated.getNumberOfPassengers());
        existing.setAirports(updated.getAirports());
        return aircraftRepository.save(existing);
    }

    public void delete(Long id) {
        aircraftRepository.deleteById(id);
    }
}
