package com.booking.service;

import com.booking.bean.Movie;
import com.booking.bean.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheFa on 17.04.16.
 */
@Service
public class TicketService {

    private List<Ticket> ticketList = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

    public List<Ticket> getTicketsList() {
        return this.ticketList;
    }

    public void addTicket(final Ticket ticket) {
        this.ticketList.add(ticket);
    }
}
