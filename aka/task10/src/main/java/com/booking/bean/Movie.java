package com.booking.bean;

import com.booking.utils.DateUtils;

import java.util.Date;

/**
 * Created by TheFa on 17.04.16.
 */
public class Movie {

    private String movieName;
    private Date movieStartDate;
    private Date movieEndDate;

    public Movie(String movieName, Date movieStartDate, final Date movieEndDate) {
        this.movieName = movieName;
        this.movieStartDate = movieStartDate;
        this.movieEndDate = movieEndDate;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieStartDate() {
        return movieStartDate;
    }

    public void setMovieStartDate(Date movieStartDate) {
        this.movieStartDate = movieStartDate;
    }

    public Date getMovieEndDate() {
        return movieEndDate;
    }

    public void setMovieEndDate(Date movieEndDate) {
        this.movieEndDate = movieEndDate;
    }

    public String getMovieStartDateString() {

        return DateUtils.sdf.format(movieStartDate);
    }

    public String getMovieEndDateString() {
        return DateUtils.sdf.format(movieEndDate);
    }
}
