package com.booking.service;

import com.booking.bean.Ticket;
import com.booking.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TheFa on 17.04.16.
 */
@Service
public class BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    private List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> getTicketsList() {
        return this.ticketList;
    }

    public void addTicket(final Ticket ticket) {
        this.ticketList.add(ticket);
    }

    public void addTicket(final String number, final String movieName, final String movieDateTime, final String placeString,
                          final User user) {
        Integer place;
        try {
            place = Integer.parseInt(placeString);
        } catch (final Exception e) {
            place = 0;
        }
        Ticket ticket = new Ticket(number, movieName, movieDateTime, place, 15, user);
        this.ticketList.add(ticket);
    }

    public void deleteTicket(final String ticketNumber) {
        for(Ticket ticket: this.ticketList) {
            if(ticket.getNumber().equals(ticketNumber)) {
                this.ticketList.remove(ticket);
            }
        }
    }
}
