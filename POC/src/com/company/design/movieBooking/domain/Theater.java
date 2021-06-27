package com.company.design.movieBooking.domain;

import java.util.Map;

public class Theater {

    String id;
    String address;
    Map<String,MovieScreen> screenMap;

    void releaseMovie(String movieId,String screenId,String startDate){
        // add movie id to screen;
    }

    void removeMovieFromTheater(String movieId, String endDate){
        // notify the movie that will be removed from screen with end date
    }
}
