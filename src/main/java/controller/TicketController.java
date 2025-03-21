package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> fetchAllTickets() {
        return ticketService.retrieveAllTickets();
    }

    @GetMapping("/{ticketId}")
    public Ticket fetchTicketById(@PathVariable String ticketId) {
        return ticketService.retrieveTicketById(ticketId);
    }

    @PostMapping
    public Ticket bookTicket(@RequestBody Ticket ticket) {
        return ticketService.processTicketBooking(ticket);
    }

    @DeleteMapping("/{ticketId}")
    public String removeTicket(@PathVariable String ticketId) {
        return ticketService.deleteTicket(ticketId) ? "Ticket successfully cancelled" : "Ticket not found";
    }
}
