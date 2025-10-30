package com.example.flights.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flights.domain.City;
import com.example.flights.repo.CityRepository;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found: " + id));
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

    public City update(Long id, City updated) {
        City existing = findById(id);
        existing.setName(updated.getName());
        existing.setState(updated.getState());
        existing.setPopulation(updated.getPopulation());
        return cityRepository.save(existing);
    }

    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
