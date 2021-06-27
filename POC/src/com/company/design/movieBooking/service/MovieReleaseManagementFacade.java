package com.company.design.movieBooking.service;

import com.company.design.movieBooking.domain.Theater;

public class MovieReleaseManagementFacade {

    MovieManagementService movieManagementService;
    ThreaterManagementService threaterManagementService;

    void releaseMovieInTheater(String theaterId, String movieId, int screenCount){

        Theater t = threaterManagementService.getTheater(theaterId);


    }

    void closeMovieInTheater(){

    }
}
