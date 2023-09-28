package design.elevator.service;

import design.elevator.model.Direction;
import design.elevator.model.ElevatorCar;
import design.elevator.model.ExternalRequest;
import design.elevator.model.InternalRequest;
import design.elevator.model.State;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dispatcher implements Runnable {
    Queue<InternalRequest> upRequests;
    Queue<InternalRequest> downRequests;
    ElevatorCar elevatorCar;

    public Dispatcher() {
        this.upRequests = new PriorityQueue<>(Comparator.comparingInt(InternalRequest::getDestFloor));
        this.downRequests = new PriorityQueue<>((a, b) -> b.getDestFloor() - b.getDestFloor());
        elevatorCar = new ElevatorCar(0, State.IDLE, Direction.NONE);
    }

    public void processUpRequests(){
        while (!upRequests.isEmpty() && (elevatorCar.getDirection().equals(Direction.UP) && elevatorCar.getCurrentFloor()<=upRequests.peek().getCurrentFloor()
                || elevatorCar.getDirection().equals(Direction.NONE)) ){
            InternalRequest request = upRequests.poll();
            elevatorCar.setState(State.MOVING);
            elevatorCar.setDirection(Direction.UP);
            System.out.println("Elevator at : " +elevatorCar.getCurrentFloor() + " UP Stopping at Floor : " + request.getCurrentFloor() + " Going to floor : "+ request.getDestFloor());
            elevatorCar.setCurrentFloor(request.getCurrentFloor());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Restarting");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elevatorCar.setDirection(Direction.NONE);

    }
    public void processDownRequests(){
        while (!downRequests.isEmpty() && (elevatorCar.getDirection().equals(Direction.UP) || elevatorCar.getDirection().equals(Direction.NONE)) ){
            InternalRequest request = downRequests.poll();
            elevatorCar.setState(State.MOVING);
            elevatorCar.setDirection(Direction.DOWN);
            elevatorCar.setCurrentFloor(request.getDestFloor());
            System.out.println("DOWN Current Floor : " + request.getCurrentFloor() + " Going to floor : "+ request.getDestFloor());
        }
        processUpRequests();
    }

    public void addExternalRequest(ExternalRequest externalRequest){
        InternalRequest internalRequest = new InternalRequest(elevatorCar.getCurrentFloor(), externalRequest.getCurrentFloor(), externalRequest.getDirection());
        if(externalRequest.getDirection().equals(Direction.UP)){
            upRequests.add(internalRequest);
        } else {
            downRequests.add(internalRequest);
        }
    }

    public void addInternalRequest(InternalRequest internalRequest){
        if(internalRequest.getDirection().equals(Direction.UP)){
            upRequests.add(internalRequest);
        } else {
            downRequests.add(internalRequest);
        }
    }

    @Override
    public void run() {
        while(true){
            processUpRequests();
            //processDownRequests();
        }

    }
}
