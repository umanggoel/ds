package design.taxi.dao;

import design.taxi.exception.TripNotFoundException;
import design.taxi.model.Cab;
import design.taxi.model.Rider;
import design.taxi.model.trip.Location;
import design.taxi.model.trip.Trip;
import design.taxi.utils.TripStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripDao {
    private static int id = 1;
    Map<Integer, Trip> trips = new HashMap<>();

    public Trip createTrip(Location from, Location to, TripStatus tripStatus, Cab cab, List<Rider> riderList, Integer price){
        Trip trip = new Trip(id++, from, to, tripStatus, cab);
        trip.addRiders(riderList);
        trip.setPrice(price);
        trips.put(trip.getTripID(), trip);
        return trip;
    }

    public Trip getTrip(int tripID) throws TripNotFoundException {
        if(!trips.containsKey(tripID))
            throw new TripNotFoundException();
        return trips.get(tripID);
    }

    public void endTrip(int tripId) throws TripNotFoundException {
        getTrip(tripId).endTrip();
    }
}
