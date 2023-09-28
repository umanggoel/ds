package design.elevator.model;

public class InternalRequest {
    int currentFloor;
    int destFloor;
    Direction direction;

    public InternalRequest(int currentFloor, int destFloor, Direction direction) {
        this.currentFloor = currentFloor;
        this.destFloor = destFloor;
        this.direction = direction;
    }



    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestFloor() {
        return destFloor;
    }

    public void setDestFloor(int destFloor) {
        this.destFloor = destFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
