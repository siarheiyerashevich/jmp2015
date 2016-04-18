package com.booking.web;

import com.booking.bean.Ticket;
import com.booking.service.BookingService;
import com.booking.bean.User;
import com.booking.service.MovieService;
import com.booking.service.UserService;
import com.booking.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * Created by TheFa on 17.04.16.
 */
@Controller
public class BookingController {

    private final Logger logger = LoggerFactory.getLogger(BookingController.class);
    private final BookingService bookingService;
    private final MovieService movieService;
    private final UserService userService;

    private Integer ticketNumber = 0;
    private String selectedDate;

    @Autowired
    public BookingController(final BookingService bookingService, final MovieService movieService,
                             final UserService userService) {
        this.bookingService = bookingService;
        this.movieService = movieService;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        model.addAttribute("movieList", movieService.getMovieList() );
        model.addAttribute("showParticularDay", false );
        return "index";
    }

    @RequestMapping(value = "/{selectedDate}", method = RequestMethod.GET)
    public String findMovies(@PathVariable String selectedDate, Model model) {

        logger.info("selectedDate ", selectedDate);
        this.selectedDate = selectedDate;
        model.addAttribute("movieList", movieService.getMovieList() );
        try {
            model.addAttribute("showParticularDay", true );
            model.addAttribute("movieResponse", movieService.getMovieList(DateUtils.sdf.parse(selectedDate)) );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public String ticketsPage( Model model) {
        logger.info("tickets");
        final List<Ticket> ticketList = bookingService.getTicketsList();
        model.addAttribute("ticketList", ticketList );
        return "tickets";
    }

    @RequestMapping(value = "/tickets/{ticketNumber}", method = RequestMethod.GET)
    public String deleteTicket(@PathVariable String ticketNumber) {
        logger.info("deleteTicket", ticketNumber);
        bookingService.deleteTicket(ticketNumber);
//        final List<Ticket> ticketList = bookingService.getTicketsList();
//        model.addAttribute("ticketList", ticketList );
        return "redirect:/tickets";
    }

    @RequestMapping(value = "/buyTicket", method = RequestMethod.POST)
    public @ResponseBody
    String buyTicket(@RequestParam String ticketInfo, @RequestParam String firstName,
                     @RequestParam String lastName, @RequestParam String place) {
        logger.info("buyTicket", ticketInfo, firstName, lastName, place);
        this.ticketNumber++;
        final User user = userService.createUser(firstName, lastName);
        final String[] movieNameAndTime = ticketInfo.split(";");
        final String movieName = movieNameAndTime[0];
        final String movieDateTime = selectedDate+" "+movieNameAndTime[1];
        bookingService.addTicket(this.ticketNumber.toString(), movieName, movieDateTime, place,user);

        return "ticket with number " + ticketNumber + " was bought";
    }
}
