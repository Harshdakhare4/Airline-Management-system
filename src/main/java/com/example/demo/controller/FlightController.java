package com.example.demo.controller;

import com.example.demo.Flight;
import com.example.demo.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> fetchAllFlights() {
        return flightService.retrieveAllFlights();
    }

    @GetMapping("/{flightId}")
    public Flight fetchFlightById(@PathVariable String flightId) {
        return flightService.retrieveFlightById(flightId);
    }

    @GetMapping("/{flightId}/schedules")
    public List<String> fetchFlightSchedules(@PathVariable String flightId) {
        return flightService.retrieveFlightSchedules(flightId);
    }
}
