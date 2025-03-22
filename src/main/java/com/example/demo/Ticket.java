package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private String id;
    private String flightId;
    private String passengerName;
    private String email;
    private boolean isCancelled;

    public Object retrieveTicketById() {
        return id;
    }
}
