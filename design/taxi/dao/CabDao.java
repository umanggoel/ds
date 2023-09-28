package design.taxi.dao;

import design.taxi.exception.CabAlreadyExistsException;
import design.taxi.exception.CabNotFoundException;
import design.taxi.model.Cab;
import design.taxi.model.trip.Location;
import design.taxi.utils.Constants;
import design.taxi.utils.DistanceCalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CabDao {
    Map<Integer, Cab> cabs = new HashMap<>();

    public void registerCab(Integer regId, String driverName, Location currentLocation) throws CabAlreadyExistsException{
        if(!cabs.containsKey(regId))
            cabs.put(regId, new Cab(regId, driverName, null, currentLocation));
        else
            throw new CabAlreadyExistsException();
    }

    public void updateLocation(int regId, Location newLocation) throws CabNotFoundException {
        if(!cabs.containsKey(regId)){
            throw new CabNotFoundException();
        }
        cabs.get(regId).setCurrentLocation(newLocation);
    }

    public List<Cab> getAllCabsWithinRadius(Integer distance, Location fromLocation) {
        if(distance==null){
            distance = Constants.MAX_ALLOWED_RADIUS_DISTANCE_KM;
        }
        final Integer finalDis = distance;
        return cabs.values().stream().filter(cab -> (DistanceCalculator.getDistance(cab.getCurrentLocation(),fromLocation)<= finalDis)).collect(Collectors.toList());
    }


}
