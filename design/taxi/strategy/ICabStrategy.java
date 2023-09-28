package design.taxi.strategy;

import design.taxi.model.Cab;
import design.taxi.model.Rider;

import java.util.List;

public interface ICabStrategy {

    public Cab matchCabToRider(List<Cab> cabs, Rider rider);
}
