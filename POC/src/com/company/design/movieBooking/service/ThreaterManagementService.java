package com.company.design.movieBooking.service;

import com.company.design.movieBooking.domain.Theater;

import java.util.Map;

public class ThreaterManagementService {

    Map<String , Theater> theaters;

    void addTheater(String id,String address){

    }

    void removeTheater(String id){

    }

    Theater getTheater(String id){
     return theaters.get(id);
    }


    void addScreen(String theaterId){
        //add a screen from theater
    }

    void removeScreen(String theaterId, String screenId){
        //remove a screen from theater
        // notify all the current and next release movies to remove this theater from its release list
    }

    void modifyScreen(String theaterId, String screenId){
        // can be used to add/remove more seats of a type
        // change price of seat
    }



}
