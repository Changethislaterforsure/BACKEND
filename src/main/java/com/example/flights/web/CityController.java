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
import com.example.flights.domain.City;
import com.example.flights.service.AirportService;
import com.example.flights.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;
    private final AirportService airportService;

    public CityController(CityService cityService, AirportService airportService) {
        this.cityService = cityService;
        this.airportService = airportService;
    }

    // GET /cities
    @GetMapping
    public List<City> getAll() {
        return cityService.findAll();
    }

    // GET /cities/{id}
    @GetMapping("/{id}")
    public City getOne(@PathVariable Long id) {
        return cityService.findById(id);
    }

    // POST /cities
    @PostMapping
    public City create(@RequestBody City city) {
        return cityService.create(city);
    }

    // PUT /cities/{id}
    @PutMapping("/{id}")
    public City update(@PathVariable Long id, @RequestBody City city) {
        return cityService.update(id, city);
    }

    // DELETE /cities/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }

    // QUESTION 1: What airports are there in each city?
    // GET /cities/{id}/airports
    @GetMapping("/{id}/airports")
    public List<Airport> airportsInCity(@PathVariable Long id) {
        return airportService.findByCity(id);
    }
}