package com.aniruddh.lld.elevatorSystem.model;

public class FloorButton {
    private final int floorNumber ;

    FloorButton(int floorNumber){
        this.floorNumber = floorNumber;
    }

    int getFloorNumber() {
        return this.floorNumber;
    }
}
