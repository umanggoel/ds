package design.taxi.model.trip;

import design.taxi.model.Cab;
import design.taxi.model.Rider;
import design.taxi.model.trip.Location;
import design.taxi.utils.TripStatus;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private int tripID;
    private Location from;
    private Location toLocation;
    private TripStatus tripStatus;
    private Cab cab;
    List<Rider> riders;
    private Integer price;

    public Trip(int tripID, Location from, Location toLocation, TripStatus tripStatus, Cab cab) {
        this.tripID = tripID;
        this.from = from;
        this.toLocation = toLocation;
        this.tripStatus = tripStatus;
        this.cab = cab;
        riders = new ArrayList<>();
        this.price = price;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void endTrip() {
        this.tripStatus = TripStatus.ENDED;
    }

    public void addRiders(List<Rider>riderLst){
        riders.addAll(riderLst);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

