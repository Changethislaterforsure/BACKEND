package com.example.flights.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flights.domain.Airport;
import com.example.flights.service.AirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    // GET /airports
    @GetMapping
    public List<Airport> getAll() {
        return airportService.findAll();
    }

    // GET /airports/{id}
    @GetMapping("/{id}")
    public Airport getOne(@PathVariable Long id) {
        return airportService.findById(id);
    }

    // POST /airports
    @PostMapping
    public Airport create(@RequestBody Airport airport) {
        return airportService.create(airport);
    }

    // PUT /airports/{id}
    @PutMapping("/{id}")
    public Airport update(@PathVariable Long id, @RequestBody Airport airport) {
        return airportService.update(id, airport);
    }

    // DELETE /airports/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        airportService.delete(id);
    }
}