package design.taxi.strategy;

import design.taxi.model.Cab;
import design.taxi.model.Rider;

import java.util.List;

public class CabAssignmentStrategy implements ICabStrategy {

    @Override
    public Cab matchCabToRider(List<Cab> cabs, Rider rider) {
        return cabs.stream().findFirst().get();
    }
}
