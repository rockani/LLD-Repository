package com.aniruddh.lld.elevatorSystem.main.model;

import com.aniruddh.lld.elevatorSystem.main.enums.Direction;
import com.aniruddh.lld.elevatorSystem.main.enums.ElevatorState;
import com.aniruddh.lld.elevatorSystem.main.event.ElevatorEvent;
import com.aniruddh.lld.elevatorSystem.main.publisher.ElevatorEventPublisher;

import java.util.PriorityQueue;

public class Elevator {

    public int getId() {
        return id;
    }

    private final int id;
    private int currentFloorNumber = 0;
    private Direction currentDirection = Direction.IDLE;
    private ElevatorState elevatorState = ElevatorState.IDLE;

    private final PriorityQueue<Integer> upQueue =
            new PriorityQueue<>();
    private final PriorityQueue<Integer> downQueue =
            new PriorityQueue<>((a, b) -> b - a);
    private final ElevatorEventPublisher publisher;


    public Elevator(int id, ElevatorEventPublisher publisher) {
        this.publisher = publisher;
        this.id = id;
    }

    public int getCurrentFloorNumber() {
        return currentFloorNumber;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public PriorityQueue<Integer> getUpQueue() {
        return upQueue;
    }

    public PriorityQueue<Integer> getDownQueue() {
        return downQueue;
    }

    public ElevatorEventPublisher getPublisher() {
        return publisher;
    }

    public void step() {

        if(currentDirection == Direction.UP || currentDirection == Direction.IDLE) {
            processUpwards();
        }else {
            processDownwards();
        }
        publisher.publish(new ElevatorEvent(id,currentDirection,currentFloorNumber));
    }

    private void processUpwards() {
        if(!upQueue.isEmpty()){
            moveTowards(upQueue.peek());
            if(currentFloorNumber == upQueue.peek()) {
                elevatorState = ElevatorState.DOOR_OPENING;
                upQueue.poll();
            }
        }
        else if(!downQueue.isEmpty()) {
            processDownwards();
        }
        else{
            this.currentDirection = Direction.IDLE;
            this.elevatorState = ElevatorState.IDLE;
        }
    }

    private void processDownwards() {
        if(!downQueue.isEmpty()){
            moveTowards(downQueue.peek());
            if(currentFloorNumber == downQueue.peek()){
                elevatorState = ElevatorState.DOOR_OPENING;
                downQueue.poll();
            }
        }
        else if(!upQueue.isEmpty()) {
            processUpwards();
        }
        else{
            this.currentDirection = Direction.IDLE;
            this.elevatorState = ElevatorState.IDLE;
        }
    }

    private void moveTowards(int target) {
        elevatorState = ElevatorState.MOVING;

        if(currentFloorNumber> target) {
            currentDirection = Direction.DOWN;
            currentFloorNumber--;
        }else if(currentFloorNumber < target) {
            currentDirection = Direction.UP;
            currentFloorNumber++;
        }
    }


    public void addStop(int floorNumber) {
        if(currentFloorNumber>floorNumber) {
            downQueue.add(floorNumber);
        }else if(currentFloorNumber < floorNumber) {
            upQueue.add(floorNumber);
        } else {
            elevatorState = ElevatorState.DOOR_OPENING;
        }
    }
}
