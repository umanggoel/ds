package design.taxi.strategy;

import design.taxi.model.trip.Location;

import java.util.Date;

public interface IPriceStrategy {
    Integer price(Location from, Location to, Date startTime, Date endTime);
}
