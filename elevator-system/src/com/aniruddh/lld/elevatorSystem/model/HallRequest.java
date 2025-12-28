package com.aniruddh.lld.elevatorSystem.model;

import com.aniruddh.lld.elevatorSystem.enums.Direction;

public class HallRequest {

    final int sourceFloor;

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    final int destinationFloor;
    final Direction direction;

    public HallRequest(int sourceFloor, int destinationFloor) {
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        if(this.sourceFloor<=this.destinationFloor)
            this.direction = Direction.UP;
        else
            this.direction = Direction.DOWN;
    }
}
