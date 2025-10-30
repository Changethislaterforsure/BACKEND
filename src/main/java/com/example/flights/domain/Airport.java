package com.example.flights.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String name;
    @Column(nullable = false, unique = true) private String code;

    @ManyToOne(optional = false)
    @JsonBackReference // prevents recursion with City.airports
    private City city;

    @ManyToMany(mappedBy = "airports")
    @JsonIgnore // avoid deep cycles when serializing
    private Set<Aircraft> aircraft = new HashSet<>();

    public Airport() {}
    public Airport(String name, String code, City city) {
        this.name = name; this.code = code; this.city = city;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
    public Set<Aircraft> getAircraft() { return aircraft; }
    public void setAircraft(Set<Aircraft> aircraft) { this.aircraft = aircraft; }
}
