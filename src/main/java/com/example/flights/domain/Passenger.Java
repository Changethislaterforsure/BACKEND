package com.example.flights.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String firstName;
    @Column(nullable = false) private String lastName;
    @Column(nullable = false) private String phoneNumber;

    @ManyToOne(optional = false)
    private City city;

    // Passenger ↔ Aircraft (owning side)
    @ManyToMany
    @JoinTable(name = "passenger_aircraft",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id"))
    private Set<Aircraft> aircraft = new HashSet<>();

    public Passenger() {}
    public Passenger(String firstName, String lastName, String phoneNumber, City city) {
        this.firstName = firstName; this.lastName = lastName;
        this.phoneNumber = phoneNumber; this.city = city;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
    public Set<Aircraft> getAircraft() { return aircraft; }
    public void setAircraft(Set<Aircraft> aircraft) { this.aircraft = aircraft; }
}