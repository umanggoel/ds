package design.taxi.strategy;

import design.taxi.model.trip.Location;
import design.taxi.utils.DistanceCalculator;

import java.util.Date;

public class PriceStrategy implements IPriceStrategy {

    @Override
    public Integer price(Location from, Location to, Date startTime, Date endTime) {
        return DistanceCalculator.getDistance(from, to)*10;
    }
}
