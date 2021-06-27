package com.company.design.movieBooking.service;

import com.company.design.movieBooking.domain.Movie;

import java.util.Map;

public class MovieManagementService {

    Map<String, Movie> movies;

    void addMovie(String movieid){

    }

    void removeMovie(String movieid){
        //notify all the theaters to update themselves if movie is removed
    }
}
