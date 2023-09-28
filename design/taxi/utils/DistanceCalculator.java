package design.taxi.utils;

import design.taxi.model.trip.Location;

public class DistanceCalculator {

    public static Integer getDistance(Location location1, Location location2){
        return (int) Math.sqrt( Math.pow(location1.getxCoordinate()-location2.getxCoordinate(),2) + Math.pow(location1.getyCoordinate()-location2.getyCoordinate(),2));
    }

}
