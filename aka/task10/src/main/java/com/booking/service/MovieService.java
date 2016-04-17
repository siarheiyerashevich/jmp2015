package com.booking.service;

import com.booking.bean.Movie;
import com.booking.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TheFa on 17.04.16.
 */
@Service
public class MovieService {

    private List<Movie> movieSchedule = new ArrayList<Movie>();

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    public List<Movie> getMovieList() {
        if (movieSchedule.isEmpty()) {
            fillMovieSchedule();
        }
        return movieSchedule;
    }

    public List<Movie> getMovieList(Date date) {
        final List<Movie> result = new ArrayList<>();
        if (movieSchedule.isEmpty()) {
            fillMovieSchedule();
        }
        for (final Movie movie : movieSchedule) {
            if (movie.getMovieStartDate().before(date) && movie.getMovieEndDate().after(date)
                    || movie.getMovieStartDate().equals(date) || movie.getMovieEndDate().equals(date)) {
                result.add(movie);
            }
        }
        return result;
    }

    private void fillMovieSchedule() {
        try {
            movieSchedule.add(new Movie("THE SHAWSHANK REDEMPTION",
                    DateUtils.sdf.parse("2016-04-18"), DateUtils.sdf.parse("2016-04-24")));
            movieSchedule.add(new Movie("THE GREEN MILE",
                    DateUtils.sdf.parse("2016-04-18"), DateUtils.sdf.parse("2016-04-22")));
            movieSchedule.add(new Movie("THE BUTTERFLY EFFECT",
                    DateUtils.sdf.parse("2016-04-21"), DateUtils.sdf.parse("2016-04-24")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}


