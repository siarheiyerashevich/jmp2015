package com.booking.bean;

import java.util.Date;

/**
 * Created by TheFa on 17.04.16.
 */
public class Ticket {

    private String number;
    private String movieName;
    private Date movieTime;
    private Integer place;
    private Double cost;
    private User user;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(Date movieStartTime) {
        this.movieTime = movieStartTime;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
