package design.elevator.service;

import design.elevator.model.Direction;
import design.elevator.model.ExternalRequest;
import design.elevator.model.InternalRequest;

// https://www.youtube.com/watch?v=14Cc8IDWtFM
// https://tedweishiwang.github.io/journal/object-oriented-design-elevator.html
public class ElevatorManager {

    static Dispatcher dispatcher = new Dispatcher();

    public ElevatorManager() {
    }

    public static void main(String args[]){

        Thread t = new Thread(dispatcher);
        t.start();

        ExternalRequest externalRequest1 = new ExternalRequest(4, Direction.UP);
        dispatcher.addExternalRequest(externalRequest1);

        InternalRequest internalRequestUP1 = new InternalRequest(4, 8, Direction.UP );
        dispatcher.addInternalRequest(internalRequestUP1);

        InternalRequest internalRequestUP2 = new InternalRequest(5, 7, Direction.UP );
        dispatcher.addInternalRequest(internalRequestUP2);

        InternalRequest internalRequestUP3 = new InternalRequest(2, 6, Direction.UP );
        dispatcher.addInternalRequest(internalRequestUP3);

    }
}
