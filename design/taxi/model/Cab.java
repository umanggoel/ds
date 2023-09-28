package design.taxi.model;

import design.taxi.model.trip.Location;
import design.taxi.model.trip.Trip;

public class Cab {
    private int cabId;
    private String driverName;
    private Trip currTrip;
    private Location currentLocation;

    public Cab(int cabId, String driverName, Trip trip, Location currentLocation) {
        this.cabId = cabId;
        this.driverName = driverName;
        this.currTrip = trip;
        this.currentLocation = currentLocation;
    }

    public int getCabId() {
        return cabId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Trip getCurrTrip() {
        return currTrip;
    }

    public void setCurrTrip(Trip currTrip) {
        this.currTrip = currTrip;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
