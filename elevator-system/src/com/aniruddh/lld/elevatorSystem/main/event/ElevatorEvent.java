package com.aniruddh.lld.elevatorSystem.main.event;

import com.aniruddh.lld.elevatorSystem.main.enums.Direction;

public class ElevatorEvent {
    int elevatorId;

    public ElevatorEvent(int elevatorId, Direction direction, int currentFloor) {
        this.elevatorId = elevatorId;
        this.direction = direction;
        this.currentFloor = currentFloor;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    Direction direction;
    int currentFloor;

}
