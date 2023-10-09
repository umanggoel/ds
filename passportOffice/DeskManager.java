package passportOffice;

import java.util.*;

public class DeskManager {

    Map<Integer, Desk> desks = new HashMap<>();
    int start = Integer.MAX_VALUE;

    void addDesk(int order) {
        Desk d = new Desk();
        d.order = order;
        start = Math.min(order, start);
        desks.put(order, d);
    }

    void evictDesks() {
        desks.clear();
    }
    List<Desk> getDesks() {
        return new ArrayList<>(desks.values());
    }

    void startTokenFlow(Token t) {
        desks.get(start).q.add(t.number);
    }

    void moveTokenToNextDesk(Integer nextDesk, double t) {
        if(desks.get(nextDesk) != null) {
            desks.get(nextDesk).q.add(t);
        }
    }

    Double getNextTokenForDesk(Integer deskNumber) {
        return desks.get(deskNumber).q.poll();
    }
}
