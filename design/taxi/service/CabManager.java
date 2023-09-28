package design.taxi.service;

import design.taxi.dao.CabDao;
import design.taxi.exception.NoCabFoundException;
import design.taxi.model.Cab;
import design.taxi.model.Rider;
import design.taxi.model.trip.Location;
import design.taxi.model.trip.Trip;
import design.taxi.strategy.CabAssignmentStrategy;

import java.util.ArrayList;
import java.util.List;

public class CabManager {

    CabAssignmentStrategy cabAssignmentStrategy;
    TripManager tripManager;
    CabDao cabDao;

    public CabManager(CabAssignmentStrategy cabAssignmentStrategy, CabDao cabDao, TripManager tripManager) {
        this.cabAssignmentStrategy = cabAssignmentStrategy;
        this.cabDao = cabDao;
        this.tripManager = tripManager;
    }

    public Cab bookCab(Rider rider, Location currLocation, Location toLocation) throws NoCabFoundException {
        List<Cab> cabList = cabDao.getAllCabsWithinRadius(10, currLocation);
        Cab cab = cabAssignmentStrategy.matchCabToRider(cabList, rider);
        if(cab==null)
            throw new NoCabFoundException();

        List<Rider> riderList = new ArrayList<>();
        riderList.add(rider);
        Trip trip = tripManager.createTrip(currLocation, toLocation, cab, riderList);
        cab.setCurrTrip(trip);
        return cab;
    }
}
