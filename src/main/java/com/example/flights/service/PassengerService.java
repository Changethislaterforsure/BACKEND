package com.example.flights.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flights.domain.Passenger;
import com.example.flights.repo.PassengerRepository;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public Passenger findById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found: " + id));
    }

    public Passenger create(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger update(Long id, Passenger updated) {
        Passenger existing = findById(id);
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setCity(updated.getCity());
        return passengerRepository.save(existing);
    }

    public void delete(Long id) {
        passengerRepository.deleteById(id);
    }
}
