package com.example.flights.web;

import java.util.List;
import java.util.Set;

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
import com.example.flights.repo.AircraftRepository;
import com.example.flights.service.AircraftService;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;
    private final AircraftRepository aircraftRepository;

    public AircraftController(AircraftService aircraftService,
                              AircraftRepository aircraftRepository) {
        this.aircraftService = aircraftService;
        this.aircraftRepository = aircraftRepository;
    }

    // GET /aircraft
    @GetMapping
    public List<Aircraft> getAll() {
        return aircraftService.findAll();
    }

    // GET /aircraft/{id}
    @GetMapping("/{id}")
    public Aircraft getOne(@PathVariable Long id) {
        return aircraftService.findById(id);
    }

    // POST /aircraft
    @PostMapping
    public Aircraft create(@RequestBody Aircraft aircraft) {
        return aircraftService.create(aircraft);
    }

    // PUT /aircraft/{id}
    @PutMapping("/{id}")
    public Aircraft update(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        return aircraftService.update(id, aircraft);
    }

    // DELETE /aircraft/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        aircraftService.delete(id);
    }

    // QUESTION 3: What airports do aircraft take off from and land at?
    // GET /aircraft/{id}/airports
    @GetMapping("/{id}/airports")
    public Set<Airport> airportsForAircraft(@PathVariable Long id) {
        Aircraft a = aircraftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aircraft not found: " + id));
        return a.getAirports();
    }
}
