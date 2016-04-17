package com.booking.web;

import com.booking.service.BookingService;
import com.booking.bean.User;
import com.booking.service.MovieService;
import com.booking.service.TicketService;
import com.booking.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by TheFa on 17.04.16.
 */
@Controller
public class BookingController {

    private final Logger logger = LoggerFactory.getLogger(BookingController.class);
    private final BookingService bookingService;
    private final MovieService movieService;
    private final TicketService ticketService;

    @Autowired
    public BookingController(final BookingService bookingService, final MovieService movieService,
                             final TicketService ticketService) {
        this.bookingService = bookingService;
        this.movieService = movieService;
        this.ticketService = ticketService;
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

        model.addAttribute("movieList", movieService.getMovieList() );
        try {
            model.addAttribute("showParticularDay", true );
            model.addAttribute("movieResponse", movieService.getMovieList(DateUtils.sdf.parse(selectedDate)) );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Locale locale, Model model) {
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String login(@Validated User user, Model model) {
        model.addAttribute("userName", user.getFirstName());
        return "user";
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public String ticketsPage( Model model) {
        ticketService.getTicketsList();
        return "tickets";
    }
}
