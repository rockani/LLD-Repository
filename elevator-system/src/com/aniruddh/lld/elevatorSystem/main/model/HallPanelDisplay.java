package com.aniruddh.lld.elevatorSystem.main.model;

import com.aniruddh.lld.elevatorSystem.main.event.ElevatorEvent;
import com.aniruddh.lld.elevatorSystem.main.event.ElevatorEventListener;

import java.util.List;

public class HallPanelDisplay implements ElevatorEventListener {
    int floorNumber;

    public List<FloorButton> getFloorButtons() {
        return floorButtons;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    List<FloorButton> floorButtons;

    public HallPanelDisplay(int floorNumber) {
        this.floorNumber = floorNumber;
        //this.floorButtons = floorButtons;
    }


    @Override
    public void onElevatorEvent(ElevatorEvent event) {
        System.out.println(
                "[Floor " + floorNumber + " Display] " +
                        "Elevator " + event.getElevatorId() +
                        " at floor " + event.getCurrentFloor() +
                        " moving " + event.getDirection()
        );
    }
}
