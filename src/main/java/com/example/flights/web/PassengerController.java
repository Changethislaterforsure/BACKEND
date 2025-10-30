package com.example.flights.web;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flights.domain.Aircraft;
import com.example.flights.domain.Airport;
import com.example.flights.domain.Passenger;
import com.example.flights.repo.PassengerRepository;
import com.example.flights.service.PassengerService;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;
    private final PassengerRepository passengerRepository;

    public PassengerController(PassengerService passengerService,
                               PassengerRepository passengerRepository) {
        this.passengerService = passengerService;
        this.passengerRepository = passengerRepository;
    }

    // GET /passengers
    @GetMapping
    public List<Passenger> getAll() {
        return passengerService.findAll();
    }

    // GET /passengers/{id}
    @GetMapping("/{id}")
    public Passenger getOne(@PathVariable Long id) {
        return passengerService.findById(id);
    }

    // POST /passengers
    @PostMapping
    public Passenger create(@RequestBody Passenger passenger) {
        return passengerService.create(passenger);
    }

    // PUT /passengers/{id}
    @PutMapping("/{id}")
    public Passenger update(@PathVariable Long id, @RequestBody Passenger passenger) {
        return passengerService.update(id, passenger);
    }

    // DELETE /passengers/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        passengerService.delete(id);
    }

    // QUESTION 2: What aircraft has each passenger flown on?
    // GET /passengers/{id}/aircraft
    @GetMapping("/{id}/aircraft")
    public Set<Aircraft> aircraftForPassenger(@PathVariable Long id) {
        Passenger p = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found: " + id));
        return p.getAircraft();
    }

    // QUESTION 4: What airports have passengers used?
    // (Passenger -> Aircraft -> Airports)
    // GET /passengers/{id}/airports
    @GetMapping("/{id}/airports")
    public Set<Airport> airportsUsedByPassenger(@PathVariable Long id) {
        Passenger p = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found: " + id));

        return p.getAircraft().stream()
                .flatMap(ac -> ac.getAirports().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
