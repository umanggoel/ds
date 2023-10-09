package passportOffice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TokenManager {

    DeskManager deskManager;
    Map<Double, Token> tokens = new HashMap<>();

    public TokenManager(DeskManager deskManager) {
        this.deskManager = deskManager;
    }

    Token getToken() {
        Token t = new Token();
        t.number = Math.random();
        List<Desk> desks = deskManager.getDesks();
        PriorityQueue<Desk> q = new PriorityQueue<>((o1, o2) -> o1.order - o2.order);
        q.addAll(desks);
        t.desks = q;
        tokens.put(t.number, t);
        return t;
    }

    Desk moveTokenToNextDesk(double t) {
        tokens.get(t).desks.poll();
        return tokens.get(t).desks.peek();
    }
}
