package com.booking.bean;

import java.util.Date;

/**
 * Created by TheFa on 17.04.16.
 */
public class Ticket {

    private String number;
    private String movieName;
    private String movieTime;
    private Integer place;
    private Integer cost;
    private User user;

    public Ticket(String number, String movieName, String movieTime, Integer place, Integer cost, User user) {
        this.number = number;
        this.movieName = movieName;
        this.movieTime = movieTime;
        this.place = place;
        this.cost = cost;
        this.user = user;
    }

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

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieStartTime) {
        this.movieTime = movieStartTime;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
