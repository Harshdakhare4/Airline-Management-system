package com.example.demo.service;

import com.example.demo.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final List<Flight> flightList = new ArrayList<>();

    public FlightService() {
        flightList.add(new Flight("1", "Indigo", "Dubai", "Mumbai", "08:00 PM", "10:00 AM", List.of("2024-03-25", "2024-03-26")));
        flightList.add(new Flight("2", "Air India", "Mumbai", "Pune", "02:20 PM", "04:10 PM", List.of("2024-03-25", "2024-03-26")));
    }

    public List<Flight> retrieveAllFlights() {
        return flightList;
    }

    public Flight retrieveFlightById(String flightId) {
        return flightList.stream().filter(flight -> flight.getFlightId().equals(flightId)).findFirst().orElse(null);
    }

    public List<String> retrieveFlightSchedules(String flightId) {
        return Optional.ofNullable(retrieveFlightById(flightId)).map(Flight::getAvailableSchedules).orElse(null);
    }
}
