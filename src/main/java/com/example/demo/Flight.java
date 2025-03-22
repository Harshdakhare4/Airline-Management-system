package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private String flightId;
    private String airlineName;
    private String departureLocation;
    private String arrivalLocation;
    private String departureTimestamp;
    private String arrivalTimestamp;
    private List<String> availableSchedules; // List of available schedules
}
