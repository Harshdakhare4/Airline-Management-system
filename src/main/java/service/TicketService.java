package com.example.demo.service;

import com.example.demo.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> retrieveAllTickets() {
        return ticketList;
    }

    public Ticket retrieveTicketById(String ticketId) {
        return ticketList.stream().filter(ticket -> ticket.getTicketId().equals(ticketId)).findFirst().orElse(null);
    }

    public Ticket processTicketBooking(Ticket ticket) {
        ticketList.add(ticket);
        return ticket;
    }

    public boolean deleteTicket(String ticketId) {
        Optional<Ticket> ticket = ticketList.stream().filter(t -> t.getTicketId().equals(ticketId)).findFirst();
        ticket.ifPresent(t -> t.setCancelled(true));
        return ticket.isPresent();
    }
}
