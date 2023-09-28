package design.elevator.model;

public class ElevatorCar {

    int currentFloor;
    State state;
    Direction direction;

    public ElevatorCar(int currentFloor, State state, Direction direction) {
        this.currentFloor = currentFloor;
        this.state = state;
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
