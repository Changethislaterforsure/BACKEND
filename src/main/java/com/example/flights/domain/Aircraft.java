package com.example.flights.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String type;
    @Column(nullable = false) private String airlineName;
    @Column(nullable = false) private int numberOfPassengers;

    // Aircraft ↔ Airport (owning side)
    @ManyToMany
    @JoinTable(name = "aircraft_airport",
            joinColumns = @JoinColumn(name = "aircraft_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id"))
    private Set<Airport> airports = new HashSet<>();

    // Inverse side of Passenger ↔ Aircraft (not required for queries, but useful)
    @ManyToMany(mappedBy = "aircraft")
    @JsonIgnore
    private Set<Passenger> passengers = new HashSet<>();

    public Aircraft() {}
    public Aircraft(String type, String airlineName, int numberOfPassengers) {
        this.type = type; this.airlineName = airlineName; this.numberOfPassengers = numberOfPassengers;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getAirlineName() { return airlineName; }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }
    public int getNumberOfPassengers() { return numberOfPassengers; }
    public void setNumberOfPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }
    public Set<Airport> getAirports() { return airports; }
    public void setAirports(Set<Airport> airports) { this.airports = airports; }
    public Set<Passenger> getPassengers() { return passengers; }
    public void setPassengers(Set<Passenger> passengers) { this.passengers = passengers; }
}