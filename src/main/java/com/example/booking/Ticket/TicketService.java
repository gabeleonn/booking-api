package com.example.booking.Ticket;

import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    @Override
    public String method() {
        return "Methods";
    }
}
