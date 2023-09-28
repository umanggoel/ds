package design.taxi.service;

import design.taxi.dao.TripDao;
import design.taxi.exception.TripNotCreatedException;
import design.taxi.exception.TripNotFoundException;
import design.taxi.model.Cab;
import design.taxi.model.Rider;
import design.taxi.model.trip.Location;
import design.taxi.model.trip.Trip;
import design.taxi.strategy.PriceStrategy;
import design.taxi.utils.TripStatus;

import java.util.Date;
import java.util.List;

public class TripManager {
    private TripDao tripDao;
    private PriceStrategy priceStrategy;

    public TripManager(TripDao tripDao, PriceStrategy priceStrategy) {
        this.tripDao = tripDao;
        this.priceStrategy = priceStrategy;
    }

    public Trip createTrip(Location from, Location to, Cab cab, List<Rider> riderList) throws TripNotCreatedException {
       Integer price = priceStrategy.price(from, to, new Date(), null);
       Trip trip =  tripDao.createTrip(from, to, TripStatus.ACTIVE, cab, riderList, price);
       if(trip==null)
           throw new TripNotCreatedException();

       return trip;
    }

    public void endTrip(int tripID) throws TripNotFoundException {
        tripDao.endTrip(tripID);
    }
}
